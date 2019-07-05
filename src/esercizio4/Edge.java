package esercizio4;

public class Edge {
	private Node source;
    private Node destination;
    private Float weight;
    /**
     * constructor
     * @param source
     * @param destination
     * @param weight
     */
    public Edge(Node source, Node destination, Float weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }
    /**
     * return the weight
     * @return
     */
    public Float getWeight() {
        return weight;
    }
    /**
     * return the source
     * @return
     */
    public Node getSource() {
        return source;
    }
    /**
     * return the destination
     * @return
     */
    public Node getDestination() {
        return destination;
    }

    @Override
    public boolean equals(Object o) {
    	
        if (o == null || getClass() != o.getClass() || this == null) return false;

        Edge edge = (Edge) o;

        if (!weight.equals(edge.weight)) return false;
        if (!source.equals(edge.source)) return false;
        if (!destination.equals(edge.destination)) return false;
        return true;

    }

    @Override
    public String toString() {
        return "(" + source + " > " + destination + ", " + weight + ")";
    }

}
