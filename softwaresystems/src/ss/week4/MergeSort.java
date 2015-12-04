package ss.week4;

import java.util.*;
import java.util.LinkedList;

public class MergeSort {
	
	public static void main(String[] args) {
		List<Integer> testList = new ArrayList<>(Arrays.asList(3,6,5,4));
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
    		System.out.println(index);
    		List<Elem> firstList = list.subList(0, index);
    		System.out.println("Firstlist" + firstList);
    		List<Elem> first = mergesort(firstList);
    		System.out.println("First" + first);
    		List<Elem> secondList = list.subList(index, list.size());
    		System.out.println("Secondlist" + secondList);
    		List<Elem> second = mergesort(secondList);
    		System.out.println("Second" + second);
    		
    		//result = Collections.emptyList();
    		
    		int fi = 0;
    		int si = 0;
    		//System.out.println(first.size());
    		while (fi < first.size() && si < second.size()) {
    			//System.out.println("im here");
    			if (first.get(fi).compareTo(second.get(si)) < 0) {
    				result.add(first.get(fi));
    				fi++;
    				//System.out.println("added " + result);
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
    		System.out.println("semiresult" + result);
    		list = result;
    		System.out.println(list);
    		return result;
    	}
    }
}
