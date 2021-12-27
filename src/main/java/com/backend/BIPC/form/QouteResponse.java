package com.backend.BIPC.form;

import com.backend.BIPC.entities.quote.Premium;
import com.backend.BIPC.entities.quote.Property;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QouteResponse {

    private Property property;
    private Premium premium;
}
