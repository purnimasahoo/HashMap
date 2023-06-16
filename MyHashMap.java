package Map;

import java.util.ArrayList;
import java.util.LinkedList;

public class MyHashMap {
	
	private class Node{
		
		private int key, value;
		
		public Node(int k, int v) {
			key=k;
			value=v;
		}
	}
	
	private ArrayList<LinkedList> list;
	
	private int size=10;
	
	public MyHashMap() {
		list = new ArrayList<>(10);
		
		for(int i=0; i<size; i++) {
			list.add(i, new LinkedList<Node>());
		}
	}
	
	public void put(int key, int value) {
		
		int hash = key%size;
		
		LinkedList<Node> l = list.get(hash);
		
		boolean found = false;
		
		for(int i=0; i<l.size(); i++) {
			
			if(l.get(i).key == key) {
				found=true;
				l.get(i).value= value;
				return;
			}
		}
		
		if(!found) {
			l.add(new Node(key, value));
		}
	}
	
	public int get(int key) {
		
		int hash = key%size;
		
		LinkedList<Node> l = list.get(hash);
		
		for(int i=0; i<l.size(); i++) {
			
			if(l.get(i).key == key) {
				return l.get(i).value;
			}
		}
		
		return -1;		
	}
	
	public void remove(int key) {
		
		int hash= key%size;
		
		LinkedList<Node> l = list.get(hash);
		
		for(int i=0; i<l.size(); i++) {
			
			if(l.get(i).key == key) {
				l.remove(i);
			}
		}
	}
	
	public static void main(String args[]) {
		MyHashMap obj = new MyHashMap();
		obj.put(1,1);
		int param_2 = obj.get(1);
		System.out.println(param_2);
		obj.remove(1);
		int param_1 = obj.get(1);
		System.out.println(param_1);
	}

}
