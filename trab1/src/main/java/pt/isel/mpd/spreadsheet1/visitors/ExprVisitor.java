package pt.isel.mpd.spreadsheet1.visitors;

import pt.isel.mpd.spreadsheet1.expressions.BinExpr;
import pt.isel.mpd.spreadsheet1.expressions.Const;
import pt.isel.mpd.spreadsheet1.expressions.MemoExpr;
import pt.isel.mpd.spreadsheet1.model.CellRef;

public interface ExprVisitor {
    void visit(BinExpr expr);
    void visit(Const c);
    void visit(MemoExpr v);
    void visit(CellRef v);
}
