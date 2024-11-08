package org.js.vocaapi.dto.member;

import org.js.vocaapi.dto.Constants;

import jakarta.validation.constraints.Email;
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
public class JoinRequestDTO {
    @Email
    private String email;

    @NotBlank
    @Pattern(regexp = Constants.passwordReg, message = Constants.passwordInfoText)
    @Size(min = 8, max = 20)
    private String password;

    @NotBlank
    @Pattern(regexp = Constants.nicknameReq, message = Constants.nicknameInfoText)
    @Size(min = 2, max = 20)
    private String nickname;
}
