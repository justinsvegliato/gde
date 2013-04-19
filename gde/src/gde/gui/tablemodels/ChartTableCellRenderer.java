package gde.gui.tablemodels;

import gde.models.Chart;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class ChartTableCellRenderer extends DefaultTableCellRenderer {

    private final ImageIcon iconPie = new ImageIcon(getClass().getResource("pie_graph.png"));
    private final ImageIcon iconLine = new ImageIcon(getClass().getResource("line_graph.png"));
    private final ImageIcon iconBar = new ImageIcon(getClass().getResource("bar_graph.png"));

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
                return iconPie;
            case LINE:
                return iconLine;
            case BAR:
                return iconBar;
        }
        return null;
    }
}
