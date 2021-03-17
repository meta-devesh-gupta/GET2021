package Graph;

public class GraphImpl implements Graph {
	private LinkedList<LinkedList<Edge>> edgeList;

	public GraphImpl(int totaVertex) {
		edgeList = new LinkedList<LinkedList<Edge>>();
		for (int index = 0; index < totaVertex; index++) {
			edgeList.add(new LinkedList<Edge>());
		}
	}

	/**
	 * This method will add edge in the undirected graph
	 * 
	 * @param source
	 *            It is the source vertex
	 * @param destination
	 *            It is the destination vertex
	 * @param weight
	 *            It is the weight of the edge
	 * @return true if edge is added in the graph else return false
	 */
	public boolean addEdge(int source, int destination, int weight) {
		if (source < 0 && source >= edgeList.getSize())
			return false;
		edgeList.get(source).add(new Edge(destination, weight));
		edgeList.get(destination).add(new Edge(source, weight));
		return true;
	}

	/**
	 * This method will check whether the graph is connected or not
	 * 
	 * @return true if graph is connected else return false
	 */
	@Override
	public boolean isConnectedGraph() {
		if (edgeList.getSize() == 0)
			return false;

		boolean[] visited = new boolean[edgeList.getSize()];

		// starting from 0 source vertex
		DFS(0, visited);

		boolean isConnected = true;
		for (int index = 0; index < visited.length; index++) {
			if (visited[index] == false) {
				isConnected = false;
				break;
			}
		}
		return isConnected;
	}

	/**
	 * This method is for the Depth first search for the input vertex and after
	 * visiting the vertex set its value true in visited[]
	 * 
	 * @param sourceVertex
	 *            It is the source vertex
	 * @param visited
	 *            It is the array of vertex which are visited or not
	 */
	private void DFS(int sourceVertex, boolean[] visited) {

		// marking the vertex visited
		visited[sourceVertex] = true;

		// traversing through neighbor nodes
		for (int index = 0; index < edgeList.get(sourceVertex).getSize(); index++) {
			int neighborVertex = edgeList.get(sourceVertex).get(index)
					.getDestinationVertex();

			if (visited[neighborVertex] == false) {
				// make recursive call from neighbor node
				DFS(neighborVertex, visited);
			}
		}
	}

	/**
	 * This method will return the list of all the vertex which are reachable
	 * from the input node
	 * 
	 * @param sourceVertex
	 *            It is the input source vertex
	 * @return list of all the vertex which are reachable from the input source
	 *         vertex
	 */
	@Override
	public LinkedList<Integer> reachable(int sourceVertex) {

		if (sourceVertex < 0 || sourceVertex >= edgeList.getSize())
			throw new AssertionError("Invalid Source Vertex");

		LinkedList<Integer> reachableNodeList = new LinkedList<Integer>();
		boolean[] visited = new boolean[edgeList.getSize()];

		// starting from source vertex
		DFS(sourceVertex, visited);

		for (int index = 0; index < visited.length; index++) {
			if (visited[index])
				reachableNodeList.add(index);
		}
		return reachableNodeList;
	}

	/**
	 * This method will return the minimum weight vertex
	 * 
	 * @param weights
	 *            It is the input vertex weight array
	 * @param visited
	 *            It shows whether vertex is visited or not
	 * @return minimum weight vertex
	 */
	private int findMinimumVertex(int weights[], boolean visited[]) {
		int minVertex = -1;
		for (int vertex = 0; vertex < edgeList.getSize(); vertex++) {
			if (visited[vertex] == false
					&& (minVertex == -1 || weights[vertex] < weights[minVertex]))
				minVertex = vertex;
		}
		return minVertex;
	}

