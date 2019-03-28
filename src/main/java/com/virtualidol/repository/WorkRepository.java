package com.virtualidol.repository;

import com.virtualidol.entities.Work;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface WorkRepository extends JpaRepository<Work, Long>
{
    public abstract List<Work> findAll();
}