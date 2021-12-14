package home.amml.ad.second_pc_store.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import home.amml.ad.second_pc_store.model.entity.Publication;
import home.amml.ad.second_pc_store.model.entity.UserPublication;
import home.amml.ad.second_pc_store.model.repository.SecondPCRepository;

public class PublicationViewModel extends AndroidViewModel {

    private SecondPCRepository repository;


    public PublicationViewModel(@NonNull Application application) {
        super(application);
        repository = new SecondPCRepository(application);
    }

    public void insertPublication(Publication publication){
        repository.insertPublication(publication);
    }

    public void updatePublication(Publication publication){
        repository.updatePublication(publication);
    }

    public void deletePublication(Publication publication){
        repository.deletePublication(publication);
    }

    public LiveData<Publication> getLivePublication(long idPublication) {
        return repository.getLivePublication(idPublication);
    }

    public LiveData<List<Publication>> getLivePublications() {
        return repository.getLivePublications();
    }

    public LiveData<List<UserPublication>> getAllUserPublications(long userid) {
        return repository.getAllUserPublications(userid);
    }

    public MutableLiveData<Long> getLiveInsertPublication() {
        return repository.getLiveInsertPublication();
    }

    public MutableLiveData<Integer> getLiveUpdatePublication() {
        return repository.getLiveUpdatePublication();
    }

    public MutableLiveData<Integer> getLiveDeletePublication() {
        return repository.getLiveDeletePublication();
    }


}
