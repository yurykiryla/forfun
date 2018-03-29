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
	 * Пока что хватит теории. Пришло время посмотреть, как создать или получить объект java.util.stream.Stream.
	 *   - Пустой стрим: Stream.empty() // Stream<String>
	 *   - Стрим из List: list.stream() // Stream<String>
	 *   - Стрим из Map: map.entrySet().stream() // Stream<Map.Entry<String, String>>
	 *   - Стрим из массива: Arrays.stream(array) // Stream<String>
	 *   - Стрим из указанных элементов: Stream.of("a", "b", "c") // Stream<String>
	 *   
	 *   В данном примере источником служит метод Arrays.stream, который из массива args делает стрим. 
	 *   Промежуточный оператор filter отбирает только те строки, длина которых не превышает два. 
	 *   Терминальный оператор collect собирает полученные элементы в новый список.
	 */
	public void arrayToList() {
		String[] array = {"s", "sdfd", "sd"};
		List<String> list = Arrays.stream(array).filter(s -> s.length() <= 2).collect(Collectors.toList());
		System.out.println(list);
		System.out.println();
	}
}
