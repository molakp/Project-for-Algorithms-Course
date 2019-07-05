
public class EditDistance {

	public int[][] matrix;
	String s1;
	String s2;
	int noop;

	/**
	 * constructor
	 * 
	 * @param s1
	 * @param s2
	 */
	public EditDistance(String s1, String s2) {
		this.matrix = new int[s1.length() + 1][s2.length() + 1];
		this.s1 = s1.toLowerCase();
		this.s2 = s2.toLowerCase();
		noop = Integer.MAX_VALUE;

		for (int i = 0; i <= s1.length(); i++)
			for (int j = 0; j <= s2.length(); j++)
				matrix[i][j] = -1;
	}

	/**
	 * return str without the first char
	 * 
	 * @param str
	 * @return
	 */
	private String rest(String str) {
		String rest = "";
		for (int i = 1; i < str.length(); i++)
			rest += str.charAt(i);
		return rest;
	}

	/**
	 * return the distance of two strings (recursive method)
	 * 
	 * @param s1
	 * @param s2
	 * @return
	 */
	public int edit_distance_rec(String s1, String s2) {

		if (s1.length() == 0) {
			return s2.length();
		} else if (s2.length() == 0) {
			return s1.length();
		} else if (s1.charAt(0) == s2.charAt(0)) {
			return edit_distance_rec(rest(s1), rest(s2));
		} else
			return 1 + min(edit_distance_rec(s1, rest(s2)), edit_distance_rec(rest(s1), s2), noop);
	}

	/**
	 * return the distance of two strings (dynamic-recursive method)
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	public int edit_distance_recdyn(int i, int j) {

		if ((s1.length() - i) == 0)
			return s2.length() - j;
		if ((s2.length() - j) == 0)
			return s1.length() - i;
		if (s1.charAt(i) == s2.charAt(j))
			return edit_distance_recdyn(i + 1, j + 1);
		if (matrix[i][j] == -1)
			matrix[i][j] = min(1 + edit_distance_recdyn(i, j + 1), 1 + edit_distance_recdyn(i + 1, j), noop);

		return matrix[i][j];
	}

	/**
	 * return the min of three value
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	private int min(int a, int b, int c) {
		int min = a;
		if (a > b)
			min = b;
		if (b > c)
			min = c;
		return min;
	}
}
