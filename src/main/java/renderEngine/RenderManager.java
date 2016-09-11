package renderEngine;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.ContextAttribs;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.PixelFormat;

/**
 * Created by tynut on 11/09/2016.
 */
public class RenderManager {



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
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create(new PixelFormat(), contextAttributes);
            Display.setTitle(WINDOW_TITLE);
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        GL11.glViewport(0,0,WIDTH,HEIGHT);
    }

    public static void updateDisplay() {
        Display.sync(FPS);
        Display.update();
    }

    public static void closeDisplay() {
        Display.destroy();
    }
}
