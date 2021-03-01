package question1;

public final class IntSet {
	
	//array to represent a set of integers in the range 1-1000
	private final int set[]=new int[1000];
	private int length=0;

	/**
	 * IntSet Constructor
	 * @param arr to initialize the set
	 */
	public IntSet(int set[], int length) {
		for(int index=0;index<length;index++){
			if(!this.isMember(set[index]))
				this.set[this.length++]=set[index];
		}
	}
	
	/**
	 * Check whether x is member of set
	 * @param x value to check for
	 * @return boolean value if set[index]==x
	 */
	public boolean isMember(int x) {
		boolean flag = false;
		for(int index=0;index<this.length;index++){
			if(this.set[index]==x){
				flag=true;
				break;
			}
		}
		return flag;
	}
	
	/**
	 * @return size of the set
	 */
	public int size() {
		return this.length;
	}
	
	/**
	 * Check whether s is subset of the set
	 * @param s 
	 * @return 
	 */
	public boolean isSubSet(IntSet subset) {
		boolean flag = true;
		
		for(int subsetIndex=0;subsetIndex<subset.size();subsetIndex++){
			for(int setIndex=0;setIndex<this.length;setIndex++){
				if(subset.set[subsetIndex]==this.set[setIndex]){
					flag=true;
					break;
				}
				else
					flag=false;
				
			}
			if(!flag) 
				break;
		}
		return flag;
	}
	
	/**
	 * @return  complement set, you can assume that 1..1000 is the universal set
	 */
	public IntSet getComplement() {
		int lengthOfComplementArray=1000-this.length;
		int complementArray[] = new int[lengthOfComplementArray];
		
		for(int counter=1, index=0;counter<=1000;counter++){
			if(!this.isMember(counter))
				complementArray[index++]+=counter;
		}
		
		return new IntSet(complementArray, lengthOfComplementArray);
	}
	
	/**
	 * @param firstSet is first IntSet
	 * @param secondSet is second IntSet
	 * @return the union intSet of firstSet and secondSet
	 */
	public IntSet union(IntSet secondSet) {
		IntSet firstSet = this;
		int unionArrayLength = firstSet.size() + secondSet.size();
		int unionArray[] = new int[unionArrayLength];
		for(int index=0;index<firstSet.size();index++){
			unionArray[index]=firstSet.set[index];
		}
		for(int counter=0,index=firstSet.size();counter<secondSet.size();counter++){
			if(!firstSet.isMember(secondSet.set[counter]))
				unionArray[index++]=secondSet.set[counter];
		}
		return new IntSet(unionArray, unionArrayLength);
	}
	
	
	
	public String toString(){
		String result="";
		for(int index=0;index<this.size();index++)
			result+=this.set[index]+" ";
		return result;
	}
	
}
