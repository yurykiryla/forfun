/**
 * 
 */
package com.graphpath;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuryk
 *
 */
public class Graph<E> {
	private final Entry<E> root;
	
	public Graph (E root){
		this.root = new Entry<E>(root);
	}
	
	public Entry<E> getRoot() {
		return root;
	}
	
	public Entry<E> add(E value, Entry<E> parent) {
		if (value == null) {
			throw new NullPointerException("value cannot be null");
		}
		Entry<E> entry = new Entry<E>(value);
		if (parent != null) {
			parent.addChild(entry);
		} else {
			root.addChild(entry);
		}
		
		return entry;
	}
	
	static final class Entry<E> {
		private final E value;
		private List<Entry<E>> children;
		
		Entry(E value) {
			this.value = value;
		}
		
		void addChild(Entry<E> child) {
			if (children == null) {
				children = new ArrayList<Entry<E>>();
			}
			children.add(child);
		}
		
		E getValue() {
			return value;
		}
		
		List<Entry<E>> getChildren() {
			return children;
		}
	}
}
