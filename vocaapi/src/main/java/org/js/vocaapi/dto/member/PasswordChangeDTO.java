package org.js.vocaapi.dto.member;

import org.js.vocaapi.dto.Constants;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PasswordChangeDTO {
    
    @NotBlank
    @Pattern(regexp = Constants.passwordReg, message = Constants.passwordInfoText)
    @Size(min = 8, max = 20)
    private String exPassword;
    
    @NotBlank
    @Pattern(regexp = Constants.passwordReg, message = Constants.passwordInfoText)
    @Size(min = 8, max = 20)
    private String newPassword;
}
