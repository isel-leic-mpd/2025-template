package pt.isel.mpd.spreadsheet1.expressions;

import pt.isel.mpd.spreadsheet1.exceptions.DivByZeroException;

public class Div extends BinExpr {
    
    public Div(Expr left, Expr right) {
        super(left, right);
        if (right.eval() == 0) {
            throw new ArithmeticException("Div by zero!");
        }
    }
    
    @Override
    public String getOperator() {
        return "/";
    }
    
    @Override
    public double eval() {
        var r = right.eval();
        if (r== 0.0) throw new DivByZeroException();
        return left.eval() / r;
    }
    
}
