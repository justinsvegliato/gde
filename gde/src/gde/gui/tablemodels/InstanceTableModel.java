package gde.gui.tablemodels;

import static gde.gui.tablemodels.TableModel.database;
import gde.models.Field;
import gde.models.Game;
import gde.models.Instance;
import org.bson.types.ObjectId;
import org.jongo.MongoCollection;

public class InstanceTableModel extends TableModel<Instance> {
    private static final Class[] TYPES = {Boolean.class, String.class};
    private static final String[] TITLES = {"Select", "Identifier"};

    public InstanceTableModel(Game game) {
        super(game, TYPES, TITLES);
    }

    @Override
    public void populate() {
        setRowCount(0);
        MongoCollection instancesCollection = database.getCollection("instances");
        String instancesQuery = String.format("{gameId: '%s'}", game.getKey().toString());
        Iterable<Instance> instances = instancesCollection.find(instancesQuery).as(Instance.class);
        for (Instance instance : instances) {
            this.addRow(new Object[]{false, instance.getIdentifier()});
        }
    }

    @Override
    public void update(Instance entry) {
        addRow(new Object[] {false, entry.getIdentifier()});
    }

}
