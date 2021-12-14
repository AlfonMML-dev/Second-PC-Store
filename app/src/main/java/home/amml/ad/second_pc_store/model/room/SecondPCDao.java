package home.amml.ad.second_pc_store.model.room;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import home.amml.ad.second_pc_store.model.entity.Computer;
import home.amml.ad.second_pc_store.model.entity.ComputerGPU;
import home.amml.ad.second_pc_store.model.entity.GPU;
import home.amml.ad.second_pc_store.model.entity.Publication;
import home.amml.ad.second_pc_store.model.entity.Purchase;
import home.amml.ad.second_pc_store.model.entity.User;
import home.amml.ad.second_pc_store.model.entity.UserPublication;
import home.amml.ad.second_pc_store.model.entity.UserPurchase;
import home.amml.ad.second_pc_store.model.entity.UserSell;

public interface SecondPCDao {

    //Insert Methods
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertComputer(Computer computer);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertGPU(GPU gpu);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertPublication(Publication publication);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertPurchase(Purchase purchase);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insertUser(User user);

    //Update Methods
    @Update
    int updateComputer(Computer computer);

    @Update
    int updateGPU(GPU gpu);

    @Update
    int updatePublication(Publication publication);

    @Update
    int updatePurchase(Purchase purchase);

    @Update
    int updateUser(User user);

    //Delete Methods
    @Delete
    int deleteComputer(Computer computer);

    @Delete
    int deleteGPU(GPU gpu);

    @Delete
    int deletePublication(Publication publication);

    @Delete
    int deletePurchase(Purchase purchase);

    @Delete
    int deleteUser(User user);

    //Query Methods
    @Query("select * from computer where idComputer = :idComputer order by nameProduct asc")
    LiveData<Computer> getComputer(long idComputer);

    @Query("select * from gpu where model = :model order by model asc")
    LiveData<GPU> getGPU(String model);

    @Query("select * from publication where idPost = :idPublication order by date desc")
    LiveData<Publication> getPublication(long idPublication);

    @Query("select * from purchase where idPurchase = :idPurchase order by date desc")
    LiveData<Purchase> getPurchase(long idPurchase);

    @Query("select * from user where idUser = :idUser order by username asc")
    LiveData<User> getUser(long idUser);

    @Query("select * from computer order by nameProduct asc")
    LiveData<List<Computer>> getComputers();

    @Query("select * from gpu order by model asc")
    LiveData<List<GPU>> getGPUs();

    @Query("select * from publication order by date desc")
    LiveData<List<Publication>> getPublications();

    @Query("select * from purchase order by date desc")
    LiveData<List<Purchase>> getPurchases();

    @Query("select * from user order by username asc")
    LiveData<List<User>> getUsers();

    //Complex Query Methods
    /**
     * Método que recibe el modelo de una GPU y devuelve todos los ordenadores que utilizan
     * ese modelo de GPU.
     * @param model Hace referencia al modelo de GPU.
     * @return Los ordenadores que llevan el modelo de GPU, pasado como parámetro.
     */
    @Query("select compu.*, g.model, g.type from computer compu join gpu g " +
            "on compu.gpuModel = g.model where compu.gpuModel = :model order by compu.nameProduct asc")
    LiveData<List<ComputerGPU>> getAllGPUComputers(String model);

    /**
     * Método que recibe un id de un usuario y devuelve todas las publicaciones subidas
     * por tal usuario, ordenadas por fecha, siendo la primera la más reciente.
     * @param userid Hace referencia al identificador del usuario.
     * @return Las publicaciones subidas por el usuario.
     */
    @Query("select publi.*, u.idUser userPubli_idUser, u.username userPubli_username, " +
            "u.urlUserPic userPubli_urlUserPic from publication publi join user u " +
            "on publi.idUserPost = u.idUser where publi.idUserPost = :userid order by publi.date desc")
    LiveData<List<UserPublication>> getAllUserPublications(long userid);

    /**
     * Método que recibe un id de un usuario y devuelve todas las compras realizadas
     * por tal usuario, ordenadas por fecha, siendo la primera la más reciente.
     * @param userid Hace referencia al identificador del usuario.
     * @return Las compras realizadas por el usuario.
     */
    @Query("select purch.*, u.idUser userPur_idUser, u.username userPur_username, " +
            "u.urlUserPic userPur_urlUserPic from purchase purch join user u " +
            "on purch.idBuyer = u.idUser where purch.idBuyer = :userid order by purch.date desc")
    LiveData<List<UserPurchase>> getAllUserPurchases(long userid);

    /**
     * Método que recibe un id de un usuario y devuelve todas las ventas realizadas
     * por tal usuario, ordenadas por fecha, siendo la primera la más reciente.
     * @param userid Hace referencia al identificador del usuario.
     * @return Las ventas realizadas por el usuario.
     */
    @Query("select sell.*, u.idUser userSell_idUser, u.username userSell_username, " +
            "u.urlUserPic userSell_urlUserPic from purchase sell join user u " +
            "on sell.idSeller = u.idUser where sell.idSeller = :userid order by sell.date desc")
    LiveData<List<UserSell>> getAllUserSells(long userid);

}
