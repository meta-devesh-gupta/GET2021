package graphicslibrary;

public class Circle implements Shape {

	private Point pointOfOrigin;
	private int radius;
	private String name = "Circle";

	/**
	 * Creating the Circle shape
	 * 
	 * @param pointOfOrigin
	 *            It is the point of origin
	 * @param radius
	 *            It is the radius of the circle
	 */
	public Circle(Point pointOfOrigin, int radius) {
		this.pointOfOrigin = pointOfOrigin;
		this.radius = radius;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public double getArea() {
		double area = Math.PI * radius * radius;
		return area;
	}

	@Override
	public double getPerimeter() {
		double perimeter = 2 * Math.PI * radius;
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

		int currentX = pointOfOrigin.getX() - radius;
		int currentY = pointOfOrigin.getY() - radius;
		if (currentX <= 0 || currentY <= 0)
			return false;

		currentX = pointOfOrigin.getX() + radius;
		currentY = pointOfOrigin.getY() + radius;
		if (currentX >= screenMaxCoordinate.getX()
				|| currentY >= screenMaxCoordinate.getY())
			return false;
		return true;
	}
}
