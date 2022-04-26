package com.atguigu.yygh.cmn.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.yygh.cmn.mapper.DictMapper;
import com.atguigu.yygh.cmn.service.DictService;
import com.atguigu.yygh.model.cmn.Dict;
import com.atguigu.yygh.vo.cmn.DictEeVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/4/26 08:55
 */
@Service
public class DictServiceImpl extends ServiceImpl<DictMapper, Dict> implements DictService {


    //根据数据id查询子数据列表
    @Override
    public List<Dict> findChirData(Long id) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", id);
        List<Dict> dictList = baseMapper.selectList(wrapper);


        for (Dict dict : dictList) {
            Long dictId = dict.getId();
            boolean hasChild = this.hasChild(dictId);
            dict.setHasChildren(hasChild);
        }
        return dictList;

    }


    //导出数据字典接口
    @Override
    public void exportDictData(HttpServletResponse response) {
        //设置编码集
        response.setCharacterEncoding("utf-8");
        //设置输出的文件格式
        response.setContentType("application/vnd.ms-excel");
        //设置文件名
        String fileName = "dict";
        //拼接输出的文件名和文件格式
        response.setHeader("Content-disposition","attachment;filename="+fileName+".xlsx");

        //查询数据库
        List<Dict> dictList = baseMapper.selectList(null);
        //Dict -- DictEeVo
        ArrayList<DictEeVo> voArrayList = new ArrayList<>(dictList.size());
        //将查询数据库封装到对应的vo类中，并装到集合中
        for (Dict dict : dictList) {
            DictEeVo dictEeVo = new DictEeVo();
            BeanUtils.copyProperties(dict,dictEeVo,DictEeVo.class);
            voArrayList.add(dictEeVo);

        }
        try {
            EasyExcel.write(response.getOutputStream(),DictEeVo.class)
                    .sheet("数据字典")
                    .doWrite(voArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //判断id下面是否有子节点
    private boolean hasChild(Long id){
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id",id);
        Integer count = baseMapper.selectCount(wrapper);
        return count > 0;
    }


}
