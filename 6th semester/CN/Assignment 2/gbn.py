import time
from config import TIMEOUT, PACKET_COUNT, WINDOW_SIZE
from network.channel import Packet, UnreliableChannel
from threading import Thread

DATA = [f"Pkt{i}" for i in range(PACKET_COUNT)]

class GBNSender:
    def __init__(self, channel):
        self.channel = channel
        self.base = 0
        self.next_seq_num = 0
        self.timer_start = None
        self.packets = []

    def start(self, data_packets):
        self.packets = [Packet(i, data) for i, data in enumerate(data_packets)]
        while self.base < len(self.packets):
            while self.next_seq_num < self.base + WINDOW_SIZE and self.next_seq_num < len(self.packets):
                pkt = self.packets[self.next_seq_num]
                print(f"[Sender] Sending: {pkt}")
                self.channel.send_to_receiver(pkt)
                if self.base == self.next_seq_num:
                    self.timer_start = time.time()
                self.next_seq_num += 1

            ack = self.channel.receive_from_receiver()
            if ack:
                if not ack.is_corrupt() and ack.ack:
                    print(f"[Sender] ACK received: {ack}")
                    self.base = ack.seq_num + 1
                    if self.base == self.next_seq_num:
                        self.timer_start = None
                    else:
                        self.timer_start = time.time()
                else:
                    print(f"[Sender] Invalid ACK: {ack}")

            if self.timer_start and time.time() - self.timer_start > TIMEOUT:
                print("[Sender] Timeout. Resending window...")
                for i in range(self.base, self.next_seq_num):
                    print(f"[Sender] Resending: {self.packets[i]}")
                    self.channel.send_to_receiver(self.packets[i])
                self.timer_start = time.time()


class GBNReceiver:
    def __init__(self, channel):
        self.channel = channel
        self.expected_seq_num = 0

    def start(self):
        while True:
            pkt = self.channel.receive_from_sender()
            if pkt:
                if not pkt.is_corrupt() and pkt.seq_num == self.expected_seq_num:
                    print(f"[Receiver] Received: {pkt}")
                    ack = Packet(pkt.seq_num, "", ack=True)
                    self.channel.send_to_sender(ack)
                    self.expected_seq_num += 1
                else:
                    print(f"[Receiver] Dropped/Out-of-order: {pkt}")
                    ack = Packet(self.expected_seq_num - 1, "", ack=True)
                    self.channel.send_to_sender(ack)


def run_gbn_demo():
    channel = UnreliableChannel()
    sender = GBNSender(channel)
    receiver = GBNReceiver(channel)

    receiver_thread = Thread(target=receiver.start)
    receiver_thread.daemon = True
    receiver_thread.start()

    sender.start(DATA)


if __name__ == "__main__":
    run_gbn_demo()
