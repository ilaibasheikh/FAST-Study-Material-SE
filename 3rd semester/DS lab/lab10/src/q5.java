import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;



public class q5 {

    private static String encodeString(String inputString, Map<Character, String> huffmanCodes) {
        StringBuilder encodedString = new StringBuilder();
        for (char c : inputString.toCharArray()) {
            encodedString.append(huffmanCodes.get(c));
        }
        return encodedString.toString();
    }
    public static void main(String[] args) {
        String inputString = "BSE-3B";

        Map<Character, String> huffmanCodes = encode(inputString);
        String encodedString = encodeString(inputString, huffmanCodes);

        System.out.println("Original : " + inputString);
        System.out.println("Encoded  " + encodedString);

        String decodedString = decode(encodedString, huffmanCodes);
        System.out.println("Decoded " + decodedString);
    }

    private static Map<Character, String> encode(String inputString) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char c : inputString.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }


        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
            priorityQueue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (priorityQueue.size() > 1) {
            HuffmanNode left = priorityQueue.poll();
            HuffmanNode right = priorityQueue.poll();

            HuffmanNode internalNode = new HuffmanNode('\0', left.frequency + right.frequency);
            internalNode.left = left;
            internalNode.right = right;

            priorityQueue.add(internalNode);
        }

        // Traverse the Huffman Tree and generate codes
        HuffmanNode root = priorityQueue.poll();
        Map<Character, String> huffmanCodes = new HashMap<>();
        generateCodes(root, "", huffmanCodes);

        return huffmanCodes;
    }

    private static void generateCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
        if (root != null) {
            if (root.data != '\0') {
                huffmanCodes.put(root.data, code);
            }
            generateCodes(root.left, code + "0", huffmanCodes);
            generateCodes(root.right, code + "1", huffmanCodes);
        }
    }



    private static String decode(String encodedString, Map<Character, String> huffmanCodes) {
        StringBuilder decodedString = new StringBuilder();
        int index = 0;

        while (index < encodedString.length()) {
            HuffmanNode current = findDecodedCharacter(encodedString, index, huffmanCodes);
            decodedString.append(current.data);
            index += huffmanCodes.get(current.data).length();
        }

        return decodedString.toString();
    }

    private static HuffmanNode findDecodedCharacter(String encodedString, int index, Map<Character, String> huffmanCodes) {
        HuffmanNode root = new HuffmanNode('\0', 0);
        HuffmanNode current = root;

        while (index < encodedString.length()) {
            char bit = encodedString.charAt(index);
            if (bit == '0') {
                if (current.left == null) {
                    current.left = new HuffmanNode('\0', 0);
                }
                current = current.left;
            } else {
                if (current.right == null) {
                    current.right = new HuffmanNode('\0', 0);
                }
                current = current.right;
            }

            index++;

            if (huffmanCodes.containsKey(current.data)) {
                break;
            }
        }

        return current;
    }
}

class HuffmanNode implements Comparable<HuffmanNode> {
    char data;
    int frequency;
    HuffmanNode left, right;

    public HuffmanNode(char data, int frequency) {
        this.data = data;
        this.frequency = frequency;
        left = right = null;
    }

    @Override
    public int compareTo(HuffmanNode node) {
        return this.frequency - node.frequency;
    }
}