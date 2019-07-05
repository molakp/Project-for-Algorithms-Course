package esercizio4;

public class Node {
    private String label;
    /**
     * contructor
     * @param label
     */
    public Node(String label) {
        this.label = label;
    }
    /**
     * return label
     * @return
     */
    public String getLabel() {
        return label;
    }
    /**
     * Fit equals for our case
     */
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass() || this == null) return false;

        Node node = (Node) o;

        return label.equals(node.label);
    }

    @Override
    public String toString() {
        return "\"" + label + "\"";
    }
}