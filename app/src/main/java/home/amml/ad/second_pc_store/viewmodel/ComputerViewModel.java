package home.amml.ad.second_pc_store.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import home.amml.ad.second_pc_store.model.entity.Computer;
import home.amml.ad.second_pc_store.model.entity.ComputerGPU;
import home.amml.ad.second_pc_store.model.repository.SecondPCRepository;

public class ComputerViewModel extends AndroidViewModel {

    private SecondPCRepository repository;

    public ComputerViewModel(@NonNull Application application) {
        super(application);
        repository = new SecondPCRepository(application);
    }

    public void insertComputer(Computer computer){
        repository.insertComputer(computer);
    }

    public void updateComputer(Computer computer){
        repository.updateComputer(computer);
    }

    public void deleteComputer(Computer computer){
        repository.deleteComputer(computer);
    }

    public LiveData<Computer> getLiveComputer(long idComputer) {
        return repository.getLiveComputer(idComputer);
    }

    public LiveData<List<Computer>> getLiveComputers() {
        return repository.getLiveComputers();
    }

    public LiveData<List<ComputerGPU>> getAllGPUComputers(String model) {
        return repository.getAllGPUComputers(model);
    }

    public MutableLiveData<Long> getLiveInsertComputer() {
        return repository.getLiveInsertComputer();
    }

    public MutableLiveData<Integer> getLiveUpdateComputer() {
        return repository.getLiveUpdateComputer();
    }

    public MutableLiveData<Integer> getLiveDeleteComputer() {
        return repository.getLiveDeleteComputer();
    }
}
