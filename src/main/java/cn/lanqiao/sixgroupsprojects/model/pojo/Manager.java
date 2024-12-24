package cn.lanqiao.sixgroupsprojects.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Manager {

  private Integer id;
  private String loginName;
  private String phone;
  private String email;
  private String role;
  private java.sql.Timestamp joinTime;
  private Integer status;

}
