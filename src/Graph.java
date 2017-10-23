import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
// DIrected Graph
public class Graph {
	private static HashMap<Integer, Node> nodeLookup = new HashMap<Integer, Node>();
	
	public static class Node{
		private int id;
		LinkedList<Node> adjecent  = new LinkedList<Node>();
		private Node(int id){
			this.id = id;
		}
	}
	
	private Node getNode(int id){
		if(nodeLookup.containsKey(id)){
			return nodeLookup.get(id);
		}
		return null;
	}
	private void setNode(Node node){
		nodeLookup.put(node.id, node);
	}
	public void addEdge(int source, int dest){
		Node s = getNode(source);
		Node d = getNode(dest);
		s.adjecent.add(d);
	}
	public boolean hasPathDFS(int source, int dest){
		Node s = getNode(source);
		Node d = getNode(dest);
		HashSet<Integer> visited = new HashSet<Integer>();
		return hasPathDFS(s, d, visited);
	}
	private boolean hasPathDFS(Node source, Node dest, HashSet<Integer> visited) {
		if(visited.contains(source.id)){
			return false;
		}
		visited.add(source.id);
		if(source == dest){
			return true;
		}
		for(Node child : source.adjecent){
			if(hasPathDFS(child, dest, visited)){
				return true;
			}
		}
		return false;
	}
	public boolean hasPathBFS(int source, int dest){
		return hasPathBFS(getNode(source), getNode(dest));
	}
	private boolean hasPathBFS(Node source, Node dest){
		LinkedList<Node> nextToVisit = new LinkedList<Node>();
		HashSet<Integer> visited = new HashSet<Integer>();
		nextToVisit.add(source);
		while(!nextToVisit.isEmpty()){
			Node node = nextToVisit.remove();
			if(node == dest){
				return true;
			}
			if(visited.contains(node.id)){
				continue;
			}
			visited.add(node.id);
			
			for(Node child : node.adjecent){
				nextToVisit.add(child);
			}		
		}
		return false;
	}
	
	public static void main(String[] args){
		Node a = new Node(1);
		Node b = new Node(2);
		Node c = new Node(3);
		Node d = new Node(4);
		Node e = new Node(5);
		Node f = new Node(6);
		
		Graph g = new Graph();
		g.setNode(a);
		g.setNode(b);
		g.addEdge(a.id, b.id);
		
		g.setNode(c);
		g.setNode(d);
		g.addEdge(d.id, c.id);
		g.addEdge(b.id, d.id);
		g.setNode(e);
		g.setNode(f);
		g.addEdge(e.id, f.id);
		
		System.out.println("is a to c has a path:" + g.hasPathBFS(a.id, c.id));
		System.out.println("is a to e has a path:" + g.hasPathDFS(a.id, e.id));
		
	}
}
