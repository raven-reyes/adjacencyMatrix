
public class AdjacencyMatrix {
int n ; // number of vertices 
// we give our adjacency matrix a rough size of 20 by 20.when we call the main method , the value of
// n(the number of vertices you want to create) will be passed in this place of [20][20] 
//and create the actual adjacency matrix of n * n
// you can choose a rough size of your choice
int adjMatrix[][] = new int[20][20];  
// constructor
public AdjacencyMatrix(int n) {
	this.n = n;
}
//adding an edge from i to j, adjMatrix[i][j] = 1  requires O(1) time. this is constant time
public void addEdge(int i, int j ) {
	if(i < 0 || i >= n) {
		System.out.println("vertex " + i + " does not exist in this graph");
	}  if(j < 0 || j >= n) {
		System.out.println("vertex " + j + " does not exist in this graph");
	} else {
//in an adjacency matrix of an undirected graph,if an edge exist between vertices i and j of the graph, 
//then adjMatrix[i][j] = 1 and adjMatrix[j][i] = 1. If no edge exists between these two vertices, 
//then adjMatrix[i][j] = 0 and adjMatrix[j][i] = 0.
	adjMatrix[i][j]= 1;
	adjMatrix[j][i] = 1;
	}
}
//To remove an edge say from i to j, adjMatrix[i][j] = 0  requires O(1) time. this is constant time
public void deleteEdge(int i , int j) {
	if(i < 0 || i >= n) {
		System.out.println("vertex " + i + " does not exist");
	}
	if(j < 0 || j >= n) {
		System.out.println("vertex " + j + " does not exist");
	
	} else {
	// To remove an edge between two vertices suppose i and j,
	// set the corresponding values in the adjacency matrix equal to 0.
	// That is, set adjMatrix[i][j]=0 and adjMatrix[j][i]= 0 if both the vertices i and j exists.
	adjMatrix[i][j] = 0 ;
	adjMatrix[j][i] = 0 ;
	}
}
//to add a new vertex to VxV matrix the we need to increase 
//both the row and column of the existing adjacency matrix 
//storage will increase from (|V|^2) to (|V|+1)^2.
// the time complexity for this operation is O(V) because we are not doing any copying of elements
// we are just increasing the size of the existing matrix hence O(V)
public void addVertex(int x)
{
    n++; // increasing the number of vertices
 // initializing the new elements to .that is new vertex added is not connected to any other vertex) 
    for (int i = 0; i < n; ++i)
    {
        adjMatrix[i][n - 1] = 0;
        adjMatrix[n - 1][i] = 0;
    }
}
public void printGraph() {
 for(int i = 0; i < n ;i++) { 
	 for(int j = 0 ; j < n ; j++) {
		 System.out.print(adjMatrix[i][j]+ " ");
	 }
	 System.out.println();
 }
 //System.out.println();
 for(int i = 0 ; i < n ; i++) {
 System.out.println("vertex " + i + " is connected to ");
 for(int j =  0 ; j < n ; j++) {

	if( adjMatrix[i][j] > 0) {
		 System.out.println(j + " ");
	 }
	 }
 }
 }
	public static void main(String[] args) {
 AdjacencyMatrix graph = new AdjacencyMatrix(9); //this creates a matrix grid of of 9 by 9(9 * 9)
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(0, 3);
		graph.addEdge(0, 7);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 6);
		graph.addEdge(2, 2); // a loop(from a vertex to itself)
		graph.addEdge(2, 3);
		graph.addEdge(2, 4);
		graph.addEdge(2, 5);
		graph.addEdge(2, 6);
		graph.addEdge(2, 7);
		graph.addEdge(2, 8);
		graph.addEdge(3, 4);
		graph.addEdge(3, 7);
		graph.addEdge(3, 8);
		graph.addEdge(4, 5);
		graph.addEdge(4, 6);
		graph.addEdge(4, 7);
		graph.addEdge(4, 8);
		graph.addEdge(5, 6);
		graph.addEdge(5, 7);
		graph.addEdge(5, 8);
		graph.addEdge(6, 7);
		graph.printGraph(); // print graph
		graph.addVertex(9); // add new vertex 
		graph.addEdge(0, 9); // connect new vertex to existing vertices
		graph.addEdge(2, 9);
		graph.addEdge(4, 9);
		graph.addEdge(5, 9);
		graph.addEdge(6, 9);
		graph.addEdge(7, 9);
		graph.addVertex(10); // add new vertex 
		graph.addEdge(7, 10); // connect new vertex to existing vertices
		graph.addEdge(5, 10);
		graph.addEdge(8, 10);
		System.out.println("print graph after adding new vertices");
		graph.printGraph(); // print graph after adding new vertex
		System.out.println();
		graph.deleteEdge(1,3); // deleting an edge
		System.out.println("print graph after deleting an edge");
		graph.printGraph();    // print graph after deleting an edge
	}

}
