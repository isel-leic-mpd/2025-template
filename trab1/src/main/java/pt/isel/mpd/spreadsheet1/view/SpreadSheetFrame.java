package pt.isel.mpd.spreadsheet1.view;

import pt.isel.mpd.expressions.Const;
import pt.isel.mpd.spreadsheet1.expressions.Expr;
import pt.isel.mpd.spreadsheet1.expressions.MemoExpr;
import pt.isel.mpd.spreadsheet1.model.CalcSheet;
import pt.isel.mpd.spreadsheet1.parsers.ParserExpr2;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * this class implements the app frame window
 * and the controller for spreadsheet MVC
 */
public class SpreadSheetFrame extends JFrame {
    // Command names
    private static final String ADD_LINE_CMD = "Add Line";
    private static final String ADD_COL_CMD = "Add Col";
    private static final String RM_LINE_CMD = "Remove Line";
    private static final String RM_COL_CMD = "Remove Col";
    private static final String OPEN_SHEET_CMD = "Open";
    private static final String SAVE_SHEET_CMD = "Save";
    private static final String CLEAR_CMD = "Clear";
    private static final String UNDO_CMD = "Undo";
    
    public final ParserExpr2 parser;
    
    private SheetPanel panel;
    private CalcSheet model;
    private JTextField status;
    private JMenuBar menuBar;
    private static final int LINES = 10;
    private static final int COLS = 10;
    
    /**
     * Sheet Controler code!
     */
    private class ExprCellEditor extends AbstractCellEditor
        implements TableCellEditor {
        
        private final JTextField editor;
        
        /**
         *
         */
        public ExprCellEditor() {
            editor = new JTextField();
            
            editor.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    stopCellEditing(); // Confirma a edição ao pressionar Enter
                }
            });
        }
        
        @Override
        public boolean stopCellEditing() {
             try {
                 if (!editor.getText().isEmpty()) {
                     parser.parse(editor.getText());
                 }
                 status.setText("");
                  return super.stopCellEditing();
             }
             catch(Exception e) {
                 status.setText(e.getMessage());
                 editor.selectAll();
                 return false;
             }
        }
        
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            if (row == 0 || column == 0) {
                status.setText("");
                return table.getEditorComponent();
            }
            if (value == null) {
                editor.setText("");
            }
            else if (value instanceof String) {
                editor.setText((String) value);
            }
            else if (value instanceof Expr) {
                var text = ((Expr) value).getFormula();
                editor.setText(text);
            }
            status.setText("");
            return editor;
        }
        
        @Override
        public Object getCellEditorValue() {
            try  {
                if (editor.getText().isEmpty()) return new Const(0);
                var expr = parser.parse(editor.getText());
                return new MemoExpr(editor.getText(), expr);
            }
            catch(Exception pe) {
                status.setText(pe.getMessage());
                return new Const(0);
            }
        }
    }
    
    private void addItem(String name, JMenu menu) {
        var item = new JMenuItem(name);
        
        // TO COMPLETE!
        
        menu.add(item);
    }
    
    private void buildMenu() {
        menuBar = new JMenuBar();
        JMenu edit = new JMenu("Edit");
        addItem(ADD_LINE_CMD, edit);
        addItem(ADD_COL_CMD, edit);
        addItem(RM_LINE_CMD, edit);
        addItem(RM_COL_CMD, edit);
        addItem(UNDO_CMD, edit);
        
        JMenu file = new JMenu("File");
        addItem(SAVE_SHEET_CMD, file);
        addItem(OPEN_SHEET_CMD, file);
        addItem(CLEAR_CMD, file);
        menuBar.add(file);
        menuBar.add(edit);
        setJMenuBar(menuBar);
    }
    
    private void initComponents() {
        BorderLayout layout = new BorderLayout();
        Container container = getContentPane();
        container.setLayout(layout);
        
        model = new CalcSheet(LINES, COLS);
        panel = new SheetPanel(model, new ExprCellEditor());
        
        status = new JTextField("");
        container.add(panel, BorderLayout.CENTER);
        container.add(status, BorderLayout.SOUTH);
    }
    
    public SpreadSheetFrame() {
        super("SpreadSheet");
        initComponents();
        parser = new ParserExpr2(model);
        buildMenu();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
    }
    
  
}
