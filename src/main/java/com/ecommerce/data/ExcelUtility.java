package com.ecommerce.data;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtility {

    private String filePath;

    public ExcelUtility(String filePath) {
        this.filePath = filePath;
    }

    // Method to read data from an Excel file
    public String readCellData(String sheetName, int rowNum, int colNum) {
        String cellData = "";
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet != null) {
                Row row = sheet.getRow(rowNum);
                if (row != null) {
                    Cell cell = row.getCell(colNum);
                    if (cell != null) {
                        cellData = cell.toString();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return cellData;
    }

    // Method to write data to an Excel file
    public void writeCellData(String sheetName, int rowNum, int colNum, String data) {
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                sheet = workbook.createSheet(sheetName);
            }

            Row row = sheet.getRow(rowNum);
            if (row == null) {
                row = sheet.createRow(rowNum);
            }

            Cell cell = row.getCell(colNum);
            if (cell == null) {
                cell = row.createCell(colNum);
            }

            cell.setCellValue(data);

            try (FileOutputStream fos = new FileOutputStream(new File(filePath))) {
                workbook.write(fos);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to create a new Excel file
    public void createNewExcelFile() {
        try (Workbook workbook = new XSSFWorkbook()) {
            FileOutputStream fos = new FileOutputStream(new File(filePath));
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to get the number of rows in a sheet
    public int getRowCount(String sheetName) {
        int rowCount = 0;
        try (FileInputStream fis = new FileInputStream(new File(filePath));
             Workbook workbook = new XSSFWorkbook(fis)) {

            Sheet sheet = workbook.getSheet(sheetName);
            if (sheet != null) {
                rowCount = sheet.getPhysicalNumberOfRows();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return rowCount;
    }
}

