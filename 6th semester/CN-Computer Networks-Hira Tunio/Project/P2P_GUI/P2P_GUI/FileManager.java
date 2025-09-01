import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class FileManager {
   
    private static HashMap<String, List<String>> sharedFiles = new HashMap<>();

    
    public static void addFile(String fileName, String ownerAddress) {
        sharedFiles.putIfAbsent(fileName, new ArrayList<>());
        sharedFiles.get(fileName).add(ownerAddress);  
        System.out.println("In addFile mehtod Adding file " +fileName+"with owner "+ownerAddress);
    }

    
    public static HashMap<String, List<String>> getSharedFiles() {
        return sharedFiles;
    }

   
    public static boolean fileExists(String fileName) {
        return sharedFiles.containsKey(fileName);
    }

   
    public static List<String> getFileOwners(String fileName) {
        return sharedFiles.getOrDefault(fileName, new ArrayList<>());
    }
}
