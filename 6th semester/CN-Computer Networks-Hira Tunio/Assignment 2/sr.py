from network.channel import Packet, UnreliableChannel
from config import TIMEOUT, PACKET_COUNT, WINDOW_SIZE
from threading import Thread
import time

DATA = [f"Pkt{i}" for i in range(PACKET_COUNT)]

class SRSender:
    def __init__(self, channel):
        self.channel = channel
        self.base = 0
        self.next_seq_num = 0
        self.timers = {}
        self.acknowledged = {}
        self.packets = []

    def start(self, data_packets):
        self.packets = [Packet(i, data) for i, data in enumerate(data_packets)]

        while self.base < len(self.packets):
           
            while self.next_seq_num < self.base + WINDOW_SIZE and self.next_seq_num < len(self.packets):
                pkt = self.packets[self.next_seq_num]
                print(f"[Sender] Sending: {pkt}")
                self.channel.send_to_receiver(pkt)
                self.timers[pkt.seq_num] = time.time()
                self.acknowledged[pkt.seq_num] = False
                self.next_seq_num += 1

            
            ack = self.channel.receive_from_receiver()
            if ack:
                if not ack.is_corrupt() and ack.ack:
                    print(f"[Sender] ACK received: {ack}")
                    self.acknowledged[ack.seq_num] = True

                    
                    while self.base < len(self.packets) and self.acknowledged.get(self.base, False):
                        self.base += 1

            
            for seq in range(self.base, self.next_seq_num):
                if not self.acknowledged.get(seq, False):
                    if time.time() - self.timers[seq] > TIMEOUT:
                        print(f"[Sender] Timeout. Resending: {self.packets[seq]}")
                        self.channel.send_to_receiver(self.packets[seq])
                        self.timers[seq] = time.time()


class SRReceiver:
    def __init__(self, channel):
        self.channel = channel
        self.expected_base = 0
        self.buffer = {}

    def start(self):
        while True:
            pkt = self.channel.receive_from_sender()
            if pkt:
                if pkt.is_corrupt():
                    print(f"[Receiver] Corrupted packet: {pkt}")
                    continue

                print(f"[Receiver] Received: {pkt}")
                if self.expected_base <= pkt.seq_num < self.expected_base + WINDOW_SIZE:
                    
                    if pkt.seq_num not in self.buffer:
                        self.buffer[pkt.seq_num] = pkt
                    ack = Packet(pkt.seq_num, "", ack=True)
                    self.channel.send_to_sender(ack)

                 
                    while self.expected_base in self.buffer:
                        print(f"[Receiver] Delivered: {self.buffer[self.expected_base]}")
                        del self.buffer[self.expected_base]
                        self.expected_base += 1
                else:
                    print(f"[Receiver] Packet out of window: {pkt}")
                    
                    ack = Packet(pkt.seq_num, "", ack=True)
                    self.channel.send_to_sender(ack)


def run_sr_demo():
    channel = UnreliableChannel()
    sender = SRSender(channel)
    receiver = SRReceiver(channel)

    receiver_thread = Thread(target=receiver.start)
    receiver_thread.daemon = True
    receiver_thread.start()

    sender.start(DATA)


if __name__ == "__main__":
    run_sr_demo()
