package graphicslibrary;

import graphicslibrary.Shape.ShapeType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Screen Class
public class Screen {

	private static final int XMAX = 900;
	private static final int YMAX = 900;
	private static Point screenMaxCoordinate = new Point(XMAX, YMAX);
	private static List<Shape> listOfShapes = new ArrayList<>();
	private static Map<Shape, Date> map = new HashMap<>();

	/**
	 * This method will return the copy of list of shapes
	 * 
	 * @return copy of list of shapes
	 */
	public List<Shape> getListOfShapes() {
		return new ArrayList<>(listOfShapes);
	}

	/**
	 * This method will return the HashMap mapping Shape with timestamps
	 * 
	 * @return copy of HashMap<Shape, Date>
	 */
	public Map<Shape, Date> getShapeTimestamp() {
		return new HashMap<>(map);
	}

	/**
	 * This method will create and add shape on the screen
	 * 
	 * @param shapeType
	 *            It is the enum that tell which shape it is
	 * @param point
	 *            It is the point of origin of the shape
	 * @param list
	 *            It contains the width, height and radius for the respective
	 *            shapes
	 * @return true if shape can be created else return false
	 */
	public boolean addShape(ShapeType shapeType, Point point, List<Integer> list) {
		Shape shape = ShapeFactory.createShape(shapeType, point, list);
		if (!shape.isPointEnclosed(screenMaxCoordinate))
			return false;
		listOfShapes.add(shape);

		Calendar calendar = Calendar.getInstance();
		Date timestamp = calendar.getTime();
		map.put(shape, timestamp);
		return true;
	}

	/**
	 * This method will delete the particular selected shape from the screen
	 * 
	 * @param index
	 *            It is the index of the shape in listOfShapes
	 * @return true if shape can be deleted else return falses
	 */
	public boolean deleteShape(int index) {
		// displaying shape and then deleting it
		if(listOfShapes.isEmpty())
			throw new AssertionError("List of shapes is empty");
		if (index < 0 || index > listOfShapes.size())
			return false;
		Shape shape = listOfShapes.get(index);
		listOfShapes.remove(shape);
		map.remove(shape);
		return true;
	}

	/**
	 * This method will delete all the shape of specific shape type
	 * 
	 * @param shapeType
	 *            It is the enum that tell which shape it is
	 */
	public void deleteAllShape(ShapeType shapeType) {
		String shapeName = shapeType.toString();

		for (int index = 0; index < listOfShapes.size(); index++) {
			Shape shape = listOfShapes.get(index);
			if (shape.getName().equals(shapeName)) {
				listOfShapes.remove(shape);
				index--;
				map.remove(shape);
			}
		}
	}

	/**
	 * This method will sort the listOfShapes on the basis of area in ascending
	 * order
	 */
	public void sortingBasedOnArea() {
		Comparator<Shape> comparator = new Comparator<Shape>() {

			@Override
			public int compare(Shape one, Shape two) {
				if (one.getArea() >= two.getArea())
					return 1;
				return -1;
			}
		};

		Collections.sort(listOfShapes, comparator);
	}

	/**
	 * This method will sort the listOfShapes on the basis of perimeter in
	 * ascending order
	 */
	public void sortingBasedOnPerimeter() {
		Comparator<Shape> comparator = new Comparator<Shape>() {

			@Override
			public int compare(Shape one, Shape two) {
				if (one.getPerimeter() >= two.getPerimeter())
					return 1;
				return -1;
			}
		};

		Collections.sort(listOfShapes, comparator);
	}

	/**
	 * This method will sort the listOfShapes on the basis of timestamp in
	 * ascending order means Shape which is created first will come first in the
	 * list
	 */
	public void sortingBasedOnTimestamp() {
		Comparator<Shape> comparator = new Comparator<Shape>() {

			@Override
			public int compare(Shape one, Shape two) {
				Date timestampOne = map.get(one);
				Date timestampTwo = map.get(two);

				return timestampOne.compareTo(timestampTwo);
			}
		};

		Collections.sort(listOfShapes, comparator);
	}

	/**
	 * This method will sort the listOfShapes on the basis of distance of shape
	 * from the origin in ascending order
	 */
	public void sortingBasedOnOriginDistance() {
		Comparator<Shape> comparator = new Comparator<Shape>() {

			@Override
			public int compare(Shape one, Shape two) {
				double distanceOfOne = Math.sqrt((one.getOrigin().getX() * one
						.getOrigin().getX())
						- (one.getOrigin().getY() * one.getOrigin().getY()));
				double distanceOfTwo = Math.sqrt((two.getOrigin().getX() * two
						.getOrigin().getX())
						- (two.getOrigin().getY() * two.getOrigin().getY()));
				if (distanceOfOne >= distanceOfTwo)
					return 1;
				else
					return -1;
			}
		};

		Collections.sort(listOfShapes, comparator);
	}
}