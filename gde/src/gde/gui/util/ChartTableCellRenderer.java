package gde.gui.util;

import gde.models.Chart;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ChartTableCellRenderer extends DefaultTableCellRenderer {

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

    private ImageIcon getIcon(Chart.ChartType type) {
        switch (type) {
            case PIE:
                return ImageLoader.getPieIcon();
            case LINE:
                return ImageLoader.getLineIcon();
            case BAR:
                return ImageLoader.getBarIcon();
            case MAP:
                return ImageLoader.getMapIcon();
            case SCATTER:
                return ImageLoader.getScatterIcon();
        }
        return null;
    }
}
