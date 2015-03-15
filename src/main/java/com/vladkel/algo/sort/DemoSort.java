package com.vladkel.algo.sort;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.vladkel.algo.sort.model.Sort;
import com.vladkel.algo.sort.model.SortType;

public class DemoSort {

	/**
	 * http://lwh.free.fr/
	 * http://fr.wikipedia.org/wiki/Tri_par_insertion
	 */
	
	public static void main(String [] args){
		
		Integer [] array = createArray(); 
							//{9, 3, 7, 1, 6, 10, 4, 2, 5, 8};
		
		Sort sort = new Sort();
		
		sortByType(sort, array, SortType.tri_par_insertion);
		
		sortByType(sort, array, SortType.tri_par_selection);
		
		sortByType(sort, array, SortType.tri_a_bulle);
	}
	
	public static void sortByType(Sort sort, Integer [] array, SortType sortType){
		
		Date b = new Date();
		
		sort.setArray(array.clone());
		System.out.print(sortType + " : ");
		sort.display();
		sort.sort(sortType);
		sort.display();
		
		Date e = new Date();
		System.out.println("Took " + (e.getTime() - b.getTime()) + " ms");
	}
	
	public static Integer [] createArray(){
		List<Integer> list = new ArrayList<Integer>();
		Random randomGenerator = new Random();
		for(int i = 0; i < 1000; i++){
			list.add(randomGenerator.nextInt(10000));
		}
		
		Integer [] ret = new Integer[list.size()];
	    int i = 0;
	    for (Integer e : list)  
	        ret[i++] = e.intValue();
		return ret;
	}
}
