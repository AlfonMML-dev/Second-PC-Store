package home.amml.ad.second_pc_store.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "computers")
public class Computer {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @NonNull
    @ColumnInfo(name = "nameProduct")
    public String nameProduct;

    @NonNull
    @ColumnInfo(name = "typeComputer")
    public String typeComputer;

    @NonNull
    @ColumnInfo(name = "cpu")
    public String cpu;

    /**
     * Tiene únicamente dos filas y dos columnas por fila.
     * Primera fila - primer campo -> dedicada
     * Primera fila - segundo campo -> modelo
     */
    @NonNull
    @ColumnInfo(name = "gpu")
    public String[][] gpu;

    @NonNull
    @ColumnInfo(name = "ram")
    public short ram;

    //SSD o HD
    @NonNull
    @ColumnInfo(name = "typeMemory")
    public String typeMemory;

    @NonNull
    @ColumnInfo(name = "sizeMemory")
    public short sizeMemory;

    @ColumnInfo(name = "timeBatery")
    public String timeBatery;

    @ColumnInfo(name = "tasaRefresco")
    public short tasaRefresco;

    @ColumnInfo(name = "numPortsTotal")
    public short numPortsTotal;

    @ColumnInfo(name = "numUSB3Ports")
    public short numUSB3Ports;

    @ColumnInfo(name = "numUSBPorts")
    public short numUSBPorts;

    @ColumnInfo(name = "numRJPorts")
    public short numRJPorts;

    @ColumnInfo(name = "numHDMIPorts")
    public short numHDMIPorts;
}
