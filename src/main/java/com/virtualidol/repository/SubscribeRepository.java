package com.virtualidol.repository;

import com.virtualidol.entities.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface SubscribeRepository extends JpaRepository<Subscribe, Long>
{
}