public class maxSubSequence {
    public static int findMaxSum(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxHastaAhora = nums[0];
        int maxActual = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxActual = Math.max(nums[i], maxActual + nums[i]);
            maxHastaAhora = Math.max(maxHastaAhora, maxActual);
        }

        return maxHastaAhora;
    }

    public static void main(String[] args) {
        int[] arreglo = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("La suma máxima es: " + findMaxSum(arreglo));
    }
}