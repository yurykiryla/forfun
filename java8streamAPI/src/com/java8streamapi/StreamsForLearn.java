/**
 * 
 */
package com.java8streamapi;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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
		List<String> list = Arrays.stream(array).filter(s -> s.length() <= 2).collect(Collectors.toList());
		System.out.println(list);
		System.out.println();
	}
}
