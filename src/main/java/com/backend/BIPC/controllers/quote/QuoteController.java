package com.backend.BIPC.controllers.quote;

import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.entities.quote.Premium;
import com.backend.BIPC.entities.quote.Property;
import com.backend.BIPC.form.QouteResponse;
import com.backend.BIPC.form.Test;
import com.backend.BIPC.services.auth.UserService;
import com.backend.BIPC.services.quote.PremiumService;
import com.backend.BIPC.services.quote.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class QuoteController {

    @Autowired
    private PropertyService propertyService;
    @Autowired
    private PremiumService premiumService;

    @Autowired
    private UserService userService;

    @PostMapping("/get-quote")
    private ResponseEntity<QouteResponse> getQuote(@RequestBody Test test){
     try{
         User user= userService.getUserByUsername(test.getEmail());
         QouteResponse qouteResponse =new QouteResponse();
         Property property=propertyService.getPropertyByUser(user);
         Premium premium=premiumService.getPremiumByProperty(property);
         qouteResponse.setPremium(premium);
         qouteResponse.setProperty(property);
         return ResponseEntity.ok(qouteResponse);
     }
     catch(Exception ex){
         return  ResponseEntity.badRequest().body(null);
        }
    }
}
