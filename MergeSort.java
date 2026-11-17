import java.util.Arrays;

class MergeSort {
    public static int[] mergesort(int[] arr) {
        // 1. Base case to stop infinite recursion
        if (arr.length <= 1) {
            return arr;
        }

        // 2. Use '/' instead of '//', and pass 0 and arr.length
        int mid = arr.length / 2;
        int[] lefthalf = Arrays.copyOfRange(arr, 0, mid);
        int[] righthalf = Arrays.copyOfRange(arr, mid, arr.length);

        // 3. Declare types for sortedleft and sortedright
        int[] sortedleft = mergesort(lefthalf);
        int[] sortedright = mergesort(righthalf);

        return merge(sortedleft, sortedright);
    }

    // 4. Return type is int[], and parameters must have types
    public static int[] merge(int[] left, int[] right) {
        // 5. Fixed-size array instead of dynamic list
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // 6. Copy remaining elements instead of Python's .extend(left[i:])
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Unsorted Array : "+ Arrays.toString(arr));
        int[] sorted = mergesort(arr);
        System.out.println("Sorted Array: " + Arrays.toString(sorted));
    }
}