package com.abhijeet.course.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    //getAllUsers()
    //getUser(UUID id)
    //addUser(User user)
    //updateUser(User user)
    //deleteUser(UUID id)

    Optional<User> findByUserName(String username);

    @Query(value = "SELECT * FROM User e WHERE e.is_deleted = true", nativeQuery = true)
    List<User> findIsDeleted();
}
