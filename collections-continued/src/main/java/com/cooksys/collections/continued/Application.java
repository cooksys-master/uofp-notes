package com.cooksys.collections.continued;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cooksys.collections.continued.hotel.*;

public class Application {

	private static final Set<Character> ALPHABET = new HashSet<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
			'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

	public static void main(String[] args) {

		System.out.println(countUniqueLetters("Hello World12345"));
		System.out.println(countUniqueLetters("supercalifragilisticexpialidocious"));

		System.out.println(countLetterOccurrences("supercalifragilisticexpialidocious"));
		System.out.println(countLetterOccurrences("Hello World12345;!@"));

		Adult adult1 = new Adult("Will", 30);
		Adult adult2 = new Adult("Peter", 30);

		Set<Person> guests = new HashSet<>();
		guests.add(adult1);
		guests.add(adult2);

		Hotel hotel1 = new Hotel(20);

		hotel1.checkInGuests(100, guests);

		System.out.println(hotel1.roomsStillAvailable());

		System.out.println(hotel1.allCheckedInGuests());

	}

	public static int countUniqueLetters(String s) {
		Set<Character> uniqueLetters = new HashSet<>();
		for (char c : s.toLowerCase().toCharArray()) {
			if (ALPHABET.contains(c)) {
				uniqueLetters.add(c);
			}
		}
		return uniqueLetters.size();
	}

	public static Map<Character, Integer> countLetterOccurrences(String s) {
		Map<Character, Integer> result = new HashMap<>();
		for (char c : s.toLowerCase().toCharArray()) {
			if (ALPHABET.contains(c)) {
				if (result.containsKey(c)) {
					result.put(c, result.get(c) + 1);
				} else {
					result.put(c, 1);
				}
			}
		}
		return result;
	}

}
