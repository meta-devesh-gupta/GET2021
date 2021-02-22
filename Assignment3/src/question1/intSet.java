package question1;

public final class intSet {
	//array to represent a set of integers in the range 1-1000
	private final int set[]=new int[1000];
	private int setLength=0;

	/**
	 * intSet Constructor
	 * @param arr to initailize the set
	 */
	public intSet(int arr[]) {
		for(int i=0;i<arr.length;i++){
			if(!isMember(arr[i]))
				set[setLength++]=arr[i];
		}
	}
	
	/**
	 * check whether x is member of set
	 * @param x value to check for
	 * @return boolean value if set[i]==x
	 */
	public boolean isMember(int x) {
		for(int i=0;i<setLength;i++){
			if(this.set[i]==x) return true;
		}
		return false;
	}
	
	/**
	 * @return size of the set
	 */
	public int size() {
		return setLength;
	}
	
	/**
	 * check whether s is subset of the set
	 * @param s 
	 * @return 
	 */
	public boolean isSubSet(intSet s) {
		boolean flag = false;
		for(int i=0;i<s.size();i++){
			for(int j=0;j<setLength;j++){
				if(s.set[i]==set[j]){
					flag=true;
					break;
				}
				else{
					flag=false;
				}
			}
			if(!flag) 
				return false;
		}
		return true;
	}
	
	/**
	 * @return  complement set, you can assume that 1..1000 is the universal set
	 */
	public intSet getComplement() {
		int len=1000-this.setLength;
		int complementArray[] = new int[len];
		for(int i=1, index=0;i<=1000;i++){
			if(!isMember(i))
				complementArray[index++]+=i;
		}
		return new intSet(complementArray);
	}
	
	/**
	 * @param s1 intSet one
	 * @param s2 intSet two
	 * @return the union intSet of s1 and s2
	 */
	public static intSet union(intSet s1, intSet s2) {
		int unionArray[] = new int[s1.size() + s2.size()];
		for(int i=0;i<s1.size();i++){
			unionArray[i]=s1.set[i];
		}
		for(int i=0,index=s1.size();i<s2.size();i++){
			if(!s1.isMember(s2.set[i]))
				unionArray[index++]=s2.set[i];
		}
		return new intSet(unionArray);
	}
	
	
	public String toString(){
		String result="";
		for(int i=0;i<this.size();i++)
			result+=this.set[i]+" ";
		return result;
	}
	
	public static void main(String[] args) {
		int odd[] = {1,3,5,7,9};
		int even[] = {2,4,6,8,10};
		intSet oddSet = new intSet(odd);
		intSet evenSet = new intSet(even);
		System.out.println("size: "+oddSet.size());
		System.out.println("isMemeber: "+ oddSet.isMember(6));
		intSet compSet = oddSet.getComplement();
		System.out.println(compSet);
		System.out.println(compSet.isSubSet(oddSet));
		intSet unionSet = union(evenSet, oddSet);
		System.out.println();
		for(int i=0;i<unionSet.size();i++)
			System.out.print(unionSet.set[i]+" ");
		
	}
	
}
