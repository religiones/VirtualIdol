package com.virtualidol.repository;

import com.virtualidol.entities.Comment;
import com.virtualidol.entities.User;
import com.virtualidol.entities.Work;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface CommentRepository extends JpaRepository<Comment, Long>
{
    public abstract List<Comment> findAllByWorkFk(Work paramWork);

    public abstract List<Comment> findAllByUserFk(User paramUser);
}