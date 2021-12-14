package home.amml.ad.second_pc_store.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "computer",
        indices = {@Index(value = {"cpu", "ram"})},
        foreignKeys = @ForeignKey(entity = GPU.class, parentColumns = "model", childColumns = "gpuModel",
                onDelete = ForeignKey.CASCADE))
public class Computer implements Parcelable {

    @PrimaryKey(autoGenerate = true)
    public long idComputer;

    @NonNull
    @ColumnInfo(name = "nameProduct")
    public String nameProduct;

    @NonNull
    @ColumnInfo(name = "typeComputer")
    public String typeComputer;

    @NonNull
    @ColumnInfo(name = "cpu")
    public String cpu;

    @NonNull
    @ColumnInfo(name = "gpuModel")
    public String gpuModel;

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

    public Computer() {
    }

    public Computer(long idComputer, @NonNull String nameProduct, @NonNull String typeComputer,
                    @NonNull String cpu, @NonNull String gpuModel, short ram,
                    @NonNull String typeMemory, short sizeMemory, String timeBatery,
                    short tasaRefresco, short numPortsTotal, short numUSB3Ports, short numUSBPorts,
                    short numRJPorts, short numHDMIPorts) {
        this.idComputer = idComputer;
        this.nameProduct = nameProduct;
        this.typeComputer = typeComputer;
        this.cpu = cpu;
        this.gpuModel = gpuModel;
        this.ram = ram;
        this.typeMemory = typeMemory;
        this.sizeMemory = sizeMemory;
        this.timeBatery = timeBatery;
        this.tasaRefresco = tasaRefresco;
        this.numPortsTotal = numPortsTotal;
        this.numUSB3Ports = numUSB3Ports;
        this.numUSBPorts = numUSBPorts;
        this.numRJPorts = numRJPorts;
        this.numHDMIPorts = numHDMIPorts;
    }

    protected Computer(Parcel in) {
        idComputer = in.readLong();
        nameProduct = in.readString();
        typeComputer = in.readString();
        cpu = in.readString();
        gpuModel = in.readString();
        ram = (short) in.readInt();
        typeMemory = in.readString();
        sizeMemory = (short) in.readInt();
        timeBatery = in.readString();
        tasaRefresco = (short) in.readInt();
        numPortsTotal = (short) in.readInt();
        numUSB3Ports = (short) in.readInt();
        numUSBPorts = (short) in.readInt();
        numRJPorts = (short) in.readInt();
        numHDMIPorts = (short) in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idComputer);
        dest.writeString(nameProduct);
        dest.writeString(typeComputer);
        dest.writeString(cpu);
        dest.writeString(gpuModel);
        dest.writeInt((int) ram);
        dest.writeString(typeMemory);
        dest.writeInt((int) sizeMemory);
        dest.writeString(timeBatery);
        dest.writeInt((int) tasaRefresco);
        dest.writeInt((int) numPortsTotal);
        dest.writeInt((int) numUSB3Ports);
        dest.writeInt((int) numUSBPorts);
        dest.writeInt((int) numRJPorts);
        dest.writeInt((int) numHDMIPorts);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Computer> CREATOR = new Creator<Computer>() {
        @Override
        public Computer createFromParcel(Parcel in) {
            return new Computer(in);
        }

        @Override
        public Computer[] newArray(int size) {
            return new Computer[size];
        }
    };
}
