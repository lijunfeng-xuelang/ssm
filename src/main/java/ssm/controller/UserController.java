package ssm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ssm.model.User;
import ssm.service.UserService;

@Controller
public class UserController {
    @Autowired
    private UserService service;
    @GetMapping("/addUser")
    public String add(){
        User user = new User();
        user.setUserName("zhangsan");
        user.setAge(30);
        this.service.addUser(user);
        return "user";
    }
}
