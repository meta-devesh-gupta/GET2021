package Graph;

public class Edge {
	private int destinationVertex;
	private int edgeWeight;

	public Edge(int destinationVertex, int edgeWeight) {
		this.destinationVertex = destinationVertex;
		this.edgeWeight = edgeWeight;
	}

	/**
	 * @return the destinationVertex
	 */
	public int getDestinationVertex() {
		return destinationVertex;
	}

	/**
	 * @param destinationVertex
	 *            the destinationVertex to set
	 */
	public void setDestinationVertex(int destinationVertex) {
		this.destinationVertex = destinationVertex;
	}

	/**
	 * @return the edgeWeight
	 */
	public int getEdgeWeight() {
		return edgeWeight;
	}

	/**
	 * @param edgeWeight
	 *            the edgeWeight to set
	 */
	public void setEdgeWeight(int edgeWeight) {
		this.edgeWeight = edgeWeight;
	}

	@Override
	public String toString() {
		return "Edge [destinationVertex=" + destinationVertex + ", edgeWeight="
				+ edgeWeight + "]";
	}

}
