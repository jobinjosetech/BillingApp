import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

class Items {
    static final int tea = 10;
    static final int coffee = 15;
    static final int snacks = 10;
    static final int idli = 8;
    static final int dosha = 6;
}

class Bills {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    String date;
    String name;
    long phoneNumber;

    ArrayList<String> items = new ArrayList<String>();
    double totalAmount;

    public Bills(String name, long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    void addItems(String item){
        items.add(item);
    }

    void generateBills(){
        LocalDateTime now = LocalDateTime.now();
        date = dtf.format(now);
        double total = 0;
        System.out.println("------------- Bills ------------------");
        System.out.println("date: "+date);
        System.out.println("Customer name: "+name);
        System.out.println("Customer phone: "+phoneNumber);

        System.out.println("------- Items -------");
        for(String item: items) {
            if(item=="tea"){
                total+=Items.tea;
                System.out.println("Tea: "+Items.tea);
            } else if (item=="coffee") {
                total+=Items.coffee;
                System.out.println("Coffee: "+Items.coffee);
            }else if (item=="snacks") {
                total+=Items.snacks;
                System.out.println("Snacks: "+Items.snacks);
            }
            else if (item=="idli") {
                total+=Items.idli;
                System.out.println("Idli: "+Items.idli);
            }
            else if (item=="dosha") {
                total+=Items.dosha;
                System.out.println("Dosha: "+Items.dosha);
            }
        }
        totalAmount = total;
        System.out.println("Total Amount: "+totalAmount);
    }
}


public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("\nPlease enter your name: ");
        String name  = sc.next();
        System.out.print("\nPlease enter phone number: ");
        long phone  = sc.nextLong();
        Bills bill = new Bills(name, phone);
        while (true){
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

        switch (choice){
            case 1:
                bill.addItems("tea");
                break;
            case 2:
                bill.addItems("coffee");
                break;
            case 3:
                bill.addItems("snacks");
                break;
            case 4:
                bill.addItems("idli");
                break;
            case 5:
                bill.addItems("dosha");
                break;
            case 6:
                bill.generateBills();
                break;
        }

    }
    }
}