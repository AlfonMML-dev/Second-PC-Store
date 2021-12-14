package home.amml.ad.second_pc_store.model.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import home.amml.ad.second_pc_store.model.entity.Computer;
import home.amml.ad.second_pc_store.model.entity.GPU;
import home.amml.ad.second_pc_store.model.entity.Publication;
import home.amml.ad.second_pc_store.model.entity.Purchase;
import home.amml.ad.second_pc_store.model.entity.User;

@Database(entities = {Computer.class, GPU.class, Publication.class, Purchase.class, User.class}, version = 1, exportSchema = false)
public abstract class SecondPCDatabase extends RoomDatabase {
    public abstract SecondPCDao getDao();

    private static volatile SecondPCDatabase INSTANCE;

    public static SecondPCDatabase getDatabase(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), SecondPCDatabase.class,
                    "secondpcstore").build();
        }
        return INSTANCE;
    }
}
