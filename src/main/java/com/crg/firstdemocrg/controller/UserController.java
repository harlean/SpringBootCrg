package com.crg.firstdemocrg.controller;


import com.crg.firstdemocrg.domin.User;
import com.crg.firstdemocrg.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
public class UserController {

    private final UserRepo userRepo;

    @Autowired
    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @PostMapping("/person/save")
    public User save(@RequestParam String name){
        User user = new User();
        user.setName(name);
       if(userRepo.save(user)){
           System.out.printf("用户对象：%s 保存成功！ \n",user);
       }
        return  user;
    }
}
