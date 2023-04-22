import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<CurrentAccount> accounts = new ArrayList<CurrentAccount>();
        Bank bank = new Bank(accounts);
        int firstAccountId = bank.createAccount(true, 250, 1000);
        int secoundAccountId = bank.createAccount(false, 5000, 10000);
        bank.deposit(firstAccountId, 100);
        bank.drawMoney(firstAccountId, 250);
        bank.transfer(secoundAccountId, firstAccountId, 500);
        bank.deleteAccount(firstAccountId);
        bank.deleteAccount(secoundAccountId);
    }
}
