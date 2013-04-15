/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gde.gui.tablemodels;

import gde.models.Chart;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import sun.swing.DefaultLookup;

/**
 *
 * @author Andrew
 */
public class ImageRenderer extends DefaultTableCellRenderer {
    JLabel lbl = new JLabel();

    private final ImageIcon iconPie = new ImageIcon(getClass().getResource("icon1.jpg"));
    private final ImageIcon iconLine = new ImageIcon(getClass().getResource("icon2.jpg"));
    private final ImageIcon iconBar = new ImageIcon(getClass().getResource("icon3.jpg"));
    
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
        boolean hasFocus, int row, int column) {
        
        //super.getTableCellRendererComponent(table, new Object(), isSelected, hasFocus, row, column);
        
        lbl.setText(((ChartHeader) value).getTitle());
        lbl.setIcon(getIcon(((ChartHeader) value).getType()));
        
        if (isSelected) {
            lbl.setBackground(table.getSelectionBackground());
            lbl.setForeground(table.getSelectionForeground());
        }
        else {
            lbl.setBackground(table.getBackground());
            lbl.setForeground(table.getForeground());
        }
        
        lbl.setOpaque(true);
        
        return lbl;
    }
    
    public ImageIcon getIcon(Chart.ChartType type){
        switch (type){
            case PIE:
                return iconPie;
            case LINE:
                return iconLine;
            case BAR:
                return iconBar;
        }
        return null;
    }
}
