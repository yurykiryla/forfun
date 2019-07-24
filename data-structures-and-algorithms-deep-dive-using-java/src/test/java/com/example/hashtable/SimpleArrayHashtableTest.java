/**
 * 
 */
package com.example.hashtable;

import static org.junit.jupiter.api.Assertions.assertSame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.utils.Employee;

/**
 * @author Yury_Kiryla
 *
 */
class SimpleArrayHashtableTest {

	SimpleArrayHashtable hashtable;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		hashtable = new SimpleArrayHashtable();
	}

	/**
	 * Test method for
	 * {@link com.example.hashtable.SimpleArrayHashtable#put(java.lang.String, com.example.utils.Employee)}.
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
		
		assertSame(janeJones, hashtable.get(marySmith.getLastName()));
	}
}
