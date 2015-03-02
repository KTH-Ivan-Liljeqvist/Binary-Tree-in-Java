import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This class is testing the functionality of the Tree class.
 * All of the public methods are tested.
 * This test class does both positive and negative tests.
 * Edge cases like null are tested.
 * @author IvanLiljeqvist
 * @version 1-03-2015
 */

public class BinTreeTest {

	/**
	 * Testing the functionality of add method.
	 * Testing edge-cases like duplicates and null.
	 */
	@Test
	public void addTest() {
		Tree<Integer> t=new Tree<Integer>();
		
		assertTrue(t.add(111));
		assertTrue(t.add(11));
		assertTrue(t.add(12));
		assertFalse(t.add(12));
		
		assertTrue(t.contains(111));
		assertTrue(t.contains(11));
		assertTrue(t.contains(12));
		assertFalse(t.contains(1212));
		
		assertFalse(t.add(null));
		assertFalse(t.contains(null));
		
	}
	
	/**
	 * Testing the functionality of the contains method.
	 * Positive and negative tests.
	 */
	@Test
	public void containsTest(){
		Tree<Integer> t=new Tree<Integer>();
		
		assertTrue(t.add(111));
		assertTrue(t.add(11));
		assertTrue(t.add(12));
		assertFalse(t.add(null));
		
		assertTrue(t.contains(12));
		assertTrue(t.contains(111));
		assertTrue(t.contains(11));
		
		assertFalse(t.contains(null));
		
		assertFalse(t.contains(123));
	}
	/**
	 * Testing the functionality of the depth method.
	 * The method is tested on a balanced tree and on an unbalanced tree.
	 */
	@Test
	public void depthTest(){
		Tree<Integer> t= new Tree<Integer>();
		
		assertEquals(t.depth(),0);
		
		assertTrue(t.add(1)); //root element
		
		assertEquals(t.depth(),1);
		
		assertTrue(t.add(0)); //left element
		
		assertEquals(t.depth(),2);
		
		assertTrue(t.add(2)); //right element
		assertEquals(t.depth(),2);
		
		assertTrue(t.add(3)); //right element 
		
		assertEquals(t.depth(),3);
		
		assertTrue(t.add(5)); //right element
		
		assertEquals(t.depth(),4);
		
		assertFalse(t.add(5)); //shouldnt be added
		
		assertEquals(t.depth(),4);
		
		for(int i=6,j=1;i<350;i++,j++){
			assertTrue(t.add(i));
			assertEquals(t.depth(),4+j);
		}
		
		
	}
	/**
	 * Testing the functionality of the numberOFLeafs method.
	 */
	@Test
	public void numberOfLeafsTest(){
		Tree<Integer> t= new Tree<Integer>();
		
		assertEquals(0,t.numberOfLeafs());
		
		assertTrue(t.add(-23)); //root element
		
		assertEquals(1,t.numberOfLeafs());
		
		assertTrue(t.add(0)); //right element
		
		assertEquals(1,t.numberOfLeafs());
		
		assertTrue(t.add(-100)); //left element
		
		assertEquals(2,t.numberOfLeafs());
		
		assertTrue(t.add(-200)); //left element
		
		assertEquals(2,t.numberOfLeafs());
		
		assertTrue(t.add(-50)); //right element
		
		assertEquals(3,t.numberOfLeafs());
	}
	/**
	 * Testing the functionality of the size method.
	 * One of the tests is testing so it ignores duplicates.
	 */
	@Test
	public void sizeTest(){
		Tree<Integer> t= new Tree<Integer>();
		
		assertEquals(0,t.size());
		
		assertTrue(t.add(0)); //root element
		
		assertEquals(1,t.size());
		
		assertFalse(t.add(0)); //not added
		
		assertEquals(1,t.size());
		
		assertTrue(t.add(10)); //right element
		
		assertEquals(2,t.size());
		
		assertTrue(t.add(100)); //right element
		
		assertEquals(3,t.size());
		
		assertTrue(t.add(-100)); //left element
		
		assertEquals(4,t.size());
	}
	/**
	 * Testing toString method.
	 * One of the tests is testing toString on an empty tree.
	 */
	@Test
	public void toStringTest(){
		Tree<Integer> t= new Tree<Integer>();
		
		assertEquals("[]",t.toString());
		
		assertTrue(t.add(0)); //root element
		
		assertEquals("[0]",t.toString());
		
		assertTrue(t.add(1));
		
		assertEquals("[0, 1]",t.toString());
		
		assertTrue(t.add(-1));
		
		assertEquals("[-1, 0, 1]",t.toString());
		
		assertFalse(t.add(null));
		
		assertEquals("[-1, 0, 1]",t.toString());
	}
}
