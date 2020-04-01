import static org.junit.Assert.*;

import java.util.*;

import org.junit.Test;

public class HeapTester {

	@Test
	public void testBuildHeapDifferentCostsOneChild() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(0)); cities.get(0).setMinCost(5);
		cities.add(new City(1)); cities.get(1).setMinCost(3);
		cities.add(new City(2)); cities.get(2).setMinCost(7);
		cities.add(new City(3)); cities.get(3).setMinCost(2);
		Heap h = new Heap();
		h.buildHeap(cities);
		ArrayList<City> test = h.toArrayList();
		assertEquals(3, test.get(0).getCityName());
		assertEquals(2, test.get(0).getMinCost());
		assertEquals(1, test.get(1).getCityName());
		assertEquals(3, test.get(1).getMinCost());
		assertEquals(2, test.get(2).getCityName());
		assertEquals(7, test.get(2).getMinCost());
		assertEquals(0, test.get(3).getCityName());
		assertEquals(5, test.get(3).getMinCost());
	}
	
	@Test
	public void testBuildHeapSameCosts() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(3)); cities.get(0).setMinCost(5);
		cities.add(new City(1)); cities.get(1).setMinCost(5);
		cities.add(new City(2)); cities.get(2).setMinCost(5);
		cities.add(new City(0)); cities.get(3).setMinCost(5);
		Heap h = new Heap();
		h.buildHeap(cities);
		ArrayList<City> test = h.toArrayList();
		assertEquals(0, test.get(0).getCityName());
		assertEquals(5, test.get(0).getMinCost());
		assertEquals(1, test.get(1).getCityName());
		assertEquals(5, test.get(1).getMinCost());
		assertEquals(2, test.get(2).getCityName());
		assertEquals(5, test.get(2).getMinCost());
		assertEquals(3, test.get(3).getCityName());
		assertEquals(5, test.get(3).getMinCost());
	}
	
	@Test
	public void testBuildHeapThreeWayTie() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(0)); cities.get(0).setMinCost(3);
		cities.add(new City(4)); cities.get(1).setMinCost(5);
		cities.add(new City(5)); cities.get(2).setMinCost(6);
		cities.add(new City(6)); cities.get(3).setMinCost(1);
		cities.add(new City(2)); cities.get(4).setMinCost(3);
		cities.add(new City(3)); cities.get(5).setMinCost(2);
		cities.add(new City(1)); cities.get(6).setMinCost(3);
		Heap h = new Heap();
		h.buildHeap(cities);
		ArrayList<City> test = h.toArrayList();
		assertEquals(6, test.get(0).getCityName());
		assertEquals(1, test.get(0).getMinCost());
		assertEquals(0, test.get(1).getCityName());
		assertEquals(3, test.get(1).getMinCost());
		assertEquals(3, test.get(2).getCityName());
		assertEquals(2, test.get(2).getMinCost());
		assertEquals(4, test.get(3).getCityName());
		assertEquals(5, test.get(3).getMinCost());
		assertEquals(2, test.get(4).getCityName());
		assertEquals(3, test.get(4).getMinCost());
		assertEquals(5, test.get(5).getCityName());
		assertEquals(6, test.get(5).getMinCost());
		assertEquals(1, test.get(6).getCityName());
		assertEquals(3, test.get(6).getMinCost());
		
	}
	@Test
	public void testinsert() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(0)); cities.get(0).setMinCost(3);
		cities.add(new City(4)); cities.get(1).setMinCost(5);
		cities.add(new City(5)); cities.get(2).setMinCost(6);
		cities.add(new City(6)); cities.get(3).setMinCost(1);
		cities.add(new City(2)); cities.get(4).setMinCost(3);
		cities.add(new City(3)); cities.get(5).setMinCost(2);
		cities.add(new City(1)); cities.get(6).setMinCost(3);
		Heap h = new Heap();
		h.buildHeap(cities);
		City c = new City(7);
		c.setMinCost(1);
		h.insertNode(c);
		int i = h.findMin().getMinCost();
		assertEquals(1, i);
		int j = h.findMin().getCityName();
		assertEquals(6, j);
	}
	
	@Test
	public void testinsert2() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(0)); cities.get(0).setMinCost(3);
		cities.add(new City(4)); cities.get(1).setMinCost(5);
		cities.add(new City(5)); cities.get(2).setMinCost(6);
		cities.add(new City(6)); cities.get(3).setMinCost(1);
		cities.add(new City(2)); cities.get(4).setMinCost(3);
		cities.add(new City(3)); cities.get(5).setMinCost(2);
		cities.add(new City(1)); cities.get(6).setMinCost(3);
		Heap h = new Heap();
		h.buildHeap(cities);
		City c = new City(7);
		c.setMinCost(0);
		h.insertNode(c);
		int i = h.toArrayList().get(0).getMinCost();
		assertEquals(0, i);
	}
	
	@Test
	public void testInsertWInverted() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(0)); cities.get(0).setMinCost(3);
		cities.add(new City(4)); cities.get(1).setMinCost(5);
		cities.add(new City(5)); cities.get(2).setMinCost(6);
		cities.add(new City(6)); cities.get(3).setMinCost(1);
		cities.add(new City(2)); cities.get(4).setMinCost(3);
		cities.add(new City(3)); cities.get(5).setMinCost(2);
		cities.add(new City(1)); cities.get(6).setMinCost(3);
		Heap h = new Heap();
		h.buildHeap(cities);
		ArrayList<City> test = h.toArrayList();
		City c = new City(7);
		c.setMinCost(0);
		h.insertNode(c);
		int i = h.findMin().getMinCost();
		assertEquals(0, i);
		int j = h.findMin().getCityName();
		assertEquals(7, j);
	}
	
	@Test
	public void testExtractMin() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(0)); cities.get(0).setMinCost(3);
		cities.add(new City(4)); cities.get(1).setMinCost(5);
		cities.add(new City(5)); cities.get(2).setMinCost(6);
		cities.add(new City(6)); cities.get(3).setMinCost(1);
		cities.add(new City(2)); cities.get(4).setMinCost(3);
		cities.add(new City(3)); cities.get(5).setMinCost(2);
		cities.add(new City(1)); cities.get(6).setMinCost(3);
		Heap h = new Heap();
		h.buildHeap(cities);
		City c = h.extractMin();
		int name = c.getCityName();
		int cost = c.getMinCost();
		int i = h.findMin().getMinCost();
		assertEquals(name,6);
		assertEquals(cost,1);
		assertEquals(2, i);
	}
	
	
	@Test
	public void testExtractMin3() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(1)); cities.get(0).setMinCost(3);
		cities.add(new City(4)); cities.get(1).setMinCost(5);
		cities.add(new City(5)); cities.get(2).setMinCost(6);
		cities.add(new City(6)); cities.get(3).setMinCost(1);
		cities.add(new City(2)); cities.get(4).setMinCost(3);
		cities.add(new City(3)); cities.get(5).setMinCost(3);
		cities.add(new City(0)); cities.get(6).setMinCost(3);
		Heap h = new Heap();
		h.buildHeap(cities);
		City c = h.extractMin();
		int name = c.getCityName();
		int cost = c.getMinCost();
		int i = h.findMin().getMinCost();
		int j = h.findMin().getCityName();
		assertEquals(name,6);
		assertEquals(cost,1);
		assertEquals(3, i);
		assertEquals(0, j);
		City c2 = new City(6);
		c2.setMinCost(1);
		h.insertNode(c2);
		System.out.println();
	}
	
	@Test
	public void testDeleteMin() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(1)); cities.get(0).setMinCost(3);
		cities.add(new City(4)); cities.get(1).setMinCost(5);
		cities.add(new City(5)); cities.get(2).setMinCost(6);
		cities.add(new City(6)); cities.get(3).setMinCost(1);
		cities.add(new City(2)); cities.get(4).setMinCost(3);
		cities.add(new City(3)); cities.get(5).setMinCost(3);
		cities.add(new City(0)); cities.get(6).setMinCost(3);
		Heap h = new Heap();
		h.buildHeap(cities);
		h.delete(0);
		int i = h.findMin().getMinCost();
		int j = h.findMin().getCityName();
		assertEquals(3, i);
		assertEquals(0, j);
		City c = new City(6);
		c.setMinCost(1);
		h.insertNode(c);
		System.out.println();
	}
	
	@Test
	public void testDeleteLastChild() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(1)); cities.get(0).setMinCost(3);
		cities.add(new City(4)); cities.get(1).setMinCost(5);
		cities.add(new City(5)); cities.get(2).setMinCost(6);
		cities.add(new City(6)); cities.get(3).setMinCost(1);
		cities.add(new City(2)); cities.get(4).setMinCost(3);
		cities.add(new City(0)); cities.get(5).setMinCost(3);
		cities.add(new City(3)); cities.get(6).setMinCost(3);
		Heap h = new Heap();
		h.buildHeap(cities);
		h.delete(6);
		int i = h.findMin().getMinCost();
		int j = h.findMin().getCityName();
		assertEquals(1, i);
		assertEquals(6, j);
		City c = new City(3);
		c.setMinCost(3);
		h.insertNode(c);
		System.out.println();
	}
	
	@Test
	public void testDelete2ndLasthild() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(1)); cities.get(0).setMinCost(3);
		cities.add(new City(4)); cities.get(1).setMinCost(5);
		cities.add(new City(5)); cities.get(2).setMinCost(6);
		cities.add(new City(6)); cities.get(3).setMinCost(1);
		cities.add(new City(2)); cities.get(4).setMinCost(3);
		cities.add(new City(0)); cities.get(5).setMinCost(3);
		cities.add(new City(3)); cities.get(6).setMinCost(3);
		Heap h = new Heap();
		h.buildHeap(cities);
		h.delete(5);
		int i = h.findMin().getMinCost();
		int j = h.findMin().getCityName();
		assertEquals(1, i);
		assertEquals(6, j);
		City c = new City(5);
		c.setMinCost(6);
		h.insertNode(c);
		System.out.println();
	}
	
	@Test
	public void testDeleteHeapUp() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(1)); cities.get(0).setMinCost(1);
		cities.add(new City(4)); cities.get(1).setMinCost(9);
		cities.add(new City(5)); cities.get(2).setMinCost(22);
		cities.add(new City(6)); cities.get(3).setMinCost(17);
		cities.add(new City(2)); cities.get(4).setMinCost(11);
		cities.add(new City(0)); cities.get(5).setMinCost(33);
		cities.add(new City(3)); cities.get(6).setMinCost(27);
		cities.add(new City(7)); cities.get(7).setMinCost(21);
		cities.add(new City(8)); cities.get(8).setMinCost(19);
		Heap h = new Heap();
		h.buildHeap(cities);
		h.delete(5);
		ArrayList<City> test = h.toArrayList();
		int i = test.get(2).getMinCost();
		assertEquals(19, i);

	}
	
	@Test
	public void testDeleteReAdd() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(1)); cities.get(0).setMinCost(1);
		cities.add(new City(4)); cities.get(1).setMinCost(9);
		cities.add(new City(5)); cities.get(2).setMinCost(22);
		cities.add(new City(6)); cities.get(3).setMinCost(17);
		cities.add(new City(2)); cities.get(4).setMinCost(11);
		cities.add(new City(0)); cities.get(5).setMinCost(33);
		cities.add(new City(3)); cities.get(6).setMinCost(27);
		cities.add(new City(7)); cities.get(7).setMinCost(21);
		cities.add(new City(8)); cities.get(8).setMinCost(19);
		Heap h = new Heap();
		h.buildHeap(cities);
		h.delete(5);
		ArrayList<City> test = h.toArrayList();
		int i = test.get(2).getMinCost();
		assertEquals(19, i);
		City c = new City(0);
		c.setMinCost(33);
		h.insertNode(c);
		System.out.println();

	}
	
	@Test
	public void testChangeKey() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(0)); cities.get(0).setMinCost(5);
		cities.add(new City(1)); cities.get(1).setMinCost(3);
		cities.add(new City(2)); cities.get(2).setMinCost(7);
		cities.add(new City(3)); cities.get(3).setMinCost(2);
		Heap h = new Heap();
		h.buildHeap(cities);
		ArrayList<City> test = h.toArrayList();
		h.changeKey(test.get(0), 10);
		assertEquals(1, h.findMin().getCityName());
	
	}
	
	@Test
	public void testChangeKey2() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(0)); cities.get(0).setMinCost(5);
		cities.add(new City(1)); cities.get(1).setMinCost(3);
		cities.add(new City(2)); cities.get(2).setMinCost(7);
		cities.add(new City(3)); cities.get(3).setMinCost(2);
		Heap h = new Heap();
		h.buildHeap(cities);
		ArrayList<City> test = h.toArrayList();
		h.changeKey(test.get(1), 10);
		assertEquals(3, h.findMin().getCityName());
	
	}
	
	@Test
	public void testChangeKey3() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(0)); cities.get(0).setMinCost(5);
		cities.add(new City(1)); cities.get(1).setMinCost(3);
		cities.add(new City(2)); cities.get(2).setMinCost(7);
		cities.add(new City(3)); cities.get(3).setMinCost(10);
		Heap h = new Heap();
		h.buildHeap(cities);
		ArrayList<City> test = h.toArrayList();
		h.changeKey(test.get(1), 3);
		assertEquals(0, h.findMin().getCityName());
	
	}
	
	@Test
	public void testChangeKey4() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(0)); cities.get(0).setMinCost(3);
		cities.add(new City(4)); cities.get(1).setMinCost(5);
		cities.add(new City(5)); cities.get(2).setMinCost(6);
		cities.add(new City(6)); cities.get(3).setMinCost(1);
		cities.add(new City(2)); cities.get(4).setMinCost(3);
		cities.add(new City(3)); cities.get(5).setMinCost(2);
		cities.add(new City(1)); cities.get(6).setMinCost(3);
		Heap h = new Heap();
		h.buildHeap(cities);
		ArrayList<City> test = h.toArrayList();
		h.changeKey(test.get(3), 3);
		assertEquals(6, h.findMin().getCityName());
	
	}
	
	@Test
	public void testChangeKey5() {
		ArrayList<City> cities = new ArrayList<>();
		
		cities.add(new City(0)); cities.get(0).setMinCost(3);
		cities.add(new City(4)); cities.get(1).setMinCost(5);
		cities.add(new City(5)); cities.get(2).setMinCost(6);
		cities.add(new City(6)); cities.get(3).setMinCost(1);
		cities.add(new City(2)); cities.get(4).setMinCost(3);
		cities.add(new City(3)); cities.get(5).setMinCost(2);
		cities.add(new City(1)); cities.get(6).setMinCost(3);
		Heap h = new Heap();
		h.buildHeap(cities);
		ArrayList<City> test = h.toArrayList();
		h.changeKey(test.get(3), 0);
		assertEquals(4, h.findMin().getCityName());
	
	}

}
