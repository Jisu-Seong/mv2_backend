package org.js.vocaapi.dto;

public class Constants {
    public static final String passwordReg = "^[A-Za-z0-9!@#$%^&*()_-]{8,20}$";

    public static final String nicknameReq = "^[가-힣A-Za-z0-9]{2,20}$";

    public static final String passwordInfoText = "비밀번호는 영문 대소문자/숫자/특수문자 !@#$%^&*()_- 중, 8자리 이상 20자리 이하로 설정하여야 합니다.";

    public static final String nicknameInfoText = "닉네임은 한글문자/영문 대소문자/숫자 중 2자리 이상 20자리 이하로 설정하여야 합니다.";

    
}
