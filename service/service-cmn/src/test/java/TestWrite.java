import com.alibaba.excel.EasyExcel;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：m
 * @date ：Created in 2022/4/26 18:49
 */
public class TestWrite {
    public static void main(String[] args) {

        //构建数据list集合
        List<UserData> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            UserData data = new UserData();
            data.setUid(i);
            data.setName("lucy" + i);
            list.add(data);

        }

        //设置excel文件路径和文件名称
        String fileNmae = "/Users/m/Desktop/excel/01.xlsx";

        //调用方法
        EasyExcel.write(fileNmae, UserData.class).sheet("用户列表")
                .doWrite(list);
    }

}
