/**
 * 
 */
package com.java8streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * https://annimon.com/article/2778
 * 
 * @author Yury_Kiryla
 *
 */
public class StreamsForLearn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		StreamsForLearn sfl = new StreamsForLearn();
		
		sfl.arrayToList();
		sfl.simpleWithTerminate();
		sfl.parallelStream();
		sfl.sources();
	}

	/**
	 * ���� ��� ������ ������. ������ ����� ����������, ��� ������� ��� �������� ������ java.util.stream.Stream.
	 *   - ������ �����: Stream.empty() // Stream<String>
	 *   - ����� �� List: list.stream() // Stream<String>
	 *   - ����� �� Map: map.entrySet().stream() // Stream<Map.Entry<String, String>>
	 *   - ����� �� �������: Arrays.stream(array) // Stream<String>
	 *   - ����� �� ��������� ���������: Stream.of("a", "b", "c") // Stream<String>
	 *   
	 *   � ������ ������� ���������� ������ ����� Arrays.stream, ������� �� ������� args ������ �����. 
	 *   ������������� �������� filter �������� ������ �� ������, ����� ������� �� ��������� ���. 
	 *   ������������ �������� collect �������� ���������� �������� � ����� ������.
	 */
	public void arrayToList() {
		String[] array = {"s", "sdfd", "sd"};
		List<String> list = Arrays.stream(array)
				.filter(s -> s.length() <= 2)
				.collect(Collectors.toList());
		System.out.println(list);
		System.out.println();
	}
	
	/**
	 * ����� ��� ��� ������������� ���������:
	 * - filter � �������� ��������, �������� ������� ������ 300,
	 * - map � ���������� 11 � ������� �����,
	 * - limit � ������������ ���������� ��������� �� 3.
	 * 
	 * ������������ �������� forEach ��������� ������� print � ������� ����������� ��������.
	 */
	public void simpleWithTerminate() {
		IntStream.of(120, 410, 85, 32, 314, 12)
				.filter(x -> x < 200)
				.map(x -> x + 11)
				.limit(3)
				.forEach(System.out::println);
		System.out.println();
	}
	
	/**
	 * ����� �������� ������������ �����, ����� ���� ������� ����� parallelStream() ������ stream(), 
	 * ���� ���������� ������� ����� � ������������, ������ ������������� �������� parallel.
	 */
	public void parallelStream() {
		List<Integer> list = Arrays.asList(1, 4, 3, 5);
		
		list = list.parallelStream()
				.filter(x -> x > 2)
				.map(x -> x * 2)
				.collect(Collectors.toList());
		System.out.println(list);
		
		int sum = IntStream.range(0, 10).parallel().map(x -> x * 10).sum();
		System.out.println(sum);
		System.out.println();
	}
	
	/**
	 * 6.1. ���������
	 */
	public void sources() {
		// empty()
		// �����, ��� � ���������, ����� ���� ������, � ������ ���� ����������� ���������� ������ ����� ������������.
		Stream.empty()
	    		.forEach(System.out::println);
		
		// of(T value)
		// of(T... values)
		// ����� ��� ������ ��� ���������� ������������� ���������. ����� ����� ����, ��� ���������� ����� �����������:
	    Arrays.asList(1, 2, 3).stream()
        		.forEach(System.out::println);
	    // ������ ��� �������. ��� ��� �����:
	    Stream.of(1, 2, 3)
        		.forEach(System.out::println);

	    // ofNullable(T t)
	    // �������� � Java 9. ���������� ������ �����, ���� � �������� ��������� ������� null, 
	    // � ��������� ������, ���������� ����� �� ������ ��������.
	    String str = Math.random() > 0.5 ? "I'm feeling lucky" : null;
	    Stream.ofNullable(str)
	    		.forEach(System.out::println);

	    // generate(Supplier s)
	    // ���������� ����� � ����������� ������������������� ���������, ������������ �������� Supplier s.
	    Stream.generate(() -> Math.random())
	    		.limit(6)
	    		.forEach(System.out::println);
	    
	    
	}
}
