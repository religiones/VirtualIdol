package com.virtualidol.repository;

import com.virtualidol.entities.Thumbsup;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface ThumbsupRepository extends JpaRepository<Thumbsup, Long>
{
}