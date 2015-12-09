package ss.week4;

import java.util.*;
import java.util.LinkedList;

public class MergeSort {
	
	public static void main(String[] args) {
		List<Integer> testList = new ArrayList<>(Arrays.asList(3,6,5,4,45,74,346,734,2346,734,4,64,236,47,2364,84));
		List<Integer> result = mergesort(testList);
		System.out.println(testList);
		System.out.println("RESULT" + result);
	}
	
    public static <Elem extends Comparable<Elem>> List<Elem> mergesort(List<Elem> list) {
    	List<Elem> result = new ArrayList<>();
    	if (list.size() <= 1) {
    		result = list;
    		return result;
    	} else {
    		int index = list.size()/2;
    		List<Elem> firstList = list.subList(0, index);
    		List<Elem> first = mergesort(firstList);
    		List<Elem> secondList = list.subList(index, list.size());
    		List<Elem> second = mergesort(secondList);
    		
    		int fi = 0;
    		int si = 0;
    		while (fi < first.size() && si < second.size()) {
    			if (first.get(fi).compareTo(second.get(si)) < 0) {
    				result.add(first.get(fi));
    				fi++;
    			} else {
    				result.add(second.get(si));
    				si++;
    			}
    		}
    		if (fi < first.size()) {
    			result.addAll(first.subList(fi, first.size()));
    		} else if(si < second.size()) {
    			result.addAll(second.subList(si, second.size()));
    		}
    		return result;
    	}
    }
}
