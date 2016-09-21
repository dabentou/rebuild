package com.tian.rebuild;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList<E> {

	private Object[] ele;
	
	private int size;
	
	private static final int defaultSize =10;
	
	
	public MyArrayList(int capacity){
		if(capacity<0){
			throw new IllegalArgumentException("���鳤�Ȳ���С����");
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
			//��ǰ�������Ѿ����ͣ���Ҫ����
			int newCapacity = 2 * size;
			ele = Arrays.copyOf(ele, newCapacity);
		}
	}
	
	public E get(int index){
		if(index<0||index>=size){
			throw new IllegalArgumentException("���Ϸ�������");
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
