import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Neighbor {
	int vertexNum;
	//Neighbor next;
	
	//constructor
	public Neighbor(int vn) {
		vertexNum = vn;
	}
	
	public int getIndex() {
		return vertexNum;
	}
}

class Vertex {
	String name = "";
	public ArrayList<Neighbor> nbrList = new ArrayList<Neighbor>();
	
	public Vertex(String n) {
		name = n;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public void addNeighbor(int n) {
		nbrList.add(new Neighbor(n));
	}
	
	public String toString() {
		return "Name: " + name + "-->" + nbrList.toString();
	}
}

public class Graph1 {

	private Vertex[] arrV; //Name of people
	
	//constructor
	public Graph1(String file) throws FileNotFoundException {
		Scanner fileReader = new Scanner(new File(file));
		//read first number indicating size of the array
		arrV = new Vertex[fileReader.nextInt()]; //Created vertex of the size in the first line of file
		
		while(fileReader.hasNext()) {
			//read through first n(10) into vertex array
			//arrV[i].<--new Vertex(??), do it for loop arrV.length
			for(int i = 0; i < arrV.length; i++) {
				arrV[i] = new Vertex(fileReader.next());
				//arrV[i].getName();
			}
			
			//read through the pairs
			while(fileReader.hasNext()) {
				//find correct vertex to add neighbor to
				String vertexFirst = fileReader.next();
				String vertexSecond = fileReader.next();
				
				for(Vertex e : arrV) {
					if (e.getName().equals(vertexFirst)) {
						//add second value to first neighbor
						e.addNeighbor(getIndex(vertexSecond));
					}
					
					if (e.getName().equals(vertexSecond)) {
						//add first value to second neighbor
						e.addNeighbor(getIndex(vertexFirst));
					}
				}
			}
		}
		
		fileReader.close();
		
	}
	
	//provide a method to look up index from string (getIndex)
	public int getIndex(String name) {
		for(int i = 0; i < arrV.length; i++) {
			if (arrV[i].getName().equals(name)) {
				return i;
			}
		}
		
		return -1;
	}
	
	
	//provide a method to print out the friend list (getFriends)
	public void getFriends(int index) {
		System.out.print(arrV[index].getName());
		
		for (int i = 0; i < arrV[index].nbrList.size(); i++) {
			System.out.print("--> " + arrV[arrV[index].nbrList.get(i).vertexNum].name);
			//System.out.println(arrV[index].nbrList.get(i).vertexNum);
		}
		
		System.out.println();
	}
	
	public void print() {
		for(int i = 0; i < arrV.length; i++) {
			getFriends(i);
		}
	}
	
	public static void main(String[] args) {
		Scanner kbReader = new Scanner(System.in);
		System.out.print("Enter graph input file name: ");
		String file = kbReader.nextLine();
		
		//create graph based on the file name
		try {
			Graph1 graph = new Graph1(file);
			
			graph.print();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//graph.print();
		
		kbReader.close();
	}

}
