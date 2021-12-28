package service.impl;

import bean.User;
import repository.IUserRepository;
import repository.impl.UserRepository;
import service.IUserService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService implements IUserService {

    private IUserRepository iUserRepository = new UserRepository();

    @Override
    public void insertUser(User user) throws SQLException {
        this.iUserRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return this.iUserRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return this.iUserRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return this.iUserRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return this.iUserRepository.updateUser(user);
    }

    @Override
    public List<User> searchByCountry(String country) {
        return this.iUserRepository.searchByCountry(country);
    }

    @Override
    public List<User> sortList(String sortValue) {
        return this.iUserRepository.sortList(sortValue);
    }
}
