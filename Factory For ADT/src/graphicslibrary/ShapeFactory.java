package graphicslibrary;

import java.util.List;

import graphicslibrary.Shape.ShapeType;

//ShapeFactory class that will create shapes based on the ShapeType
public class ShapeFactory {

	private static int widthIndex = 0;
	private static int heightIndex = 1;
	private static int radiusIndex = 0;

	/**
	 * This method will create the shape object of shape type and return the
	 * shape object
	 * 
	 * @param shapeType
	 *            It is the enum that tell which shape it is
	 * @param point
	 *            It is the point of origin of the shape
	 * @param list
	 *            It will contain the list of the necessary values such as
	 *            width, height and radius of the respective shape type
	 * @return the object of the shape
	 */
	public static Shape createShape(ShapeType shapeType, Point point,
			List<Integer> list) {
		if (shapeType.compareTo(ShapeType.Circle) == 0)
			return new Circle(point, list.get(radiusIndex));
		else if (shapeType.compareTo(ShapeType.Square) == 0)
			return new Square(point, list.get(widthIndex));
		else if (shapeType.compareTo(ShapeType.Rectangle) == 0)
			return new Rectangle(point, list.get(widthIndex),
					list.get(heightIndex));
		else if (shapeType.compareTo(ShapeType.Triangle) == 0)
			return new Triangle(point, list.get(widthIndex),
					list.get(heightIndex));

		return null;
	}

}
