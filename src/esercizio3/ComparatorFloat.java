package esercizio3;
import java.util.Comparator;

public class ComparatorFloat implements Comparator<Float>{

	public int compare(Float a, Float b){
		if(a > b) return 1;
		if(a < b) return -1;
		return 0;
	}
}