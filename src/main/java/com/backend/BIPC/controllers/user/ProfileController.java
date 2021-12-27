package com.backend.BIPC.controllers.user;


import com.backend.BIPC.Exception.GenericException;
import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.entities.user.Profile;
import com.backend.BIPC.form.Test;
import com.backend.BIPC.services.auth.UserService;
import com.backend.BIPC.services.user.ProfileService;
import com.backend.BIPC.utils.FileUploadUtil;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @Autowired
    private FileUploadUtil fileUploadUtil;

    @Autowired
    private UserService userService;


    @PostMapping("/profile")
    public Profile getProfile(@RequestBody Test test){

        User user=userService.getUserByUsername(test.getEmail());
        System.out.println(user);
        return profileService.getProfileByUser(user);
    }

    @PostMapping("/set-user-profile")
    public Profile uplaodProfile(@RequestParam("image") MultipartFile file, @RequestParam("mobile")
            String mobile, @RequestParam("email") String email, @RequestParam("address") String address,
                                 @RequestParam("city") String city, @RequestParam("state") String state, @RequestParam("pincode") int pincode
    ) throws Exception {
        if (file.isEmpty()) {
            throw  new GenericException("file is not found");
        }
        try {
            String path = fileUploadUtil.saveFile(file);

            try {
                User user = userService.getUserByUsername(email);
                Profile profile = new Profile(null, mobile, address, city, state, pincode, path, user);
                Profile profile1 = profileService.save(profile);
                return profile1;
            } catch (Exception ex) {
                throw new Exception("Profile not added" + ex.getMessage());
            }
        } catch (Exception e) {
            throw new Exception("file not uploaded");
        }

    }
}
