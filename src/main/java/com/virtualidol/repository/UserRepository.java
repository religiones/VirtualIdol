package com.virtualidol.repository;

import com.virtualidol.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface UserRepository extends JpaRepository<User, Long>
{
    public abstract User findByAccount(String paramString);

    public abstract User findUserById(Long paramLong);
}