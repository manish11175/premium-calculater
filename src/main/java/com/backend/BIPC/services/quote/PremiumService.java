package com.backend.BIPC.services.quote;

import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.entities.quote.Premium;
import com.backend.BIPC.entities.quote.Property;
import com.backend.BIPC.repositories.PremiumRepository;
import com.backend.BIPC.repositories.PropertyRepository;
import com.backend.BIPC.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PremiumService {


    @Autowired
    private PremiumRepository premiumRepository;

    public void savePremium(Premium premium) {
        Premium premium1=premiumRepository.findByProperty(premium.getProperty());
        if(premium1==null){
            premiumRepository.save(premium);
        }
        else{
            premium1.setPremium(premium.getPremium());
            premiumRepository.save(premium1);
        }

    }


    public Premium getPremiumByProperty(Property property) {
        return premiumRepository.findByProperty(property);
    }
}
