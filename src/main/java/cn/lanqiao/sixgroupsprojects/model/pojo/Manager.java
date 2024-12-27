package cn.lanqiao.sixgroupsprojects.model.pojo;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

  private Integer id;
  private String loginName;
  private String password;
  private String phone;
  private String email;
  private String role;
  private java.sql.Timestamp joinTime;
  private Integer status;
  private String code;

}
