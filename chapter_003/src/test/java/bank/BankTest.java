package bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BankTest {

    User userVasily = new User("Vasily", "27471");
    User userIvan = new User("Ivan", "27472");
    User userMarya = new User("Marya", "27473");
    User userOlga = new User("Olga", "27474");
    Bank bank = new Bank();
    Account account1 = new Account(500, 111);
    Account account2 = new Account(1000, 112);
    Account account3 = new Account(1500, 113);
    Account account4 = new Account(2000, 114);
    Account account5 = new Account(0, 115);

    @Test
    public void whenAddUser() {
        bank.addUser(userVasily);
        bank.addUser(userIvan);
        bank.addUser(userMarya);
        boolean result1 = bank.usersInfo.containsKey(userVasily);
        boolean result2 = bank.usersInfo.containsKey(userIvan);
        boolean result3 = bank.usersInfo.containsKey(userMarya);
        boolean result4 = bank.usersInfo.containsKey(userOlga);
        assertThat(result1, is(true));
        assertThat(result2, is(true));
        assertThat(result3, is(true));
        assertThat(result4, is(false));
    }

    @Test
    public void whenDeleteUser() {
        bank.addUser(userVasily);
        boolean result1 = bank.usersInfo.containsKey(userVasily);
        bank.deleteUser(userVasily);
        boolean result2 = bank.usersInfo.containsKey(userVasily);
        assertThat(result1, is(true));
        assertThat(result2, is(false));
    }

    @Test
    public void whenAddAccountFromUser() {
        bank.addUser(userVasily);
        bank.addAccountFromUser(userVasily.getPassport(), account1);
        bank.addAccountFromUser(userVasily.getPassport(), account2);
        bank.addAccountFromUser(userVasily.getPassport(), account3);
        assertThat(userVasily.getUserAccounts().get(0), is(account1));
        assertThat(userVasily.getUserAccounts().get(1), is(account2));
        assertThat(userVasily.getUserAccounts().get(2), is(account3));
    }
}