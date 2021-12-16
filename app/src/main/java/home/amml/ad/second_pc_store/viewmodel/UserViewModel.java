package home.amml.ad.second_pc_store.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import home.amml.ad.second_pc_store.model.entity.User;
import home.amml.ad.second_pc_store.model.repository.SecondPCRepository;

public class UserViewModel extends AndroidViewModel {

    private SecondPCRepository repository;


    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new SecondPCRepository(application);
    }

    public void insertUser(User user){
        repository.insertUser(user);
    }

    public void updateUser(User user){
        repository.updateUser(user);
    }

    public void deleteUser(User user){
        repository.deleteUser(user);
    }

    public LiveData<User> getLiveUser(long idUser) {
        return repository.getLiveUser(idUser);
    }

    public LiveData<User> getLiveUserWithPass(String userName, String passUser) {
        return repository.getLiveUserWithPass(userName, passUser);
    }

    public LiveData<List<User>> getLiveUsers() {
        return repository.getLiveUsers();
    }

    public MutableLiveData<Long> getLiveInsertUser() {
        return repository.getLiveInsertUser();
    }

    public MutableLiveData<Integer> getLiveUpdateUser() {
        return repository.getLiveUpdateUser();
    }

    public MutableLiveData<Integer> getLiveDeleteUser() {
        return repository.getLiveDeleteUser();
    }
}
