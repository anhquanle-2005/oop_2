package tuan5;
import java.util.Scanner;

public class baiTap1 {
    public static void main(String[] args) {
        Scanner mang = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử của mảng: ");
        int n = mang.nextInt();

        int[] arr = new int[n];

        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            arr[i] = mang.nextInt();
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        System.out.println("Tổng các phần tử trong mảng là: " + sum);
    }
}