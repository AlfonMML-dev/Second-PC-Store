package home.amml.ad.second_pc_store.model.entity;

import androidx.room.Embedded;

public class UserPublication {

    @Embedded
    public Publication publication;

    @Embedded(prefix = "userPubli_")
    public User user;
}
