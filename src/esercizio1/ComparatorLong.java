package esercizio1;
import java.util.Comparator;

public class ComparatorLong implements Comparator<Long>{

	public int compare(Long a, Long b){
		if(a > b) return 1;
		if(a < b) return -1;
		return 0;
	}
}