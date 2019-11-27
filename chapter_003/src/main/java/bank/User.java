package bank;

import java.util.ArrayList;
import java.util.Objects;

public class User {
    private String name;
    private String passport;
    private ArrayList<Account> userAccounts = new ArrayList<>();

    public ArrayList<Account> getUserAccounts() {
        return userAccounts;
    }

    public void setUserAccounts(Account account) {
        this.userAccounts.add(account);
    }

    public User(String name, String passport, ArrayList<Account> userAccounts) {
        this.name = name;
        this.passport = passport;
        this.userAccounts = userAccounts;
    }


    public User(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name) &&
                Objects.equals(passport, user.passport);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, passport);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassport() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }
}
