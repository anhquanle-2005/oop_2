
import java.util.Arrays;

public class baiTap2 {
    public static void main(String[] args) {
        // Khởi tạo mảng
        int[] array = {1, 2, 3, 4, 5};

        // In mảng ban đầu
        System.out.println("Mảng ban đầu: " + Arrays.toString(array));

        // Đảo ngược mảng
        reverseArray(array);

        // In mảng đã đảo ngược
        System.out.println("Mảng đã đảo ngược: " + Arrays.toString(array));
    }

    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            // Hoán đổi phần tử
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            // Di chuyển con trỏ
            left++;
            right--;
        }
    }
}

