package cn.lanqiao.sixgroupsprojects.controller;

import cn.lanqiao.sixgroupsprojects.model.pojo.Orders;
//import cn.lanqiao.sixgroupsprojects.service.OredersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/orders") // 定义基础路径为 /orders
public class OrdersController {

    @Autowired
//    private OrdersService ordersService; // 自动注入 OrdersService
//    private OrdersService ordersService;

    // 获取所有订单信息的接口
    @GetMapping("/all") // 映射到 URL 的 /orders/all
    public List<Orders> getAllOrders() {
//        return ordersService.findAll(); // 调用服务层方法获取所有订单
    }

    // 可以根据需要添加更多的端点（Endpoints），例如，获取单个订单信息、创建新订单、更新订单状态等
}