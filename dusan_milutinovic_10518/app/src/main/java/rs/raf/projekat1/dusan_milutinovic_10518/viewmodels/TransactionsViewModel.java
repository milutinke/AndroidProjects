package rs.raf.projekat1.dusan_milutinovic_10518.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class TransactionsViewModel {
    private final MutableLiveData<List<BankTransaction>> transactions = new MutableLiveData<>();

    public void setTransactions(List<BankTransaction> newTransactions) {
        transactions.setValue(new ArrayList<>(newTransactions));
    }

    public LiveData<List<BankTransaction>> getTransactions() {
        return transactions;
    }
}
