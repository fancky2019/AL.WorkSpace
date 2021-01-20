package com.onlyedu.ordermigratedbtool.utility;

import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import com.onlyedu.ordermigratedbtool.model.pojo.MessageResult;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ExcelHelper {


    public static List<EosStudent> getExcelStudentData(String fileName) throws Exception {

        InputStream in = new FileInputStream(fileName);
        // 创建excel工作簿
        Workbook work = getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }

        Sheet sheet = work.getSheetAt(0);
        List<EosStudent> eosStudentList = new ArrayList<>();
        // 滤过第一行标题
        for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
            Row row = sheet.getRow(j);
            if (row == null || row.getFirstCellNum() == j) {
                continue;
            }
            EosStudent eosStudent = new EosStudent();
            eosStudent.setEosStudentID(Integer.valueOf(getCellFormatValue(row.getCell(2)).toString()));
            eosStudent.setStudentName(getCellFormatValue(row.getCell(1)).toString());
            eosStudent.setGrade( getCellFormatValue(row.getCell(11)).toString());
            eosStudent.setPhone( getCellFormatValue(row.getCell(3)).toString());
//                eosStudent.setSchoolName((String) getCellFormatValue(row.getCell(2)));
            eosStudentList.add(eosStudent);
        }

        work.close();
        return eosStudentList;
    }

    public static List<EosStudent> getExcelOrderData(String fileName) throws Exception {

        InputStream in = new FileInputStream(fileName);
        // 创建excel工作簿
        Workbook work = getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }

        Sheet sheet = work.getSheetAt(0);
        List<EosStudent> eosStudentList = new ArrayList<>();
        // 滤过第一行标题
        for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
            Row row = sheet.getRow(j);
            if (row == null || row.getFirstCellNum() == j) {
                continue;
            }
            EosStudent eosStudent = new EosStudent();
            eosStudent.setEosStudentID((Integer) getCellFormatValue(row.getCell(2)));
            eosStudent.setStudentName(getCellFormatValue(row.getCell(1)).toString());
            eosStudent.setGrade((String) getCellFormatValue(row.getCell(11)));
            eosStudent.setPhone((String) getCellFormatValue(row.getCell(3)));
//                eosStudent.setSchoolName((String) getCellFormatValue(row.getCell(2)));
            eosStudentList.add(eosStudent);
        }

        work.close();
        return eosStudentList;
    }

    /**
     * 读取对应数据格式的单元格数据
     *
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
     *
     * @param in
     * @param fileName
     * @return
     */
    private static Workbook getWorkbook(InputStream in, String fileName) throws Exception {

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
