package render;

import org.joml.Matrix4f;

public class Camera {
	
	private Matrix4f cameraMatrix;
	private Matrix4f viewMatrix;
	
	public Camera() {
		cameraMatrix = new Matrix4f();
		cameraMatrix.setPerspective(70, 640/480, 0.1f, 100);
		cameraMatrix.lookAt(0, 3, 10,
				0, 0,  0,
				0, 1,  0);
		viewMatrix = new Matrix4f();
		viewMatrix.identity();
	}
	
	//public void lookAt(Model model);
	//public void lockOn(Model model);
	//public void zoom(float val);
	//public void trasnlateMove(float[] translate);
	
	/**
	 * Use this only when you need the float arr to load it into openGL
	 */
	public float[] getCameraMatrixArr(){
		return cameraMatrix.get(new float[16]);
	}
	
	public Matrix4f getCameraMatrixObj() {
		return cameraMatrix;
	}

	public float[] getViewMatrixArr() { return viewMatrix.get(new float [16]);};
	
	public void zoom(float var) {
		cameraMatrix.translate(0, 0, var);
	}
}	
