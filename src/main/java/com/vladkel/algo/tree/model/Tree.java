package com.vladkel.algo.tree.model;

import java.util.ArrayList;
import java.util.List;

public class Tree<T> {

	private T value;
	
	private Tree<T> [] children;
	
	/*
	 * Constructors
	 */
	public Tree(T value){
		this.setValue(value);
		this.setChildren(new Tree[0]);
	}
	
	public Tree(T value, Tree<T> [] children){
		this.setValue(value);
		this.setChildren(children);
	}

	
	/*
	 * Utils
	 */
	
	/**
	 * @return the size of the tree
	 * The size of a tree is the number of nodes contained by the tree
	 */
	public int size(){
		int size = 1;
		
		for(Tree<T> tree : children){
			size += tree.size();
		}
		
		return size;
	}
	
	/**
	 * @return the height of the tree
	 * The height of a tree is its max number levels
	 */
	
	public int height(){
		return height(0, 0);
	}
	
	public int height(int height, int maxHeight){
		
		height += 1;
		
		if(height > maxHeight)
			maxHeight = height;
		
		for(Tree<T> tree : children){
			maxHeight = tree.height(height, maxHeight);
		}
		
		return maxHeight;
	}
	
	
	public void readInWidth(){
		
		System.out.println("Lecture horizontale : ");
		
		List<Tree> nodes = new ArrayList<Tree>();
		List<Tree> childrens = new ArrayList<Tree>();
		nodes.add(this);
		
		while(nodes.size() > 0){
			for(Tree tree : nodes){
				System.out.println(tree.getValue());
				for(Tree node : tree.getChildren()){
					childrens.add(node);
				}
			}
			nodes.removeAll(nodes);
			nodes.addAll(childrens);
			childrens.removeAll(childrens);
		}
	}
	
	
	/*
	 * Getters ans setters
	 */
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Tree<T> [] getChildren() {
		return children;
	}

	public void setChildren(Tree<T> [] children) {
		this.children = children;
	}
	
	
}
