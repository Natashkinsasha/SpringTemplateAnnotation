package by.natashkinsasha.springtemplateannotation.service;


import by.natashkinsasha.springtemplateannotation.entity.User;
import by.natashkinsasha.springtemplateannotation.entity.Waybill;

import java.util.List;

public interface UserService {
    List<User> getAll();
    User getByID(long id);
    User save(User user);
    void remove(long id);

}
