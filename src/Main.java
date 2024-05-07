public class Main {
    public static void main(String[] args) {
        
        BankAccount llogari1 = new BankAccount(1, 1000.00);
        BankAccount llogari2 = new BankAccount(2, 500.00);
        
        Runnable[] transactions = new Runnable[] {
                new Transaction(llogari1, 200.00, true),  // Depozite ne llogari1
                new Transaction(llogari1, 300.00, false), // Terheqje nga llogari1
                new Transaction(llogari1, 100.00, true),  // Depozite ne llogari1
                new Transaction(llogari1, 500.00, false), // Terheqje nga llogari1
                new Transaction(llogari2, 150.00, true),  // Depozite ne llogari2
                new Transaction(llogari2, 50.00, false),  // Terheqje nga llogari2
                new Transaction(llogari2, 200.00, true),  // Depozite ne llogari2
                new Transaction(llogari2, 600.00, false)  // Terheqje nga llogari2 (fonde te pamjaftueshme)
        };

        Thread[] threads = new Thread[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            threads[i] = new Thread(transactions[i]);
            threads[i].start();
        }
        
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {

            }
        }

        
        System.out.printf("Bilanci perfundimtar i llogarise %d: %.2f%n", llogari1.getId(), llogari1.getBalance());
        System.out.printf("Bilanci perfundimtar i llogarise %d: %.2f%n", llogari2.getId(), llogari2.getBalance());
    }
}