package com.virtualidol.repository;

import com.virtualidol.entities.Idol;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface IdolRepository extends JpaRepository<Idol, Long>
{
    public abstract Idol findIdolByName(String paramString);

    public abstract Idol findIdolById(Long paramLong);
}