package bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

public class Bank {

    public Map<User, List<Account>> usersInfo = new HashMap<>();

    public void addUser(User user) {
        usersInfo.putIfAbsent(user, user.getUserAccounts());
    }

    public void deleteUser(User user) {
        usersInfo.remove(user);
    }

    public void addAccountFromUser(String passport, Account account) {
        searchByPassport(passport).forEach(e ->
                e.getKey().getUserAccounts().add(account));
    }

    public void deleteAccountFromUser(String passport, Account account) {
        searchByPassport(passport).forEach(e ->
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
        AtomicBoolean result = new AtomicBoolean(false);
        searchByPassport(srcPassport).
                forEach(e -> {
                    for (Account account : e.getKey().getUserAccounts()) {
                        searchByRequisite(srcRequisite, dstRequisite, destPassport, amount, account, result);
                    }
                });
        return result.get();
    }

    private Stream<Map.Entry<User, List<Account>>> searchByPassport(String passport) {
        return usersInfo
                .entrySet()
                .stream()
                .filter(e -> e.getKey().getPassport().equals(passport));
    }

    private void searchByRequisite(String srcRequisite, String dstRequisite,
                                   String destPassport, double amount, Account account, AtomicBoolean result) {
        if (account.getRequisites() == Integer.parseInt(srcRequisite) && account.getValue() >= amount) {
            searchByPassport(destPassport).
                    forEach(r -> {
                        for (Account dstAccount : r.getKey().getUserAccounts()) {
                            if (dstAccount.getRequisites() == Integer.parseInt(dstRequisite)) {
                                account.transfer(account, dstAccount, amount);
                                result.set(true);
                            }
                        }
                    });
        }
    }
}


