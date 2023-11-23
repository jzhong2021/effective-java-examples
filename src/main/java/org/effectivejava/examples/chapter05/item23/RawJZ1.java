package org.effectivejava.examples.chapter05.item23;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RawJZ1 {
	// Uses raw type (List) - fails at runtime! - Page 112
	public static void main(String[] args) {
		List<String> strings = new ArrayList<String>();
		//unsafeAdd(strings, new Integer(42));	//Runtime Exception in thread "main" java.lang.ClassCastException: class java.lang.Integer cannot be cast to class java.lang.String (java.lang.Integer and java.lang.String are in module java.base of loader 'bootstrap')
		unsafeAdd(strings, "this is good");
		String s = strings.get(0); // Compiler-generated cast
		
		System.out.println(s);
	}

	private static void unsafeAdd(List list, Object o) {
		list.add(o);
	}

	private static void unsafeAdd1(List<?> list, Object o) {
		//list.add(o);	//Compiler Error: The method add(capture#1-of ?) in the type List<capture#1-of ?> is not applicable for the arguments (Object)
	}
	
	// Use of raw type for unknown element type - don't do this! - Page 113
	static int rawNumElementsInCommon(Set s1, Set s2) {
		int result = 0;
		for (Object o1 : s1)
			if (s2.contains(o1))
				result++;
		return result;
	}

	// Unbounded wildcard type - typesafe and flexible - Page 113
	static int numElementsInCommon(Set<?> s1, Set<?> s2) {
		int result = 0;
		for (Object o1 : s1)
			if (s2.contains(o1))
				result++;
		return result;
	}

	static void numElementsInCommonJZ(Set<?> s1, Set<?> s2) {
		
		if( s1 instanceof Set) {	//Good1
			Set m1 = s1;
			Set<?> m2 = s2;
			
			System.out.println("s1 instanceof Set");
		}

		if( s1 instanceof Set<?>) {	//Good2
			System.out.println("s1 instanceof Set");
		}

		//if( s1 instanceof Set<String>) //Compile Error: Cannot perform instanceof check against parameterized type Set<String>. Use the form Set<?> instead since further generic type information will be erased at runtime
		{
			System.out.println("s1 instanceof Set");
		}
		
	}

}
