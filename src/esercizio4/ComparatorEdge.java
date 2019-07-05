package esercizio4;
import java.util.Comparator;

public class ComparatorEdge implements Comparator<Edge>{

	public int compare(Edge a, Edge b){
		if(a.getWeight() > b.getWeight()) return 1;
		if(a.getWeight() < b.getWeight()) return -1;
		return 0;
	}
}