package com.cooksys.collections.generics;

// Type parameters are represented by a single capital letter
// examples: T - Type, E - Element, K - Key, V - Value
public class Box<T> {
	
	private T x;

	public Box(T x) {
		this.x = x;
	}

	public T getX() {
		return x;
	}

	public void setX(T x) {
		this.x = x;
	}

}
