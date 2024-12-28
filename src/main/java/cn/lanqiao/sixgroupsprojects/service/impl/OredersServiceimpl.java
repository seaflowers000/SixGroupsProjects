package cn.lanqiao.sixgroupsprojects.service.impl;

import cn.lanqiao.sixgroupsprojects.mapper.OrdersMapper;
import cn.lanqiao.sixgroupsprojects.model.pojo.Orders;
import cn.lanqiao.sixgroupsprojects.service.OredersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OredersServiceimpl implements OredersService {
    @Autowired
    private OrdersMapper ordersMapper;

    @Override
    public List<Orders> findAll() {
        return ordersMapper.findAll();


    }
}
