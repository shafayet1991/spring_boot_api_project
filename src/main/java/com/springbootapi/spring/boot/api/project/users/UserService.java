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

    public Users addUser(Users users) {
        userRepository.save(users);
        return users;
    }

    public List<Users>  getallUsersList(){
        List<Users> allUsersList = new ArrayList<>();
        userRepository.findAll().forEach(allUsersList::add);
        return allUsersList;
    }

    public Users getUserDetails(String id){
        return userRepository.findById(id).get();
    };

    public Users updateUser(Users user, String id) {
        Users data = userRepository.findById(id).get();
        data.setRole(user.getRole());
        data.setName(user.getPassword());
        data.setName(user.getName());
        userRepository.save(data);
        return userRepository.findById(id).get();
    }

    public String deleteUser(String id) {
        //arrayUsers.removeIf(obj -> obj.getId().equals(id));
        userRepository.deleteById(id);
        return "User Id-" + id + " is removed successfully";
    }
}
