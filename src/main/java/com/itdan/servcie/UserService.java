package com.itdan.servcie;

import org.springframework.stereotype.Service;

@Service
public class UserService {


    public String getUserById(Integer id){
            return "根据ID查询用户"+id;
    }

    public String deleteUser(Integer id){
        return "删除用户"+id;
    }


}
