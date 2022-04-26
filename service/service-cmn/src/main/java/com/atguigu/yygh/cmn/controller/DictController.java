package com.atguigu.yygh.cmn.controller;

import com.alibaba.excel.EasyExcel;
import com.atguigu.yygh.cmn.service.DictService;
import com.atguigu.yygh.common.result.Result;
import com.atguigu.yygh.model.cmn.Dict;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/4/26 09:03
 */
@Api(tags = "医院字典")
@RestController
@RequestMapping("/admin/cmn/dict")
@CrossOrigin
public class DictController {

    @Autowired
    private DictService dictService;

    //导出数据字典接口
    @GetMapping("/exportData")
    public Result export(HttpServletResponse response) {
        dictService.exportDictData(response);
        return Result.ok();
    }




    //根据id查询子节点数据列表
    @ApiOperation(value = "根据数据id查询子数据列表")
    @GetMapping("/findChildData/{id}")
    public Result findChildData(@PathVariable Long id){
        List<Dict> list = dictService.findChirData(id);
        return Result.ok(list);
    }

}
