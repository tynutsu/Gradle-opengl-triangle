package applicationMain;

import renderEngine.Model;

import static loader.Loader.cleanMemory;
import static loader.Loader.createModel;
import static org.lwjgl.opengl.Display.isCloseRequested;
import static renderEngine.RenderManager.closeDisplay;
import static renderEngine.RenderManager.createDisplay;
import static renderEngine.RenderManager.updateDisplay;
import static renderEngine.Renderer.clearScreen;
import static renderEngine.Renderer.draw;

/**
 * Created by tynut on 10/09/2016.
 */
public class Main {

    public static void main(String[] args) {
        createDisplay();

        final float[] positions = {
                -0.66f, -0.66f, +0.0f,
                +0.66f, -0.66f, +0.0f,
                +0.00f, +0.66f, +0.0f
        };

        Model model = createModel(positions);

        while(!isCloseRequested()) {
            clearScreen();
            draw(model);
            updateDisplay();
        }

        cleanMemory();
        closeDisplay();
    }
}
