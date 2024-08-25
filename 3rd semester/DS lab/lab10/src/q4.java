//import java.util.HashMap;
//import java.util.Map;
//import java.util.PriorityQueue;
//
//
//
//public class q4 {
//    public static void main(String[] args) {
//        String inputString = "BSE-3B";
//
//        Map<Character, String> huffmanCodes = encode(inputString);
//
//        System.out.println("Original " + inputString);
//        System.out.println("Encoded  " + encodeString(inputString, huffmanCodes));
//    }
//
//    public static Map<Character, String> encode(String inputString) {
//        Map<Character, Integer> frequencyMap = new HashMap<>();
//
//
//        for (char c : inputString.toCharArray()) {
//            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
//        }
//
//
//        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<>();
//        for (Map.Entry<Character, Integer> entry : frequencyMap.entrySet()) {
//            priorityQueue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
//        }
//
//
//        while (priorityQueue.size() > 1) {
//            HuffmanNode left = priorityQueue.poll();
//            HuffmanNode right = priorityQueue.poll();
//
//            HuffmanNode internalNode = new HuffmanNode('\0', left.frequency + right.frequency);
//            internalNode.left = left;
//            internalNode.right = right;
//
//            priorityQueue.add(internalNode);
//        }
//
//
//        HuffmanNode root = priorityQueue.poll();
//        Map<Character, String> huffmanCodes = new HashMap<>();
//        generateCodes(root, "", huffmanCodes);
//
//        return huffmanCodes;
//    }
//    public static String encodeString(String inputString, Map<Character, String> huffmanCodes) {
//        StringBuilder encodedString = new StringBuilder();
//        for (char c : inputString.toCharArray()) {
//            encodedString.append(huffmanCodes.get(c));
//        }
//        return encodedString.toString();
//    }
//
//    public static void generateCodes(HuffmanNode root, String code, Map<Character, String> huffmanCodes) {
//        if (root != null) {
//            if (root.data != '\0') {
//                huffmanCodes.put(root.data, code);
//            }
//            generateCodes(root.left, code + "0", huffmanCodes);
//            generateCodes(root.right, code + "1", huffmanCodes);
//        }
//    }
//
//
//
//
//
//}
//
//class HuffmanNode implements Comparable<HuffmanNode> {
//    char data;
//    int frequency;
//    HuffmanNode left, right;
//
//    public HuffmanNode(char data, int frequency) {
//        this.data = data;
//        this.frequency = frequency;
//        left = right = null;
//    }
//
//    @Override
//    public int compareTo(HuffmanNode node) {
//        return this.frequency - node.frequency;
//    }
//}