public class App {
    public static void main(String[] args) throws Exception {
        Bank bank = new Bank();
        int firstAccountId = bank.createAccount(250);
        int secoundAccountId = bank.createAccount(5000, 10000);
        bank.deposit(firstAccountId, 100);
        bank.drawMoney(firstAccountId, 250);
        bank.transfer(secoundAccountId, firstAccountId, 50);
        System.out.println(bank.getExtract(firstAccountId));
    }
}
 