package home.amml.ad.second_pc_store.model.entity;

import androidx.room.Embedded;

public class ComputerGPU {

    @Embedded
    public Computer computer;

    @Embedded(prefix = "gpuCompu_")
    public GPU gpu;
}
