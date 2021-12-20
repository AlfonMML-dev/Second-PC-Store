package home.amml.ad.second_pc_store.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "publication",
        indices = {@Index(value = "idUserPost"), @Index(value = "idProduct")},
        foreignKeys = {
        @ForeignKey(entity = User.class, parentColumns = "idUser", childColumns = "idUserPost",
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Computer.class, parentColumns = "idComputer", childColumns = "idProduct",
                onDelete = ForeignKey.CASCADE)})
public class Publication implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public long idPost;

    @NonNull
    @ColumnInfo(name = "idUserPost")
    public long idUserPost;

    @NonNull
    @ColumnInfo(name = "idProduct")
    public long idProduct;

    @NonNull
    @ColumnInfo(name = "sellPrice")
    public double sellPrice;

    @NonNull
    @ColumnInfo(name="date")
    public String date;

    @NonNull
    @ColumnInfo(name = "urlComputer")
    public String urlComputer;

//    public Publication() {}

    public Publication(long idUserPost, long idProduct, double sellPrice,
                       @NonNull String date, @NonNull String urlComputer) {
        this.idUserPost = idUserPost;
        this.idProduct = idProduct;
        this.sellPrice = sellPrice;
        this.date = date;
        this.urlComputer = urlComputer;
    }

    protected Publication(Parcel in) {
        idPost = in.readLong();
        idUserPost = in.readLong();
        idProduct = in.readLong();
        sellPrice = in.readDouble();
        date = in.readString();
        urlComputer = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idPost);
        dest.writeLong(idUserPost);
        dest.writeLong(idProduct);
        dest.writeDouble(sellPrice);
        dest.writeString(date);
        dest.writeString(urlComputer);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Publication> CREATOR = new Creator<Publication>() {
        @Override
        public Publication createFromParcel(Parcel in) {
            return new Publication(in);
        }

        @Override
        public Publication[] newArray(int size) {
            return new Publication[size];
        }
    };
}
