package uo.mp.s5.figure.drawable;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import uo.mp.s5.acme.picture.Picture;
import uo.mp.s5.shapes.Circle;
import uo.mp.s5.shapes.Rectangle;
import uo.mp.s5.shapes.Triangle;

public class Canvas {
	private List< Drawable > drawables = new ArrayList<>();

	public void add(Rectangle drawable) {
		drawables.add(drawable);
	}

	public void draw(PrintStream out) {
		for (Drawable drawable : drawables) {
			drawable.draw(out);
		}
	}

	public void add(Circle circle) {
		drawables.add(circle);
	}

	public void add(Picture picture) {
		drawables.add(picture);
		
	}

	public void add(Triangle triangle) {
		drawables.add(triangle);
		
	}
}
