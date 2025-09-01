from config import PACKET_COUNT, TIMEOUT
from network.channel import Packet, UnreliableChannel
from threading import Thread
import time


DATA = ["Pkt" + str(i) for i in range(PACKET_COUNT)]


class RDT3Sender:
    def __init__(self, channel):
        self.channel = channel
        self.seq_num = 0
        self.timer = None

    def start(self, data_packets):
        for data in data_packets:
            packet = Packet(seq_num=self.seq_num, data=data)
            print(f"[Sender] Sending: {packet}")
            self.channel.send_to_receiver(packet)

            ack_received = False
            start_time = time.time()

            while not ack_received:
                while True:
                    ack = self.channel.receive_from_receiver()
                    if ack:
                        if not ack.is_corrupt() and ack.ack and ack.seq_num == self.seq_num:
                            print(f"[Sender] ACK received: {ack}")
                            ack_received = True
                            break
                        else:
                            print(f"[Sender] Invalid ACK: {ack}")
                    if time.time() - start_time > TIMEOUT:
                        print(f"[Sender] Timeout. Resending: {packet}")
                        self.channel.send_to_receiver(packet)
                        start_time = time.time()
                        break

            self.seq_num = 1 - self.seq_num 


class RDT3Receiver:
    def __init__(self, channel):
        self.channel = channel
        self.expected_seq = 0

    def start(self):
        while True:
            packet = self.channel.receive_from_sender()
            if packet:
                if not packet.is_corrupt() and packet.seq_num == self.expected_seq:
                    print(f"[Receiver] Received: {packet}")
                    ack = Packet(seq_num=packet.seq_num, data="", ack=True)
                    self.channel.send_to_sender(ack)
                    self.expected_seq = 1 - self.expected_seq
                else:
                    print(f"[Receiver] Packet dropped or duplicate: {packet}")
                    
                    ack = Packet(seq_num=1 - self.expected_seq, data="", ack=True)
                    self.channel.send_to_sender(ack)


def run_rdt3_demo():
    channel = UnreliableChannel()
    sender = RDT3Sender(channel)
    receiver = RDT3Receiver(channel)

    receiver_thread = Thread(target=receiver.start)
    receiver_thread.daemon = True
    receiver_thread.start()

    sender.start(DATA)


if __name__ == "__main__":
    run_rdt3_demo()
