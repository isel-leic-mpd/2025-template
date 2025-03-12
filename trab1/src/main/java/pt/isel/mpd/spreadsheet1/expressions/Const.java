package pt.isel.mpd.spreadsheet1.expressions;

public class Const implements Expr {
    public final double value;
    
    public Const(double value) {
        this.value = value;
        
    }
    public double eval()  {
        return value;
    }
  
    
    @Override
    public String getFormula() {
        return Double.valueOf(value).toString();
    }
   
    
    @Override
    public String toString() {
        return getEvalText();
    }
    
}
