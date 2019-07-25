/**
 * 
 */
package com.example.hashtable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.LinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.utils.Employee;

/**
 * @author Yury_Kiryla
 *
 */
class HashtableUtilTest {
  
  HashtableUtil utils;

  /**
   * @throws java.lang.Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    utils = new HashtableUtil();
  }

  /**
   * Test method for {@link com.example.hashtable.HashtableUtil#hash(int)}.
   */
  @Test
  void testHash() {
    int[] nums = {59382, 43, 6894, 500,  99, -58};
    for (int i = 0; i < nums.length; i++) {
      assertTrue(0 <= utils.hash(nums[i]) && 10 > utils.hash(nums[i]));
    }
  }

  @Test
  void testCleanList () throws Exception {
    LinkedList<Employee> employees = new LinkedList<>();
    employees.add(new Employee("Jane", "Jones", 123));
    employees.add(new Employee("John", "Doe", 5678));
    employees.add(new Employee("Mike", "Wilson", 45));
    employees.add(new Employee("Mary", "Smith", 5555));
    employees.add(new Employee("John", "Doe", 5678));
    employees.add(new Employee("Bill", "End", 3948));
    employees.add(new Employee("Jane", "Jones", 123));
    
    utils.cleanList(employees);
    
    assertEquals(5, employees.size());
  }
}
