package com.vladkel.algo.sort.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Sort<T> {

	private T [] array;
	
	public Sort(){
		super();
		setArray((T[]) new Object[0]);
	}
	
	public T [] getArray() {
		return array;
	}

	public void setArray(T [] array) {
		this.array = array;
	}
	
	public void sort(SortType sortType){
		
		switch (sortType) {
			case tri_par_insertion:
				sortByInsertion();
				break;
			case tri_par_selection:
				sortByInsertion();
				break;
			case tri_a_bulle:
				sortByBulle();
				break;
			case tri_fusion:
				sortByFusion();
				break;
	
			default:
				break;
		}
		
	}
	
	public void display(){
		for(T t : array){
			System.out.print(t + "|");
		}
		System.out.println();
	}
	
	public int compare(T t, T u){
		if(t.getClass() == String.class){
			return t.toString().compareTo(u.toString());
		}
		if(t.getClass() == Character.class){
			return t.toString().compareTo(u.toString());
		}
		else if(t.getClass() == Integer.class){
			return Integer.parseInt(t.toString()) - Integer.parseInt(u.toString());
		}
		else if(t.getClass() == Double.class){
			return (int) (Double.parseDouble(t.toString()) - Double.parseDouble(u.toString()));
		}
		else if(t.getClass() == Long.class){
			return (int) (Long.parseLong(t.toString()) - Long.parseLong(u.toString()));
		}
		return 0;
	}
	
	public void sortByInsertion(){
		for(int i = 1; i < array.length; i++){
			T t = array[i];
			int j = i;
			while(j > 0 && compare(t, array[j - 1]) < 0){
				array[j] = array[j - 1];
				j = j - 1;
			}
			array[j] = t;
		}
	}
	
	public void sortBySelection(){
		int min;
		for(int i = 0; i < array.length; i++){
			min = i;
			for(int j = i; j < array.length; j++){
				if(compare(array[min], array[j]) < 0){
					min = j;
				}
			}
			if(min != i){
				array[min] = array[i];
				array[i] = array[min];
			}
		}
	}
	
	public void sortByBulle(){
		boolean permut = true;
		while(permut){
			permut = false;
			for(int i = 0; i < array.length - 1; i++){
				if(compare(array[i], array[i + 1]) > 0){
					T temp = array[i + 1];
					array[i + 1] = array[i];
					array[i] = temp;
					permut = true;
				}
			}
		}
	}
	
	public void sortByFusion(){
		List<List<T>> lists = new ArrayList<List<T>>();
		for(int i = 0; i < array.length - 1; i++){
			List<T> l = new ArrayList<T>();
			l.add(array[i]);
			if(i+1 <= array.length - 1)
			l.add(array[i+1]);
			i++;
			lists.add(l);
		}
		
		List<T> finalList = new ArrayList<T>();
		
		Scanner sc = new Scanner(System.in);
		for(List<T> l : lists){
			finalList = fusion(finalList, l);
			for(T t : finalList){
				System.out.print(t + "|");
			}
			System.out.println();
			sc.nextLine();
		}
		
		for(int i = 0; i < finalList.size(); i++){
			array[i] = finalList.get(i);
		}
	}
	
	public List<T> fusion(List<T> l, List<T> m){
		List<T> list = new ArrayList<T>();
		int indexL = 0, 
			indexM = 0;
		
		while(list.size() != (l.size() + m.size())){
			if(indexL < l.size() && indexM < m.size()){
				if(compare(l.get(indexL), m.get(indexM)) < 0){
					list.add(l.get(indexL));
					indexL++;
				}
				else{
					list.add(m.get(indexM));
					indexM++;
				}
			}
			else if(indexL < l.size() && indexM >= m.size()){
				list.add(l.get(indexL));
				indexL++;
			}
			else if(indexL >= l.size() && indexM < m.size()){
				list.add(m.get(indexM));
				indexM++;
			}
		}
		
		return list;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
