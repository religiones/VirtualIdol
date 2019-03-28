package com.virtualidol.repository;

import com.virtualidol.entities.Comment_relation;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface Comment_relationRepository extends JpaRepository<Comment_relation, Long>
{
}