package gde.gui.util;

import javax.swing.ImageIcon;

/**
 * The ImageLoader class merely serves to store all of the images used in the application in one spot.
 * 
 * @author Justin Svegliato
 */
public class ImageLoader {
    /** the resource root */
    private static final String RESOURCE_ROOT = "/gde/resources/";
    
    /** the icon to represent pie charts */
    private static final ImageIcon PIE_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "pie_graph.png"));
    
    /** the icon to represent line charts */
    private static final ImageIcon LINE_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "line_graph.png"));
    
    /** the icon to represent bar charts */
    private static final ImageIcon BAR_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "bar_graph.png"));
    
    /** the icon to represent map charts */
    private static final ImageIcon MAP_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "map_graph.png"));
    
    /** the icon to represent scatter charts */
    private static final ImageIcon SCATTER_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "scatter_graph.png"));
    
    /** the icon to represent the application */
    private static final ImageIcon APP_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "gde_icon2.png"));
    
    /**  the icon to represent the refresh icon */
    private static final ImageIcon REFRESH_ICON = new ImageIcon(ImageLoader.class.getResource(RESOURCE_ROOT + "refresh_icon_small.png"));

    /**
     * Instantiates a newly-instantiated ImageLoader object.
     */
    private ImageLoader() {
    }
    
    /**
     * Returns the resource root.
     * 
     * @return the resource root
     */
    public static String getResourceRoot() {
        return RESOURCE_ROOT;
    }

    /**
     * Returns the icon to represent pie charts.
     * 
     * @return the ImageIcon for pie charts
     */
    public static ImageIcon getPieIcon() {
        return PIE_ICON;
    }

    /**
     * Returns the icon to represent line graphs.
     * 
     * @return the ImageIcon for line graphs
     */
    public static ImageIcon getLineIcon() {
        return LINE_ICON;
    }

    /**
     * Returns the icon to represent bar graphs.
     * 
     * @return the ImageIcon for bar graphs
     */
    public static ImageIcon getBarIcon() {
        return BAR_ICON;
    }
        
    /**
     * Returns the icon to represent scatter charts.
     * 
     * @return the ImageIcon for scatter charts
     */
    public static ImageIcon getScatterIcon() {
        return SCATTER_ICON;
    }

    /**
     * Returns the icon to represent the application.
     * 
     * @return the ImageIcon for the application.
     */
    public static ImageIcon getAppIcon() {
        return APP_ICON;
    }        

    /**
     * Returns the icon to represent map graphs.
     * 
     * @return the ImageIcon for map graphs.
     */
    public static ImageIcon getMapIcon() {
        return MAP_ICON;
    }

    /**
     * Returns the icon to represent the refresh action.
     * 
     * @return the ImageIcon for the refresh action.
     */
    public static ImageIcon getRefreshIcon() {
        return REFRESH_ICON;
    }
}