package esercizio3;
import java.util.Comparator;

public class ComparatorDataString implements Comparator<Data<String>>{

	public int compare(Data<String> a, Data<String> b){
		if(a.getPriority() > b.getPriority()) return 1;
		if(a.getPriority() < b.getPriority()) return -1;
		return 0;
	}
}