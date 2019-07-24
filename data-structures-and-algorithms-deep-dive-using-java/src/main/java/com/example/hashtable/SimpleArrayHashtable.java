/**
 * 
 */
package com.example.hashtable;

import com.example.utils.Employee;

/**
 * @author Yury_Kiryla
 *
 */
public class SimpleArrayHashtable {

	private Employee[] hashtable;

	public SimpleArrayHashtable() {
		hashtable = new Employee[10];
	}

	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);
		if (hashtable[hashedKey] != null) {
			System.out.println("Sorry, there is a value in position " + hashedKey);
		} else {
			hashtable[hashedKey] = employee;
		}
	}

	public Employee get(String key) {
		int hashedKey = hashKey(key);
		return hashtable[hashedKey];
	}

	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}

	public void print() {
		for (Employee employee : hashtable) {
			System.out.println(employee);
		}
	}
}
