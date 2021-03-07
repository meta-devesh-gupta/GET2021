package graphicslibrary;

public class Triangle implements Shape {

	private Point pointOfOrigin;
	private int width;
	private int height;
	private String name = "Triangle";

	/**
	 * Creating the Triangle shape
	 * 
	 * @param pointOfOrigin
	 *            It is the point of origin
	 * @param width
	 *            It is the width of the triangle
	 * @param height
	 *            It is the height of the triangle
	 * 
	 */
	public Triangle(Point pointOfOrigin, int width, int height) {
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
		area /= 2.0;
		return area;
	}

	@Override
	public double getPerimeter() {
		double hypotenuse = Math.sqrt((width * width) + (height * height));
		double perimeter = width + height + hypotenuse;
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

		int topVertexX = pointOfOrigin.getX() + (width / 2);
		int topVertexY = pointOfOrigin.getY()
				+ (int) (Math.sqrt(3) * (width / 2));
		if (topVertexX > screenMaxCoordinate.getX()
				|| topVertexY > screenMaxCoordinate.getY())
			return false;
		return true;
	}
}
