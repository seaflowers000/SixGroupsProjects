package cn.lanqiao.sixgroupsprojects.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Roles {

  private long id;
  private String roleName;
  private String permissionRules;
  private String description;
  private long status;


}
