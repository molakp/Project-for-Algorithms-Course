package esercizio4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import esercizio3.MinHeap;

public class Main {

	public static void caricaGrafo(String path, Graph grafo){
	    BufferedReader br = null;
	    try {
	    	br = new BufferedReader(new FileReader(path));
	    	String line = null;
	    	System.out.println("Loading data from " + path);
	    	while ((line = br.readLine()) != null) {
	    		String[] lineElements = line.split(",");

	    		grafo.insert(lineElements[0], lineElements[1], Float.parseFloat(lineElements[2]));
	    	}
	  		System.out.println("End\n");
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    	System.exit(0);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    } finally {
	          if (br != null) {
	                try {
	                      br.close();
	                } catch (IOException e) {
	                      e.printStackTrace();
	                }
	          }
	    }
	}
	
	public static Graph algoPrim(Graph graphBase, Graph graphPrim, Node v){
		ComparatorEdge edgeComp = new ComparatorEdge();
		MinHeap<Edge> queue = new MinHeap<Edge>(edgeComp);
		if(graphBase != null && !graphBase.empty()){	
			for(Edge e : graphBase.getNodes().get(v)) queue.insert(e);		
			while(!queue.empty()){
				Edge edgeMin = queue.extractMin();
				Node destination = edgeMin.getDestination();
				if(!graphPrim.getNodes().containsKey(destination)){
					graphPrim.insert(edgeMin);
					for(Edge e : graphBase.getNodes().get(edgeMin.getDestination())) queue.insert(e);
				}

			}
		}

		return graphPrim;
	}

	public static void main(String[] args) {
		if(args.length < 1){
			System.out.println("Please insert in args[0] the path's file of italian_dist_graph.csv");
	        System.exit(0);
	    }

		Graph graph = new Graph(0); 
		caricaGrafo(args[0], graph);
		System.out.println("Graph without Prim algorithm:");
		System.out.println("Nodes: " + graph.getNodes().size() + "; Edges: " + graph.getSizeOfEdges() + "; Total Weight: " + graph.getWeight());

		Graph graphPrim = new Graph(0);

		while(!graphPrim.equalsNodes(graph)){
			Node node = graph.getDifferentNode(graphPrim);
			graphPrim = algoPrim(graph, graphPrim, node);
		}

		System.out.println("\nGraph with Prim algotithm");
		System.out.println("Nodes: " + graphPrim.getNodes().size() + "; Edges: " + graphPrim.getSizeOfEdges() + "; Total Weight: " + graphPrim.getWeight());
	}
}
