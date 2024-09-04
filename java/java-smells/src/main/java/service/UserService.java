package service;

import model.User;

import java.time.LocalDate;
import java.util.ArrayList;

public class UserService {
    private ArrayList<User> users;

    public UserService() {
        users = new ArrayList<>();
    }

    public User addUser(String fullName, LocalDate dateOfBirth) {
        User user = new User(users.size() + 1, fullName, dateOfBirth);
        users.add(user);
        return user;
    }

    public int getUserNo() {
        return users.size();
    }

    public User getUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public boolean isAdult(int id) {
        User user = getUserById(id);

        return !user.getDateOfBirth().plusYears(18).isAfter(LocalDate.now());
    }
}
