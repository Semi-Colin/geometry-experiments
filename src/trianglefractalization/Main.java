package trianglefractalization;

import apcs.Window;

public class Main {
	
	static int degree;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		apcs.Window.size(800, 800);
		degree = 0;
		while(true) {
			mouseTri();
			//printDegree();
			Window.sleep(100);
		}
	}
	
	static void printDegree() {
		String degreeString = "degree: " + degree;
		Window.out.color("white");
		Window.out.print(degreeString, 20, 20);
	}
	
	static void mouseTri() {
		int x1 = 0; int y1 = 0;
		int x2 = 0; int y2 = 0;
		int x3 = 0; int y3 = 0;
		
		Window.frame();
		
		while(Window.mouse.released()) {}
		x1 = Window.mouse.getX();
		y1 = Window.mouse.getY();
		Window.sleep(300);
		while(Window.mouse.released()) {
			Window.frame();
			Window.out.line(x1, y1, Window.mouse.getX(), Window.mouse.getY());
		}
		x2 = Window.mouse.getX();
		y2 = Window.mouse.getY();
		Window.sleep(300);
		while(Window.mouse.released()) {
			Window.frame();
			Window.out.polygon(x1, y1, x2, y2, Window.mouse.getX(), Window.mouse.getY());
		}
		Window.frame();
		x3 = Window.mouse.getX();
		y3 = Window.mouse.getY();
		splitTri(x1,y1,x2,y2,x3,y3,5);
		
	}
	
	static void splitTri(int x1, int y1, int x2, int y2, int x3, int y3, int d) {
		if(d == 0) {
			Window.out.color(80,50, Window.random(50, 255));
			Window.out.polygon(x1,y1,(x2+x1)/2,(y2+y1)/2,x3,y3);
			Window.out.color(80,50, Window.random(50,255));
			Window.out.polygon((x2+x1)/2,(y2+y1)/2,x2,y2,x3,y3);
		} else if(d % 2 == 0) {
			splitTri(x1,y1,(x2+x1)/2,(y2+y1)/2,x3,y3,d-1);
			splitTri((x2+x1)/2,(y2+y1)/2,x2,y2,x3,y3,d-1);
		} else {
			splitTri(x1,y1,(x3+x2)/2,(y3+y2)/2,x3,y3,d-1);
			splitTri(x1,y1,x2,y2,(x3+x2)/2,(y3+y2)/2,d-1);
		}
		
	}

}
