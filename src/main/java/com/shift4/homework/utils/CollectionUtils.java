package com.shift4.homework.utils;

import java.util.AbstractMap;
import java.util.Map;


public class CollectionUtils {

	private CollectionUtils() {}

	public static  <K, V> Map.Entry<K, V> mapEntry(K key, V value) {

		return new AbstractMap.SimpleEntry<>(key, value);
	}
}
