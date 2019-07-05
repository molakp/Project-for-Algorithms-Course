package esercizio1;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class Main {

	public static void load(String path, Sort<Long> array){
	    BufferedReader br = null;
	    try {
	    	br = new BufferedReader(new FileReader(path));
	    	String line = null;
	    	long x;
	    	System.out.println("\nLoading data from " + path);
	  		while((line = br.readLine()) != null){
	  		    x = Long.parseLong(line);
	  		    array.add(x);
	  		}
	  		System.out.println("End");
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
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

	public static boolean findSum(Sort<Long> array, long sum){
    	int left = 0;
        int right = array.size() - 1;
        while(left < right){
           if((array.get(left) + array.get(right)) == sum) return true;
           if((array.get(left) + array.get(right)) >= sum) right--;
           if((array.get(left) + array.get(right)) < sum) left++;
        }
        return false;
	}

	public static void main(String[] args){
		if(args.length < 2){
	        System.out.println("Please insert in args[0] the path's file of integers, and in args[1] the path's file of sums numbers");
	        System.exit(0);
	    }
		ComparatorLong comp = new ComparatorLong();
        Sorter<Long> sorter = new Sort<Long>(comp);
		Sort<Long> elements = new Sort<Long>(comp);
		Sort<Long> sums = new Sort<Long>(comp);
		System.out.print("Choose the algorithm\n\n1: Insertion, 2: Merge\n");
		Scanner scan = new Scanner(System.in);
        int choise = scan.nextInt();
        scan.close();

        long startSim = System.currentTimeMillis();

		load(args[0], elements);
		load(args[1], sums);

		if(choise == 1){
			sorter.insertionSort(elements);
		} else if(choise == 2){
			sorter.mergeSort(elements);
		} else {
			System.out.println("Please insert only 1 or 2");
			System.exit(0);
		}

        for(int i = 0; i < sums.size(); i++){
        	if(findSum(elements, sums.get(i)))
               	System.out.println("\nSum " + sums.get(i) + " founded");
        	else System.out.println("\nNo sum " + sums.get(i) + " founded");
        }

        long endSim = System.currentTimeMillis();
        long timeEndSim = ((endSim - startSim) / 1000);
        System.out.println("\nTotal time " + timeEndSim + " sec");
	}

}
