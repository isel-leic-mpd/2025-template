package pt.isel.mpd.parser;

import pt.isel.mpd.exceptions.ParserException;
import pt.isel.mpd.expressions.Const;
import pt.isel.mpd.expressions.Expr;
import pt.isel.mpd.spreadsheet0.model.CalcSheet;
import pt.isel.mpd.spreadsheet0.model.CellRef;

/**
 * An extended parser that knpw to parse cell names
 * Note that the parser dowsn't check if names are valid in the context of the sheet
 */
public class ParserExpr2 extends ParserExpr {
    private static final String MAX = "MAX";
    private static final String SUM = "SUM";
    
    private final CalcSheet sheet;
    private String startRange, endRange;
    
    public ParserExpr2(CalcSheet sheet) {
        this.sheet = sheet;
    }
    
    
    protected Expr factor()  {
        if (token.isWord()) {
            String name = token.getWord();
            nextToken();
            return new CellRef(name, sheet);
        }
        if (token.isNumber())  {
            double number = token.getNumber();
            nextToken();
            return new Const(number);
        }
        else if (token.getType() == Lex.TokType.OPEN_BRACKET) {
            nextToken();
            Expr expr = expression();
            if (token.getType() == Lex.TokType.CLOSE_BRACKET) {
                nextToken();
                return expr;
            }
        }
        throw new ParserException("Number, Word or parentheses expected!");
    }
}
