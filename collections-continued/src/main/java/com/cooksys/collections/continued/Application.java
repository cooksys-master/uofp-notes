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
		
		Adult adult0 = new Adult("RootParent", 1000, null);

		Adult adult1 = new Adult("Adult1", 50, adult0);
		Adult adult2 = new Adult("Adult2", 30, adult1);
		
		Child child1 = new Child("Child1", 5, adult2);
		
		System.out.println(child1.generateAncestorsList());
		System.out.println(child1.getParent());

		Set<Person> guests = new HashSet<>();
		guests.add(adult1);
		guests.add(adult2);

		Hotel hotel1 = new Hotel(20);

		hotel1.checkInGuests(100, guests);

		System.out.println(hotel1.roomsStillAvailable());

		System.out.println(hotel1.allCheckedInGuests());
		
		Map<Integer, Set<Person>> mainHotelRooms = hotel1.getHotelRooms();
		
		mainHotelRooms.get(100).add(child1);
		
		System.out.println("Main Hotel Rooms: ");
		System.out.println(mainHotelRooms);
		System.out.println("Hotel1.getHotelRooms: ");
		System.out.println(hotel1.getHotelRooms());

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
