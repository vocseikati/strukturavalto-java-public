package lambdaintro;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class BankAccounts {

    private List<BankAccount> accounts;

    public BankAccounts(List<BankAccount> accounts) {
        this.accounts = accounts;
    }

    public List<BankAccount> listBankAccountsByAccountNumber() {
        accounts.sort(Comparator.comparing(BankAccount::getAccountNumber));
        return accounts;
        //List<BankAccount> ordered = new ArrayList<>(bankAccounts);
        //        ordered.sort(Comparator.naturalOrder());
        //        return ordered;
    }

    public List<BankAccount> listBankAccountsByBalance() {
        accounts.sort((o1, o2) -> (int) (Math.abs(o1.getBalance()) - Math.abs(o2.getBalance())));
        return accounts;
//        List<BankAccount> ordered = new ArrayList<>(bankAccounts);
//        ordered.sort(Comparator.comparing((a) -> Math.abs(a.getBalance())));
//        return ordered;
    }

    public List<BankAccount> listBankAccountsByBalanceDesc() {
        accounts.sort((o1, o2) -> (int) (o2.getBalance() - o1.getBalance()));
        return accounts;
//        List<BankAccount> ordered = new ArrayList<>(bankAccounts);
//        ordered.sort(Comparator.comparing(BankAccount::getBalance).reversed());
//        return ordered;
    }

    public List<BankAccount> listBankAccountsByNameThanAccountNumber() {
        Collator collator = Collator.getInstance(new Locale("hu", "HU"));
        Comparator<BankAccount> comparator = Comparator.comparing(BankAccount::getNameOfOwner, Comparator.nullsFirst(collator))
                .thenComparing(BankAccount::getAccountNumber);
        accounts.sort(comparator);

        //accounts.sort(new Comparator<BankAccount>() {
        //            @Override
        //            public int compare(BankAccount o1, BankAccount o2) {
        //                if (o1.getNameOfOwner().equals(o2.getNameOfOwner())){
        //                    return o1.getAccountNumber().compareTo(o2.getAccountNumber());
        //                } else {
        //                    return o1.getNameOfOwner().compareTo(o2.getNameOfOwner());
        //                }
        //            }
        //        });
        return accounts;
    }
}
