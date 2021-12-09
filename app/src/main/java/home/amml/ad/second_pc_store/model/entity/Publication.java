package home.amml.ad.second_pc_store.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "publications",
        foreignKeys = {
        @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "idUser",
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Computer.class, parentColumns = "id", childColumns = "idProduct",
                onDelete = ForeignKey.CASCADE)})
public class Publication {
    @PrimaryKey(autoGenerate = true)
    public long id;
    
    @NonNull
    @ColumnInfo(name = "idUser")
    public long idUser;

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
}
