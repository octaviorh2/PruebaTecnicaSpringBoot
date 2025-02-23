package com.prueba.backend.infrastructure.repository;

import com.prueba.backend.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User ,Long> {
    @Query("SELECT u FROM User u WHERE u.userName = :username")
    User findByUsername(@Param("username") String username);
}
