package com.atguigu.yygh.cmn.service.impl;

import com.alibaba.excel.EasyExcel;
import com.atguigu.yygh.cmn.listener.DictListener;
import com.atguigu.yygh.cmn.mapper.DictMapper;
import com.atguigu.yygh.cmn.service.DictService;
import com.atguigu.yygh.model.cmn.Dict;
import com.atguigu.yygh.vo.cmn.DictEeVo;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

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
    //keyGenerator：key的生成个规则，指定为我们上面redisconfig配置类中指定的生成规则
    @Cacheable(value = "dict",keyGenerator = "keyGenerator")
    @Override
    public List<Dict> findChlidData(Long id) {
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


    //判断id下面是否有子节点
    private boolean hasChild(Long id) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", id);
        Integer count = baseMapper.selectCount(wrapper);
        return count > 0;
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
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");

        //查询数据库
        List<Dict> dictList = baseMapper.selectList(null);
        //Dict -- DictEeVo
        ArrayList<DictEeVo> voArrayList = new ArrayList<>(dictList.size());
        //将查询数据库封装到对应的vo类中，并装到集合中
        for (Dict dict : dictList) {
            DictEeVo dictEeVo = new DictEeVo();
            BeanUtils.copyProperties(dict, dictEeVo, DictEeVo.class);
            voArrayList.add(dictEeVo);

        }
        try {
            EasyExcel.write(response.getOutputStream(), DictEeVo.class)
                    .sheet("数据字典")
                    .doWrite(voArrayList);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //导入数据字典
    //allEntries = true: 方法调用后清空所有缓存
    @CacheEvict(value = "dict", allEntries=true)
    @Override
    public void importDictData(MultipartFile file) {
        try {
            EasyExcel.read(file.getInputStream(), DictEeVo.class, new DictListener(baseMapper)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //根据dictcode和value查询
    @Override
    public String getDictName(String dictCode, String value) {
        //如果dictCode为空，直接根据value查询
        if(StringUtils.isEmpty(dictCode)) {
            //直接根据value查询
            QueryWrapper<Dict> wrapper = new QueryWrapper<>();
            wrapper.eq("value",value);
            Dict dict = baseMapper.selectOne(wrapper);
            return dict.getName();
        } else {//如果dictCode不为空，根据dictCode和value查询
            //根据dictcode查询dict对象，得到dict的id值
            Dict codeDict = this.getDictByDictCode(dictCode);
            Long parent_id = codeDict.getId();
            //根据parent_id和value进行查询
            Dict finalDict = baseMapper.selectOne(new QueryWrapper<Dict>()
                    .eq("parent_id", parent_id)
                    .eq("value", value));
            return finalDict.getName();
        }

    }

    //根据dictCode获取下级节点
    @Override
    public List<Dict> findByDictCode(String dictCode) {
        //根据dictcode获取对应id
        Dict dict = this.getDictByDictCode(dictCode);
        //根据id获取子节点
        List<Dict> chlidData = this.findChlidData(dict.getId());
        return chlidData;
    }

    private Dict getDictByDictCode(String dictCode) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.eq("dict_code",dictCode);
        Dict codeDict = baseMapper.selectOne(wrapper);
        return codeDict;
    }





    //根据上级编码与值获取数据字典名称
/*    @Override
    public String getNameByParentDictCodeAndValue(String parentDictCode, String value) {

        //如果value能唯一定位数据字典，parentDictCode可以传空，例如：省市区的value值能够唯一确定
        if (StringUtils.isEmpty(parentDictCode)) {
            baseMappe
        }



        return null;
    }*/

}