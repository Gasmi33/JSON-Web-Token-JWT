package com.example.demo.api;

import com.example.demo.domain.Role;
import com.example.demo.service.*;
import com.example.demo.domain.User;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.security.Principal;
import java.util.List;
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor

public class UserResource {
    private final UserService  userService;
    @GetMapping("/users")
    public ResponseEntity<List<User>>getUsers(Principal principal){
        System.out.println(principal.getName());
        return ResponseEntity.ok().body(userService.getUsers());
    }
    @RequestMapping("/user/save")
    public ResponseEntity<User>saveUser(@RequestBody User user)
    {
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));
    }
    @RequestMapping("/role/save")
    public ResponseEntity<Role>saveRole(@RequestBody Role role)
    {
        URI uri= URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    @RequestMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUser form )
    {
        userService.addRoleToUser(form.getUsername(), form.getRolename());
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/username", method = RequestMethod.GET)
    @ResponseBody
        public String currentUserName(Principal principal) {
            return principal.getName();
        }


}
@Data
class RoleToUser{
    private String username;
    private String rolename;
}
