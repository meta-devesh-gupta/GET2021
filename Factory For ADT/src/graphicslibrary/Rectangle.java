package graphicslibrary;

public class Rectangle implements Shape {

	private Point pointOfOrigin;
	private int width;
	private int height;
	private String name = "Rectangle";

	/**
	 * Creating the Rectangle shape
	 * 
	 * @param pointOfOrigin
	 *            It is the point of origin
	 * @param width
	 *            It is the width of the rectangle
	 * @param height
	 *            It is the height of the rectangle
	 */
	public Rectangle(Point pointOfOrigin, int width, int height) {
		this.pointOfOrigin = pointOfOrigin;
		this.width = width;
		this.height = height;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getArea() {
		double area = width * height;
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter = 2 * (width + height);
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
		int topRightCornerY = pointOfOrigin.getY() + height;
		if (topRightCornerX > screenMaxCoordinate.getX()
				|| topRightCornerY > screenMaxCoordinate.getY())
			return false;
		return true;
	}
}
