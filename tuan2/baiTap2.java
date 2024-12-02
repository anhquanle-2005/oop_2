<<<<<<< HEAD
=======
package tuan2;
>>>>>>> Anh_Quan
import java.util.Scanner;

public class bai2 {
    public static void main(String[] args) {       
        Scanner scanner = new Scanner(System.in);
        String name;
        int age;
        double height;
        boolean likesProgramming;

        System.out.print("Nhập tên của bạn: ");
        name = scanner.nextLine();
        
        System.out.print("Nhập tuổi của bạn: ");
        age = scanner.nextInt();
        
        System.out.print("Nhập chiều cao của bạn (mét): ");
        height = scanner.nextDouble();
        
        System.out.print("Có thích lập trình không? (true/false): ");
        likesProgramming = scanner.nextBoolean();

        scanner.close();

        System.out.println("\nThông tin cá nhân:");
        System.out.println("Tên: " + name);
        System.out.println("Tuổi: " + age);
        System.out.println("Chiều cao: " + height + " mét");
        System.out.println("Có thích lập trình không? " + (likesProgramming ? "Có" : "Không"));
    }
}
