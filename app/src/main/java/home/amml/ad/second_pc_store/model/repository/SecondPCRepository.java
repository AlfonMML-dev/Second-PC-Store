package home.amml.ad.second_pc_store.model.repository;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import home.amml.ad.second_pc_store.model.entity.Computer;
import home.amml.ad.second_pc_store.model.entity.ComputerGPU;
import home.amml.ad.second_pc_store.model.entity.GPU;
import home.amml.ad.second_pc_store.model.entity.Publication;
import home.amml.ad.second_pc_store.model.entity.Purchase;
import home.amml.ad.second_pc_store.model.entity.User;
import home.amml.ad.second_pc_store.model.entity.UserPublication;
import home.amml.ad.second_pc_store.model.entity.UserPurchase;
import home.amml.ad.second_pc_store.model.entity.UserSell;
import home.amml.ad.second_pc_store.model.room.SecondPCDao;
import home.amml.ad.second_pc_store.model.room.SecondPCDatabase;

public class SecondPCRepository {

    //Declaración de la interfaz SecondPCDao
    private SecondPCDao dao;

    private LiveData<Computer> liveComputer;
    private LiveData<GPU> liveGPU;
    private LiveData<Publication> livePublication;
    private LiveData<Purchase> livePurchase;
    private LiveData<User> liveUser;
    private LiveData<User> liveUserWithPass;

    private LiveData<List<Computer>> liveComputers;
    private LiveData<List<GPU>> liveGPUs;
    private LiveData<List<Publication>> livePublications;
    private LiveData<List<Purchase>> livePurchases;
    private LiveData<List<User>> liveUsers;

    private LiveData<List<ComputerGPU>> allGPUComputers;
    private LiveData<List<UserPublication>> allUserPublications;
    private LiveData<List<UserPurchase>> allUserPurchases;
    private LiveData<List<UserSell>> allUserSells;

    private MutableLiveData<Long> liveInsertComputer;
    private MutableLiveData<Integer> liveUpdateComputer;
    private MutableLiveData<Integer> liveDeleteComputer;
    private MutableLiveData<Long> liveInsertGPU;
    private MutableLiveData<Integer> liveUpdateGPU;
    private MutableLiveData<Integer> liveDeleteGPU;
    private MutableLiveData<Long> liveInsertPublication;
    private MutableLiveData<Integer> liveUpdatePublication;
    private MutableLiveData<Integer> liveDeletePublication;
    private MutableLiveData<Long> liveInsertPurchase;
    private MutableLiveData<Integer> liveUpdatePurchase;
    private MutableLiveData<Integer> liveDeletePurchase;
    private MutableLiveData<Long> liveInsertUser;
    private MutableLiveData<Integer> liveUpdateUser;
    private MutableLiveData<Integer> liveDeleteUser;

    private SharedPreferences preferences;

