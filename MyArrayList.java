import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class MyArrayList<E> {

	private Object[] ele;
	
	private int defaultSize = 10;
	
	private int size;
	
	private Object[] nullEle = {};
	
	public MyArrayList(int length){
		ele = new Object[length];
	}
	
	public MyArrayList(){
		ele = new Object[defaultSize];
	}
	
	public int size(){
		return size;
	}
	
	//往数组后边拼接，也可以向中间插入
	public void add(E e){
		//要判断数组是否越界
		if(size>=ele.length)
			enlarge();
		ele[size++] = e;
	}
	
	public void enlarge(){
		System.out.println("我扩容了");
		//每次扩容，容量变为之前的两倍
		ele = Arrays.copyOf(ele, ele.length*2);
	}
	
	public E get(int index){
		//要判断index是否越界超过size（数组的长度）
		if(index >=size){
			System.out.println("我的异常");
			throw new IndexOutOfBoundsException();
		}
		return (E)ele[index];
	}
	
	public E remove(int index){
		if(index < size){
			E obj = (E)ele[index];
			System.arraycopy(ele, index+1, ele, index, size-index-1);
			ele[--size] = null;
			return obj;
		}else{
			throw new IndexOutOfBoundsException();
		}
	}
	
	public Iterator itereator(){
		return new Ite();
	}
	
	private class Ite implements Iterator{
		
		private int curtor;
		
		
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return curtor<size;
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
