package pt.isel.mpd.spreadsheet1.view;

import pt.isel.mpd.spreadsheet1.model.CalcSheet;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.MouseListener;

import static javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
import static javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

public class SheetPanel extends JPanel {
  
    private final SheetView sheetView;
    private final CalcSheet model;
    
    public SheetPanel(CalcSheet model, TableCellEditor cellEditor) {
        sheetView = new SheetView(model);
        sheetView.setDefaultEditor(Object.class, cellEditor);
        this.model = model;
        JScrollPane js=new JScrollPane(sheetView);
        
        js.setVerticalScrollBarPolicy(VERTICAL_SCROLLBAR_AS_NEEDED);
        js.setHorizontalScrollBarPolicy(HORIZONTAL_SCROLLBAR_AS_NEEDED);
        
        setLayout(new BorderLayout());
       
        add(js);
        setPreferredSize(new Dimension(1200, 600));
        js.setVisible(true);
        sheetView.setAutoResizeMode( JTable.AUTO_RESIZE_OFF );
       
    }
    
  
    public int getSelectedRow() {
        return sheetView.getSelectedRow();
     
    }
    
    Object getSelectedItem() {
        int line = sheetView.getSelectedRow();
        int col = sheetView.getSelectedColumn();
        
        return model.getValueAt(line, col);
    }
    
    public int getSelectedColumn() {
        return sheetView.getSelectedColumn();
     
    }
    
    public void addListener(MouseListener listener) {
        sheetView.addMouseListener(listener);
    }
}
