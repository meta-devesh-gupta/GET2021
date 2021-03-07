package graphicslibrary;

//Shape Interface
public interface Shape {

	// ShapeType enum that contains list all the supported type of shapes
	public enum ShapeType {
		Circle, Triangle, Rectangle, Square;
	}

	/**
	 * This method will return the type of the shape in string format
	 * 
	 * @return the type of shape
	 */
	public String getName();

	/**
	 * This method will calculate and return the area of the shape
	 * 
	 * @return area of the shape
	 */
	public double getArea();

	/**
	 * This method will calculate and return the perimeter of the shape
	 * 
	 * @return perimeter of the shape
	 */
	public double getPerimeter();

	/**
	 * This method will return the point of origin of the shape
	 * 
	 * @return point of origin of the shape
	 */
	public Point getOrigin();

	/**
	 * This method will check whether the shape can be created on the screen
	 * 
	 * @param screenMaxCoordinate
	 *            Is is the maximum coordinate of the screen
	 * @return true if the shape can be created else false
	 */
	public boolean isPointEnclosed(Point screenMaxCoordinate);

}
