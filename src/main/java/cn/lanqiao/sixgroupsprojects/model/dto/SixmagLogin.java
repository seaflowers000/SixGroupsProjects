package cn.lanqiao.sixgroupsprojects.model.dto;

import lombok.Data;

@Data
public class SixmagLogin {
    private String loginName;
    private String password;
    private boolean remember;
    private Integer id;
    private String role;
    private  String userText;
    private String verifyCode;
    private String phone;
}
