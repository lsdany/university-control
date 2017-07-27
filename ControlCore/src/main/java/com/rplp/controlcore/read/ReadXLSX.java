/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplp.controlcore.read;

import com.rplp.controlcore.core.ManageExcel;
import com.rplp.controlcore.entity.Student;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author luisdany
 */
public class ReadXLSX implements ManageExcel {

    @Override
    public Workbook readFile(String path) {
        
        Workbook workbook = null;
        try{
            FileInputStream excelFile = new FileInputStream(new File(path));
            workbook = new XSSFWorkbook(excelFile);
        }catch(IOException e){
            e.printStackTrace();
        }
        
        return workbook;
    }

    @Override
    public void writeFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int rowsToIgnore = 3;
    private int maxCellSize = 3;

    public List<Student> getStudentsFromXLS(String path) {

        List<Student> students = new ArrayList<>();
        try {

            Workbook workbook = readFile(path);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            int rowCounter = 0;

            while (iterator.hasNext()) {

                Row currentRow = iterator.next();

                if (rowCounter > rowsToIgnore) {

                    Iterator<Cell> cellIterator = currentRow.iterator();

                    int cellCounter = 0;
                    Student student = new Student();
                    while (cellIterator.hasNext()) {

                        Cell currentCell = cellIterator.next();

                        if (cellCounter < maxCellSize) {

                            if (currentCell.getColumnIndex() == 0) {
                                student.setId(currentCell.getNumericCellValue());
                            } else if (currentCell.getColumnIndex() == 1) {
                                student.setIdCard(currentCell.getStringCellValue().replaceAll(" ", ""));
                            } else if (currentCell.getColumnIndex() == 2) {
                                student.setName(currentCell.getStringCellValue());
                            }

                        }

                        cellCounter++;

                    }
                    System.out.println(student.toString());
                    students.add(student);
                }

                rowCounter++;

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return students;
    }

}
