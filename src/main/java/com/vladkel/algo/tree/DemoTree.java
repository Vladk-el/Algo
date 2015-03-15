package com.vladkel.algo.tree;

import com.vladkel.algo.tree.model.Tree;

public class DemoTree {
	
	public static void main(String [] args){
		
		simpleDemo();
		
	}
	
	public static void simpleDemo(){
		
		Tree tree = createTree();
		
		System.out.println("tree.size() : " + tree.size());
		
		System.out.println("tree.height() : " + tree.height());
		
		tree.readInWidth();
		
		
	}
	
	public static <T> Tree createTree(){
		
		Tree d = new Tree("D"); // ==> Feuille
		Tree e = new Tree("E");
		Tree g = new Tree("G");
		Tree h = new Tree("H");
		Tree i = new Tree("I");
		
		Tree f = new Tree("F", new Tree[]{g, h, i});
		
		Tree c = new Tree("C", new Tree[]{f});
		
		Tree b = new Tree("B", new Tree[]{d, e});
		
		Tree a = new Tree("A", new Tree[]{b, c}); // ==> Racine
		
		
		return a;
	}

}
