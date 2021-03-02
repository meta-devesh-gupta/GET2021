package question3;

//Class Area to calculate areas for different shapes
public class Area {

	/**
	 * Calculating area of the Triangle
	 * 
	 * @param width
	 *            width of triangle such that width > 0
	 * @param height
	 *            height of triangle such that height > 0
	 * @return computed area of triangle value as double
	 */
	public double areaOfTriangle(double width, double height) {
		double areaOfTriangle = 0.0;
		try {
			areaOfTriangle = width * height;
			areaOfTriangle /= 2.0;
		} catch (ArithmeticException arithmeticException) {
			System.out.println(arithmeticException);
		}
		return areaOfTriangle;
	}

	/**
	 * Calculating area of the Rectangle
	 * 
	 * @param width
	 *            width of triangle such that width > 0
	 * @param height
	 *            height of triangle such that height > 0
	 * @return computed area of rectangle value as double
	 */
	public double areaOfRectangle(double width, double height) {
		double areaOfRectangle = width * height;
		return areaOfRectangle;
	}

	/**
	 * Calculating area of Square
	 * 
	 * @param width
	 *            width of square such that width > 0
	 * @return computed area of square value as double
	 */
	public double areaOfSquare(double width) {
		double areaOfSquare = width * width;
		return areaOfSquare;
	}

	/**
	 * Calculating area of Circle
	 * 
	 * @param radius
	 *            radius of circle such that radius > 0
	 * @return computed area of triangle value as double upto two decimal places.
	 */
	public double areaOfCircle(double radius) {
		double areaOfCircle = Math.PI * radius * radius;
		areaOfCircle = Double.parseDouble(String.format("%.2f", areaOfCircle));
		return areaOfCircle;
	}
}
