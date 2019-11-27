package bank;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {

    private User userVasily = new User("Vasily", "27471");
    private User userIvan = new User("Ivan", "27472");
    private User userMarya = new User("Marya", "27473");
    private User userOlga = new User("Olga", "27474");
    private Bank bank = new Bank();
    private Account account1 = new Account(500, 111);
    private Account account2 = new Account(1000, 112);
    private Account account3 = new Account(1500, 113);
    private Account account4 = new Account(2000, 114);
    private Account account5 = new Account(0, 115);

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

    @Test
    public void whenDeleteAccountFromUser() {
        bank.addUser(userVasily);
        bank.addAccountFromUser(userVasily.getPassport(), account1);
        bank.addAccountFromUser(userVasily.getPassport(), account2);
        bank.addAccountFromUser(userVasily.getPassport(), account3);
        bank.deleteAccountFromUser(userVasily.getPassport(), account1);
        assertThat(userVasily.getUserAccounts().get(0), is(account2));
        assertThat(userVasily.getUserAccounts().get(1), is(account3));
    }

    @Test
    public void whenGetUserAccounts() {
        List<Account> resultList = new ArrayList<>();
        List<Account> expectedList = new ArrayList<>();
        bank.addUser(userVasily);
        bank.addAccountFromUser(userVasily.getPassport(), account1);
        bank.addAccountFromUser(userVasily.getPassport(), account2);
        bank.addAccountFromUser(userVasily.getPassport(), account3);
        expectedList.add(account1);
        expectedList.add(account2);
        expectedList.add(account3);
        resultList = bank.getUserAccounts(userVasily.getPassport());
        assertEquals(expectedList, resultList);
    }

    @Test
    public void whenTransferMoney() {
        boolean result;
        boolean resultIfZero;
        bank.addUser(userVasily);
        bank.addUser(userIvan);
        bank.addAccountFromUser(userVasily.getPassport(), account1);
        bank.addAccountFromUser(userVasily.getPassport(), account5);
        bank.addAccountFromUser(userIvan.getPassport(), account2);
        result = bank.transferMoney(userVasily.getPassport(), Integer.toString(userVasily.getUserAccounts().get(0).getRequisites()),
                userIvan.getPassport(), Integer.toString(userIvan.getUserAccounts().get(0).getRequisites()), 500.00);
        resultIfZero = bank.transferMoney(userVasily.getPassport(), Integer.toString(userVasily.getUserAccounts().get(1).getRequisites()),
                userIvan.getPassport(), Integer.toString(userIvan.getUserAccounts().get(0).getRequisites()), 500.00);
        assertThat(userVasily.getUserAccounts().get(0).getValue(), closeTo(0.0, 0));
        assertThat(userIvan.getUserAccounts().get(0).getValue(), closeTo(1500.0, 0));
        assertThat(result, is(true));
        assertThat(resultIfZero, is(false));

    }
}