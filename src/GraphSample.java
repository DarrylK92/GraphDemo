import java.util.LinkedList;
import java.util.List;

class Graph {
	class Edge {
		private int v;
		private int w;
		
		//constructor
		Edge(int v1, int w1) {
			v = v1;
			w = w1;
		}
		
		public String toString() {
			return "[ " + v + ", " + w + " ]";
		}
	}
	
	private List<Edge>[] listEdge;
	
	public Graph(int n) {
		listEdge = new LinkedList[n];
		for(int i = 0; i < n; i++) {
			listEdge[i] = new LinkedList<Edge>();
		}
	}
	
	public void addEdge(int u, int v, int w) {
		listEdge[u].add(0, new Edge(v, w));
	}
	
	//look for if v and u are connected
	public boolean isConected(int u, int v) {
		for(Edge e : listEdge[u]) { //for each value in the uth linkedList in listEdge
			if (e.v == v) {
				return true;
			}
		}
		return false;
	}
	
	//toString
	public String toString() {
		String s = "\n{\n";
		for(List<Edge> e : listEdge) {
			s += e.toString() + "\n";
		}
		s += "}";
		
		return s;
	}
}

public class GraphSample {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<Integer>();
		list.add(10);
		list.add(30);
		list.add(60);
		list.add(0, 88);
		
//		for(Integer e: list) {
//			System.out.print(e + " ");
//		}
		
		//Create array of linked list
		List<Integer> [] arr = new LinkedList[10];
		
		//Go through each element in array and assign a new LinkedList of Integers
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new LinkedList<Integer>();
		}
		
		arr[0].add(10);
		arr[0].add(39);
		arr[0].add(23);
		
		for(List<Integer> e: arr) {
			System.out.print(e + " ");
		}
		
		//graph
		Graph graph = new Graph(10);
		graph.addEdge(0,  2,  10);
		graph.addEdge(0,  5,  15);
		graph.addEdge(2,  5,  10);
		graph.addEdge(9,  3,  16);
		System.out.println(graph);
		System.out.println(graph.isConected(9,  16));
	}

}
