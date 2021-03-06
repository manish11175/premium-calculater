package com.backend.BIPC.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PremiumResponse {
    private Long propertyId;
    private String item;
    private Double basePremium;
    private String insuranceType;
    private String insuranceSubType;
}
