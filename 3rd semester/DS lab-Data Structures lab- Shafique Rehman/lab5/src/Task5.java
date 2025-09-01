import java.util.ArrayList;
import java.util.List;

public class Task5 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};

        int targetSum = 7;

        List<List<Integer>> subsets = findSubsetsWithSum(nums, targetSum);

        if (subsets.isEmpty()) {
            System.out.println("No subsets found with the target sum.");
        } else {
            System.out.println("Subsets with the target sum:");
            for (List<Integer> subset : subsets) {
                System.out.println(subset);
            }
        }
    }

    public static List<List<Integer>> findSubsetsWithSum(int[] nums, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsets(nums, targetSum, new ArrayList<>(), 0, result);
        return result;
    }

    public static void findSubsets(int[] nums, int target, List<Integer> current, int index, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }
        if (index >= nums.length || target < 0) {
            return;
        }

        current.add(nums[index]);
        findSubsets(nums, target - nums[index], current, index + 1, result);

        current.remove(current.size() - 1);
        findSubsets(nums, target, current, index + 1, result);
    }
}
