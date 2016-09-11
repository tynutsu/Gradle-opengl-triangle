package ApplicationMain;

import org.lwjgl.opengl.Display;
import renderEngine.RenderManager;

/**
 * Created by tynut on 10/09/2016.
 */
public class ApplicationMain {

    public static void main(String[] args) {
        RenderManager.createDisplay();

        while(!Display.isCloseRequested()) {
            RenderManager.updateDisplay();
        }

        RenderManager.closeDisplay();
    }
}
