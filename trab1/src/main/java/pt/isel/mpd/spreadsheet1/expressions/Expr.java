package pt.isel.mpd.spreadsheet1.expressions;


public interface Expr {
    double eval();
    String getFormula();
    
    /**
     * a new default methos, eventually useful to produce
     * the representation of an expression to show on SheetView
     * @return
     */
    default String getEvalText() {
        var value = eval();
        var text =  Double.isNaN(value) ? getFormula() : Double.toString(value);
        return text;
    }
}
