package loader;

import renderEngine.Model;

import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.BufferUtils.createFloatBuffer;
import static org.lwjgl.opengl.GL11.GL_FLOAT;
import static org.lwjgl.opengl.GL15.GL_ARRAY_BUFFER;
import static org.lwjgl.opengl.GL15.GL_STATIC_DRAW;
import static org.lwjgl.opengl.GL15.glBindBuffer;
import static org.lwjgl.opengl.GL15.glBufferData;
import static org.lwjgl.opengl.GL15.glDeleteBuffers;
import static org.lwjgl.opengl.GL15.glGenBuffers;
import static org.lwjgl.opengl.GL20.glVertexAttribPointer;
import static org.lwjgl.opengl.GL30.glBindVertexArray;
import static org.lwjgl.opengl.GL30.glDeleteVertexArrays;
import static org.lwjgl.opengl.GL30.glGenVertexArrays;
import static constants.AttributeList.POSITIONS;

/**
 * Created by tynut on 12/09/2016.
 */
public class Loader {
    private static List<Integer> vaos = new ArrayList<>();
    private static List<Integer> vbos = new ArrayList<>();

    public static Model createModel(float[] positions) {

        // create Vertex Array Objects and keep track of it
        int vaoID = glGenVertexArrays();
        vaos.add(vaoID);
        glBindVertexArray(vaoID);
        // create buffer data
        FloatBuffer vboData = createFloatBuffer(positions.length);
        vboData.put(positions);
        vboData.flip();
        // create buffer object and keep track of it
        int vboID = glGenBuffers();
        vbos.add(vboID);

        // bind the vbo to the array buffer, put the positions data in the right attributes list and store it in the vao
        glBindBuffer(GL_ARRAY_BUFFER, vboID);
        glBufferData(GL_ARRAY_BUFFER, vboData, GL_STATIC_DRAW);
        glVertexAttribPointer(POSITIONS, 3, GL_FLOAT, false, 0, 0);
        glBindBuffer(GL_ARRAY_BUFFER, 0);
        glBindVertexArray(0);

        return new Model(vaoID, positions.length/3);
    }

    public static void cleanMemory() {
        // remove all tracked vaos and vbos
        vaos.forEach(vao -> glDeleteVertexArrays(vao));
        vbos.forEach(vbo -> glDeleteBuffers(vbo));
    }
}
