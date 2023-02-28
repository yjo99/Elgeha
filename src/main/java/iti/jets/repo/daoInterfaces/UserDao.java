package iti.jets.repo.daoInterfaces;
import java.util.List;

import iti.jets.repo.entities.User;

public interface UserDao {
    public void save(User user );
    public void deleteById(int id);
    public void update(User user);
    public User selectUser(int id);
    public List<User> selectUsers();
}
