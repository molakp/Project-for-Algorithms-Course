package esercizio4;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.assertEquals;

public class TestGraph {
	Graph indirect = new Graph(0);
	Graph direct = new Graph(1);

	@Before
	public void init(){
		Node t = new Node("Torino");
		Node b = new Node("Bologna");
		Node r = new Node("Roma");
		Node m = new Node("Milano");
		Node n = new Node("Napoli");

		Edge e1 = new Edge(t, m, 5.0f);
		Edge e2 = new Edge(r, t, 20.0f);
		Edge e3 = new Edge(b, r, 5.0f);
		Edge e4 = new Edge(r, m, 15.0f);
		Edge e5 = new Edge(t, n, 25.0f);
		Edge e6 = new Edge(n, r, 5.0f);

		indirect.insert(e1);
		indirect.insert(e2);
		indirect.insert(e3);
		indirect.insert(e4);
		indirect.insert(e5);
		indirect.insert(e6);

		direct.insert(e1);
		direct.insert(e2);
		direct.insert(e3);
		direct.insert(e4);
		direct.insert(e5);
		direct.insert(e6);
	}
	/**
     * Test of adding an edge in directed graph.
     */
	@Test
	public void testInsertDirect(){
		Node x = new Node("Lecce");
		Node y = new Node("Bari");
		direct.insert(new Edge(x, y, 5.0f));
		assertEquals(direct.getNodes().containsKey(x), true);
		assertEquals(direct.getSizeOfEdges() == 7, true);
	}
	/**
	 * Test of adding an edge in indirected graph
	 */
	@Test
	public void testInsertIndirect(){
		Node x = new Node("Lecce");
		Node y = new Node("Bari");
		indirect.insert(new Edge(x, y, 9.0f));
		assertEquals(indirect.getNodes().containsKey(x), true);
		assertEquals(indirect.getNodes().containsKey(y), true);
		assertEquals(indirect.getSizeOfEdges() == 14, true);
	}
	/**
	 * Test of adding an edge by two string in directed graph
	 */
	@Test
	public void testInsertDirectFromLabels(){
		direct.insert("Perugia", "Ancona", 10.0f);
		assertEquals(direct.containsLabel("Perugia"), true);
		assertEquals(direct.getSizeOfEdges() == 7, true);
	}
	/**
	 * Test of adding an edge by two string in indirected graph
	 */
	@Test
	public void testInsertIndirectFromLabels(){
		indirect.insert("Palermo", "Catania", 5.0f);
		assertEquals(indirect.containsLabel("Palermo"), true);
		assertEquals(indirect.getSizeOfEdges() == 14, true);
	}
	/**
	 * Test of getTotalWeight method
	 */
	@Test
	public void testGetTotalWeight(){
		assertEquals(direct.getWeight() == 75.0f, true);
		assertEquals(indirect.getWeight() == 75.0f, true);
	}
	/**
	 * Test of getNumTotalEdge method
	 */
	@Test
	public void testGetTotalEdge(){
		assertEquals(direct.getSizeOfEdges() == 6, true);
		assertEquals(indirect.getSizeOfEdges() == 12, true);
	}
	/**
	 * Test of adding an existent edge
	 */
	@Test
	public void testAddSameEdge(){
		indirect.insert("Torino", "Milano", 5.0f);
		assertEquals(indirect.getSizeOfEdges() == 14, false);
		direct.insert("Torino", "Milano", 5.0f);
		assertEquals(direct.getSizeOfEdges() == 7, false);
	}
	
	public static void main(String[] args) {
	     Result result = JUnitCore.runClasses(TestGraph.class);

	     for (Failure failure : result.getFailures()) {
	        System.out.println(failure.toString());
	     }

	     System.out.println(result.wasSuccessful());
	 }
}
