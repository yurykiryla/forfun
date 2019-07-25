/**
 * 
 */
package com.example.hashtable;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

import com.example.utils.Employee;

/**
 * @author Yury_Kiryla
 *
 */
public class ChainedHashtable {

	private LinkedList<StoredEmployee>[] hashtable;

	public ChainedHashtable() {
		hashtable = new LinkedList[10];
		for (int i = 0; i < hashtable.length; i++) {
			hashtable[i] = new LinkedList<ChainedHashtable.StoredEmployee>();
		}
	}

	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);
		hashtable[hashedKey].add(new StoredEmployee(key, employee));
	}

	public Employee get(String key) {
		int hashedKey = hashKey(key);
		ListIterator<StoredEmployee> iterator = hashtable[hashedKey].listIterator();
		StoredEmployee employee = null;
		while (iterator.hasNext()) {
			employee = iterator.next();
			if (employee.key.equals(key)) {
				return employee.employee;
			}
		}

		return null;
	}

	public Employee remove(String key) {
		int hashedKey = hashKey(key);
		Iterator<StoredEmployee> iterator = hashtable[hashedKey].iterator();
		while (iterator.hasNext()) {
			StoredEmployee storedEmployee = iterator.next();
			if (storedEmployee.key.equals(key)) {
				iterator.remove();
				return storedEmployee.employee;
			}
		}
		return null;
	}

	private int hashKey(String key) {
//		return key.length() % hashtable.length;
		return Math.abs(key.hashCode()) % hashtable.length;
	}

	public void printHashtable() {
		for (int i = 0; i < hashtable.length; i++) {
			if (hashtable[i].isEmpty()) {
				System.out.println("Empty");
			} else {
				for (StoredEmployee storedEmployee : hashtable[i]) {
					System.out.print(storedEmployee.employee);
					System.out.print(" -> ");
				}
				System.out.println("null");
			}
		}
	}

	private static class StoredEmployee {
		String key;
		Employee employee;

		StoredEmployee(String key, Employee employee) {
			super();
			this.key = key;
			this.employee = employee;
		}
	}
}
