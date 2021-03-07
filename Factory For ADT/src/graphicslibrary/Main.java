package graphicslibrary;

import graphicslibrary.Shape.ShapeType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Main {
	/**
	 * Reading integer input from the user
	 * 
	 * @return integer value read from user
	 */
	public static int integerInput() {
		InputStreamReader inputStreamReader = new InputStreamReader(System.in);
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		int integer = 0;

		while (true) {
			try {
				integer = Integer.parseInt(bufferedReader.readLine());
				break;
			} catch (Exception exception) {
				System.err.println("Invalid Input....");
				System.out.println("Enter again: ");
			}
		}
		return integer;
	}

	// For testing
	public static void main(String[] args) {
		Screen screen = new Screen();
		while (true) {
			System.out.println("\n         MENU");
			System.out.println("*******************************************");
			System.out.println("1. To add a shape object");
			System.out.println("2. To delete a shape object from the screen");
			System.out
					.println("3. To delete all shape objects of a specific type");
			System.out.println("4. To sort shapes in list");
			System.out.println("5. To show all shapes");
			System.out.println("6. To exit");
			System.out.println("Enter your choice: ");
			int choice = integerInput();
			switch (choice) {
			case 1:
				if (addingShape(screen))
					System.out.println("Shape added successfully");
				else
					System.out.println("Shape not added");
				break;
			case 2:
				List<Shape> listOfShapes = screen.getListOfShapes();
				Map<Shape, Date> shapeTimestamp = screen.getShapeTimestamp();
				displayListOfShapes(listOfShapes, shapeTimestamp);
				System.out.println("Enter Shape Choice to delete: ");
				int shapeChoice = integerInput();
				if (screen.deleteShape(shapeChoice - 1)) {
					System.out.println("Shape deleted successfully");
				} else {
					System.out.println("Invalid Input...");
				}
				break;
			case 3:
				System.out.println("1. To delete Circles");
				System.out.println("2. To delete Triangle");
				System.out.println("3. To delete Square");
				System.out.println("4. To delete Rectangle");
				System.out.println("Enter choice: ");
				shapeChoice = integerInput();
				if (shapeChoice >= 1 && shapeChoice <= 4) {
					switch (shapeChoice) {
					case 1:
						screen.deleteAllShape(ShapeType.Circle);
						break;
					case 2:
						screen.deleteAllShape(ShapeType.Triangle);
						break;
					case 3:
						screen.deleteAllShape(ShapeType.Square);
						break;
					case 4:
						screen.deleteAllShape(ShapeType.Rectangle);
						break;
					}
					System.out.println("Shapes deleted successfully");
				} else {
					System.out.println("Invalid Input");
				}

				break;
			case 4:
				sortShapes(screen);
				break;
			case 5:
				List<Shape> allshapeList = screen.getListOfShapes();
				shapeTimestamp = screen.getShapeTimestamp();
				displayListOfShapes(allshapeList, shapeTimestamp);
				break;
			case 6:
				System.exit(0);
			default:
				System.out.println("Invalid Input...");
			}
		}
	}

	/**
	 * This method will collect all the necessary values that is needed to
	 * create and add shape on the screen
	 * 
	 * @param screen
	 *            It is the object of screen on which shape is to be created
	 * @return true if shapes are added on the screen else return false
	 */
	private static boolean addingShape(Screen screen) {
		int x, y;
		int widthIndex = 0;
		int heightIndex = 1;
		int radiusIndex = 0;
		System.out.println("Choose Shape Type: ");
		System.out.println("1. Square");
		System.out.println("2. Rectangle");
		System.out.println("3. Triangle");
		System.out.println("4. Circle");
		System.out.println("Enter ShapeType Choice: ");
		int shapeChoice = integerInput();

		boolean flag = false;

		if (shapeChoice >= 1 && shapeChoice <= 4) {
			System.out.println("Enter Point of Orgin: ");
			System.out.println("Enter X Coordinate: ");
			x = integerInput();
			System.out.println("Enter Y Coordinate: ");
			y = integerInput();
			Point point = new Point(x, y);
			List<Integer> list = new ArrayList<>();

			switch (shapeChoice) {

			case 1:
				System.out.println("Enter width: ");
				list.add(widthIndex, integerInput());
				flag = screen.addShape(ShapeType.Square, point, list);
				break;
			case 2:
				System.out.println("Enter width: ");
				list.add(widthIndex, integerInput());
				System.out.println("Enter height: ");
				list.add(heightIndex, integerInput());
				flag = screen.addShape(ShapeType.Rectangle, point, list);
				break;
			case 3:
				System.out.println("Enter width: ");
				list.add(widthIndex, integerInput());
				System.out.println("Enter height: ");
				list.add(heightIndex, integerInput());
				flag = screen.addShape(ShapeType.Triangle, point, list);
				break;
			case 4:
				System.out.println("Enter radius: ");
				list.add(radiusIndex, integerInput());
				flag = screen.addShape(ShapeType.Circle, point, list);
				break;
			}
		} else
			System.out.println("Invalid Input...");
		return flag;
	}

	/**
	 * This method will display the shape and its timestamp on the screen
	 */
	public static void displayListOfShapes(List<Shape> listOfShapes,
			Map<Shape, Date> shapeTimestamp) {
		if (listOfShapes.isEmpty())
			System.out.println("List of shapes is empty");
		for (int index = 0; index < listOfShapes.size(); index++) {
			Shape shape = listOfShapes.get(index);
			System.out.println((index + 1) + ". " + shape.getName() + " -> "
					+ shapeTimestamp.get(shape));
		}
	}

	/**
	 * This method will ask user how they want the list of shapes to be sorted
	 * 
	 * @param screen
	 *            It is the object of screen
	 */
	public static void sortShapes(Screen screen) {
		System.out.println("Choose option to sort the shapes: ");
		System.out.println("1. Based on area");
		System.out.println("2. Based on perimeter");
		System.out.println("3. Based on distance from origin");
		System.out.println("4. Based on timestamp");
		System.out.println("Enter option: ");
		int sortchoice = integerInput();
		if (sortchoice >= 1 && sortchoice <= 4) {
			switch (sortchoice) {
			case 1:
				screen.sortingBasedOnArea();
				break;
			case 2:
				screen.sortingBasedOnPerimeter();
				break;
			case 3:
				screen.sortingBasedOnOriginDistance();
				break;
			case 4:
				screen.sortingBasedOnTimestamp();
				break;
			}
			System.out.println("Shapes sorted successfully");
		} else
			System.out.println("Invalid Input");
	}
}