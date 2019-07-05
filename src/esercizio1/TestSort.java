package esercizio1;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.assertEquals;

public class TestSort {
	ComparatorLong comp = new ComparatorLong();
	Sorter<Long> sorter = new Sort<Long>(comp);

	Sort<Long> array1 = new Sort<Long>(comp);
	Sort<Long> array2 = new Sort<Long>(comp);

	Sort<Long> arrayNull = null;

	Sort<Long> empty1 = new Sort<Long>(comp);
	Sort<Long> empty2 = new Sort<Long>(comp);

	Sort<Long> equal1 = new Sort<Long>(comp);
	Sort<Long> equal2 = new Sort<Long>(comp);
	/**
	 * init method
	 */
	@Before
	public void init(){

		long a = 1, b = 2, c = 3, d = 4, e = 5, f = 6;

		array1.add(a);
		array1.add(b);
		array1.add(c);
		array1.add(d);
		array1.add(e);
		array1.add(f);

		array2.add(c);
		array2.add(b);
		array2.add(a);
		array2.add(f);
		array2.add(d);
		array2.add(e);

		equal1.add(a);
		equal1.add(a);
		equal1.add(a);

		equal2.add(a);
		equal2.add(a);
		equal2.add(a);
	}
	/**
     * Test of Insertion Sort, for Long type.
     */
	@Test
	public void testInsertionSortLong(){
		sorter.insertionSort(array2);
		assertEquals(array2.equals(array1), true);
	}
	/**
     * Test of Insertion Sort, for Long type in case of null.
     */
	@Test
	public void testInsertionSortLongNull(){
		sorter.insertionSort(arrayNull);
		assertEquals(arrayNull, null);
	}
	/**
     * Test of Insertion Sort, for Long type in case of empty.
     */
	@Test
	public void testInsertionSortLongEmpty(){
		sorter.insertionSort(empty1);
		assertEquals(empty1.equals(empty2), true);
	}
	/**
     * Test of Insertion Sort, for Long type in case is equal.
     */
	@Test
	public void testInsertionSortLongEqual(){
		sorter.insertionSort(equal2);
		assertEquals(equal1.equals(equal2), true);
	}
	/**
     * Test of Merge Sort, for Long type.
     */
	@Test
	public void testMergeSortLong(){
		sorter.mergeSort(array2);
		assertEquals(array2.equals(array1), true);
	}
	/**
     * Test of Merge Sort, for Long type in case is null.
     */
	@Test
	public void testMergeSortLongNull(){
		sorter.mergeSort(arrayNull);
		assertEquals(arrayNull, null);
	}
	/**
     * Test of Merge Sort, for Long type in case is empty.
     */
	@Test
	public void testMergeSortLongEmpty(){
		sorter.mergeSort(empty1);
		assertEquals(empty1.equals(empty2), true);
	}
	/**
     * Test of Merge Sort, for Long type in case is equal.
     */
	@Test
	public void testMergeSortLongEqual(){
		sorter.mergeSort(equal1);
		assertEquals(equal1.equals(equal2), true);
	}
	/**
     * Test of size.
     */
	@Test
	public void testSize(){
		assertEquals(6, array1.size());
		assertEquals(0, empty1.size());
		assertEquals(3, equal1.size());
	}
	/**
     * Test of get.
     */
	@Test
	public void testGet(){
		assertEquals(array1.get(1) == 2, true);
	}

	public static void main(String[] args) {
	     Result result = JUnitCore.runClasses(TestSort.class);

	     for (Failure failure : result.getFailures()) {
	        System.out.println(failure.toString());
	     }

	     System.out.println(result.wasSuccessful());
	 }
}