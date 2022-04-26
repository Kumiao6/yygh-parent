import com.alibaba.excel.EasyExcel;

/**
 * @author ：m
 * @date ：Created in 2022/4/26 19:12
 */
public class TestRead {
    public static void main(String[] args) {

        //读取文件
        String fielName = "/Users/m/Desktop/excel/01.xlsx";

        EasyExcel.read(fielName, UserData.class,new ExcelListener()).sheet().doRead();
    }

}
