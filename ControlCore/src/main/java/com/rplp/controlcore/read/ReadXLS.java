/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rplp.controlcore.read;

import com.rplp.controlcore.core.ManageExcel;
import org.apache.poi.ss.usermodel.Workbook;

/**
 *
 * @author luisdany pernillo
 */
public class ReadXLS implements ManageExcel{
    
    public ReadXLS(){
        
    }

    @Override
    public Workbook readFile(String path) {
      
        return null;
        
    }

    @Override
    public void writeFile() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
