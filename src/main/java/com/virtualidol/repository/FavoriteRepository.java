package com.virtualidol.repository;

import com.virtualidol.entities.Favorite;
import com.virtualidol.entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface FavoriteRepository extends JpaRepository<Favorite, Long>
{
    public abstract List<Favorite> findAllByUserFk(User paramUser);
}