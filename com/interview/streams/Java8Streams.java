package com.interview.streams;

import java.util.IntSummaryStatistics;
import java.util.stream.IntStream;

public class Java8Streams {

	public static void main(String[] args) {

		int[] numbers = { 4, 1, 13, 90, 16, 2, 0 };

		int min = IntStream.of(numbers).min().getAsInt();
		int max = IntStream.of(numbers).max().getAsInt();
		double average = IntStream.of(numbers).average().getAsDouble();
		long count = IntStream.of(numbers).count();
		int sum = IntStream.of(numbers).sum();

		IntSummaryStatistics statistics = IntStream.of(numbers).summaryStatistics();

		System.out.println("Min : " + min);
		System.out.println("Max : " + max);
		System.out.println("Average : " + average);
		System.out.println("Count : " + count);
		System.out.println("Sum : " + sum);

		System.out.println(statistics);

		// print 3 min distinct values in an array
		// Here original array is not mutated
		IntStream.of(numbers).distinct().sorted().limit(3).forEach(System.out::println);

		long EvenCount = IntStream.of(numbers).filter(num -> num % 2 == 0).map(num -> num).count();
		
		System.out.println("Even Count : " + EvenCount);

	}

}