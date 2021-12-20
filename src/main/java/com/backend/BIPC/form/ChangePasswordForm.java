package com.backend.BIPC.form;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordForm {
    private String username;
    private String oldPassword;
    private String newPassword;

}
