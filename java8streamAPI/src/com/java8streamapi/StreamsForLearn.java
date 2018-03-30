/**
 * 
 */
package com.java8streamapi;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
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
		sfl.middleOperators();
		sfl.terminal();
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
	    // Поскольку стрим бесконечный, нужно его ограничивать или осторожно использовать, дабы не попасть в бесконечный цикл.
	    Stream.generate(() -> Math.random())
	    		.limit(6)
	    		.forEach(System.out::println);
	    
//	    iterate​(T seed, UnaryOperator f)
//	    Возвращает бесконечный стрим с элементами, которые образуются в результате последовательного применения функции f 
//	    к итерируемому значению. Первым элементом будет seed, затем f(seed), затем f(f(seed)) и так далее.
	    Stream.iterate(2, x -> x + 6)
	    		.limit(6)
	    		.forEach(System.out::println);
	    
//	    Появился в Java 9. Всё то же самое, только добавляется ещё один аргумент hasNext: если он возвращает false, 
//	    то стрим завершается. Это очень похоже на цикл for:
//
//	        for (i = seed; hasNext(i); i = f(i)) {
//	        }
//
//	    Таким образом, с помощью iterate теперь можно создать конечный стрим.
	    Stream.iterate(2, x -> x < 25, x -> x + 6)
	    		.forEach(System.out::println);
	    
//	    concat(Stream a, Stream b)
//	    Объединяет два стрима так, что вначале идут элементы стрима A, а по его окончанию последуют элементы стрима B.
	    Stream.concat(
	            Stream.of(1, 2, 3),
	            Stream.of(4, 5, 6))
	        .forEach(System.out::println);
	    
//	    builder()
//	    Создаёт мутабельный объект для добавления элементов в стрим без использования какого-либо контейнера для этого.
	    Stream.Builder<Integer> streamBuilder = Stream.<Integer>builder()
	    		.add(0)
	    		.add(1);
	    for (int i = 2; i <= 8; i += 2) {
	    	streamBuilder.accept(i);
	    }
	    streamBuilder
	    		.add(9)
	    		.add(10)
	    		.build()
	    		.forEach(System.out::println);
	    
//	    IntStream.range​(int startInclusive, int endExclusive)
//	    LongStream.range​(long startInclusive, long endExclusive)
//	    Создаёт стрим из числового промежутка [start..end), то есть от start (включительно) по end.
	    IntStream.range(0, 10)
	    		.forEach(System.out::println);
	    LongStream.range(-10L, -5L)
	    		.forEach(System.out::println);
	    
