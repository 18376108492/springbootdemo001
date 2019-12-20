package com.itdan.controller;

import com.itdan.pojo.User;
import com.itdan.servcie.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @Autowired
   private UserService userService;

    @GetMapping("/user")
    public String toUser(Model model){

        List<User> users=new ArrayList<>();

        for (int i = 0; i <10 ; i++) {
            User user=new User();
            user.setId(i);
            user.setName("xiao"+i);
            user.setAdd("xxxxxx");
            user.setBirthday(new Date());
            if(i%2==0){
                user.setSex(0);
            }else {
                user.setSex(1);
            }
                users.add(user);
        }
        model.addAttribute("users",users);
        return "user";
    }


    @GetMapping("/getbyid")
    public String getByID(){
      return  userService.getUserById(1);
    }

    @GetMapping("/delete")
    public String delete(){
        return  userService.deleteUser(1);
    }


}
