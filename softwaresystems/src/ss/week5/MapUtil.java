package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class MapUtil {
	
	//@requires map != null
	//@ensures \result == \forall K key, key2; map.keySet().containsKey(key) && map.keySet().contains(key); map.get(key) != map.get(key2) || key == key2;
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        Set<K> keySet = map.keySet();
        boolean result = true;
        for (K key : keySet) {
        	for (K compareKey : keySet) {
        		if (map.get(key) == map.get(compareKey) && key != compareKey) {
        			result = false;
        			break;
        		}
        	}
        	if (result == false) {
        		break;
        	}
        }
        return result;
    }
    
    //@requires map != null && range != null
    //@ensures \result == \forall V value; range.contains(value); map.containsValue(value);
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
    	Set<K> keySet = map.keySet();
    	boolean result = true;
    	for(V value : range) {
    		for(K key : keySet) {
    			if (map.get(key) == value) {
    				result = true;
    				break;
    			} else {
    				result = false;
    			}
    		}
    		if (result == false) {
    			break;
    		}
    	}	
        return result;
    }
    
    //@requires map != null
    //@ensures \forall K key; map.containsKey(key); \result.containsValue(Set.contains(key));
    //@ensures \forall V value; map.containsValue(value); \result.containsKey(value);
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> result = new HashMap<V, Set<K>>();
        Set<K> keySet = map.keySet();
        for (K key : keySet) {
        	V value = map.get(key);
        	Set<V> resultKeySet = result.keySet();
        	if (resultKeySet.contains(value)) {
        		result.get(value).add(key);
        	} else {
        		result.put(value, new HashSet<K>());
        		result.get(value).add(key);
        	}
        }
        return result;
	}
    
    //@requires map != null
    //@ensures \forall K key; map.containsKey(key); \result.containsValue(key);
    //@ensures \forall V value; map.containsValue(value); \result.containsKey(value);
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        Map<V, K> result = new HashMap<V, K>();
        Set<K> keySet = map.keySet();
        for (K key : keySet) {
        	V value = map.get(key);
        	result.put(value, key);
        }
        return result;
	}
	
	//@requires g != null && f != null
	//@ensures \result == \forall V value; f.containsValue(value); g.containsKey(value);
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        boolean result = true;
		Set<K> keySetF = f.keySet();
		Set<V> keySetG = g.keySet();
		for (K keyF : keySetF) {
			if (result == false) {
				break;
			}
			V value = f.get(keyF);
			if (keySetG.size() != 0) {
				for (V keyG : keySetG) {
					if (value == keyG) {
						result = true;
						break;
					} else {
						result = false;
					}
				}
			} else {
				result = false;
			}
		}
        return result;
	}
	
	//@requires g != null && f != null
	//@requires \forall V value; f.containsValue(value); g.containsKey(value);
	//@ensures \forall K key; \result.containsKey(key); f.containsKey(key) && g.containsKey(f.get(key)) && \result.containsValue(g.get(f.get(key)));
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        Map<K, W> result = new HashMap<K, W>();
        Set<K> keySetF = f.keySet();
		for (K keyF : keySetF) {
			W value = g.get(f.get(keyF));
			result.put(keyF, value);
		}
        return result;
	}
}
