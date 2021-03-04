package question1;

public class MultivariatePolynomial {

	/**
	 * This class holds only the variable name such as x,y,z and its
	 * corresponding degree.
	 *
	 */
	static class VariableDegreeNode {
		char variable;
		int degree;
		VariableDegreeNode nextVariableDegreeNode;

		public VariableDegreeNode(char variable, int degree) {
			this.variable = variable;
			this.degree = degree;
		}
	}

	/**
	 * This class holds the coefficient of the term and its corresponding
	 * VariableDegree head node
	 * 
	 */
	static class PolyLinkedListNode {
		int cofficient;
		VariableDegreeNode variableDegreeNode;
		PolyLinkedListNode nextPolyLinkedList;

		public PolyLinkedListNode(int cofficient,
				VariableDegreeNode variableDegreeNode) {
			this.cofficient = cofficient;
			this.variableDegreeNode = variableDegreeNode;
		}
	}

	/**
	 * This method will add the variable and its degree into the new node and
	 * attach it with VariableDegree head node.
	 * 
	 * @param headNodeVariable
	 *            It is the head node of the VariableDegreeNode linked list
	 * @param variable
	 *            It is the character variable
	 * @param degree
	 *            It is the degree of the character variable
	 * @return head node of the VariableDegreeNode linked list
	 */
	public VariableDegreeNode addVariable(VariableDegreeNode headNodeVariable,
			char variable, int degree) {
		VariableDegreeNode variableDegree = new VariableDegreeNode(variable,
				degree);
		if (headNodeVariable == null)
			headNodeVariable = variableDegree;
		else {
			VariableDegreeNode temp = headNodeVariable;
			while (temp.nextVariableDegreeNode != null)
				temp = temp.nextVariableDegreeNode;
			temp.nextVariableDegreeNode = variableDegree;
		}
		return headNodeVariable;
	}

	/**
	 * This will add the coefficient and its VariableDegreeNode to the linked
	 * list of the polynomial terms
	 * 
	 * @param headNodePoly
	 *            It is the head node of the polynomial linked list
	 * @param cofficient
	 *            It is the coefficient term of the polynomial term such as
	 *            3x^2y^2
	 * @param headNodeVariable
	 *            It is the head node of the VariableDegreeNode linked list
	 * @return the head node of the polynomial linked list
	 */
	public PolyLinkedListNode addPolyTerm(PolyLinkedListNode headNodePoly,
			int cofficient, VariableDegreeNode headNodeVariable) {
		PolyLinkedListNode polyLinkedListNode = new PolyLinkedListNode(
				cofficient, headNodeVariable);
		if (headNodePoly == null) {
			headNodePoly = polyLinkedListNode;
		} else {
			PolyLinkedListNode temp = headNodePoly;
			while (temp.nextPolyLinkedList != null) {
				temp = temp.nextPolyLinkedList;
			}
			temp.nextPolyLinkedList = polyLinkedListNode;
		}
		return headNodePoly;
	}

	/**
	 * This method will calculate the degree of the polynomial
	 * 
	 * @param headNode
	 *            It is the headNode of the polynomial linked list
	 * @return the degree of the polynomial
	 */
	public int findDegree(PolyLinkedListNode headNode) {
		int maxDegree = 0;

		PolyLinkedListNode tempPolyNode = headNode;
		while (tempPolyNode != null) {
			int currentDegree = 0;
			VariableDegreeNode tempVariableNode = tempPolyNode.variableDegreeNode;
			while (tempVariableNode != null) {
				currentDegree += tempVariableNode.degree;
				tempVariableNode = tempVariableNode.nextVariableDegreeNode;
			}
			maxDegree = Math.max(currentDegree, maxDegree);
			tempPolyNode = tempPolyNode.nextPolyLinkedList;
		}
		return maxDegree;
	}

	/**
	 * This method will display the polynomial
	 * 
	 * @param headNode
	 *            It is the head node of the polynomial linked list
	 */
	public void displayPoly(PolyLinkedListNode headNode) {

		PolyLinkedListNode tempPolyNode = headNode;
		while (tempPolyNode != null) {
			VariableDegreeNode tempVariableNode = tempPolyNode.variableDegreeNode;
			String term = tempPolyNode.cofficient + "";
			while (tempVariableNode != null) {
				term += tempVariableNode.variable + "^"
						+ tempVariableNode.degree;
				tempVariableNode = tempVariableNode.nextVariableDegreeNode;
			}
			System.out.println(term);
			tempPolyNode = tempPolyNode.nextPolyLinkedList;
		}
	}

	// public static void main(String[] args) {
	//
	// //3x^2y^2 + 2xz +4y^2=0
	// MultivariatePolynomial multivariatePolynomial = new
	// MultivariatePolynomial();
	// VariableDegreeNode headNodeVariable=null;
	// headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable,
	// 'x', 2);
	// headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable,
	// 'y', 3);
	// PolyLinkedListNode polyLinkedListNode = new PolyLinkedListNode(3,
	// headNodeVariable);
	// headNodeVariable=null;
	// headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable,
	// 'x', 1);
	// headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable,
	// 'z', 1);
	// polyLinkedListNode =
	// multivariatePolynomial.addPolyTerm(polyLinkedListNode, 2,
	// headNodeVariable);
	// headNodeVariable=null;
	// headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable,
	// 'y', 7);
	// polyLinkedListNode =
	// multivariatePolynomial.addPolyTerm(polyLinkedListNode, 4,
	// headNodeVariable);
	// //multivariatePolynomial.displayPoly(polyLinkedListNode);
	// System.out.println(multivariatePolynomial.findDegree(polyLinkedListNode));
	// }
}
