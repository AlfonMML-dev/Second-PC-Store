package home.amml.ad.second_pc_store.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

import home.amml.ad.second_pc_store.model.entity.ComputerGPU;
import home.amml.ad.second_pc_store.model.entity.GPU;
import home.amml.ad.second_pc_store.model.repository.SecondPCRepository;

public class GPUViewModel extends AndroidViewModel {

    private SecondPCRepository repository;

    public GPUViewModel(@NonNull Application application) {
        super(application);
        repository = new SecondPCRepository(application);
    }

    public void insertGPU(GPU gpu){
        repository.insertGPU(gpu);
    }

    public void updateGPU(GPU gpu){
        repository.updateGPU(gpu);
    }

    public void deleteGPU(GPU gpu){
        repository.deleteGPU(gpu);
    }

    public LiveData<GPU> getLiveGPU(String model) {
        return repository.getLiveGPU(model);
    }

    public LiveData<List<GPU>> getLiveGPUs() {
        return repository.getLiveGPUs();
    }

    public LiveData<List<ComputerGPU>> getAllGPUComputers(String model) {
        return repository.getAllGPUComputers(model);
    }

    public MutableLiveData<Long> getLiveInsertGPU() {
        return repository.getLiveInsertGPU();
    }

    public MutableLiveData<Integer> getLiveUpdateGPU() {
        return repository.getLiveUpdateGPU();
    }

    public MutableLiveData<Integer> getLiveDeleteGPU() {
        return repository.getLiveDeleteGPU();
    }
}
