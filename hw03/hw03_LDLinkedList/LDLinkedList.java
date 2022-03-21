import java.util.AbstractList;

/**
 * my LinkedList implementation to use Lazy Deletion method
 * */
public class LDLinkedList<E> extends AbstractList<E> {
	private Node<E> recycleHead = null;
	private Node<E> head = null;
	private int size = 0;
	private int recycleSize = 0;
	
	/**
	 * inner class to create Nodes of Linked List
	 */
	private static class Node<E>{
		private E data;
		private Node<E> next;
		
		/**
		 *  Creates a new node with a null next field. 
		 *  @param data The data stored
		*/
		private Node(E data){
			this.data = data;
			this.next = null;
		}
		
		/** 
		 * Creates a new node that references another node. 
		 * @param data The data stored 
		 * @param nodeRef The node referenced by new node
		*/
		private Node(E data, Node<E> next) { 
			this.data = data;
			this.next = next;
		}
		
	}
	
	/** 
	 * Add First method to add new node to the head of the list.
	 * Before addition program controls the LazyDeletion list.
	 * @param generic reference to add Node
	 */
	public void addFirst(E that) {
		int index = isRemoved(that);
		if(index != -1) {
			Node<E> temp = getRecycleRef(index);
			Node<E> prev = null;
			head = new Node<>(temp.data, head);
			size++;
			if(index == 0) {
				recycleHead = recycleHead.next;
				recycleSize--;
			}
			else {
				temp = getRef(index);
				prev = getRef(index-1);
				prev.next = temp.next;
				recycleSize--;
			}
		}
		else {
			head = new Node<>(that, head);
			size++;
		}
	}
	
	/**
	 * add new node to the head of the lazy deletion list. 
	 */
	public void addRecycleFirst(E that) {
		recycleHead = new Node<>(that, recycleHead);
		recycleSize++;
	}
	
	/**
	 * if the node want to add main linked list
	 * program firstly search the lazy deletion linked list
	 * @param generic reference to search at the list
	 * @return index of removed node on lazy deletion linked list
	 * */
	public int isRemoved(E that) {
		Node<E> temp = recycleHead;
		int index = 0;
		while(temp != null) {
			if(temp.data.equals(that))
				return index;
			else {
				index++;
				temp = temp.next;
			}
		}
		return -1;
	}
	
	/**
	 * return reference from given index in lazy deletion list
	 * @param index 	index of reference
	 * @return reference at given index
	 **/
	public Node<E> getRecycleRef(int index) {
		Node<E> temp = recycleHead;
		if (index < 0 || index > recycleSize) { 
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	/**
	 * method for lazy deletion
	 * @param index index of reference
	 * */
	public void lazyDelete(int index) {
		Node<E> temp = head;
		Node<E> prev = null;
		if(index == 0) {
			head = head.next;
			addRecycleFirst(temp.data);
			size--;
		}
		else {
			temp = getRef(index);
			prev = getRef(index-1);
			addRecycleFirst(temp.data);
			prev.next = temp.next;
			size--;
		}
		
	}
	
	/**
	 * method for getting reference with given index
	 * from main linked list
	 * @param index of reference
	 * @return reference at given index
	 * */
	public Node<E> getRef(int index) {
		Node<E> temp = head;
		if (index < 0 || index > size) { 
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp;
	}
	
	/**
	 * @Override get method for generic reference at given index
	 * @param index of generic type
	 * 
	 * */
	@Override
	public E get(int index) {
		Node<E> temp = head;
		if (index < 0 || index >= size) { 
			throw new IndexOutOfBoundsException(Integer.toString(index));
		}
		for(int i = 0; i < index; i++) {
			temp = temp.next;
		}
		return temp.data;
	}
	
	/**
	 * overridden size method for linked list implementation*/
	@Override
	public int size() {
		return size;
	}
	
}
