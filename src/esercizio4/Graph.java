package esercizio4;

import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Graph {

	private Map<Node, ArrayList<Edge>> graph;
	private int type;
	private Float weight;
	/**
     * contructor
     * @param type
     */
	public Graph(int type){
		this.graph = new HashMap<>();
		this.type = type;
		this.weight = 0.0f;
	}
	/**
     * get Vertices Map
     * @return
     */
	public Map<Node, ArrayList<Edge>> getNodes(){
		return graph;
	}
	/**
	 * return if graph is empty
	 * @return
	 */
	public boolean empty(){
		if(this != null && graph.keySet().size() > 0)
			return false;
		return true;
	}
	/**
     * get vertex by string
     * @param s
     * @return
     */
	public Node getNodeFromLabel(String label){
		Iterator<Node> it = graph.keySet().iterator();
		while(it.hasNext()){
			Node vertex = it.next();
			if(vertex.getLabel().equals(label)) return vertex;
		}
		return null;
	}
	/**
     * get type
     * @return
     */
	public int getType(){
		return this.type;
	}
	/**
     * get total weight
     * @return
     */
	public Float getWeight(){
		return this.weight;
	}
	/**
     * know if it contains String
     * @param s
     * @return
     */
	public boolean containsLabel(String label){
		Iterator<Node> it = graph.keySet().iterator();
		while(it.hasNext()){
			Node vertex = it.next();
			if(vertex.getLabel().equals(label)) return true;
		}
		return false;
	}
	/**
     * know if it exists edge
     * @param edge
     * @param v
     * @return
     */
	public boolean containsEdge(Edge edge, Node v){
		ArrayList<Edge> adA = new ArrayList<>();
		if(graph.containsKey(v)){
			adA = graph.get(v);
			int i = 0;
			while(i < adA.size()){
				Edge e = adA.get(i);
				if(e.getDestination().getLabel().equals(edge.getDestination().getLabel()))
					return true;
				i++;
			}
		}
		return false;
	}

	public void insert(String s1, String s2, Float weight){
		Node v, u;
		if(this.containsLabel(s1)){
			v = this.getNodeFromLabel(s1);
		} else {
			v = new Node(s1);
		}

		if(this.containsLabel(s2)){
			u = this.getNodeFromLabel(s2);
		} else {
			u = new Node(s2);
		}

		Edge edge = new Edge(v, u, weight);
		if(!this.containsEdge(edge, v))
			this.insert(edge);
	}
	/**
	 * add in map by edge
	 * @param edge
	 */
	public void insert(Edge edge){
		ArrayList<Edge> edge1 = new ArrayList<>();
		ArrayList<Edge> edge2 = new ArrayList<>();
		
		Node v = edge.getSource();
		Node u = edge.getDestination();
		if(graph.containsKey(v)){
			edge1 = graph.get(v);
		}

		edge1.add(edge);
		graph.put(v, edge1);

		if(!graph.containsKey(u)){
			graph.put(u, edge2);
		}

		if(type == 0) {
			this.insertReverse(new Edge(u, v, edge.getWeight()));
		}

		this.weight += edge.getWeight();
	}
	/**
	 * add reverse edge in case of indirect graph
	 * @param edge
	 */
	private void insertReverse(Edge edge){
		ArrayList<Edge> ad = new ArrayList<>();
		Node v = edge.getSource();

		if(graph.containsKey(v)){
			ad = graph.get(v);
		}

		ad.add(edge);
		graph.put(v, ad);
	}
	/**
	 * get the numbers of edges
	 * @return
	 */
	public int getSizeOfEdges(){
		Iterator<Node> it = graph.keySet().iterator();
		int num = 0;
		while(it.hasNext()){
			Node v = it.next();
			num += graph.get(v).size();		
		}
		return num;
	}
	/**
	 * return if the keys entries of graph are equals of g key entries
	 * @param g
	 * @return
	 */
	public boolean equalsNodes(Graph g){
		if(g != null && this != null && this.graph.keySet().equals(g.getNodes().keySet()))
			return true;
		return false;
	}

	public Node getDifferentNode(Graph g){
    	Iterator<Node> it = graph.keySet().iterator();
    	while(it.hasNext()){
    		Node v = it.next();
    		if(!g.getNodes().containsKey(v))
    			return v;
    	}
    	return null;
    }

	@Override
    public String toString() {
    	String s;
    	if(type == 1) s = "Direct";
    	else s = "Indirect";
    	s += "Graph {\n\t";
    	Iterator<Node> it = graph.keySet().iterator();
    	while(it.hasNext()){
    		Node v = it.next();
    		s += v + " -> " + graph.get(v);
    		if(it.hasNext()) s += "\n   \t";
    	}
    	s += "\n   }";
    	return s;
    }
}
