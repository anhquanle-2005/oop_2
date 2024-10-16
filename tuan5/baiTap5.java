

import java.util.*;

public class baiTap5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử trong danh sách: ");
        int soLuong = scanner.nextInt();

        int[] danhSach = new int[soLuong];

        for (int i = 0; i < soLuong; i++) {
            System.out.print("Nhập số nguyên thứ " + (i + 1) + ": ");
            danhSach[i] = scanner.nextInt();
        }

        System.out.println("\nDanh sách các số nguyên:");
        for (int i = 0; i < danhSach.length; i++) {
            System.out.println("Số nguyên thứ " + (i + 1) + ": " + danhSach[i]);
        }
        scanner.close();
    }
}
