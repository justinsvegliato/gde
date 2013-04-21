package gde.gui.util;

import javax.swing.ImageIcon;

public class ImageLoader {
    private static final String RESOURCE_ROOT = "/gde/resources/";
    
    private static final ImageIcon PIE_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "pie_graph.png"));
    private static final ImageIcon LINE_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "line_graph.png"));
    private static final ImageIcon BAR_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "bar_graph.png"));
    private static final ImageIcon APP_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "gde_icon.png"));

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

    public static ImageIcon getAppIcon() {
        return APP_ICON;
    }        
}
