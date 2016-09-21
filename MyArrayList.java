package com.tian.rebuild;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> {

	private Object[] ele;
	
	private int size;
	
	private static final int defaultSize =10;
	
	
	public MyArrayList(int capacity){
		if(capacity<0){
			throw new IllegalArgumentException("数组长度不能小于零");
		}
		ele = new Object[capacity];
	}
	
	public MyArrayList(){
		this(defaultSize);
	}
	
	public boolean add(E e){
		ensureCapacity(size+1);
		ele[size++] = e;
		return true;
	}
	
	private void ensureCapacity(int nowCapacity){
		if(nowCapacity <= ele.length){
			return ;
		}else{
			//当前的数组已经饱和，需要扩容
			int newCapacity = 2 * size;
			ele = Arrays.copyOf(ele, newCapacity);
		}
	}
	
	public E get(int index){
		if(index<0||index>=size){
			throw new IllegalArgumentException("不合法的索引");
		}
		return (E)ele[index];
	}
	
	public Ite iterator(){
		return new Ite();
	}
	
	private class Ite implements Iterator<E>{
		
		private int curtor;
		
		@Override
		public boolean hasNext() {
			
			return curtor < size;
		}
		
		@Override
		public E next() {
			// TODO Auto-generated method stub
			return (E)ele[curtor++];
		}
		
		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
	
}
