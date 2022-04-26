package com.atguigu.yygh.cmn.service;

import com.atguigu.yygh.cmn.mapper.DictMapper;
import com.atguigu.yygh.model.cmn.Dict;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/4/26 08:54
 */
public interface DictService extends IService<Dict> {
    List<Dict> findChirData(Long id);
}
