package com.pomotask.pomotask.auth.auth_user;


import com.pomotask.pomotask.auth.user.UserService;
import com.pomotask.pomotask.main.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AuthService {


    @Autowired
    private AuthRepository repo;
    @Autowired
    private UserService userService;


    public AuthModel findOrInsertByEmail(String email) {
        return this.repo.findByEmail(email)
                .orElse(this.insert(new AuthModel(email)));
    }

    public AuthModel insert(AuthModel obj) {
        obj.getUser().setAuth(obj);
        obj = repo.save(obj);
        userService.insert(obj.getUser());
        return obj;
    }

    public void deleteByEmail(String email) {
        repo.deleteByEmail(email);
    }

    public AuthModel findByEmail(String email) {
        return this.repo.findByEmail(email)
                .orElseThrow(()  ->
                        new ObjectNotFoundException(
                                "User not found."));
    }

}