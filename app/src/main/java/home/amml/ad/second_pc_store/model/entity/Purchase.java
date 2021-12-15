package home.amml.ad.second_pc_store.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "purchase",
        indices = {@Index(value = "idProduct")},
        foreignKeys = {
                @ForeignKey(entity = Computer.class, parentColumns = "idComputer", childColumns = "idProduct",
                        onDelete = ForeignKey.CASCADE)})
public class Purchase implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public long idPurchase;

    @NonNull
    @ColumnInfo(name = "idBuyer")
    public long idBuyer;

    @NonNull
    @ColumnInfo(name = "idSeller")
    public long idSeller;

    @NonNull
    @ColumnInfo(name = "idProduct")
    public long idProduct;

    @NonNull
    @ColumnInfo(name = "sellPrice")
    public double sellPrice;

    @ColumnInfo(name = "date")
    public String date;

//    public Purchase() {}

    public Purchase(long idPurchase, long idBuyer, long idSeller, long idProduct, double sellPrice, String date) {
        this.idPurchase = idPurchase;
        this.idBuyer = idBuyer;
        this.idSeller = idSeller;
        this.idProduct = idProduct;
        this.sellPrice = sellPrice;
        this.date = date;
    }

    protected Purchase(Parcel in) {
        idPurchase = in.readLong();
        idBuyer = in.readLong();
        idSeller = in.readLong();
        idProduct = in.readLong();
        sellPrice = in.readDouble();
        date = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idPurchase);
        dest.writeLong(idBuyer);
        dest.writeLong(idSeller);
        dest.writeLong(idProduct);
        dest.writeDouble(sellPrice);
        dest.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Purchase> CREATOR = new Creator<Purchase>() {
        @Override
        public Purchase createFromParcel(Parcel in) {
            return new Purchase(in);
        }

        @Override
        public Purchase[] newArray(int size) {
            return new Purchase[size];
        }
    };
}
