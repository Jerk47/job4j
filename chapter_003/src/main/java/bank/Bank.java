package bank;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Bank {

    public Map<User, List<Account>> usersInfo = new HashMap<>();

    public void addUser(User user) {
        usersInfo.putIfAbsent(user, user.getUserAccounts());
    }

    public void deleteUser(User user) {
        usersInfo.remove(user);
    }

    public void addAccountFromUser(String passport, Account account) {
        searchByPassport(passport).getUserAccounts().add(account);
    }

    public void deleteAccountFromUser(String passport, Account account) {
        searchByPassport(passport).getUserAccounts().remove(account);
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
        AtomicBoolean result = new AtomicBoolean(false);
        Account srcAccount = searchByRequisite(searchByPassport(srcPassport), srcRequisite);
        Account dstAccount = searchByRequisite(searchByPassport(destPassport), dstRequisite);
        if (srcAccount.getValue() >= amount) {
            srcAccount.transfer(dstAccount, amount);
            result.set(true);
        }
        return result.get();
    }

    public User searchByPassport(String passport) {
        return usersInfo
                .entrySet()
                .stream()
                .filter(e ->
                        e.getKey().getPassport().equals(passport))
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);
    }

    public Account searchByRequisite(User user, String req) {
        Account resultAccount = null;
        if (user != null) {
            for (Account account : searchByPassport(user.getPassport()).getUserAccounts()) {
                if (account.getRequisites() == Integer.parseInt(req)) {
                    resultAccount = account;
                    break;
                }
            }
        }
        return resultAccount;
    }
}



