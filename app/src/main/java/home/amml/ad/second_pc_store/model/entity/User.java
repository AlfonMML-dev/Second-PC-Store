package home.amml.ad.second_pc_store.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "user",
        indices = {@Index(value = "username", unique = true)})
public class User implements Parcelable {
    @PrimaryKey(autoGenerate = true)
    public long idUser;

    @NonNull
    @ColumnInfo(name = "username")
    public String username;

    @NonNull
    @ColumnInfo(name = "password")
    public String password;

    //Si el usuario no sube una imagen para registrarse, se le pondrá una por defecto
    @ColumnInfo(name = "urlUserPic")
    public String urlUserPic;

    public User() {}

    public User(long idUser, @NonNull String username, @NonNull String password, String urlUserPic) {
        this.idUser = idUser;
        this.username = username;
        this.password = password;
        this.urlUserPic = urlUserPic;
    }

    protected User(Parcel in) {
        idUser = in.readLong();
        username = in.readString();
        password = in.readString();
        urlUserPic = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {return 0;}

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(idUser);
        dest.writeString(username);
        dest.writeString(password);
        dest.writeString(urlUserPic);
    }
}
