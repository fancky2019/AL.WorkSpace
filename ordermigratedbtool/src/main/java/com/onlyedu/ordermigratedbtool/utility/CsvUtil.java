package com.onlyedu.ordermigratedbtool.utility;

import com.onlyedu.ordermigratedbtool.model.dto.FieldObject;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

public class CsvUtil {
    public static <T extends FieldObject> void write(String fileFullPath, String[] csvHeaders, List<T> content) throws Exception {
        try {
            File file = new File(fileFullPath);
            //获取父目录
            String filePath = file.getParent();
            File fileDic = new File(filePath);
            //判断父目录是否存在,否则创建
            if (!fileDic.exists()) {
                fileDic.mkdirs();
            }


            Appendable printWriter = new PrintWriter(fileFullPath, "GBK");//指定GBK,解决Microsoft不兼容

            CSVPrinter csvPrinter = CSVFormat.EXCEL.withHeader(csvHeaders).print(printWriter);
            content.forEach(p ->
            {
                try {
                    Object[] objects = p.toFieldObject();
                    csvPrinter.printRecord(objects);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            csvPrinter.flush();
            csvPrinter.close();
        } catch (Exception ex) {
            throw ex;
        }

    }

    public static void read(String fileFullPath) throws Exception {
        try {
            //中文乱码
            //   Reader reader = new FileReader(fileFullPath);

            DataInputStream in = new DataInputStream(new FileInputStream(new File(fileFullPath)));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in, "GBK"));//这里如果csv文件编码格式是utf-8,改成utf-8即可
            Iterable<CSVRecord> records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse(bufferedReader);
            for (CSVRecord csvRecord : records) {// 第一行不会被打印出来
                // System.out.println(csvRecord.get("Id")+","+csvRecord.get("姓名") + "," +  csvRecord.get("年龄") );
            }
            bufferedReader.close();
        } catch (IOException e) {
            throw e;
        }
    }

    public static Boolean downloadFile(HttpServletResponse response, String fileName) throws Exception {
        File file = new File(fileName);
        if (!file.exists()) {
            return false;
        }
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        try {
//            response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(fileName, "UTF-8"));
            response.setHeader("Content-Disposition", "attachment;filename=" + java.net.URLEncoder.encode(file.getName(), "UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            //ResourceUtils.getURL("classpath:").getPath()
//            path = new File(ResourceUtils.getURL("classpath:").getPath());
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(file));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, i);
                os.flush();
                i = bis.read(buff);
            }
        } catch (FileNotFoundException e1) {
            //e1.getMessage()+"系统找不到指定的文件";
            throw e1;
        } catch (IOException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }
}
