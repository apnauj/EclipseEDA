public class BinaryIndexes {
    public static int[] binary(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;
        int firstFound = -1;
        
        while (low <= high && firstFound == -1) {
            int mid = low + (high - low) / 2;
            
            if (array[mid] == target) {
                firstFound = mid;
            } else if (array[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        if (firstFound == -1) {
            return new int[0];
        }

        int left = firstFound;
        while (left > 0 && array[left - 1] == target) {
            left--;
        }

        int right = firstFound;
        while (right < array.length - 1 && array[right + 1] == target) {
            right++;
        }

        int count = right - left + 1;
        int[] result = new int[count];
        for (int i = 0; i < count; i++) {
            result[i] = left + i;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] data = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int[] indices = binary(data, target);
        
        for (int idx : indices) {
            System.out.print(idx + " ");
        }
    }
}