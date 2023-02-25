package com.currency.exchange.Service;

import com.currency.exchange.Model.ExcelDto;
import com.currency.exchange.Repository.AuditRepo;
import com.currency.exchange.Repository.ExcelDtoRepo;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class excelImplementation {

    @Autowired
    private ExcelDtoRepo excelDtoRepo;

    @Autowired
    private AuditRepo auditRepo;

    public void generateExcel(HttpServletResponse response)throws IOException
    {

        List<ExcelDto> rates = excelDtoRepo.findAll();

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Courses Info");
        HSSFRow row = sheet.createRow(0);

        row.createCell(0).setCellValue("BaseCurrency");
        row.createCell(1).setCellValue("ConversionCurrency");
        row.createCell(2).setCellValue("Rate");
        row.createCell(3).setCellValue("Create_Ts");

        int dataRowIndex = 1;

        for (ExcelDto rate : rates) {
            HSSFRow dataRow = sheet.createRow(dataRowIndex);
            dataRow.createCell(0).setCellValue(rate.getBaseCurrency());
            dataRow.createCell(1).setCellValue("USD");
            dataRow.createCell(2).setCellValue(rate.getRate());
            dataRow.createCell(3).setCellValue(rate.getCreateTs().toString());
            dataRowIndex++;
        }

        ServletOutputStream ops = response.getOutputStream();
        workbook.write(ops);
        workbook.close();
        ops.close();

    }
    public void save(ExcelDto e) {
        excelDtoRepo.save(e);

    }
    public List<ExcelDto> findAll() {
        return excelDtoRepo.findAll();

    }


    }



