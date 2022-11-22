import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TransferQueue;

class Items {
    static final int tea = 10;
    static final int coffee = 15;
    static final int snacks = 10;
    static final int idli = 8;
    static final int dosha = 6;
}

class Item {
    String item;
    int quantity;

    public Item(String item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
}

class Bills {
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");
    String date;
    String name;
    long phoneNumber;

    ArrayList<Item> items = new ArrayList<Item>();
    double totalAmount;

    public Bills(String name, long phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    void addItems(String item, int quantity){
        boolean find = false;
        for(int i=0;i<items.size();i++){
            if(items.get(i).item.equals(item)){
                System.out.println("enter");
                int value = items.get(i).quantity;
                items.set(i, new Item(item, (value+quantity)));;
                find = true;
                break;
            }
        }
        if(!find){
            System.out.println("entered");
            items.add(new Item(item, quantity));
        }

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
        for(Item item: items) {
            if(item.item=="tea"){
                total+=Items.tea*item.quantity;
                System.out.println("Tea: "+Items.tea+"*"+item.quantity+"="+(Items.tea*item.quantity));
            } else if (item.item=="coffee") {
                total+=Items.coffee*item.quantity;
                System.out.println("Coffee: "+Items.coffee+"*"+item.quantity+"="+(Items.coffee*item.quantity));
            }else if (item.item=="snacks") {
                total+=Items.snacks*item.quantity;
                System.out.println("Snacks: "+Items.snacks+"*"+item.quantity+"="+(Items.snacks*item.quantity));
            }
            else if (item.item=="idli") {
                total+=Items.idli*item.quantity;
                System.out.println("Idli: "+Items.idli+"*"+item.quantity+"="+(Items.idli*item.quantity));
            }
            else if (item.item=="dosha") {
                total+=Items.dosha*item.quantity;
                System.out.println("Dosha: "+Items.dosha+"*"+item.quantity+"="+(Items.dosha*item.quantity));
            }
        }
        totalAmount = total;
        System.out.println("Total Amount: "+totalAmount);
    }
}


public class Main {
    static ArrayList<Bills> transactions = new ArrayList<Bills>();
    static Scanner sc = new Scanner(System.in);

    static void displayTransactions() {
        System.out.println("---------------- Transactions ---------------------");
        for(Bills transaction: transactions) {
            System.out.println("Date: "+transaction.date);
            System.out.println("Customer : "+transaction.name);
            System.out.println("Phone : "+transaction.phoneNumber);
            System.out.println("Amount: "+transaction.totalAmount);
            System.out.println("-----------------------\n");
        }
    }
    private boolean checkQuantity(int quantity){
        if(quantity>0){
            return true;
        }else {
            return false;
        }
    }

    public static void main(String[] args) {
        boolean newCustomer = true;
        Bills bill = null;
        while (true){
            if(newCustomer){
                System.out.print("\nPlease enter your name: ");
                String name  = sc.next();
                System.out.print("\nPlease enter phone number: ");
                long phone  = sc.nextLong();
                bill = new Bills(name, phone);
                newCustomer = false;
            }
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
                    System.out.print("Enter quantity: ");
                    int teaQ = sc.nextInt();
                    if(teaQ >0){
                        bill.addItems("tea", teaQ);
                    }else{
                        System.out.println("Invalid Quantity");
                    }
                    break;
                case 2:
                    System.out.print("Enter quantity: ");
                    int coffeeQ = sc.nextInt();
                    if(coffeeQ >0){
                        bill.addItems("coffee", coffeeQ);
                    }else{
                        System.out.println("Invalid Quantity");
                    }
                    break;
                case 3:
                    System.out.print("Enter quantity: ");
                    int snackQ = sc.nextInt();
                    if(snackQ >0){
                        bill.addItems("snacks", snackQ);
                    }else{
                        System.out.println("Invalid Quantity");
                    }
                    break;
                case 4:
                    System.out.print("Enter quantity: ");
                    int idliQ = sc.nextInt();
                    if(idliQ >0){
                        bill.addItems("idli", idliQ);
                    }else{
                        System.out.println("Invalid Quantity");
                    }
                    break;
                case 5:
                    System.out.print("Enter quantity: ");
                    int doshaQ = sc.nextInt();
                    if(doshaQ >0){
                        bill.addItems("dosha", doshaQ);
                    }else{
                        System.out.println("Invalid Quantity");
                    }
                    break;
                case 6:
                    bill.generateBills();
                    transactions.add(bill);
                    newCustomer = true;
                    break;
                case 7:
                    displayTransactions();
                    newCustomer = true;
                    break;
                case 8:
                    System.exit(0);
                    break;

            }

        }
    }
}