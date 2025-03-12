package pt.isel.mpd.spreadsheet1.expressions;


public class Sub extends BinExpr {
    
    public Sub(Expr left, Expr right) {
        super(left, right);
    }
    
    @Override
    public String getOperator() {
        return "-";
    }
    
    @Override
    public double eval() {
        return left.eval() - right.eval();
    }
}