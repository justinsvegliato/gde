package gde.gui.util;

import javax.swing.ImageIcon;

public class ImageLoader {
    private static final String RESOURCE_ROOT = "/gde/resources/";
    
    private static final ImageIcon PIE_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "pie_graph.png"));
    private static final ImageIcon LINE_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "line_graph.png"));
    private static final ImageIcon BAR_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "bar_graph.png"));
    private static final ImageIcon MAP_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "map_graph.png"));
    private static final ImageIcon SCATTER_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "scatter_graph.png"));
    private static final ImageIcon APP_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "gde_icon2.png"));
    private static final ImageIcon REFRESH_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "refresh_icon_small.png"));

    public static String getResourceRoot() {
        return RESOURCE_ROOT;
    }

    public static ImageIcon getPieIcon() {
        return PIE_ICON;
    }

    public static ImageIcon getLineIcon() {
        return LINE_ICON;
    }

    public static ImageIcon getBarIcon() {
        return BAR_ICON;
    }
        
    public static ImageIcon getScatterIcon() {
        return SCATTER_ICON;
    }

    public static ImageIcon getAppIcon() {
        return APP_ICON;
    }        

    public static ImageIcon getMapIcon() {
        return MAP_ICON;
    }

    public static ImageIcon getRefreshIcon() {
        return REFRESH_ICON;
    }
}