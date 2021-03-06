package repository;

import bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    public void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

    public List<User> searchByCountry(String country);

    public List<User> sortList(String sortValue);

    public List<User> findAllUsers();

    public void deleteUserProcedure(int id) throws SQLException;

    public  void updateUserProcedure (int id, String name, String email, String country) throws SQLException;
    }
