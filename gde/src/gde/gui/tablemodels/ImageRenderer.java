package gde.gui.tablemodels;

import gde.models.Chart;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ImageRenderer extends DefaultTableCellRenderer {

    private final ImageIcon iconPie = new ImageIcon(getClass().getResource("icon1.jpg"));
    private final ImageIcon iconLine = new ImageIcon(getClass().getResource("icon2.jpg"));
    private final ImageIcon iconBar = new ImageIcon(getClass().getResource("icon3.jpg"));

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
            boolean hasFocus, int row, int column) {
        JLabel label = new JLabel();
        label.setText(((ChartHeader) value).getTitle());
        label.setIcon(getIcon(((ChartHeader) value).getType()));
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

    public ImageIcon getIcon(Chart.ChartType type) {
        switch (type) {
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
