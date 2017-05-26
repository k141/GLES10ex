package jp.ac.titech.itpro.sdl.gles10ex;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

public class Octahedron implements SimpleRenderer.Obj {

    private FloatBuffer vbuf;
    private float x, y, z;

    public Octahedron(float s, float x, float y, float z) {
        float[] vertices = {
                // surface 1
                s, 0, 0,
                0, s, 0,
                0, 0, s,
                // surface 2
                0, 0, s,
                0, s, 0,
                -s, 0, 0,
                // surface 3
                -s, 0, 0,
                0, s, 0,
                0, 0, -s,
                // surface 4
                0, 0, -s,
                0, s, 0,
                s, 0, 0,
                // surface 5
                s, 0, 0,
                0, -s, 0,
                0, 0, s,
                // surface 6
                0, 0, s,
                0, -s, 0,
                -s, 0, 0,
                // surface 7
                -s, 0, 0,
                0, -s, 0,
                0, 0, -s,
                // surface 8
                0, 0, -s,
                0, -s, 0,
                s, 0, 0
        };
        vbuf = ByteBuffer.allocateDirect(vertices.length * 4)
                .order(ByteOrder.nativeOrder()).asFloatBuffer();
        vbuf.put(vertices);
        vbuf.position(0);
        this.x = x;
        this.y = y;
        this.z = z;
    }

    @Override
    public void draw(GL10 gl) {
        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vbuf);

        // surface 1
        gl.glNormal3f(1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 0, 3);

        // surface 2
        gl.glNormal3f(-1, 1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 3, 3);

        // surface 3
        gl.glNormal3f(-1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 6, 3);

        // surface 4
        gl.glNormal3f(1, 1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 9, 3);

        // surface 5
        gl.glNormal3f(1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 12, 3);

        // surface 6
        gl.glNormal3f(-1, -1, 1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 15, 3);

        // surface 7
        gl.glNormal3f(-1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 18, 3);

        // surface 8
        gl.glNormal3f(1, -1, -1);
        gl.glDrawArrays(GL10.GL_TRIANGLES, 21, 3);
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getZ() {
        return z;
    }
}
