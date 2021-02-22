package question2;

public final class Poly {
	private final int polyCofficients[];
	
	/**
	 * Initializing polyCOfficients
	 * @param degree of the polynomials
	 * @param polyCofficients
	 */
	public Poly(int degree, int[] polyCofficients) {
		this.polyCofficients = new int[degree];
		for(int i=0;i<polyCofficients.length;i++)
			this.polyCofficients[i]=polyCofficients[i];
	}

	/**
	 * Evaluating the polynomial for given variable
	 * @param x is given variable
	 * @return the value of the polynomial for the given value of the variable
	 */
	public float evaluate(float x){
		float result=0.0f;
		for(int i=0;i<polyCofficients.length;i++){
			float currValue = polyCofficients[i];
			for(int j=0;j<i;j++)
				currValue*=x;
			result+=currValue;
		}
		return result;
	}
	
	/**
	 * @return the degree of the polynomial
	 */
	public int degree(){
		return (polyCofficients.length-1);
	}
	
	/**
	 * Adding 2 polynomial
	 * @param p1 is first polynomial
	 * @param p2 is second polynomial
	 * @return the sum of p1 and p2
	 */
	public static Poly addPoly(Poly p1, Poly p2){
		int p1Len = p1.degree();
		int p2Len = p2.degree();
		System.out.println("p1Len "+p1Len);
		System.out.println("p2Len "+p2Len);
		int sum[] = new int[p1Len>p2Len?p1Len+1:p2Len+1];
		System.out.println(sum.length);
		for(int i=0;i<=p1Len;i++)
			sum[i]=p1.polyCofficients[i];
		for(int i=0;i<=p2Len;i++)
			sum[i]+=p2.polyCofficients[i];
		return new Poly(sum.length, sum);
	}
	
	/**
	 * @param p1 is first polynomial
	 * @param p2 is second polynomial
	 * @return the product of polynomials p1 and p2
	 */
	public static Poly multiplyPoly(Poly p1, Poly p2){
		int mul[] = new int[p1.degree()+p2.degree()+1];
		for(int i=0;i<=p1.degree();i++){
			for(int j=0;j<=p2.degree();j++){
				mul[i+j]=mul[i+j]+p1.polyCofficients[i]*p2.polyCofficients[j];
			}
		}
		return new Poly(mul.length, mul);
	}

	public String toString(){
		String result="";
		for(int i=0;i<=this.degree();i++)
			result+=this.polyCofficients[i]+" ";
		return result;
	}
	
	public static void main(String[] args) {
		int poly[] = {1,2,3};
		int poly2[] = {1,2,3,4};
		Poly p1 = new Poly(poly.length, poly);
		Poly p2 = new Poly(poly2.length, poly2);
		System.out.println(p1);
		System.out.println(p1.degree());
		System.out.println(p2);
		System.out.println(p2.degree());
		Poly add = addPoly(p1, p2);
		System.out.println(add);
		Poly mul = multiplyPoly(p1, p2);
		System.out.println(mul);
	}

}
