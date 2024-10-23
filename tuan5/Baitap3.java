import java.util.Arrays;

public class baiTap3 {
    public static void main(String[] args) {
        // Khởi tạo mảng
        int[] array = {5, 2, 9, 1, 5, 6};

        // In mảng ban đầu
        System.out.println("Mảng ban đầu: " + Arrays.toString(array));

        // Sắp xếp mảng
        bubbleSort(array);

        // In mảng đã sắp xếp
        System.out.println("Mảng đã sắp xếp: " + Arrays.toString(array));
    }

    public static void bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;

        // Thuật toán sắp xếp nổi bọt
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                // Nếu phần tử hiện tại lớn hơn phần tử tiếp theo, hoán đổi chúng
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            // Nếu không có phần tử nào được hoán đổi, mảng đã được sắp xếp
            if (!swapped) {
                break;
            }
        }
    }
}
