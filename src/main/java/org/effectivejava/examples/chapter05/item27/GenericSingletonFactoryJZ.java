// Generic singleton factory method - Pages 131-132
package org.effectivejava.examples.chapter05.item27;

import java.util.HashSet;
import java.util.Set;

public class GenericSingletonFactoryJZ {
	// Generic singleton factory pattern
	private static JzFunction<Object> IDENTITY_FUNCTION = new JzFunction<Object>() {
		public Object apply(Object arg) {
			return arg;
		}
	};

	// IDENTITY_FUNCTION is stateless and its type parameter is
	// unbounded so it's safe to share one instance across all types.
	@SuppressWarnings("unchecked")
	public static <T> JzFunction<T> identityFunction() {
		return (JzFunction<T>) IDENTITY_FUNCTION;
	}

	public static <E> Set<E> unionJZ2(Set<E> s1, Set<E> s2) {	//if no <E>, compiler error: E cannot be resolved to a type
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}
	
	static <T> T action(T t) {		//JZ
		return t;
	}
	
	// Sample program to exercise generic singleton
	public static void main(String[] args) {
		String[] strings = { "jute", "hemp", "nylon" };
		JzFunction<String> sameString = identityFunction();
		
		for (String s : strings)
			System.out.println(sameString.apply(s));

		Number[] numbers = { 1, 2.0, 3L };
		JzFunction<Number> sameNumber = identityFunction();
		for (Number n : numbers)
			System.out.println(sameNumber.apply(n));

		for (Number n : numbers)
			System.out.print(action(n)+", ");
	}
	
	
	 interface JzFunction<T> {
		T apply(T arg);
	}	
}