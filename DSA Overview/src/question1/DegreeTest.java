package question1;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import question1.MultivariatePolynomial.PolyLinkedListNode;
import question1.MultivariatePolynomial.VariableDegreeNode;

public class DegreeTest {
	MultivariatePolynomial multivariatePolynomial;
	
	@Before
	public void init(){
		multivariatePolynomial = new MultivariatePolynomial();
	}

	@Test
	public void firstCase() {
		//3x^2y^3 + 2xz +4y^2=0
		
		VariableDegreeNode headNodeVariable=null;
		headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable, 'x', 2);
		headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable, 'y', 3);
		PolyLinkedListNode polyLinkedListNode = new PolyLinkedListNode(3, headNodeVariable);
		headNodeVariable=null;
		headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable, 'x', 1);
		headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable, 'z', 1);
		polyLinkedListNode = multivariatePolynomial.addPolyTerm(polyLinkedListNode, 2, headNodeVariable);
		headNodeVariable=null;
		headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable, 'y', 3);
		polyLinkedListNode = multivariatePolynomial.addPolyTerm(polyLinkedListNode, 4, headNodeVariable);
		
		assertEquals(5,multivariatePolynomial.findDegree(polyLinkedListNode));
	}

	@Test
	public void secondCase() {
		//3x^2y^3 + 2xz +4y^7=0
		
		VariableDegreeNode headNodeVariable=null;
		headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable, 'x', 2);
		headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable, 'y', 3);
		PolyLinkedListNode polyLinkedListNode = new PolyLinkedListNode(3, headNodeVariable);
		headNodeVariable=null;
		headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable, 'x', 1);
		headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable, 'z', 1);
		polyLinkedListNode = multivariatePolynomial.addPolyTerm(polyLinkedListNode, 2, headNodeVariable);
		headNodeVariable=null;
		headNodeVariable=multivariatePolynomial.addVariable(headNodeVariable, 'y', 7);
		polyLinkedListNode = multivariatePolynomial.addPolyTerm(polyLinkedListNode, 4, headNodeVariable);
		
		assertEquals(7,multivariatePolynomial.findDegree(polyLinkedListNode));
	}
	
	@Test
	public void thirdCase() {
		//4=0 only constant
		
		VariableDegreeNode headNodeVariable=null;
		PolyLinkedListNode polyLinkedListNode = new PolyLinkedListNode(4, headNodeVariable);
		
		assertEquals(0,multivariatePolynomial.findDegree(polyLinkedListNode));
	}


}
