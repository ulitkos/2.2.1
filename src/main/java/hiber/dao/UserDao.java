package hiber.dao;

import hiber.model.User;
import hiber.service.UserService;

import java.util.List;

public interface UserDao //extends UserService
{
   void add(User user);
   List<User> listUsers();
   List<User> listUsersByCar(String model, int series);
}
