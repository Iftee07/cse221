import java.util.Arrays;

public class mergeSort {
    public static void divide(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = start + (end - start) / 2;
        divide(arr, start, mid);
        divide(arr, mid + 1, end);
        conquer(arr, start, mid, end);

    }

    public static void conquer(int[] arr, int start, int mid, int end) {
        int idx1 = start;
        int idx2 = mid + 1;
        int k = 0;
        int merged[] = new int[end - start + 1];

        while (idx1 <= mid && idx2 <= end) {
            if (arr[idx1] <= arr[idx2]) {
                merged[k++] = arr[idx1++];
            } else {
                merged[k++] = arr[idx2++];
            } 
        }

        while (idx1 <= mid) {
            merged[k++] = arr[idx1++];
        }
        while (idx2 <= end) {
            merged[k++] = arr[idx2++];
        }

        for (int i = 0, j = start; i < merged.length; i++, j++) {
            arr[j] = merged[i];
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 4, 2, 7, 8, 3, 4, 2, 1, 3, 4, 5, 2, 1, 2 };
        divide(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
