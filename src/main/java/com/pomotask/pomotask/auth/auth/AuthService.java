package com.pomotask.pomotask.auth.auth;


import com.pomotask.pomotask.app.service.exception.ObjectNotFoundException;
import com.pomotask.pomotask.auth.user.UserService;
import com.pomotask.pomotask.util.enums.RestMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
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
        Integer userId = this.userService
                .insert(obj.getUser())
                .getId();
        this.useLog(RestMethod.DELETE, userId);
        return obj;
    }

    public void deleteByEmail(String email) {
        Integer userId = this.findByEmail(email)
                .getUser()
                .getId();
        this.useLog(RestMethod.DELETE, userId);
        repo.deleteByEmail(email);
    }

    public AuthModel findByEmail(String email) {
        return this.repo.findByEmail(email)
                .orElseThrow(()  ->
                        new ObjectNotFoundException(
                                "User not found."));
    }

    private void useLog(RestMethod method, Integer id) {
        this.log.info("Object Class: "
                + this.getClass().getName().substring(0, this.getClass().getName().length()-7)
                + ", Action: " + method.getText()
                + ", ITEM_ID: " + id + ".");
    }

}