/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplp.controlcore.core;

import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author luisdany pernillo
 */
public interface ManageExcel {
    
    Workbook readFile(String path);
    
    void writeFile();
    
}
