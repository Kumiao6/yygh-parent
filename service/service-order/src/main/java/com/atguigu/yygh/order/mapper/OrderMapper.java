package com.atguigu.yygh.order.mapper;

import com.atguigu.yygh.model.order.OrderInfo;
import com.atguigu.yygh.order.config.OrderConfig;
import com.atguigu.yygh.vo.order.OrderCountQueryVo;
import com.atguigu.yygh.vo.order.OrderCountVo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import feign.Param;
import org.aspectj.weaver.ast.Or;

import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/5/9 10:49
 */
public interface OrderMapper extends BaseMapper<OrderInfo> {


    //查询预约统计数据的方法
    List<OrderCountVo> selectOrderCount(@Param("vo") OrderCountQueryVo orderCountQueryVo);
}
