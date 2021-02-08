package com.onlyedu.ordermigratedbtool.utility;

import com.onlyedu.ordermigratedbtool.model.dto.StudentRecordDto;
import com.onlyedu.ordermigratedbtool.model.entity.EosOrder;
import com.onlyedu.ordermigratedbtool.model.entity.EosStudent;
import lombok.val;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
            if (isRowEmpty(row)) {
                continue;
            }
//            String cellStopVal = row.getCell(4).toString().trim();
//            if (cellStopVal.contains("已停用")) {
//                continue;
//            }
            EosStudent eosStudent = new EosStudent();
            eosStudent.setEosStudentID(Integer.valueOf(getCellFormatValue(row.getCell(2)).toString().trim()));
            eosStudent.setStudentName(getCellFormatValue(row.getCell(1)).toString().trim());
            eosStudent.setGrade(getCellFormatValue(row.getCell(11)).toString().trim());
            eosStudent.setPhone(getCellFormatValue(row.getCell(3)).toString().trim());
//                eosStudent.setSchoolName((String) getCellFormatValue(row.getCell(2)));
            eosStudentList.add(eosStudent);
        }

        work.close();
        return eosStudentList;
    }


    public static List<EosOrder> getExcelOrderData(String fileName) throws Exception {

        InputStream in = new FileInputStream(fileName);
        // 创建excel工作簿
        Workbook work = getWorkbook(in, fileName);
//        Workbook work = getWorkbookByFileName(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }

        Sheet sheet = work.getSheetAt(1);
        List<EosOrder> eosOrderList = new ArrayList<>();
        // 滤过第一行标题
        for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
            Row row = sheet.getRow(j);
            if (row == null || row.getFirstCellNum() == j) {
                continue;
            }
            if (isRowEmpty(row)) {
                continue;
            }
            EosOrder eosStudent = new EosOrder();
            /**
             * OrderNo, EosStudentID,
             *            FeeContent, OrderTime, CourseProductName,
             *            OrderBalance, RemainRemaining
             */
            //索引从0开始
            eosStudent.setOrderNo(getCellFormatValue(row.getCell(9)).toString().trim());
            eosStudent.setEosStudentID(Integer.valueOf(getCellFormatValue(row.getCell(7)).toString().trim()));
            eosStudent.setFeeContent(getCellFormatValue(row.getCell(10)).toString().trim());
            String timeStr = getCellFormatValue(row.getCell(12)).toString().trim();
            LocalDateTime orderTime = LocalDateTime.parse(timeStr, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
            eosStudent.setOrderTime(orderTime);
            eosStudent.setCourseProductName(getCellFormatValue(row.getCell(13)).toString().trim());
            eosStudent.setCourseProductID(Integer.valueOf(getCellFormatValue(row.getCell(14)).toString().trim()));

            //保留两位小数。不然2.00会变成2.0
            eosStudent.setOrderBalance(new BigDecimal(getCellFormatValue(row.getCell(20)).toString().trim()).setScale(2, RoundingMode.HALF_UP));
            eosStudent.setRemainBalance(new BigDecimal(getCellFormatValue(row.getCell(24)).toString().trim()).setScale(2, RoundingMode.HALF_UP));

//            EosStudent eosStudent = new EosStudent();
//            eosStudent.setEosStudentID((Integer) getCellFormatValue(row.getCell(2)));
//            eosStudent.setStudentName(getCellFormatValue(row.getCell(1)).toString());
//            eosStudent.setGrade((String) getCellFormatValue(row.getCell(11)));
//            eosStudent.setPhone((String) getCellFormatValue(row.getCell(3)));
//                eosStudent.setSchoolName((String) getCellFormatValue(row.getCell(2)));
            eosOrderList.add(eosStudent);
        }

        work.close();
        return eosOrderList;
    }

    public static List<StudentRecordDto> getStudentRecord(String fileName) throws Exception {

        InputStream in = new FileInputStream(fileName);
        // 创建excel工作簿
        Workbook work = getWorkbook(in, fileName);
        if (null == work) {
            throw new Exception("创建Excel工作薄为空！");
        }

        Sheet sheet = work.getSheetAt(0);
        List<StudentRecordDto> studentRecordDtoList = new ArrayList<>();
        // 滤过第一行标题
        for (int j = sheet.getFirstRowNum(); j <= sheet.getLastRowNum(); j++) {
            Row row = sheet.getRow(j);
            if (row == null || row.getFirstCellNum() == j) {
                continue;
            }

            if (isRowEmpty(row)) {
                continue;
            }
            StudentRecordDto studentRecordDto = new StudentRecordDto();
            studentRecordDto.setName(getCellFormatValue(row.getCell(0)).toString().trim());
            studentRecordDto.setPhone(getCellFormatValue(row.getCell(1)).toString().trim());
            studentRecordDto.setGrade(getCellFormatValue(row.getCell(2)).toString().trim());
            studentRecordDto.setDistrict(getCellFormatValue(row.getCell(3)).toString().trim());
            studentRecordDto.setSchool(getCellFormatValue(row.getCell(4)).toString().trim());
            studentRecordDto.setMarketTypeOne(getCellFormatValue(row.getCell(5)).toString().trim());
            studentRecordDto.setMarketTypeTwo(getCellFormatValue(row.getCell(6)).toString().trim());
            studentRecordDto.setCallIntention(getCellFormatValue(row.getCell(7)).toString().trim());
            studentRecordDto.setEnrollIntention(getCellFormatValue(row.getCell(8)).toString().trim());
            studentRecordDto.setSaleGroup(getCellFormatValue(row.getCell(9)).toString().trim());
            studentRecordDto.setSalesman(getCellFormatValue(row.getCell(10)).toString().trim());
            studentRecordDtoList.add(studentRecordDto);
        }

        work.close();
        return studentRecordDtoList;
    }

    private static boolean isRowEmpty(Row row) {
        for (int c = row.getFirstCellNum(); c < row.getLastCellNum(); c++) {
            Cell cell = row.getCell(c);
            if (cell != null && cell.getCellType() != CellType.BLANK)
                return false;
        }
        return true;
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
                    //去除科学计数法"E",直接toString会有E
                    NumberFormat nf = NumberFormat.getInstance();
                    nf.setGroupingUsed(false);
                    Double val = cell.getNumericCellValue();
                    cellvalue = nf.format(val);
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

    private static Workbook getWorkbookByFileName(InputStream in, String fileName) throws Exception {

        Workbook book = null;
        String filetype = fileName.substring(fileName.lastIndexOf("."));
        if (".xls".equals(filetype)) {
            book = new HSSFWorkbook(in);
        } else if (".xlsx".equals(filetype)) {
//            book = new XSSFWorkbook(in);
            File file = new File(fileName);
            OPCPackage opcPackage = OPCPackage.open(file);
            XSSFWorkbook workbook = new XSSFWorkbook(opcPackage);
        } else {
            throw new Exception("请上传excel文件！");
        }
        return book;
    }
}
