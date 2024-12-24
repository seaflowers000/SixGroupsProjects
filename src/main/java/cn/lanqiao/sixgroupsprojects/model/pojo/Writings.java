package cn.lanqiao.sixgroupsprojects.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Writings {

  private long id;
  private String title;
  private java.sql.Timestamp publishTime;
  private String category;
  private long sortOrder;
  private long isRecommended;
  private long isTop;
  private long isApproved;

}
