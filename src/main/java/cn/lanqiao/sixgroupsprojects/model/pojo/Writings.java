package cn.lanqiao.sixgroupsprojects.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Writings {

  private Integer id;
  private String title;
  private java.sql.Timestamp publishTime;
  private String category;
  private Integer sortOrder;
  private Integer isRecommended;
  private Integer isTop;
  private Integer isApproved;

}
