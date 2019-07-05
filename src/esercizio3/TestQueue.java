package esercizio3;

import org.junit.Test;
import org.junit.Before;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import static org.junit.Assert.assertEquals;

public class TestQueue {
	ComparatorDataString comp = new ComparatorDataString();
	Queue<Data<String>> queue = new MinHeap<Data<String>>(comp);

	@Before
	public void init(){
		Data<String> data1 = new Data<String>("a", 2.5f);
		Data<String> data2 = new Data<String>("b", 2.8f);
		Data<String> data3 = new Data<String>("c", 7.7f);
		Data<String> data4 = new Data<String>("d", 0.2f);
		queue.insert(data1);
		queue.insert(data2);
		queue.insert(data3);
		queue.insert(data4);
	}
	
	@Test
	public void testUpdatePriorityByOccurenceDecrease(){
		Data<String> data = new Data<String>("c", 0.1f);
		queue.updatePriorityFirstOccurrence(data);
		assertEquals(queue.getData(1).getPriority() == 0.1f, true);
	}
	
	@Test
	public void testUpdatePriorityByOccurenceIncrease(){
		Data<String> data = new Data<String>("d", 8.7f);
		queue.updatePriorityFirstOccurrence(data);
		assertEquals(queue.getData(1).getPriority() == 2.5f, true);
		assertEquals(queue.getData(queue.getSize()).getPriority() == 8.7f, true);
	}
	
	@Test
	public void testUpdatePriorityByPositionIncrease(){
		Data<String> data = new Data<String>("x", 2.7f);
		queue.updatePriority(1, data);
		assertEquals(queue.getData(1).getPriority() == 2.5f, true);
		assertEquals(queue.getData(2).getPriority() == 2.7f, true);
	}
	
	@Test
	public void testUpdatePriorityByPositionDecrease(){
		Data<String> data = new Data<String>("x", 0.1f);
		queue.updatePriority(4, data);
		assertEquals(queue.getData(1).getPriority() == 0.1f, true);
		assertEquals(queue.getData(4).getPriority() == 2.5f, true);
	}
	
	@Test
	public void testInsertInEmptyQueue(){
		Queue<Data<String>> queue = new MinHeap<Data<String>>(comp);
		Data<String> data = new Data<String>("x", 3.2f);
		queue.insert(data);

		assertEquals(queue.getData(1).getPriority() == 3.2f, true);
	}
	/**
     * Test of insertion .
     */
	@Test
	public void testInsertInQueue(){
		Data<String> data = new Data<String>("x", 5.6f);
		queue.insert(data);

		assertEquals(queue.getData(3).getPriority() == 7.7f, true);
		assertEquals(queue.getData(4).getPriority() == 2.8f, true);
		assertEquals(queue.getData(5).getPriority() == 5.6f, true);
	}
	/**
     * Test to remove the min element.
     */
	@Test
	public void testExtractMinFromQueue(){
		Data<String> data = queue.extractMin();

		assertEquals(queue.getData(1).getPriority() == data.getPriority(), true);
	}
	
	public static void main(String[] args) {
	     Result result = JUnitCore.runClasses(TestQueue.class);

	     for (Failure failure : result.getFailures()) {
	        System.out.println(failure.toString());
	     }

	     System.out.println(result.wasSuccessful());
	 }
}
