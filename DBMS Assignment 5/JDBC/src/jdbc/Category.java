package jdbc;

//Category class containg details such as category id, category name and count of child catgories
public class Category {
	private int id;
	private String name;
	private int childCategoryCount;
	
	public Category(int id, String name, int childCategoryCount) {
		this.id = id;
		this.name = name;
		this.childCategoryCount = childCategoryCount;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the childCategoryCount
	 */
	public int getChildCategoryCount() {
		return childCategoryCount;
	}
	/**
	 * @param childCategoryCount the childCategoryCount to set
	 */
	public void setChildCategoryCount(int childCategoryCount) {
		this.childCategoryCount = childCategoryCount;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name
				+ ", childCategoryCount=" + childCategoryCount + "]";
	}
	
	
}
