package com.abhijeet.course.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        // return users;
        return userRepository.findAll();
    }

    public Optional<User> getUser(UUID id) {
        // return users.stream().filter(t -> t.getId().equals(id)).findFirst().get();
        return userRepository.findById(id);
    }

    public Optional<User> getByUserName(String username) {
        return userRepository.findByUserName(username);
    }

    public List<User> getDeletedUsers() {
        return userRepository.findIsDeleted();
    }

    public User addUser(User user) {
        // users.add(user);
        return userRepository.save(user);
    }

    public User updateUser(User user) {
        return userRepository.save(user);
    }

    public User deleteUser(User user) {
        user.setIs_deleted(true);
        return userRepository.save(user);
    }
}
