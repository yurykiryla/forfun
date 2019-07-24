/**
 * 
 */
package com.example.hashtable;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.utils.Employee;

/**
 * @author Yury_Kiryla
 *
 */
class LinearProbingArrayHashtableTest {

	LinearProbingArrayHashtable hashtable;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		hashtable = new LinearProbingArrayHashtable();
	}

	/**
	 * Test method for
	 * {@link com.example.hashtable.LinearProbingArrayHashtable#put(java.lang.String, com.example.utils.Employee)}.
	 */
	@Test
	void testPut() {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

		hashtable.put(janeJones.getLastName(), janeJones);
		hashtable.put(johnDoe.getLastName(), johnDoe);
		hashtable.put(marySmith.getLastName(), marySmith);
		hashtable.put(mikeWilson.getLastName(), mikeWilson);

		assertSame(janeJones, hashtable.get(janeJones.getLastName()));
		assertNotSame(marySmith, hashtable.get(janeJones.getLastName()));
	}

	/**
	 * Test method for
	 * {@link com.example.hashtable.LinearProbingArrayHashtable#get(java.lang.String)}.
	 */
	@Test
	void testGet() {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);

		hashtable.put(janeJones.getLastName(), janeJones);
		hashtable.put(johnDoe.getLastName(), johnDoe);
		hashtable.put(marySmith.getLastName(), marySmith);
		hashtable.put(mikeWilson.getLastName(), mikeWilson);

		assertSame(janeJones, hashtable.get(janeJones.getLastName()));
		assertSame(marySmith, hashtable.get(marySmith.getLastName()));
	}

	@Test
	public void testRemove() throws Exception {
		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
		Employee marySmith = new Employee("Mary", "Smith", 22);

		hashtable.put(janeJones.getLastName(), janeJones);
		hashtable.put(johnDoe.getLastName(), johnDoe);
		hashtable.put(mikeWilson.getLastName(), mikeWilson);
		hashtable.put(marySmith.getLastName(), marySmith);
		
		assertSame(janeJones, hashtable.remove(janeJones.getLastName()));
		assertNull(hashtable.remove(janeJones.getLastName()));
		assertSame(mikeWilson, hashtable.remove(mikeWilson.getLastName()));
		assertSame(marySmith, hashtable.remove(marySmith.getLastName()));
	}

}
