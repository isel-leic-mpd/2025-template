package pt.isel.mpd.spreadsheet1.parsers;

import pt.isel.mpd.spreadsheet1.expressions.Mul;
import pt.isel.mpd.spreadsheet1.model.CalcSheet;
import pt.isel.mpd.spreadsheet1.exceptions.ParserException;
import pt.isel.mpd.spreadsheet1.expressions.Const;
import pt.isel.mpd.spreadsheet1.expressions.Expr;
import pt.isel.mpd.spreadsheet1.model.CellRef;
import pt.isel.mpd.spreadsheet1.model.Max;
import pt.isel.mpd.spreadsheet1.model.Sum;

public class ParserExpr3 extends ParserExpr2 {
    private static final String MAX = "MAX";
    private static final String SUM = "SUM";
 
    private String startRange, endRange;
    
    public ParserExpr3(CalcSheet sheet) {
        super(sheet);
    }
    
    
    protected void range() {
        if (token.getType() == Lex.TokType.OPEN_BRACKET) {
            nextToken();
            if (token.isWord()) {
                startRange = token.getWord();
                nextToken();
                if (token.type == Lex.TokType.RANGE_SEP) {
                    nextToken();
                    if (token.isWord()) {
                        endRange = token.getWord();
                        nextToken();
                        if (token.getType() == Lex.TokType.CLOSE_BRACKET) {
                            nextToken();
                            return;
                        }
                    }
                }
            }
        }
        throw new ParserException("Range expected");
    }
    
    
    protected Expr factor() throws ParserException {
        int sign = 1;
        Expr expr = null;
        if (token.getType() == Lex.TokType.OP_MINUS) {
            nextToken();
            sign = -1;
        }
        if (token.isWord()) {
            String name = token.getWord();
            nextToken();
            switch (name) {
                case MAX -> {
                    range();
                    expr = new Max(sheet, startRange, endRange);
                }
                case SUM -> {
                    range();
                    expr = new Sum(sheet, startRange, endRange);
                }
                default -> {
                    nextToken();
                    expr = new CellRef(name, sheet);
                }
            }
        }
        else if (token.isNumber()) {
            double number = token.getNumber();
            nextToken();
            return new Const(sign*number);
        } else if (token.getType() == Lex.TokType.OPEN_BRACKET) {
            nextToken();
            expr = expression();
            if (token.getType() != Lex.TokType.CLOSE_BRACKET) {
                throw new ParserException("close parenthesis expected!");
            }
            nextToken();
        }
        if (expr == null) {
            throw new ParserException("Number or parentheses expected!");
        }
        if (sign == -1) {
            expr = new Mul(new Const(-1), expr);
        }
        return expr;
    }
}
