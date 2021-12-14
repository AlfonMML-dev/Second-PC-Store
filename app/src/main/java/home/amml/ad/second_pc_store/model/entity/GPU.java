package home.amml.ad.second_pc_store.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "gpu",
        indices = {@Index(value = "model", unique = true)})
public class GPU implements Parcelable {

    @NonNull
    @PrimaryKey
    public String model;

    /**
     * El tipo puede ser dedicada o integrada
     */
    @NonNull
    @ColumnInfo(name = "type")
    public String type;

    public GPU() {}

    public GPU(@NonNull String model, @NonNull String type) {
        this.model = model;
        this.type = type;
    }

    protected GPU(Parcel in) {
        model = in.readString();
        type = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(model);
        dest.writeString(type);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<GPU> CREATOR = new Creator<GPU>() {
        @Override
        public GPU createFromParcel(Parcel in) {
            return new GPU(in);
        }

        @Override
        public GPU[] newArray(int size) {
            return new GPU[size];
        }
    };
}
