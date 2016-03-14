package gde.gui.tablemodels;

import gde.gui.util.DatabaseHandler;
import gde.models.Game;
import javax.swing.table.DefaultTableModel;
import org.jongo.Jongo;

/**
 * The TableModel class incorporates the basic functionality for a table, including the column types and 
 * corresponding row titles. To use this class, another class must extend this class and specify the types and titles.
 * 
 * @author Justin Svegliato and Andrew Evans
 */
public abstract class TableModel extends DefaultTableModel {  
    
    /** the database to which the model will connect */
    protected static final Jongo database = DatabaseHandler.getDatabase();
    
    /** the game that is associated with this model */
    protected final Game game;
    
    /** the column types, namely Integer, String, or perhaps Boolean, which depend upon the game */
    protected final Class[] types;
    
    /** the column titles that depend upon the game */
    protected final String[] titles;
    
    /**
     * Creates a newly-instantiated TableModel object.
     * 
     * @param game the game that is associated with this model
     * @param types the column types, namely Integer, String, or perhaps Boolean, which depend upon the game
     * @param titles the column titles that depend upon the game
     */
    public TableModel(Game game, Class[] types, String[] titles) {
        this.game = game;
        this.types = types;
        this.titles = titles;   
        setColumnIdentifiers(this.titles);
    }
    
    /**
     * Gets the data type that is used in this column.
     * 
     * @param columnIndex the index of the column
     * @return the data type that is used in this column.
     */
    @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }

    /**
     * Returns true if the cell is editable, otherwise false.
     * 
     * @param row the row number of the cell
     * @param col the columm number of the cell
     * @return true of the cell is editable, otherwise false.
     */
    @Override
    public boolean isCellEditable(int row, int col) {
        return false;
    }      
}
