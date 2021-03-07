package graphicslibrary;

import static org.junit.Assert.*;
import graphicslibrary.Shape.ShapeType;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class ScreenTest {
	Screen screen;
	List<Integer> list;
	int widthIndex = 0;
	int heightIndex = 1;
	int radiusIndex = 0;

	@Before
	public void init() {
		screen = new Screen();
		list = new ArrayList<>();
	}

	@Test
	public void shapeCreationTest() {
		Point rectanglePoint = new Point(5,5);
		list.add(widthIndex, 10);
		list.add(heightIndex, 12);
		assertTrue(screen.addShape(ShapeType.Rectangle, rectanglePoint, list));
		
		Point trianglePoint = new Point(23,56);
		list.add(widthIndex, 54);
		list.add(heightIndex, 234);
		assertTrue(screen.addShape(ShapeType.Triangle, trianglePoint, list));
		
	}

	@Test
	public void squareCreationDeletionTest() {
		Point rectanglePoint = new Point(-4,5);
		list.add(widthIndex, 10);
		list.add(heightIndex, 12);
		assertFalse(screen.addShape(ShapeType.Square, rectanglePoint, list));
		assertTrue(screen.deleteShape(0));
	}
	
	@Test(expected=AssertionError.class)
	public void shapeDeletionTest(){
		assertFalse(screen.deleteShape(0));
	}
}
