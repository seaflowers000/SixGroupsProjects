package cn.lanqiao.sixgroupsprojects.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MagVO {
    private Integer id;
    private String loginName;
    private String password;
    private String role;
    private Integer status;
    private String Token;
}
