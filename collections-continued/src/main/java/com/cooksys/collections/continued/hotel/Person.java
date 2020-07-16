package com.cooksys.collections.continued.hotel;

import java.util.List;

public interface Person {
	
	Adult getParent();
	
	List<Adult> generateAncestorsList();

}
