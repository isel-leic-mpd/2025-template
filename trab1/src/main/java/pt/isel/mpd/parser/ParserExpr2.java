package pt.isel.mpd.parser;

import pt.isel.mpd.exceptions.ParserException;
import pt.isel.mpd.expressions.Const;
import pt.isel.mpd.expressions.Expr;
import pt.isel.mpd.expressions.Mul;
import pt.isel.mpd.spreadsheet0.model.CalcSheet;
import pt.isel.mpd.spreadsheet0.model.CellRef;

/**
 * An extended parser that knpw to parse cell names
 * Note that the parser dowsn't check if names are valid in the context of the sheet
 */
public class ParserExpr2 extends ParserExpr {
    
    private final CalcSheet sheet;
    
    public ParserExpr2(CalcSheet sheet) {
        this.sheet = sheet;
    }
    
    protected Expr factor()  {
        int sign = 1;
        Expr expr = null;
        if (token.getType() == Lex.TokType.OP_MINUS) {
            nextToken();
            sign = -1;
        }
        if (token.isWord()) {
            String name = token.getWord();
            nextToken();
            expr = new CellRef(name, sheet);
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
