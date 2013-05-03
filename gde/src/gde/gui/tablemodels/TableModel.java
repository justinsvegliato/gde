package gde.gui.tablemodels;

import gde.gui.util.DatabaseHandler;
import gde.models.Game;
import javax.swing.table.DefaultTableModel;
import org.jongo.Jongo;

public abstract class TableModel extends DefaultTableModel {  
    
    protected static final Jongo database = DatabaseHandler.getDatabase();
    protected final Game game;
    protected final Class[] types;
    protected final String[] titles;
    
    public TableModel(Game game, Class[] types, String[] titles) {
        this.game = game;
        this.types = types;
        this.titles = titles;   
        setColumnIdentifiers(this.titles);
    }
    
    @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }      
}
