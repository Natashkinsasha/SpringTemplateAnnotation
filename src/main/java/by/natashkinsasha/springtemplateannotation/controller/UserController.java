package by.natashkinsasha.springtemplateannotation.controller;


import by.natashkinsasha.springtemplateannotation.entity.User;
import by.natashkinsasha.springtemplateannotation.entity.Waybill;
import by.natashkinsasha.springtemplateannotation.entity.WaybillStatus;
import by.natashkinsasha.springtemplateannotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class UserController {

    @Autowired
    @Qualifier("userServiceImpl")
    UserService service;

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @ResponseBody
    public List<User> getAllUsers() {
        return service.getAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public User saveUser(@RequestBody User user) {
        return service.save(user);
    }


    @RequestMapping(value = "/users_test", method = RequestMethod.GET)
    @ResponseBody
    public void init(){
        User firstUser = new User();
        firstUser.setUsername("Alex Natashkin");
        User secondUser = new User();
        secondUser.setUsername("Peta Petrov");
        saveUser(firstUser);
        saveUser(secondUser);
    }
}
