package org.js.vocaapi.dto.member;

import jakarta.validation.constraints.Email;
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
public class MemberInfoDTO {

    @Email
    private String email;

    @NotBlank
    private String nickname;

    @NotBlank
    private String profileImgUrl;

}
