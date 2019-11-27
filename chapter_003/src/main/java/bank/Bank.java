package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    public Map<User, List<Account>> usersInfo = new HashMap<>();

    public void addUser(User user) {
        usersInfo.putIfAbsent(user, user.getUserAccounts());
    }

    public void deleteUser(User user) {
        usersInfo.remove(user);
    }

    public void addAccountFromUser(String passport, Account account) {
        usersInfo
                .entrySet()
                .stream()
                .filter(e -> e.getKey().getPassport().equals(passport))
                .forEach(e ->
                    e.getKey().getUserAccounts().add(account));
    }


    public void deleteAccountFromUser(String passport, Account account) {
        usersInfo
                .entrySet()
                .stream()
                .filter(e -> e.getKey().getPassport().equals(passport))
                .forEach(e ->
                    e.getKey().getUserAccounts().remove(account));
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> resultList = new ArrayList<>();
        for (Map.Entry<User, List<Account>> item : usersInfo.entrySet()) {

            if (item.getKey().getPassport().equals(passport)) {
                resultList = item.getKey().getUserAccounts();
            }
        }
        return resultList;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        boolean result = true;
        usersInfo
                .entrySet()
                .stream()
                .filter(e -> e.getKey().getPassport().equals(srcPassport)).
                forEach(e -> {
                    for (Account account : e.getKey().getUserAccounts()) {
                        if (account.getRequisites() == Integer.parseInt(srcRequisite)) {
                            usersInfo
                                    .entrySet()
                                    .stream()
                                    .filter(r -> r.getKey().getPassport().equals(destPassport)).
                                    forEach(r -> {
                                        for (Account dstAccount : r.getKey().getUserAccounts()) {
                                            if (dstAccount.getRequisites() == Integer.parseInt(dstRequisite)) {
                                                dstAccount.setValue(dstAccount.getValue() + amount);
                                                account.setValue(account.getValue() - amount);
                                            }
                                        }
                                    });
                        }
                    }
                });
        return result;
    }

    public static void main(String[] args) {
        User testUser = new User("Roman", "4729 647583");
        Bank testBank = new Bank();
        Account testAccount1 = new Account(1000.00, 2874321);
        Account testAccount2 = new Account(1500.00, 2874322);
        testBank.addUser(testUser);
        testBank.addAccountFromUser(testUser.getPassport(), testAccount1);
        testBank.addAccountFromUser(testUser.getPassport(), testAccount2);
        testBank.transferMoney("4729 647583", Integer.toString(testAccount1.getRequisites()), "4729 647583", Integer.toString(testAccount2.getRequisites()), 500.00);
        System.out.println(testBank.getUserAccounts("4729 647583").get(0).getValue());
        System.out.println(testBank.getUserAccounts("4729 647583").get(1).getValue());
    }
}


