package HashTable;

import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import List.*;

public class NHashTable<K,V> implements Map<K, V> {
	
	private static final double DEFAULT_LOAD_FACTOR =  0.75; //Java HashMap default value 
	private static final int DEFAULT_CAPACITY = 16;    //Java HashMap default value 
	
	private double load_factor;
	private int capacity;
	private int size;
	private NList<Map.Entry<K, V>>[] buckets;
	
	// CONSTRUCTORS ========
	
	NHashTable() {
		this.load_factor = DEFAULT_LOAD_FACTOR;
		this.capacity = DEFAULT_CAPACITY;
		initialSetup();
	}
	
	NHashTable(int capacity) {
		this.load_factor = DEFAULT_LOAD_FACTOR;
		this.capacity = capacity;
		initialSetup();
	}
	
	NHashTable(int capacity, double load_factor) {
		this.load_factor = load_factor;
		this.capacity = capacity;
		initialSetup();
	}
	
	// Initialises the fields 
	private void initialSetup() {
		size = 0;
		buckets = (NList<Map.Entry<K, V>>[])new Object[capacity];
	}
	
	// PUBLIC METHODS =====
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsKey(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsValue(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Set<java.util.Map.Entry<K, V>> entrySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V get(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public Set<K> keySet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public V put(K key, V value) {
		int index = key.hashCode() % capacity;
		
		NList<Map.Entry<K, V>> list = buckets[index];
		
		if (list == null) {
			buckets[index] = new NList<Map.Entry<K, V>>();
			
			Map.Entry<K, V> newEntry = new AbstractMap.SimpleEntry<K,V>(key, value);
			buckets[index].add(newEntry);
			
			return value;
		}
		
	
		return null;
	}

	@Override
	public void putAll(Map<? extends K, ? extends V> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public V remove(Object arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Collection<V> values() {
		// TODO Auto-generated method stub
		return null;
	}
	
	// PRIVATE METHODS
	
	private boolean bucketFull() {
		return capacity == size;
	}
}
