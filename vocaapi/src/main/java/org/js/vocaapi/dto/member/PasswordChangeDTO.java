package org.js.vocaapi.dto.member;

import jakarta.validation.constraints.NotBlank;
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
    private String exPassword;
    
    @NotBlank
    private String newPassword;
}
