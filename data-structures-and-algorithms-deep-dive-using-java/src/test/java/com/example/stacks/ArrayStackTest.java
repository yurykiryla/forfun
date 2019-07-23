package com.example.stacks;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;

import org.junit.jupiter.api.Test;

import com.example.stacks.ArrayStack;
import com.example.utils.Employee;

public class ArrayStackTest {

	ArrayStack stack;

	@Test
	public void testPush() {
		stack = new ArrayStack(2);

		stack.push(new Employee("Frst", "Empl", 1));
		stack.push(new Employee("Sec", "Empl", 2));
		stack.push(new Employee("Trd", "Empl", 3));
		stack.push(new Employee("For", "Empl", 4));

		assertEquals(4, stack.size());
	}

	@Test
	public void testPop() {
		stack = new ArrayStack(5);

		assertThrows(EmptyStackException.class, () -> stack.pop());

		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
		
		stack.push(janeJones);
		stack.push(johnDoe);
		stack.push(marySmith);
		stack.push(mikeWilson);
		
		assertSame(mikeWilson, stack.pop());
		assertSame(marySmith, stack.pop());
		
		assertEquals(2, stack.size());
	}

	@Test
	public void testPeak() {
		stack = new ArrayStack(5);

		assertThrows(EmptyStackException.class, () -> stack.peak());

		Employee janeJones = new Employee("Jane", "Jones", 123);
		Employee johnDoe = new Employee("John", "Doe", 4567);
		Employee marySmith = new Employee("Mary", "Smith", 22);
		Employee mikeWilson = new Employee("Mike", "Wilson", 3245);
		
		stack.push(janeJones);
		stack.push(johnDoe);
		stack.push(marySmith);
		stack.push(mikeWilson);
		
		assertSame(mikeWilson, stack.peak());
		assertSame(mikeWilson, stack.peak());
		
		assertEquals(4, stack.size());
	}

	@Test
	public void testIsEmpty() {
		stack = new ArrayStack(2);

		assertTrue(stack.isEmpty());
		
		stack.push(new Employee("Frst", "Empl", 1));
		stack.push(new Employee("Sec", "Empl", 2));
		stack.push(new Employee("Trd", "Empl", 3));
		stack.push(new Employee("For", "Empl", 4));

		assertFalse(stack.isEmpty());
	}

}
