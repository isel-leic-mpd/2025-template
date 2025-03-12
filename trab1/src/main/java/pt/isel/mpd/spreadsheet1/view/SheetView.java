package pt.isel.mpd.spreadsheet1.view;

import pt.isel.mpd.spreadsheet1.model.CalcSheet;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class SheetView extends JTable {
    private final TableCellRenderer headerRenderer;
    private final CalcSheet model;
    
    private static  class WSHeaderRenderer extends JLabel
        implements TableCellRenderer {
        
        private final Font boldFont, plainFont;
        
        public WSHeaderRenderer() {
            setHorizontalAlignment( SwingConstants.CENTER );
            setOpaque(true); //MUST do this for background to show up.
            boldFont =  getFont().deriveFont(Font.BOLD, 12.0F);
            plainFont = getFont().deriveFont(Font.PLAIN, 12.0F);
        }
        
        public Component getTableCellRendererComponent(
            JTable table, Object obj,
            boolean isSelected, boolean hasFocus,
            int row, int column) {
            
            if (column == 0 && row == 0) {
                setBackground(Color.LIGHT_GRAY);
            }
            else if (column == 0 && row > 0 || row == 0 && column > 0) {
                setBackground(Color.LIGHT_GRAY);
                setFont(boldFont);
            }
            else {
                setFont(plainFont);
            }
            this.setText(obj.toString());
            return this;
        }
    }
    
    
    public SheetView(CalcSheet model) {
        super(model);
        this.model = model;
        Font f = getFont().deriveFont(12.0f);
        setFont(f);
        
        setRowHeight(30);
        setBackground(Color.WHITE);
        headerRenderer = new WSHeaderRenderer();
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( SwingConstants.CENTER );
        
        setDefaultRenderer(Object.class,centerRenderer);
    }
    
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }
    
  
    @Override
    public void setValueAt(Object obj, int row, int column) {
        super.setValueAt(obj, row, column);
    }
    
    /**
     * To avoid have native headers
     */
    @Override
    protected void configureEnclosingScrollPane() {
        //super.configureEnclosingScrollPane();
    }
    
    
    public TableCellRenderer getCellRenderer(int row, int column) {
        if (row == 0 || column == 0) {
            return headerRenderer;
        } else {
            return super.getCellRenderer(row, column);
        }
    }

}
