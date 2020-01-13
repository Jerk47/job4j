/*package bank;

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

    public void transfer(Account anotherAccount, double amount) {
        anotherAccount.setValue(anotherAccount.getValue() + amount);
        this.setValue(this.getValue() - amount);
    }
}
*/
package bank;


import java.util.Objects;

public class Account {

    double values;
    String reqs;

    public Account(double values, String requisites) {
        this.values = values;
        this.reqs = requisites;
    }

    public double getValues() {
        return this.values;
    }


    public String getReqs () {
        return this.reqs;
    }

    boolean transfer(Account destination, double amount) {
        boolean success = false;
        if (amount > 0 && amount < this.values && destination != null) {
            success = true;
            this.values -= amount;
            destination.values += amount;
        }
        return success;
    }

    @Override
    public String toString() {
        String otvet;
        otvet = "Account{" + "values=" + values + ", reqs='" + reqs + "\\" + "}";
        return otvet;
    }

//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//
//        Account account = (Account) o;
//
//        return this.reqs.equals(account.reqs);
//    }



//    public int hashCode() {
//        return this.reqs.hashCode();
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.values, values) == 0 &&
                Objects.equals(reqs, account.reqs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values, reqs);
    }
}