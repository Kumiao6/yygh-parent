package com.atguigu.yygh.cmn.service;

import com.atguigu.yygh.cmn.mapper.DictMapper;
import com.atguigu.yygh.model.cmn.Dict;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/4/26 08:54
 */
public interface DictService extends IService<Dict> {
    List<Dict> findChlidData(Long id);

    //导出数据字典接口
    void exportDictData(HttpServletResponse response);

    //导入数据字典
    void importDictData(MultipartFile file);


    //根据dictcode和value查询
    String getDictName(String dictCode, String value);

    //根据dictCode获取下级节点
    List<Dict> findByDictCode(String dictCode);

}
