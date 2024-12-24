package cn.lanqiao.sixgroupsprojects.model.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

  private Integer orderId;
  private String recipientName;
  private String totalAmount;
  private String payableAmount;
  private String orderStatus;
  private String paymentStatus;
  private String shippingStatus;
  private String paymentMethod;
  private String deliveryMethod;
  private java.sql.Timestamp orderTime;


}
