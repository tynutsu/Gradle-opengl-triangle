package renderEngine;

import static constants.AttributeList.POSITIONS;
import static org.lwjgl.opengl.GL11.GL_COLOR_BUFFER_BIT;
import static org.lwjgl.opengl.GL11.GL_TRIANGLES;
import static org.lwjgl.opengl.GL11.glClear;
import static org.lwjgl.opengl.GL11.glClearColor;
import static org.lwjgl.opengl.GL11.glDrawArrays;
import static org.lwjgl.opengl.GL20.glDisableVertexAttribArray;
import static org.lwjgl.opengl.GL20.glEnableVertexAttribArray;
import static org.lwjgl.opengl.GL30.glBindVertexArray;

/**
 * Created by tynut on 12/09/2016.
 */
public class Renderer {

    private static final float RED = 0.12f;
    private static final float GREEN = 0.00f;
    private static final float BLUE = 0.97f;
    private static final float ALPHA = 1.00f;
    public static void clearScreen() {
        glClearColor(RED, GREEN, BLUE, ALPHA);
        glClear(GL_COLOR_BUFFER_BIT);
    }

    public static void draw(Model model) {
        glBindVertexArray(model.getVao());
        glEnableVertexAttribArray(POSITIONS);
        glDrawArrays(GL_TRIANGLES, 0, model.getTotalVertices());
        glDisableVertexAttribArray(POSITIONS);
    }
}
