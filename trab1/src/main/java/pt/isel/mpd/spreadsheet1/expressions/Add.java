package pt.isel.mpd.spreadsheet1.expressions;

/**
 *
 */
public class Add extends BinExpr {
    
    /**
     *
     * @param left
     * @param right
     */
    public Add(Expr left, Expr right) {
        super(left, right);
    }
    
    @Override
    public String getOperator() {
        return "+";
    }
    
    @Override
    public double eval() {
        return left.eval() + right.eval();
    }
    
}
