package gde.gui.tablemodels;

import gde.gui.util.DatabaseHandler;
import gde.models.Entry;
import gde.models.Game;
import javax.swing.table.DefaultTableModel;
import org.jongo.Jongo;

public abstract class TableModel<T extends Entry> extends DefaultTableModel {
    protected static final Jongo database = DatabaseHandler.getDatabase();
    protected final Class[] types;
    protected final String[] titles;
    protected final Game game;

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
    
    public abstract void populate();
    
    public abstract void update(T entry);
}