import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("----------------Menu---------------------");
        System.out.println("1. Tea - Rs.10");
        System.out.println("2. Coffee - Rs.15");
        System.out.println("3. Snacks - Rs.10");
        System.out.println("4. Idli - Rs.8");
        System.out.println("5. Dosha - Rs.6");
        System.out.println("6. Generate Bill");
        System.out.println("7. View all transactions");
        System.out.println("8. Exit");
        System.out.println("-----------------------------------------");
        System.out.print("\nPlease enter your choice: ");
        int choice  = sc.nextInt();

    }
}