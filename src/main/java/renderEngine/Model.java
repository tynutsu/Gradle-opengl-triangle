package renderEngine;

/**
 * Created by tynut on 12/09/2016.
 */
public class Model {
    private int vao;
    private int totalVertices;

    public Model(int vao, int totalVertices) {
        this.vao = vao;
        this.totalVertices = totalVertices;
    }

    public int getVao() {
        return vao;
    }

    public void setVao(int vao) {
        this.vao = vao;
    }

    public int getTotalVertices() {
        return totalVertices;
    }

    public void setTotalVertices(int totalVertices) {
        this.totalVertices = totalVertices;
    }
}
