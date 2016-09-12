package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.BasicMarker;

import static org.lwjgl.opengl.Display.create;
import static org.lwjgl.opengl.Display.setDisplayMode;
import static org.lwjgl.opengl.Display.setTitle;
import static org.lwjgl.opengl.GL11.glViewport;
import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by tynut on 11/09/2016.
 */
public class RenderManager {
    private static final Logger LOGGER = getLogger(RenderManager.class);
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 720;
    private static final int FPS = 120;
    private static final int MINOR_VERSION = 2;
    private static final int MAJOR_VERSION = 3;
    private static final String WINDOW_TITLE = "Joy Application Tester";

    public static void createDisplay() {
        ContextAttribs contextAttributes = new ContextAttribs(MAJOR_VERSION, MINOR_VERSION);
        contextAttributes.withForwardCompatible(true);
        contextAttributes.withProfileCore(true);

        try {
            setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
        } catch (LWJGLException e) {
            String errorMessage = "Cannot create a new DisplayMode when setDisplayMode for " +
                    "a display with Width: " + WIDTH + "and Height: "+ HEIGHT;
            LOGGER.error(errorMessage, e);
            closeDisplay();
        }
        try {
            create(new PixelFormat(), contextAttributes);
            setTitle(WINDOW_TITLE);
        } catch (LWJGLException e) {
            String errorMessage = "Error occurred when creating a " +
                            "new Display while setting a " +
                            "new PixelFormat with the context attributes: /n" +
                            contextAttributes.toString();
            LOGGER.error(errorMessage, e);
            closeDisplay();
        }

        glViewport(0,0,WIDTH,HEIGHT);
    }

    public static void updateDisplay() {
        Display.sync(FPS);
        Display.update();
    }

    public static void closeDisplay() {
        Display.destroy();
    }
}
