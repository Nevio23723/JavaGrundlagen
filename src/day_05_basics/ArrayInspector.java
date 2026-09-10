package day_05_basics;

public class ArrayInspector {
    public static void main(String[] args) throws Exception {
        int[] nums = {4, 25, 7, 19, 35, 8};
        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        System.out.println("Die grösste Zahl ist: " + max);
    }
}

