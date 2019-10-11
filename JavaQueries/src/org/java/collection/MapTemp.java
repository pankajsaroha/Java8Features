package org.java.collection;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface MapTemp<K, V> {
	
	public int hashCode(K key);
	
	public boolean put(K key, V value);
	public V get(K key);
	public List<V> values();
	public List<K> keySet();
	public Set<Map.Entry<K, V>> entrySet();
}
