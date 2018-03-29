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
		List<String> list = Arrays.stream(array)
				.filter(s -> s.length() <= 2)
				.collect(Collectors.toList());
		System.out.println(list);
		System.out.println();
	}
	
	/**
	 * Здесь уже три промежуточных оператора:
	 * - filter — отбирает элементы, значение которых меньше 300,
	 * - map — прибавляет 11 к каждому числу,
	 * - limit — ограничивает количество элементов до 3.
	 * 
	 * Терминальный оператор forEach применяет функцию print к каждому приходящему элементу.
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
	 * Чтобы получить параллельный стрим, нужно либо вызвать метод parallelStream() вместо stream(), 
	 * либо превратить обычный стрим в параллельный, вызвав промежуточный оператор parallel.
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
	 * 6.1. Источники
	 */
	public void sources() {
		// empty()
		// Стрим, как и коллекция, может быть пустым, а значит всем последующем операторам нечего будет обрабатывать.
		Stream.empty()
	    		.forEach(System.out::println);
		
		// of(T value)
		// of(T... values)
		// Стрим для одного или нескольких перечисленных элементов. Очень часто вижу, что используют такую конструкцию:
	    Arrays.asList(1, 2, 3).stream()
        		.forEach(System.out::println);
	    // однако она излишня. Вот так проще:
	    Stream.of(1, 2, 3)
        		.forEach(System.out::println);

	    // ofNullable(T t)
	    // Появился в Java 9. Возвращает пустой стрим, если в качестве аргумента передан null, 
	    // в противном случае, возвращает стрим из одного элемента.
	    String str = Math.random() > 0.5 ? "I'm feeling lucky" : null;
	    Stream.ofNullable(str)
	    		.forEach(System.out::println);

	    // generate(Supplier s)
	    // Возвращает стрим с бесконечной последовательностью элементов, генерируемых функцией Supplier s.
	    Stream.generate(() -> Math.random())
	    		.limit(6)
	    		.forEach(System.out::println);
	    
	    
	}
}
