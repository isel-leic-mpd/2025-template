package pt.isel.mpd.spreadsheet1.expressions;


public class MemoExpr implements Expr {
    public final Expr expr;
    public final String formula;
    
    public MemoExpr(String formula, Expr expr) {
        this.formula = formula;
        this.expr = expr;
    }
    
    @Override
    public double eval() {
        return expr.eval();
    }
   
    @Override
    public String getFormula() {
        return formula;
    }
    
    @Override
    public String toString() {
        return getEvalText();
    }
}
