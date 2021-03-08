package Stack;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class StackTest {
	OperandStack operandStack;
	OperatorStack operatorStack;
	InfixEvaluation infixEvaluation;

	@Before
	public void init() {
		operandStack = new OperandStack(4);
		operatorStack = new OperatorStack(4);
		infixEvaluation = new InfixEvaluation();
	}

	@Test(expected = AssertionError.class)
	public void stackPushTest() {

		assertTrue(operandStack.push(1));
		assertTrue(operandStack.push(2));
		assertTrue(operandStack.push(3));
		assertTrue(operandStack.push(4));

		assertTrue(operatorStack.push("+"));
		assertTrue(operatorStack.push("-"));
		assertTrue(operatorStack.push("*"));
		assertTrue(operatorStack.push("/"));

		// overflow condition
		assertTrue(operandStack.push(5));
		assertTrue(operatorStack.push("=="));

	}

	@Test(expected = AssertionError.class)
	public void stackPopTest() {

		assertEquals((Integer) 4, operandStack.pop());
		assertEquals((Integer) 3, operandStack.pop());
		assertEquals((Integer) 2, operandStack.pop());
		assertEquals((Integer) 1, operandStack.pop());

		assertEquals("/", operandStack.pop());
		assertEquals("*", operandStack.pop());
		assertEquals("-", operandStack.pop());
		assertEquals("+", operandStack.pop());

		// underflow condition
		assertEquals((Integer) 1, operandStack.pop());
		assertEquals("+", operandStack.pop());

	}

	@Test
	public void infixEvaluationTest() {

		assertEquals(-2,infixEvaluation.evaluateInfix(" 2 + ( 5 - 3 * 6 / 2 ) "));
		assertEquals(17,infixEvaluation.evaluateInfix("2 + 5 * 3"));
		assertEquals(1,infixEvaluation.evaluateInfix(" ( 22 + 4 ) == ( 23 + 3 ) "));
		assertEquals(0,infixEvaluation.evaluateInfix(" ( 100 > 99 ) == ( 1 != 1 ) "));
		assertEquals(-24,infixEvaluation.evaluateInfix(" ( 5 * 8 ) / 4 - -2 * ( 2 + 4 / 4 * ( 2 - 21 ) ) "));
	}

}
