package question2;

//Immutable Class Poly to make a polynomial performing basic methods
// evaluate, add and multiply.
public final class Poly {
	
	// an array to represent single variable polynomial
	private final int polynomialCofficients[];
	
	/**
	 * Initializing polynomialCofficients
	 * @param degree of the polynomials
	 * @param polynomialCofficients
	 */
	public Poly(int[] polynomialCofficients) {
		this.polynomialCofficients = new int[polynomialCofficients.length];
		for(int index=0;index<polynomialCofficients.length;index++)
			this.polynomialCofficients[index]=polynomialCofficients[index];
	}

	/**
	 * Evaluating the polynomial for given variable
	 * @param x is given variable
	 * @return the value of the polynomial for the given value of the variable x
	 */
	public float evaluate(float x){
		float result=0.0f;
		for(int index=0;index<polynomialCofficients.length;index++){
			float currentValue = polynomialCofficients[index];
			for(int counter=0;counter<index;counter++)
				currentValue*=x;
			result+=currentValue;
		}
		return result;
	}
	
	/**
	 * @return the degree of the polynomial
	 */
	public int degree(){
		return (polynomialCofficients.length-1);
	}
	
	/**
	 * Adding two polynomials
	 * @param secondPolynomial is the second polynomial
	 * @return the sum of this and secondPolynomial
	 */
	public Poly addPoly(Poly secondPolynomial){
		int lengthOfFirstPolynomial = this.degree();
		int lengthOfSecondPolynomial = secondPolynomial.degree();
		int lengthOfSum =0;

		if(lengthOfFirstPolynomial>lengthOfSecondPolynomial)
			lengthOfSum = lengthOfFirstPolynomial+1;
		else
			lengthOfSum=lengthOfSecondPolynomial+1;
		int sum[] = new int[ lengthOfSum];
		
		for(int index=0;index<=lengthOfFirstPolynomial;index++)
			sum[index]=this.polynomialCofficients[index];
		for(int index=0;index<=lengthOfSecondPolynomial;index++)
			sum[index]+=secondPolynomial.polynomialCofficients[index];
		
		Poly resultantPolynomial = new Poly(sum);
		return resultantPolynomial;
	}
	
	/**
	 * Multiplication of two polynomials
	 * @param secondPolynomial is the second polynomial
	 * @return the product of polynomials this and secondPolynomial
	 */
	public Poly multiplyPoly(Poly secondPolynomial){
		
		int product[] = new int[this.degree()+secondPolynomial.degree()+1];
		
		for(int indexOfThis=0;indexOfThis<=this.degree();indexOfThis++){
			for(int indexOfSecondPolynomial=0;indexOfSecondPolynomial<=secondPolynomial.degree();indexOfSecondPolynomial++){
				product[indexOfThis + indexOfSecondPolynomial]+=this.polynomialCofficients[indexOfThis]*secondPolynomial.polynomialCofficients[indexOfSecondPolynomial];
			}
		}
		
		Poly resultantMultiplication = new Poly(product);
		return resultantMultiplication;
	}

	/**
	 * To display the coefficients of the polynomial
	 */
	public String toString(){
		String result="";
		for(int index=this.degree();index>=0;index--){
			if(index==0)
				result+=this.polynomialCofficients[index];
			else
				result+=this.polynomialCofficients[index]+"x^"+index+" + ";
			
		}
		return result;
	}
	
	

}