	/**
	 * This method will find and display the minimum spanning tree
	 */
	@Override
	public void primsMST() {
		int parent[] = new int[edgeList.getSize()];

		int weights[] = new int[edgeList.getSize()];

		boolean visited[] = new boolean[edgeList.getSize()];

		for (int vertex = 0; vertex < edgeList.getSize(); vertex++) {
			weights[vertex] = Integer.MAX_VALUE;
		}

		parent[0] = -1;
		weights[0] = 0;

		for (int index = 0; index < edgeList.getSize(); index++) {
			int minimumVertex = findMinimumVertex(weights, visited);
			visited[minimumVertex] = true;

			// for each neighbor nodes of minimum vertex
			for (int counter = 0; counter < edgeList.get(minimumVertex)
					.getSize(); counter++) {
				int currentNeighborVertex = edgeList.get(minimumVertex)
						.get(counter).getDestinationVertex();
				int currentNeighborVertexWeight = edgeList.get(minimumVertex)
						.get(counter).getEdgeWeight();
				if (visited[currentNeighborVertex] == false) {
					if (currentNeighborVertexWeight < weights[currentNeighborVertex]) {
						weights[currentNeighborVertex] = currentNeighborVertexWeight;
						parent[currentNeighborVertex] = minimumVertex;
					}
				}
			}
		}
	}

	/**
	 * This method will return the minimum distance from source vertex to
	 * destination vertex
	 * 
	 * @param sourceVertex
	 *            It is the input source vertex
	 * @param destinationVertex
	 *            It is the input destination vertex
	 * @return minimum distance from source vertex to destination vertex
	 */
	@Override
	public LinkedList<Integer> dijkstra(int sourceVertex, int destinationVertex) {
		if (sourceVertex < 0 || sourceVertex >= edgeList.getSize())
			throw new AssertionError("Invalid Source Vertex");
		if (destinationVertex < 0 || destinationVertex >= edgeList.getSize()
				|| sourceVertex == destinationVertex)
			throw new AssertionError("Invalid destination Vertex");
		
		boolean visited[] = new boolean[edgeList.getSize()];
		int distance[] = new int[edgeList.getSize()];

		for (int vertex = 0; vertex < edgeList.getSize(); vertex++) {
			distance[vertex] = Integer.MAX_VALUE;
		}
		distance[sourceVertex] = 0;

		for (int index = 0; index < edgeList.getSize(); index++) {

			int minimumVertex = findMinimumVertex(distance, visited);
			visited[minimumVertex] = true;

			// for each neighbor nodes of minimum vertex
			for (int counter = 0; counter < edgeList.get(minimumVertex)
					.getSize(); counter++) {
				int currentNeighborVertex = edgeList.get(minimumVertex)
						.get(counter).getDestinationVertex();
				int currentNeighborVertexWeight = edgeList.get(minimumVertex)
						.get(counter).getEdgeWeight();

				if (visited[currentNeighborVertex] == false) {
					int newDistance = distance[minimumVertex]
							+ currentNeighborVertexWeight;
					if (newDistance < distance[currentNeighborVertex])
						distance[currentNeighborVertex] = newDistance;
				}

			}
		}

		return findPath(distance, sourceVertex, destinationVertex);
	}

	// This method will find the path from source to destination according to
	// distance array
	private LinkedList<Integer> findPath(int[] distance, int source,
			int destination) {
		LinkedList<Integer> path = new LinkedList<Integer>();
		path.add(destination);

		int currentNode = destination;

		// Loop until we find source node
		while (currentNode != source) {
			LinkedList<Edge> edges = edgeList.get(currentNode);

			// iterating over all the neighbor nodes of the current node
			for (int index = 0; index < edges.getSize(); index++) {
				if ((distance[currentNode] - edges.get(index).getEdgeWeight()) == distance[edges
						.get(index).getDestinationVertex()]) {
					path.add(edges.get(index).getDestinationVertex());
					break;
				}
			}
			// setting the current node to the next node
			currentNode = path.get(path.getSize() - 1);
		}
		return path;
	}

	/**
	 * @return the edgeList
	 */
	public LinkedList<LinkedList<Edge>> getEdgeList() {
		return edgeList;
	}

	/**
	 * @param edgeList
	 *            the edgeList to set
	 */
	public void setEdgeList(LinkedList<LinkedList<Edge>> edgeList) {
		this.edgeList = edgeList;
	}

}