//	    IntStream.rangeClosed​(int startInclusive, int endInclusive)
//	    LongStream.range​Closed(long startInclusive, long endInclusive)
//	    Создаёт стрим из числового промежутка [start..end], то есть от start (включительно) по end (включительно).
	    IntStream.rangeClosed(0, 5)
	    		.forEach(System.out::println);
	    LongStream.rangeClosed(-8L, -5L)
	    		.forEach(System.out::println);
	    
	    System.out.println();
	}
	
	/**
	 * 6.2. Промежуточные операторы
	 */
	public void middleOperators() {
//		filter​(Predicate predicate)
//		Фильтрует стрим, принимая только те элементы, которые удовлетворяют заданному условию.
		Stream.of(1, 2, 3)
	    		.filter(x -> x == 10)
	    		.forEach(System.out::print);
		Stream.of(120, 410, 85, 32, 314, 12)
	    		.filter(x -> x > 100)
	    		.forEach(System.out::println);
		
//		map​(Function mapper)
//		Применяет функцию к каждому элементу и затем возвращает стрим, в котором элементами будут результаты функции. 
//		map можно применять для изменения типа элементов.
//
//		Stream.mapToDouble​(ToDoubleFunction mapper)
//		Stream.mapToInt​(ToIntFunction mapper)
//		Stream.mapToLong​(ToLongFunction mapper)
//		IntStream.mapToObj(IntFunction mapper)
//		IntStream.mapToLong(IntToLongFunction mapper)
//		IntStream.mapToDouble(IntToDoubleFunction mapper)
//
//		Специальные операторы для преобразования объектного стрима в примитивный, примитивного в объектный, 
//		либо примитивного стрима одного типа в примитивный стрим другого.
		Stream.of("3", "4", "5")
	    		.map(Integer::parseInt)
	    		.map(x -> x + 10)
	    		.forEach(System.out::println);
		Stream.of(120, 410, 85, 32, 314, 12)
	    		.map(x -> x + 11)
	    		.forEach(System.out::println);
		Stream.of("10", "11", "32")
	    		.map(x -> Integer.parseInt(x, 16))
	    		.forEach(System.out::println);
		
//		flatMap​(Function<T, Stream<R>> mapper)
//		Один из самых интересных операторов. Работает как map, но с одним отличием — можно преобразовать 
//		один элемент в ноль, один или множество других.
//
//		flatMapToDouble​(Function mapper)
//		flatMapToInt​(Function mapper)
//		flatMapToLong​(Function mapper)
//
//		Как и в случае с map, служат для преобразования в примитивный стрим.
//
//		Для того, чтобы один элемент преобразовать в ноль элементов, нужно вернуть null, либо пустой стрим. 
//		Чтобы преобразовать в один элемент, нужно вернуть стрим из одного элемента, например, через Stream.of(x). 
//		Для возвращения нескольких элементов, можно любыми способами создать стрим с этими элементами.
		IntStream.of(2, 3, 0, 1, 3)
				.flatMap(x -> IntStream.range(0, x))
				.forEach(System.out::println);
		
//		limit​(long maxSize)
//		Ограничивает стрим maxSize элементами.
		Stream.of(120, 410, 85, 32, 314, 12)
	    		.limit(4)
	    		.forEach(System.out::println);
		
//		skip​(long n)
//		Пропускает n элементов стрима.
		Stream.of(5, 10)
	    		.skip(40)
	    		.forEach(System.out::println);
		Stream.of(120, 410, 85, 32, 314, 12)
	    		.skip(2)
	    		.forEach(System.out::println);
		
//		sorted​()
//		sorted​(Comparator comparator)
//		Сортирует элементы стрима. Причём работает этот оператор очень хитро: если стрим уже помечен 
//		как отсортированный, то сортировка проводиться не будет, иначе соберёт все элементы, отсортирует их 
//		и вернёт новый стрим, помеченный как отсортированный.
		IntStream.range(0, 100000000)
	    		.sorted()
	    		.limit(3)
	    		.forEach(System.out::println);
		IntStream.concat(
		        	IntStream.range(0, 100000000),
		        	IntStream.of(-1, -2))
		    	.sorted()
		    	.limit(3)
		    	.forEach(System.out::println);
		Stream.of(120, 410, 85, 32, 314, 12)
	    		.sorted()
	    		.forEach(System.out::println);
		Stream.of(120, 410, 85, 32, 314, 12)
	    		.sorted(Comparator.reverseOrder())
	    		.forEach(System.out::println);
		
//		distinct​()
//		Убирает повторяющиеся элементы и возвращаем стрим с уникальными элементами. Как и в случае с sorted, 
//		смотрит, состоит ли уже стрим из уникальных элементов и если это не так, отбирает уникальные и помечает 
//		стрим как содержащий уникальные элементы.
		Stream.of(2, 1, 8, 1, 3, 2)
	    		.distinct()
	    		.forEach(System.out::println);
		
//		peek​(Consumer action)
//		Выполняет действие над каждым элементом стрима и при этом возвращает стрим с элементами исходного стрима. 
//		Служит для того, чтобы передать элемент куда-нибудь, не разрывая при этом цепочку операторов (вы же помните, 
//		что forEach — терминальный оператор и после него стрим завершается?), либо для отладки.
		Stream.of(0, 3, 0, 0, 5)
			    .peek(x -> System.out.format("before distinct: %d%n", x))
			    .distinct()
			    .peek(x -> System.out.format("after distinct: %d%n", x))
			    .map(x -> x * x)
			    .forEach(x -> System.out.format("after map: %d%n", x));
		
//		takeWhile​(Predicate predicate)
//		Появился в Java 9. Возвращает элементы до тех пор, пока они удовлетворяют условию, то есть функция-предикат 
//		возвращает true. Это как limit, только не с числом, а с условием.
		Stream.of(1, 2, 3, 4, 2, 5)
	    		.takeWhile(x -> x < 3)
	    		.forEach(System.out::println);
		
//		dropWhile​(Predicate predicate)
//		Появился в Java 9. Пропускает элементы до тех пор, пока они удовлетворяют условию, затем возвращает оставшуюся 
//		часть стрима. Если предикат вернул для первого элемента false, то ни единого элемента не будет пропущено. 
//		Оператор подобен skip, только работает по условию.
		Stream.of(1, 2, 3, 4, 2, 5)
	    		.dropWhile(x -> x >= 3)
	    		.forEach(System.out::println);
		Stream.of(1, 2, 3, 4, 2, 5)
	    		.dropWhile(x -> x < 3)
	    		.forEach(System.out::println);
		
//		boxed()
//		Преобразует примитивный стрим в объектный.
		DoubleStream.of(0.1, Math.PI)
	    		.boxed()
	    		.map(Object::getClass)
	    		.forEach(System.out::println);
		
		System.out.println();
	}
	
	/**
	 * 6.3. Терминальные операторы
	 */
	public void terminal() {
//		void forEach​(Consumer action)
//		Выполняет указанное действие для каждого элемента стрима.
		Stream.of(120, 410, 85, 32, 314, 12)
	    		.forEach(x -> System.out.format("%s, ", x));
		System.out.println();
		
		
	}
}
