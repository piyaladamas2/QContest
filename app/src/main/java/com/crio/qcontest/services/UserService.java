package com.crio.qcontest.services;

 import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import com.crio.qcontest.entities.User;
import com.crio.qcontest.repositories.IUserRepository;

public class UserService{

    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Creates a new user with the specified name.
     * @param name Name of the user.
     * @return Created User object.
     */
    public User createUser(String name) {

        User newUser= new User(name);
        User user= userRepository.save(newUser);
        return user;
    }

    /**
     * Retrieves a list of users sorted by their score.
     * @param order Sorting order ("ASC" for ascending, "DESC" for descending).
     * @return List of users sorted by score as per the specified order.
     */
    public List<User> showLeaderBoard(String order) {
        List<User> listOfUser;
        listOfUser= userRepository.findAll();

        if ("asc".equalsIgnoreCase(order)) {
            listOfUser = listOfUser.stream()
                    .sorted(Comparator.comparingInt(User::getScore))
                    .collect(Collectors.toList());
        } else if ("desc".equalsIgnoreCase(order)) {
            listOfUser = listOfUser.stream()
                    .sorted(Comparator.comparingInt(User::getScore).reversed())
                    .collect(Collectors.toList());
        } else {
            listOfUser = Collections.emptyList(); // or throw an exception for invalid order value
        }
        return listOfUser;
    } 
}