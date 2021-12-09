package home.amml.ad.second_pc_store.model.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "purchases",
        foreignKeys = {
        @ForeignKey(entity = User.class, parentColumns = "id", childColumns = {"idBuyer", "idSeller"},
                onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = Computer.class, parentColumns = "id", childColumns = "idProduct",
                onDelete = ForeignKey.CASCADE)})
public class Purchase {
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

    @ColumnInfo(name="date")
    public String date;
}
