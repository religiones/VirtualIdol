package com.virtualidol.repository;

import com.virtualidol.entities.Team;
import com.virtualidol.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface TeamRepository extends JpaRepository<Team, Long>
{
    public abstract Team findTeamByUserFk(User paramUser);

    public abstract Team findTeamById(Long paramLong);
}