package com.smk.linked_list;

public class MainLinkedList {
	public static void main(String[] args) {
		MyLinkedList ml = new MyLinkedList();
		ml.insertStart("First");
		ml.insertStart("Second");
		ml.insertStart("Third");
		ml.insertStart("Fourth");
		ml.insertStart("Fifth");
		
		ml.insertEnd("End1");
		ml.insertEnd("End2");
		ml.insertEnd("End3");
		
		ml.insertAfterKeY("Keydata1", "First");
		ml.insertAfterKeY("Keydata2", "Fourth");
		ml.insertAfterKeY("KeyData3", "Keydata1");
		ml.insertAfterKeY("Last", "End3");
		
		System.out.println(ml);
		
		ml.deleteStart();
		System.out.println(ml);
		ml.deleteEnd();
		System.out.println(ml);
		ml.deleteKey("End3");
		ml.deleteKey("End2");
		ml.deleteKey("Third");
		System.out.println(ml);
		
		ml.swap("KeyData3", "Fourth");
		System.out.println("Swapping " + ml);
	}
	
}
class MyLinkedList{
	Node root;
	int size;
	
	MyLinkedList(){
		root = new Node();
		root.setData("Root");
	}
	
	public void insertEnd(String data){
		Node node = new Node(data);
		
		if(root.getNext() == null){
			root.setNext(node);
		}else{
			Node temp = root.getNext();
			while(temp.getNext()!=null){
				temp = temp.getNext();
			}
			temp.setNext(node);
			node.setNext(null);
		}
		
	}
	
	public void insertAfterKeY(String data,String key){
		Node node = new Node(data);
		
		if(root.getNext() == null){
			root.setNext(node);
		}else{
			Node temp = root.getNext();
			while(temp.getNext()!=null && !temp.getData().equals(key)){
				temp = temp.getNext();
			}
			if(temp.getNext() == null && !temp.getData().equals(key)){
				System.out.println("Key not found");
				return;
			}
			
			Node temp1 = temp.getNext();
			temp.setNext(node);
			node.setNext(temp1);
		}
		
	}
	
	public void insertStart(String data){
		Node node = new Node(data);
		
		if(root.getNext() == null){
			root.setNext(node);
		}else{
			Node temp = root.getNext();
			root.setNext(node);
			node.setNext(temp);
		}
		
	}
	
	public void deleteStart(){
		Node nodeToBeDeleted = root.getNext();
		root.setNext(nodeToBeDeleted.getNext());
		nodeToBeDeleted = null;
	}
	
	public void deleteEnd(){
		
			Node nodeToBeDeleted = root.getNext();
			Node temp = null;
			while(nodeToBeDeleted.getNext()!=null){
				temp = nodeToBeDeleted;
				nodeToBeDeleted = nodeToBeDeleted.getNext();
			}
			temp.setNext(null);
			nodeToBeDeleted = null;
		
	}
	
	public void deleteKey(String key){
		
		Node nodeToBeDeleted = root.getNext();
		Node temp = null;
		while(nodeToBeDeleted.getNext()!=null && !nodeToBeDeleted.getData().equals(key)){
			temp = nodeToBeDeleted;
			nodeToBeDeleted = nodeToBeDeleted.getNext();
		}
		
		if(nodeToBeDeleted.getNext() == null && !nodeToBeDeleted.getData().equals(key)){
			System.out.println("Key not found");
			return;
		}
		temp.setNext(nodeToBeDeleted.getNext());
		nodeToBeDeleted = null;
	
	}
	
	public void swap(String key1,String key2){
		Node temp = root;
		Node[] nodes= new Node [4];
		int count=0;
		while(temp.getNext()!=null ){
			Node ptr = temp;
			temp = temp.getNext();
			
			if(temp.getData().equals(key1) || temp.getData().equals(key2)){
				nodes[count++] = ptr;
				nodes[count++] = temp;
			}
		}
		
		if(count == 4){
			Node temp1 = nodes[0];
			Node temp2 = nodes[1];
			Node temp3 = nodes[2];
			Node temp4 = nodes[3];
			
			temp1.setNext(temp4);
			Node temp5 = temp4.getNext();
			temp4.setNext(temp2.getNext());
			temp2.setNext(temp5);
			temp3.setNext(temp2);
			
		}
		
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		Node node = root.getNext();
		sb.append(" --> "+root.getData());
		while(node.getNext() !=null){
			sb.append(" --> "+node.getData());
			node = node.getNext();
		}
		sb.append(" --> "+node.getData());
		return sb.toString();
	}
	
	
	
	
	
}
