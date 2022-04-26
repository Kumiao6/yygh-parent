import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.Map;

/**
 * @author ：m
 * @date ：Created in 2022/4/26 19:06
 */
public class ExcelListener extends AnalysisEventListener<UserData> {

    //一行一行读取excel内容，从第二行读取
    @Override
    public void invoke(UserData data, AnalysisContext context) {
        System.out.println(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {

    }

    @Override
    public void invokeHeadMap(Map<Integer, String> headMap, AnalysisContext context) {
        System.out.println("表头信息：" + headMap);
    }

}
