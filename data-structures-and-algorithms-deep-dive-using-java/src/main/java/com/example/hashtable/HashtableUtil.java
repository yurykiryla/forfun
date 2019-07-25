/**
 * 
 */
package com.example.hashtable;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import com.example.utils.Employee;

/**
 * @author Yury_Kiryla
 *
 */
public class HashtableUtil {
  
  public int hash(int value) {
    return Math.abs(Integer.hashCode(value)) % 10;
  }

  public void cleanList(List<Employee> employees) {
    Map<Integer, Employee> map = new HashMap<>();
    Iterator<Employee> iterator = employees.iterator();
    while (iterator.hasNext()) {
      Employee employee = iterator.next();
      if (!map.containsKey(employee.getId())) {
        map.put(employee.getId(), employee);
      } else {
        iterator.remove();
      }
    }
  }
}
