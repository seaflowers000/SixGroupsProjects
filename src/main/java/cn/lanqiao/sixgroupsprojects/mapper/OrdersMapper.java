package cn.lanqiao.sixgroupsprojects.mapper;

import cn.lanqiao.sixgroupsprojects.model.pojo.Orders;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrdersMapper {
    @Select("select * form orders")
    List<Orders> findAll();
}
