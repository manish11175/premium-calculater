package com.backend.BIPC.controllers.auth;

import com.backend.BIPC.form.ChangePasswordForm;
import com.backend.BIPC.services.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ChangePasswordController {
    @Autowired
    private UserService userService;


    @PostMapping("/change-password")
    public String changePassword(@RequestBody ChangePasswordForm changePasswordForm) throws Exception {
        return userService.changePassword(changePasswordForm);
    }

}
