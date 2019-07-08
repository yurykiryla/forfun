package com.example.lists.stacks.array;

import java.util.EmptyStackException;

import com.example.utils.Employee;

public class ArrayStack {
	private Employee[] stack;
	private int top;
	
	public ArrayStack(int capacity) {
		stack = new Employee[capacity];
	}
	
	public void push(Employee employee) {
		if (top == stack.length) {
			// need to resize the backing array
			Employee[] newArray = new Employee[2 * stack.length];
			System.arraycopy(stack, 0, newArray, 0, stack.length);
			stack = newArray;
		}
		
		stack[top++] = employee;
	}
	
	public Employee pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		Employee employee = stack[--top];
		stack[top] = null;
		return employee;
	}
	
	public Employee peak() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		
		return stack[top - 1];
	}
	
	public int size() {
		return top;
	}
	
	public boolean isEmpty() {
		return top == 0;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = top - 1; i >= 0; i--) {
			sb.append(stack[i] + "/n");
		}
		return sb.toString();
	}
}
