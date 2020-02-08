package project;


import render.Render;

public class Main {

	public static void main(String[] args) {
		Render render = new Render();
		render.initialize();
		render.loadNewScene();
		render.display();
		
	}
	
}
