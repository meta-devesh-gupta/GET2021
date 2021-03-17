package Graph;

public interface Graph {

	boolean isConnectedGraph();

	LinkedList<Integer> reachable(int sourceVertex);
	
	void primsMST();
	
	LinkedList<Integer> dijkstra(int sourceVertex, int destinationVertex);
}