    public SecondPCRepository(Context context) {
        SecondPCDatabase db = SecondPCDatabase.getDatabase(context);
        dao = db.getDao();
        liveInsertComputer = new MutableLiveData<>();
        liveUpdateComputer = new MutableLiveData<>();
        liveDeleteComputer = new MutableLiveData<>();
        liveInsertGPU = new MutableLiveData<>();
        liveUpdateGPU = new MutableLiveData<>();
        liveDeleteGPU = new MutableLiveData<>();
        liveInsertPublication = new MutableLiveData<>();
        liveUpdatePublication = new MutableLiveData<>();
        liveDeletePublication = new MutableLiveData<>();
        liveInsertPurchase = new MutableLiveData<>();
        liveUpdatePurchase = new MutableLiveData<>();
        liveDeletePurchase = new MutableLiveData<>();
        liveInsertUser = new MutableLiveData<>();
        liveUpdateUser = new MutableLiveData<>();
        liveDeleteUser = new MutableLiveData<>();
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public void insertComputer(Computer computer){
        Runnable r  = () ->{
            liveInsertComputer.postValue(dao.insertComputer(computer));
        };
        new Thread(r).start();
    }

    public void updateComputer(Computer computer){
        Runnable r  = () ->{
            liveUpdateComputer.postValue(dao.updateComputer(computer));
        };
        new Thread(r).start();
    }

    public void deleteComputer(Computer computer){
        Runnable r  = () ->{
            liveDeleteComputer.postValue(dao.deleteComputer(computer));
        };
        new Thread(r).start();
    }

    public void insertGPU(GPU gpu){
        Runnable r  = () ->{
            liveInsertGPU.postValue(dao.insertGPU(gpu));
        };
        new Thread(r).start();
    }

    public void updateGPU(GPU gpu){
        Runnable r  = () ->{
            liveUpdateGPU.postValue(dao.updateGPU(gpu));
        };
        new Thread(r).start();
    }

    public void deleteGPU(GPU gpu){
        Runnable r  = () ->{
            liveDeleteGPU.postValue(dao.deleteGPU(gpu));
        };
        new Thread(r).start();
    }

    public void insertPublication(Publication publication){
        Runnable r  = () ->{
            liveInsertPublication.postValue(dao.insertPublication(publication));
        };
        new Thread(r).start();
    }

    public void updatePublication(Publication publication){
        Runnable r  = () ->{
            liveUpdatePublication.postValue(dao.updatePublication(publication));
        };
        new Thread(r).start();
    }

    public void deletePublication(Publication publication){
        Runnable r  = () ->{
            liveDeletePublication.postValue(dao.deletePublication(publication));
        };
        new Thread(r).start();
    }

    public void insertPurchase(Purchase purchase){
        Runnable r  = () ->{
            liveInsertPurchase.postValue(dao.insertPurchase(purchase));
        };
        new Thread(r).start();
    }

    public void updatePurchase(Purchase purchase){
        Runnable r  = () ->{
            liveUpdatePurchase.postValue(dao.updatePurchase(purchase));
        };
        new Thread(r).start();
    }

    public void deletePurchase(Purchase purchase){
        Runnable r  = () ->{
            liveDeletePurchase.postValue(dao.deletePurchase(purchase));
        };
        new Thread(r).start();
    }

    public void insertUser(User user){
        Runnable r  = () ->{
            liveInsertUser.postValue(dao.insertUser(user));
        };
        new Thread(r).start();
    }

    public void updateUser(User user){
        Runnable r  = () ->{
            liveUpdateUser.postValue(dao.updateUser(user));
        };
        new Thread(r).start();
    }

    public void deleteUser(User user){
        Runnable r  = () ->{
            liveDeleteUser.postValue(dao.deleteUser(user));
        };
        new Thread(r).start();
    }

    public LiveData<Computer> getLiveComputer(long idComputer) {
        if(liveComputer == null){
            liveComputer = dao.getComputer(idComputer);
        }
        return liveComputer;
    }

    public LiveData<GPU> getLiveGPU(String model) {
        if(liveGPU == null){
            liveGPU = dao.getGPU(model);
        }
        return liveGPU;
    }

    public LiveData<Publication> getLivePublication(long idPublication) {
        if(livePublication == null){
            livePublication = dao.getPublication(idPublication);
        }
        return livePublication;
    }

    public LiveData<Purchase> getLivePurchase(long idPurchase) {
        if(livePurchase == null){
            livePurchase = dao.getPurchase(idPurchase);
        }
        return livePurchase;
    }

    public LiveData<User> getLiveUser(long idUser) {
        if(liveUser == null){
            liveUser = dao.getUser(idUser);
        }
        return liveUser;
    }

    public LiveData<User> getLiveUserWithPass(String userName, String passUser) {
        if(liveUserWithPass == null){
            liveUserWithPass = dao.getUserWithPass(userName, passUser);
        }
        return liveUserWithPass;
    }

    public LiveData<List<Computer>> getLiveComputers() {
        if(liveComputers == null){
            liveComputers = dao.getComputers();
        }
        return liveComputers;
    }

    public LiveData<List<GPU>> getLiveGPUs() {
        if(liveGPUs == null){
            liveGPUs = dao.getGPUs();
        }
        return liveGPUs;
    }

    public LiveData<List<Publication>> getLivePublications() {
        if(livePublications == null){
            livePublications = dao.getPublications();
        }
        return livePublications;
    }

    public LiveData<List<Purchase>> getLivePurchases() {
        if(livePurchases == null){
            livePurchases = dao.getPurchases();
        }
        return livePurchases;
    }

    public LiveData<List<User>> getLiveUsers() {
        if(liveUsers == null){
            liveUsers = dao.getUsers();
        }
        return liveUsers;
    }

    public LiveData<List<ComputerGPU>> getAllGPUComputers(String model) {
        if (allGPUComputers == null){
            allGPUComputers = dao.getAllGPUComputers(model);
        }
        return allGPUComputers;
    }

    public LiveData<List<UserPublication>> getAllUserPublications(long userid) {
        if (allUserPublications == null){
            allUserPublications = dao.getAllUserPublications(userid);
        }
        return allUserPublications;
    }

    public LiveData<List<UserPurchase>> getAllUserPurchases(long userid) {
        if (allUserPurchases == null){
            allUserPurchases = dao.getAllUserPurchases(userid);
        }
        return allUserPurchases;
    }

    public LiveData<List<UserSell>> getAllUserSells(long userid) {
        if (allUserSells == null){
            allUserSells = dao.getAllUserSells(userid);
        }
        return allUserSells;
    }

    public MutableLiveData<Long> getLiveInsertComputer() {
        return liveInsertComputer;
    }

    public MutableLiveData<Integer> getLiveUpdateComputer() {
        return liveUpdateComputer;
    }

    public MutableLiveData<Integer> getLiveDeleteComputer() {
        return liveDeleteComputer;
    }

    public MutableLiveData<Long> getLiveInsertGPU() {
        return liveInsertGPU;
    }

    public MutableLiveData<Integer> getLiveUpdateGPU() {
        return liveUpdateGPU;
    }

    public MutableLiveData<Integer> getLiveDeleteGPU() {
        return liveDeleteGPU;
    }

    public MutableLiveData<Long> getLiveInsertPublication() {
        return liveInsertPublication;
    }

    public MutableLiveData<Integer> getLiveUpdatePublication() {
        return liveUpdatePublication;
    }

    public MutableLiveData<Integer> getLiveDeletePublication() {
        return liveDeletePublication;
    }

    public MutableLiveData<Long> getLiveInsertPurchase() {
        return liveInsertPurchase;
    }

    public MutableLiveData<Integer> getLiveUpdatePurchase() {
        return liveUpdatePurchase;
    }

    public MutableLiveData<Integer> getLiveDeletePurchase() {
        return liveDeletePurchase;
    }

    public MutableLiveData<Long> getLiveInsertUser() {
        return liveInsertUser;
    }

    public MutableLiveData<Integer> getLiveUpdateUser() {
        return liveUpdateUser;
    }

    public MutableLiveData<Integer> getLiveDeleteUser() {
        return liveDeleteUser;
    }

}
