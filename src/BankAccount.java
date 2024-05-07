public class BankAccount {
    private int id;
    private double balance;


    public BankAccount(int id, double initialBalance) {
        this.id = id;
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Depozituar %.2f ne llogarine %d. Bilanci i ri: %.2f%n", amount, id, balance);
        } else {
            System.out.println("Shume e pavlefshme.");
        }
    }

    public synchronized void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.printf("Terhequr %.2f nga llogaria %d. Bilanci i ri: %.2f%n", amount, id, balance);
        } else if (amount > 0) {
            System.out.printf("Fonde te pamjaftueshme në llogarine %d. Bilanci aktual: %.2f%n", id, balance);
        } else {
            System.out.println("Shume e pavlefshme.");
        }
    }

    public synchronized double getBalance() {
        return balance;
    }

    public int getId() {
        return id;
    }
}
