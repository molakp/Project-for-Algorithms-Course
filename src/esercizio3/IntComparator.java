package esercizio3;
import java.util.Comparator;

public class IntComparator implements Comparator<Integer>{

	public int compare(Integer a, Integer b){
		if(a > b) return 1;
		else if(a == b) return 0;
		else return -1;
	}
}