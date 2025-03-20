package pt.isel.mpd.spreadsheet1.model;

import pt.isel.mpd.spreadsheet1.expressions.Expr;

public class Max implements Expr {
   public Max(CalcSheet sheet, String startCellName, String endCellName) {
   
   }

    @Override
    public double eval() {
        return 0;
    }
    
    @Override
    public String getFormula() {
        return "";
    }
}
