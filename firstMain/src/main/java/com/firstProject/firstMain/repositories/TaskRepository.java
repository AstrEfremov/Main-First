package com.firstProject.firstMain.repositories;

import com.firstProject.firstMain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.firstProject.firstMain.entities.Task;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Optional<User> findByTitle(String title);
}
