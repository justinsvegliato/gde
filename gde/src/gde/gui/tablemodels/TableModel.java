package gde.gui.tablemodels;

import gde.gui.util.DatabaseHandler;
import gde.models.Game;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import org.bson.types.ObjectId;
import org.jongo.Jongo;

public abstract class TableModel<T> extends DefaultTableModel {  
    
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
        
    public abstract void populate();
    
    @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }   

    public abstract void add(T entry);

    public abstract void remove(int[] rowIds);

    public abstract void update(T entry, int rowId);
    
    public abstract T getEntryAt(int rowId);

    public abstract void setEntryAt(int rowId, T entry);
    
    protected abstract void addRow(T entry);
}
