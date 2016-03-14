package gde.gui.util;

import gde.models.Chart.ChartType;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * The ChartTableCellRenderer objects merely specializes and formats the cells in the chart table.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public class ChartTableCellRenderer extends DefaultTableCellRenderer {

    /**
     * Retrieves a specialized component cell for the chart table.
     * 
     * @param table the table to which the cell renderer will be applied.
     * @param value the object which occupies the cell.
     * @param isSelected whether or not the cell is selected.
     * @param hasFocus whether or not the cell has focus.
     * @param row the row of the cell in the table.
     * @param column the column of the cell in the table.
     * @return the cell component
     */
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setText(((ChartTableCellData) value).getTitle());
        label.setIcon(getIcon(((ChartTableCellData) value).getType()));
        label.setOpaque(true);
        if (isSelected) {
            label.setBackground(table.getSelectionBackground());
            label.setForeground(table.getSelectionForeground());
        } else {
            label.setBackground(table.getBackground());
            label.setForeground(table.getForeground());
        }
        return label;
    }

    /**
     * Returns the appropriate image icon to represent the given chart type.
     * 
     * @param type chart type
     * @return ImageIcon to represent the chart in its cell
     */
    private ImageIcon getIcon(ChartType type) {
        switch (type) {
            case PIE:
                return ImageLoader.getPieIcon();
            case LINE:
                return ImageLoader.getLineIcon();
            case MAP:
                return ImageLoader.getMapIcon();
            case SCATTER:
                return ImageLoader.getScatterIcon();
        }
        return null;
    }
}
