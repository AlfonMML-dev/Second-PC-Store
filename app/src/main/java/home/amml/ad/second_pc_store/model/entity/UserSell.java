package home.amml.ad.second_pc_store.model.entity;

import androidx.room.Embedded;

public class UserSell {

    @Embedded
    public Purchase purchase;

    @Embedded(prefix = "userSell_")
    public User user;
}
