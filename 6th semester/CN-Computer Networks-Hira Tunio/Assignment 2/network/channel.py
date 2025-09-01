from config import LOSS_PROB, CORRUPTION_PROB, DELAY_PROB
import time
import random

class UnreliableChannel:
    def __init__(self):
        self.sender_to_receiver = []
        self.receiver_to_sender = []

    def send_to_receiver(self, packet):
        self._simulate(packet, self.sender_to_receiver, direction="Sender → Receiver")

    def send_to_sender(self, packet):
        self._simulate(packet, self.receiver_to_sender, direction="Receiver → Sender")

    def _simulate(self, packet, queue, direction):
        if random.random() < LOSS_PROB:
            print(f"[Channel] Packet lost ({direction}): {packet}")
            return

        if random.random() < CORRUPTION_PROB:
            packet = packet.copy()
            packet.data = "####"
            packet.corrupted = True
            print(f"[Channel] Packet corrupted ({direction}): {packet}")

        if random.random() < DELAY_PROB:
            delay = round(random.uniform(0.5, 1.5), 2)
            print(f"[Channel] Packet delayed ({direction}): {packet} for {delay}s")
            time.sleep(delay)

        queue.append(packet)

    def receive_from_sender(self):
        return self._receive(self.sender_to_receiver)

    def receive_from_receiver(self):
        return self._receive(self.receiver_to_sender)

    def _receive(self, queue):
        if queue:
            return queue.pop(0)
        return None


class Packet:
    def __init__(self, seq_num, data, ack=False):
        self.seq_num = seq_num
        self.data = data
        self.ack = ack
        self.corrupted = False
        self.checksum = self.calculate_checksum()

    def calculate_checksum(self):
        return sum(bytearray(self.data.encode())) + self.seq_num + int(self.ack)

    def is_corrupt(self):
        return self.checksum != self.calculate_checksum()

    def copy(self):
        return Packet(self.seq_num, self.data, self.ack)

    def __str__(self):
        status = "ACK" if self.ack else "DATA"
        return f"{status} Packet(seq={self.seq_num}, data='{self.data}')"

