package gde.gui.util;

import javax.swing.table.DefaultTableModel;

public class TableModel extends DefaultTableModel {

    private final Class[] TYPES;

    public TableModel(Class[] types, String[] names) {
        setColumnIdentifiers(names);
        TYPES = types;
    }

    @Override
    public Class getColumnClass(int columnIndex) {
        return TYPES[columnIndex];
    }
}