package com.springbootapi.spring.boot.api.project.users;
import com.springbootapi.spring.boot.api.project.MyUserDetailsService;
import com.springbootapi.spring.boot.api.project.util.JwtUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan("com.springbootapi.spring.boot.api.project.users")
public class UserController {
    public UserController() {
    }

    @Autowired
    private UserService userService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @RequestMapping("users")
    public List<Users> getAllUsers(){
        return userService.getallUsersList();
    };
    @RequestMapping("user/{id}")
    public Users getUser(@PathVariable String id){
        return userService.getUserDetails(id);
    }
    @RequestMapping(method = RequestMethod.POST, value = "/user")
    public Users addUser(@RequestBody Users user){
        return userService.addUser(user);
    }
    @RequestMapping(method = RequestMethod.PUT, value = "/user/{id}")
    public Users updateUser(@RequestBody Users user, @PathVariable String id){
        return userService.updateUser(user, id);
    }
    @RequestMapping(method = RequestMethod.DELETE, value = "/user/{id}")
    public String deleteUser(@PathVariable String id){
        return userService.deleteUser(id);
    }
}
