package com.backend.BIPC.services.quote;

import com.backend.BIPC.entities.auth.User;
import com.backend.BIPC.entities.quote.Premium;
import com.backend.BIPC.entities.quote.Property;
import com.backend.BIPC.repositories.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public Property savePropertyDetails(Property propertyDetails){
        Property property = propertyRepository.findByUser(propertyDetails.getUser());
        if (property==null){
            return propertyRepository.save(propertyDetails);
        }
        else {
            property.setCoverageDate(propertyDetails.getCoverageDate());
            property.setInsuranceSubType(propertyDetails.getInsuranceSubType());
            property.setItem(propertyDetails.getItem());
            property.setModel(propertyDetails.getModel());
            property.setPurchaseDate(propertyDetails.getPurchaseDate());
            property.setInsuranceType(propertyDetails.getInsuranceType());
            property.setPurchaseRate(propertyDetails.getPurchaseRate());
            return propertyRepository.save(property);
        }

    }

    public Property getPropertyByUser(User user) {
        return propertyRepository.findByUser(user);
    }


}
