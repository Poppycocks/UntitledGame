package input;

import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.lwjgl.BufferUtils;

import java.nio.DoubleBuffer;

import static org.lwjgl.glfw.GLFW.*;

public class Input {

    private Vector3f wasdVector;
    private Matrix4f mouseMatrix;

    private long window;
    private float strength;

    private DoubleBuffer mouseX;
    private DoubleBuffer mouseY;

    public Input(long window){
        this.window = window;
        this.wasdVector = new Vector3f();
        this.mouseMatrix = new Matrix4f();
        this.strength = .15f;

        mouseX = BufferUtils.createDoubleBuffer(1);
        mouseY = BufferUtils.createDoubleBuffer(1);

    }

    public Vector3f getWASD(){
        wasdVector.zero();

        int w = glfwGetKey(window,GLFW_KEY_W);
        int a = glfwGetKey(window, GLFW_KEY_A);
        int s = glfwGetKey(window, GLFW_KEY_S);
        int d = glfwGetKey(window, GLFW_KEY_D);

        if(w==1){
            wasdVector.z = 1 * strength;
        }
        if(a==1){
            wasdVector.x = 1 * strength;
        }
        if(s==1){
            wasdVector.z = -1 * strength;
        }
        if(d==1){
            wasdVector.x = -1 * strength;
        }


        return wasdVector;


    }

    public Matrix4f getMouseMatrix() {
        mouseMatrix.identity();

        glfwGetCursorPos(window, mouseX, mouseY);
        double y  = mouseY.get(0);
        double x = mouseX.get(0);

        //center coords

        //System.out.println("x: "+x+" y: "+y);


        return mouseMatrix;
    }
}
