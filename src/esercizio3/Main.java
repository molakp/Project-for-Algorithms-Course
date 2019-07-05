package esercizio3;

import java.util.Scanner;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {

		ComparatorDataString comp = new ComparatorDataString();
		Queue<Data<String>> queue = new MinHeap<Data<String>>(comp);

		Scanner scan = new Scanner(System.in);
		scan.useLocale(Locale.US);
		boolean end = false;
		int answer;
		String label = "";
		float priority = 0.0f;
		while(!end){		
	        try{
	        	System.out.print("\n1. Insert an element;\n2. Extract min;\n3. End;\n");
	        	answer = scan.nextInt();
	        	switch(answer){
		        	case 1:
		        		System.out.print("\nInsert a Label: ");
				        label = scan.next();
				        System.out.print("Insert Priority: ");
				        try{
				        	priority = scan.nextFloat();
					        Data<String> dataInsert = new Data<String>(label, priority);
					        queue.insert(dataInsert);
				        } catch(java.util.InputMismatchException e) {
				        	System.out.print("\nOnly Float type accepted\n");
				        	scan.next();
				        }
				    break;
		        	case 2:
		        		Data<String> dataRemoved = queue.extractMin();
		        		if(dataRemoved != null)
		        			System.out.print("\n" + dataRemoved + " removed from queue\n");
		        	break;
		        	case 3:
		        		end = true;
		        	break;
		        	default:
		        		System.out.println("Please insert only 1, 2 or 3");
		        		end = true;
	        	}
	        } catch(java.util.InputMismatchException e){
	        	System.out.print("\nOnly Integer accepted\n");
	        	end = true;
	        }
	        
		}

		scan.close();

		System.out.println("\nQueue created: " + queue);
	}

}
