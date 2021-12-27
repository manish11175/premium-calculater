package com.backend.BIPC.form;


import com.backend.BIPC.entities.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PremiumRequest {

   private Double premium;

   private String email;
}
