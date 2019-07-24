/**
 * 
 */
package com.example.hashtable;

import com.example.utils.Employee;

/**
 * @author Yury_Kiryla
 *
 */
public class LinearProbingArrayHashtable {

	private StoredEmployee[] hashtable;

	public LinearProbingArrayHashtable() {
		hashtable = new StoredEmployee[10];
	}

	public void put(String key, Employee employee) {
		int hashedKey = hashKey(key);

		if (occupied(hashedKey)) {
			int stopIndex = hashedKey;
			if (hashedKey == hashtable.length - 1) {
				hashedKey = 0;
			} else {
				hashedKey++;
			}

			while (occupied(hashedKey) && hashedKey != stopIndex) {
				hashedKey = (hashedKey % 1) % hashtable.length;
			}
		}

		if (occupied(hashedKey)) {
			System.out.println("Sorry, there is a value in position " + hashedKey);
		} else {
			hashtable[hashedKey] = new StoredEmployee(key, employee);
		}
	}

	public Employee get(String key) {
		int hashedKey = findKey(key);
		if (hashedKey == -1) {
			return null;
		}
		return hashtable[hashedKey].employee;
	}

	public Employee remove(String key) {
		int hashedKey = findKey(key);
		if (hashedKey == -1) {
			return null;
		}

		Employee employee = hashtable[hashedKey].employee;
		hashtable[hashedKey] = null;

		StoredEmployee[] oldHashtable = hashtable;
		hashtable = new StoredEmployee[oldHashtable.length];
		for (int i = 0; i < oldHashtable.length; i++) {
			if (oldHashtable[i] != null) {
				put(oldHashtable[i].key, oldHashtable[i].employee);
			}
		}

		return employee;
	}

	private int hashKey(String key) {
		return key.length() % hashtable.length;
	}

	private boolean occupied(int position) {
		return hashtable[position] != null;
	}

	private int findKey(String key) {
		int hashedKey = hashKey(key);
		if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		}

		int stopIndex = hashedKey;
		if (hashedKey == hashtable.length - 1) {
			hashedKey = 0;
		} else {
			hashedKey++;
		}

		while (hashedKey != stopIndex && hashtable[hashedKey] != null && !hashtable[hashedKey].key.equals(key)) {
			hashedKey = (hashedKey + 1) % hashtable.length;
		}

		if (hashtable[hashedKey] != null && hashtable[hashedKey].key.equals(key)) {
			return hashedKey;
		} else {
			return -1;
		}
	}

	public void print() {
		for (StoredEmployee employee : hashtable) {
			System.out.println(employee == null ? "empty" : employee.employee);
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
