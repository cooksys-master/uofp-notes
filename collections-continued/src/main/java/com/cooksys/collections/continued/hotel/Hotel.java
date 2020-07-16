package com.cooksys.collections.continued.hotel;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Hotel {
	
	private int numberOfRooms;
	private Map<Integer, Set<Person>> hotelRooms = new HashMap<>();
	
	public Hotel(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public void checkInGuests(int roomNumber, Set<Person> guests) {
		hotelRooms.put(roomNumber, guests);
	}
	
	public void checkOutGuests(int roomNumber) {
		hotelRooms.remove(roomNumber);
	}
	
	public int roomsStillAvailable() {
		return numberOfRooms - hotelRooms.size();
	}
	
	public Set<Person> allCheckedInGuests() {
		Set<Person> result = new HashSet<>();
		for (Set<Person> guestSet : hotelRooms.values()) {
			result.addAll(guestSet);
		}
		return result;
	}

	public Map<Integer, Set<Person>> getHotelRooms() {
		Map<Integer, Set<Person>> result = new HashMap<>();
		for (Integer roomNumber : hotelRooms.keySet()) {
			result.put(roomNumber, new HashSet<>(hotelRooms.get(roomNumber)));
		}
		return result;
	}
	
	

}
