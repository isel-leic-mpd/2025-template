package pt.isel.mpd.spreadsheet1.model;

import pt.isel.mpd.spreadsheet1.expressions.Expr;

import javax.swing.*;

public class CalcSheet extends AbstractCalcSheet  {
    public CalcSheet(int rows, int cols) {
        super(rows, cols);
       
        JOptionPane.showMessageDialog(null,
            "The class CalcSheet and related classes must be correctly integrated!");
    }
    
    
    @Override
    public Cell getCellAt(int row, int col) {
        // TO IMPLEMENT
         return new Cell(this, row,col);
    }
    
   
    @Override
    public void setCellAt(int row, int col, Expr expr)  {
         // TO IMPLEMENT
    }
    
   
}
