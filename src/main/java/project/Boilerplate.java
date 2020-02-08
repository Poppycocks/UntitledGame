package project;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Boilerplate {
			
	
	public static CharSequence readShader(Path path) throws IOException {
		return new StringBuilder(new String(Files.readAllBytes(null)));
	}
	
	public static float[] createModelFloatArray(Path path)  throws IOException{
		
//		return new float[]{
//			-0.9f,-0.9f,
//			0.85f,-0.9f,
//			-0.9f,0.85f,
//			0.9f,-0.85f,
//			0.9f,0.9f,
//			-0.85f,0.9f
//		};	//placeholder

		return new float[]{
				// front
				-1.0f -1.0f,  1.0f,
				1.0f, -1.0f,  1.0f,
				1.0f,  1.0f,  1.0f,
				-1.0f,  1.0f,  1.0f,
				// back
				-1.0f, -1.0f, -1.0f,
				1.0f, -1.0f, -1.0f,
				1.0f,  1.0f, -1.0f,
				-1.0f,  1.0f, -1.0f
		};
	}
	
}
