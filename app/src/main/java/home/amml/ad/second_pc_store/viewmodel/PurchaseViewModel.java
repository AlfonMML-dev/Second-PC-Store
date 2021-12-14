package home.amml.ad.second_pc_store.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import home.amml.ad.second_pc_store.model.entity.Purchase;
import home.amml.ad.second_pc_store.model.entity.UserPurchase;
import home.amml.ad.second_pc_store.model.entity.UserSell;
import home.amml.ad.second_pc_store.model.repository.SecondPCRepository;

public class PurchaseViewModel extends AndroidViewModel {

    private SecondPCRepository repository;

    public PurchaseViewModel(@NonNull Application application) {
        super(application);
        repository = new SecondPCRepository(application);
    }

    public void insertPurchase(Purchase purchase){
        repository.insertPurchase(purchase);
    }

    public void updatePurchase(Purchase purchase){
        repository.updatePurchase(purchase);
    }

    public void deletePurchase(Purchase purchase){
        repository.deletePurchase(purchase);
    }

    public LiveData<Purchase> getLivePurchase(long idPurchase) {
        return repository.getLivePurchase(idPurchase);
    }

    public LiveData<List<Purchase>> getLivePurchases() {
        return repository.getLivePurchases();
    }

    public LiveData<List<UserPurchase>> getAllUserPurchases(long userid) {
        return repository.getAllUserPurchases(userid);
    }

    public LiveData<List<UserSell>> getAllUserSells(long userid) {
        return repository.getAllUserSells(userid);
    }

    public MutableLiveData<Long> getLiveInsertPurchase() {
        return repository.getLiveInsertPurchase();
    }

    public MutableLiveData<Integer> getLiveUpdatePurchase() {
        return repository.getLiveUpdatePurchase();
    }

    public MutableLiveData<Integer> getLiveDeletePurchase() {
        return repository.getLiveDeletePurchase();
    }
}
