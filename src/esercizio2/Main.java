

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void loadArray(String path, ArrayList<String> array) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			String line = null;
			System.out.println("\nLoading data from " + path);
			while ((line = br.readLine()) != null) {
				array.add(line.toLowerCase());
			}
			System.out.println("Data loaded");
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

	public static void loadPhrase(String path, ArrayList<String> phrase) {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			System.out.println("\nloadPhrase Loading data from " + path);
			System.out.println("End of data loading");
			String word = br.readLine();
			String[] tmp = word.split("\\, |\\. |\\: |\\.|\\s");
			for (String s : tmp)
				phrase.add(s);
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

	public static int findMin(ArrayList<Integer> array) {
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < array.size(); i++) {
			if (array.get(i) < min) {
				min = array.get(i);
			}
		}
		return min;
	}

	public static void main(String args[]) {
		// Ask for choise
		if (args.length < 2) {
			System.out.println(
					"Please insert in args[0] the path of the dictionary file , and in args[1] the  phrase file's path");
			System.exit(0);
		}
		System.out.print("Select the method:\n\n1: Recursive, 2: Dynamic\n");
		Scanner scan = new Scanner(System.in);
		int choise = scan.nextInt();
		scan.close();
		if (choise != 1 && choise != 2) {
			System.out.println("Please insert only 1 or 2");
			System.exit(1);
		}
		// choise done
		long startSim = System.currentTimeMillis(); // start time count
		ArrayList<String> dict = new ArrayList<String>();
		ArrayList<String> phrase = new ArrayList<String>();

		loadArray(args[0], dict);
		loadPhrase(args[1], phrase);
		int i, dist = Integer.MAX_VALUE;

		for (String s1 : phrase) //Per quante parole ci sono nella frase {

			
			System.out.print("\n" + "'" + s1 + "' found:");
			int min = Integer.MAX_VALUE;
			ArrayList<Integer> distance = new ArrayList<Integer>();
			long start = System.currentTimeMillis();
			for (int a = 0; a < dict.size(); a++) {
				String s2 = dict.get(a);
				EditDistance ed = new EditDistance(s1, s2);

				if (choise == 1) {
					dist = ed.edit_distance_rec(s1.toLowerCase(), s2.toLowerCase());
				} else {
					dist = ed.edit_distance_recdyn(0, 0);
				}
				distance.add(dist);
				if (dist < min)
					min = dist;
			}
			if (min > 0) {
				i = findMin(distance);
				System.out.println("\nWrong word!");
				System.out.print("Similar words with edit_distance " + min + ": ");
				for (int a = 0; a < distance.size(); a++) {
					if (distance.get(a) == i) {
						System.out.print("\"" + dict.get(a) + "\"; ");
					}
				}
				System.out.print("\nResearched in " + (System.currentTimeMillis() - start) + " ms\n");
			} else
				System.out.println("\nRight word");
				
		}
		long endSim = System.currentTimeMillis();
		long timeEndSim = ((endSim - startSim) / 1000);
		System.out.println("\n Total time: " + timeEndSim + " sec");
	}

