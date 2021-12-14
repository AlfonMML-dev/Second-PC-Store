package home.amml.ad.second_pc_store.model.entity;

import androidx.room.Embedded;

public class UserPurchase {

    @Embedded
    public Purchase purchase;

    @Embedded(prefix = "userPur_")
    public User user;
}
