package com.virtualidol.repository;

import com.virtualidol.entities.Agent;
import com.virtualidol.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface AgentRepository extends JpaRepository<Agent, Long>
{
    public abstract Agent findAgentByUserFk(User paramUser);

    public abstract Agent findAgentById(Long paramLong);
}