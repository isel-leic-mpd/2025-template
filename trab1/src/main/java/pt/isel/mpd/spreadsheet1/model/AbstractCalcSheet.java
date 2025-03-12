package pt.isel.mpd.spreadsheet1.model;

import pt.isel.mpd.spreadsheet1.exceptions.InvalidCoordinatesException;
import pt.isel.mpd.spreadsheet1.exceptions.SheetException;
import pt.isel.mpd.spreadsheet1.expressions.Expr;

import javax.swing.table.AbstractTableModel;

public abstract class AbstractCalcSheet extends AbstractTableModel {
    
    private static final int MAX_COLS = ('Z' - 'A' + 1);
    
    public record  CellCoords(int row, int col){ }
    
    
    protected int rows, cols;
    
    // abstract hooks for template methods getValueAt e setValueAt
    public abstract Cell getCellAt(int row, int col);
    public abstract void setCellAt(int row, int col, Expr expr);
    
    protected AbstractCalcSheet(int rows, int cols) {
        if (rows < 2 || cols < 2) {
            throw new SheetException("Invalid table sizes");
        }
        this.rows = rows;
        this.cols = cols;
    }
    
    /**
     * obtain the coordinates (row,col) of the cell represented by a CellRef
     * @param name
     * @return
     */
    public CellCoords coordsFromName(String name) {
        int col=-1, row=-1;
        try {
            name = name.toUpperCase();
            col = name.charAt(0) - 'A'+1;
            row = Integer.parseInt(name.substring(1));
        }
        catch(NumberFormatException ignored) { }
        if (!validCoords(row,col) ) throw new InvalidCoordinatesException();
        return new CellCoords(row,col);
    }

    protected void checkCoords(int r, int c) {
        if (!validCoords(r,c))
            throw new InvalidCoordinatesException();
    }
    
    boolean validCoords(int row, int col) {
        return row>= 0 && row <= rows && col >= 0 && col <= cols;
    }
    
    public boolean isValidCellName(String name) {
        try {
            coordsFromName(name);
            return true;
        }
        catch(InvalidCoordinatesException bce) {
            return false;
        }
    }
    
    /**
     * conver the cell coordinates (row,col) to the equivalent name
     * @param row
     * @param col
     * @return
     */
    public String nameFromCoords(int row, int col) {
        return String.valueOf((char) ('A' + col - 1)) + (char) ('1' + row - 1);
    }
    
    // AbstractTableModel implementation
    
    @Override
    public int getRowCount() {
        return rows + 1;
    }
    
    @Override
    public int getColumnCount() {
        return cols + 1;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        checkCoords(rowIndex, columnIndex);
        if (columnIndex == 0 && rowIndex == 0) return "";
        else if (columnIndex == 0) return rowIndex;
        else if(rowIndex == 0) return (char) ('A' + columnIndex-1);
        else return getCellAt(rowIndex, columnIndex).getExpr();
    }
    
    @Override
    public void setValueAt(Object obj, int rowIndex, int columnIndex) {
        checkCoords(rowIndex, columnIndex);
        if (columnIndex == 0 || rowIndex == 0) {
            return;
        }
        setCellAt(rowIndex, columnIndex, (Expr) obj);
        
        // warn the view the a certain cell was changed!
        this.fireTableCellUpdated(rowIndex, columnIndex);
    }
}
