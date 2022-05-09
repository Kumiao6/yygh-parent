package com.atguigu.yygh.order.api;

import com.atguigu.yygh.common.result.Result;
import com.atguigu.yygh.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：m
 * @date ：Created in 2022/5/9 10:38
 */
@RestController
@RequestMapping("/api/order/orderInfo")
@Api(value = "订单接口")
public class OrderApiController {

    @Autowired
    private OrderService orderService;

    //生成挂号订单
    @ApiOperation(value = "生成挂号订单")
    @PostMapping("auth/submitOrder/{scheduleId}/{patientId}")
    public Result savaOrders(@PathVariable String scheduleId,
                             @PathVariable Long patientId) {
        Long orderId = orderService.saveOrder(scheduleId,patientId);
        return Result.ok(orderId);
    }

}
