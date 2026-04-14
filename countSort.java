import java.util.Arrays;

public class countSort {
    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 4, 2, 7, 8, 3, 4, 2, 1, 3, 4, 5, 2, 1, 2 };
        int retured[] = count_sort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println("------------------------------");
        System.out.println(Arrays.toString(retured));
    }

    public static int[] count_sort(int[] arr) {
        if (arr.length == 0) {
            return arr;
        }

        int max_val = arr[0];
        for (int num : arr) {
            if (num > max_val) {
                max_val = num;
            }
        }

        int count_arr[] = new int[max_val + 1];
        for (int num : arr) {
            count_arr[num]++;
        }
        System.out.println(Arrays.toString(count_arr));

        for (int i = 1; i < count_arr.length; i++) {
            count_arr[i] = count_arr[i - 1] + count_arr[i];
        }
        System.out.println(Arrays.toString(count_arr));

        for (int i = count_arr.length - 1; i > 0; i--) {
            count_arr[i] = count_arr[i - 1];
        }
        count_arr[0] = 0;
        System.out.println(Arrays.toString(count_arr));

        int ret_arr[] = new int[arr.length];
        for (int num : arr) {
            ret_arr[count_arr[num]] = num;
            count_arr[num]++;
        }
        return ret_arr;
    }
}