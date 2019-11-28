package bank;

public class Account {
    private double value;
    private int requisites;

    public Account(double value, int requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getRequisites() {
        return requisites;
    }

    public void setRequisites(int requisites) {
        this.requisites = requisites;
    }

    public void transfer(Account account, Account dstAccount, double amount) {
        dstAccount.setValue(dstAccount.getValue() + amount);
        account.setValue(account.getValue() - amount);
    }
}
