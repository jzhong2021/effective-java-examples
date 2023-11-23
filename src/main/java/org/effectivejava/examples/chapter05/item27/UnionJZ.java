// Generic union method and program to exercise it - pages 129 - 130
package org.effectivejava.examples.chapter05.item27;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class UnionJZ {

	// Generic method
	public static <E> Set<E> union(Set<E> s1, Set<E> s2) {
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}
	
	//raw type
	public static Set unionJZ1(Set s1, Set s2) {
		Set result = new HashSet(s1);
		result.addAll(s2);
		return result;
	}
	
	//Generic method
	public static <E> Set<E> unionJZ2(Set<E> s1, Set<E> s2) {	//if no <E>, compiler error: E cannot be resolved to a type
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}

	//Generic type
	public static Set<String> unionJZ3(Set<String> s1, Set<String> s2) {	//if no <E>, compiler error: E cannot be resolved to a type
		Set<String> result = new HashSet<String>(s1);
		result.addAll(s2);
		return result;
	}
	
	// Simple program to exercise generic method
	public static void main(String[] args) {
		Set<String> guys = new HashSet<String>(Arrays.asList("Tom", "Dick",
				"Harry"));
		Set<String> stooges = new HashSet<String>(Arrays.asList("Larry", "Moe",
				"Curly"));
		Set<String> aflCio = union(guys, stooges);
		System.out.println(aflCio);
		
		Set jz1 = unionJZ1(guys, stooges);
		System.out.println(jz1);

		Set<String> jz2 = unionJZ2(guys, stooges);
		System.out.println(jz2);

		Set<String> jz3 = unionJZ3(guys, stooges);
		System.out.println(jz3);
		
	}
}
