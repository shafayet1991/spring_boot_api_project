package com.springbootapi.spring.boot.api.project.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<Users> arrayUsers = new ArrayList<>(Arrays.asList(
            new Users("1", "shafayet", "Software Engineer"),
            new Users("2", "ashique", "Software Engineer")
    ));

    public List<Users>  getallUsersList(){
        return arrayUsers;
    }

    public Users getUserDetails(String id){
        return arrayUsers.stream().filter(u -> u.getId().equals(id)).findFirst().get();
    };

    public Users addUser(Users users) {
        arrayUsers.add(users);
        return users;
    }

    public Users updateUser(Users user, String id) {
        for(Users users : arrayUsers){
            if(users.getId().equals(id)){
                users.setName(user.getName());
                users.setRole(user.getRole());
                break;
            }
        }
        return user;
    }

    public String deleteUser(String id) {
        arrayUsers.removeIf(obj -> obj.getId().equals(id));
        return "User Id-" + id + " is removed successfully";
    }
}
