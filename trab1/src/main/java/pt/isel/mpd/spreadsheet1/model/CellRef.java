package pt.isel.mpd.spreadsheet1.model;

import pt.isel.mpd.spreadsheet1.expressions.Expr;

// to complete
public class CellRef implements Expr {
    private  CalcSheet sheet;
    public final String name;
    
    public CellRef(String name, CalcSheet sheet) {
        this.name = name;
        this.sheet = sheet;
    }
    
    public CellRef(String name) {
        this.name = name;
        this.sheet = null;
    }
    
    public Cell getCell() {
        return null;
    }
    
    @Override
    public double eval() {
        return 0;
    }
    
    @Override
    public String getFormula() {
       return getCell().getFormula();
    }
    
}
