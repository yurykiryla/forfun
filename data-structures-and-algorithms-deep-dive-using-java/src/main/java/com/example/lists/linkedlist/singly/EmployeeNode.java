/**
 * 
 */
package com.example.lists.linkedlist.singly;

import com.example.utils.Employee;

/**
 * @author Yury_Kiryla
 *
 */
public class EmployeeNode {

	private Employee employee;
	private EmployeeNode next;

	/**
	 * @param employee
	 */
	public EmployeeNode(Employee employee) {
		super();
		this.employee = employee;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee
	 *            the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the next
	 */
	public EmployeeNode getNext() {
		return next;
	}

	/**
	 * @param next
	 *            the next to set
	 */
	public void setNext(EmployeeNode next) {
		this.next = next;
	}

	public String toString() {
		return employee.toString();
	}
}
