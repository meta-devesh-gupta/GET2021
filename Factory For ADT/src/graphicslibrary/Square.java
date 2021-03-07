package graphicslibrary;

//Square shape class
public class Square implements Shape {

	private Point pointOfOrigin;
	private int width;
	private String name = "Square";

	/**
	 * Creation of Square shape
	 * 
	 * @param pointOfOrigin
	 *            It is the point of origin
	 * @param width
	 *            It is the width of the square
	 */
	public Square(Point pointOfOrigin, int width) {
		this.pointOfOrigin = pointOfOrigin;
		this.width = width;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getArea() {
		double area = width * width;
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter = 4 * width;
		return perimeter;
	}

	@Override
	public Point getOrigin() {
		return new Point(pointOfOrigin.getX(), pointOfOrigin.getY());
	}

	@Override
	public boolean isPointEnclosed(Point screenMaxCoordinate) {
		if (pointOfOrigin.getX() < 0 || pointOfOrigin.getY() < 0
				|| pointOfOrigin.getX() >= screenMaxCoordinate.getX()
				|| pointOfOrigin.getY() >= screenMaxCoordinate.getY())
			return false;

		int topRightCornerX = pointOfOrigin.getX() + width;
		int topRightCornerY = pointOfOrigin.getY() + width;
		if (topRightCornerX > screenMaxCoordinate.getX()
				|| topRightCornerY > screenMaxCoordinate.getY())
			return false;
		return true;
	}
}
