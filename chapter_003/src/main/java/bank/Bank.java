package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {

    public Map<User, List<Account>> usersInfo = new HashMap<>();

    public void addUser(User user) {
        usersInfo.put(user, user.getUserAccounts());
    }

    public void deleteUser(User user) {
        usersInfo.remove(user);
    }

    public void addAccountFromUser(String passport, Account account) {
        usersInfo
                .entrySet()
                .stream()
                .filter(e -> e.getKey().getPassport().equals(passport))
                .forEach(e -> {
                    e.getKey().getUserAccounts().add(account);
                });
    }


    public void deleteAccountFromUser(String passport, Account account) {
        usersInfo
                .entrySet()
                .stream()
                .filter(e -> e.getKey().getPassport().equals(passport))
                .forEach(e -> {
                    e.getKey().getUserAccounts().remove(account);
                });
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> resultList = new ArrayList();
        for(Map.Entry<User, List<Account>> item : usersInfo.entrySet()){

            if (item.getKey().getPassport().equals(passport)) {
               resultList = item.getKey().getUserAccounts();
            }
        }
        return  resultList;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {

        return false;
    }
}


