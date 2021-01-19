package com.onlyedu.ordermigratedbtool.controller;

import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 查看Maven 依赖注释：解析excel
 */
@RestController
@RequestMapping("/readexceldata")
public class ReadExcelDataController {

    private final static Logger logger = LogManager.getLogger(ReadExcelDataController.class);

    /*
     注意：url中含有参数是路径会报400，encodeURIComponent(url中的参数值);
         postman选中参数值，右键EncodeURIComponent
     */

    /**
     * 读取csv和Excel文档数据
     *
     * @param fileFullNamePath
     * @return
     */
    @GetMapping("/readData")
    public MessageResult<Void> readData(String fileFullNamePath) {
        MessageResult<Void> messageResult = new MessageResult<>();
        try {
            getExcelData(fileFullNamePath);
            messageResult.setCode(0);
        } catch (Exception ex) {
            messageResult.setCode(500);
            logger.error(ex.toString());
        }
        return messageResult;
    }

    private List getExcelData(String fileName) throws Exception {

        List list = new ArrayList<>();
        InputStream in = new FileInputStream(fileName);
        // 创建excel工作簿
        Workbook work = getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }
        Sheet sheet = null;
        Row row = null;
        Cell cell = null;
        for (int i = 0; i < work.getNumberOfSheets(); i++) {

            sheet = work.getSheetAt(i);
            if (sheet == null) {
                continue;
            }
            // 滤过第一行标题
            for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
                row = sheet.getRow(j);
                if (row == null || row.getFirstCellNum() == j) {
                    continue;
                }
                List<Object> li = new ArrayList<>();
                for (int y = row.getFirstCellNum(); y < row.getLastCellNum(); y++) {
                    cell = row.getCell(y);
                    Object val = getCellFormatValue(cell);//读取对应数据格式的单元格数据
                    li.add(cell);
                }
                list.add(li);
            }
        }
        work.close();
        return list;
    }


    /**
     * 读取对应数据格式的单元格数据
     * @param cell
     * @return
     */
    private static Object getCellFormatValue(Cell cell) {
        Object cellvalue = "";
        if (cell != null) {
            switch (cell.getCellType()) {
                case NUMERIC:
                    cellvalue = String.valueOf(cell.getNumericCellValue());
                    break;
                case FORMULA: {
                    cellvalue = cell.getDateCellValue();
                    break;
                }
                case STRING:
                    cellvalue = cell.getRichStringCellValue().getString();
                    break;
                default:
                    cellvalue = "";
            }
        } else {
            cellvalue = "";
        }
        return cellvalue;
    }

    /**
     * 判断文件格式
     * @param in
     * @param fileName
     * @return
     */
    private Workbook getWorkbook(InputStream in, String fileName) throws Exception {

        Workbook book = null;
        String filetype = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(filetype)) {
            book = new HSSFWorkbook(in);
        } else if (".xlsx".equals(filetype)) {
            book = new XSSFWorkbook(in);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return book;
    }
}
