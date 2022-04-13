import java.awt.*;
import java.util.Comparator;
import java.lang.Comparable;

public class ArrayBST<E extends Comparable<E>>
        implements SearchTree<E>, Comparator<E>
{
    private Object [] container;
    private int size;

    public ArrayBST(){
        size = 0;
        container = new Object[2];
    }

    public Object[] getContainer() {
        return container;
    }

    public void setContainer(Object[] container) {
        this.container = container;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    /**
     * getter method for parent object in array
     * @param i index of child object
     * @return data of Parent object
     */
    public E getParent(int i){
        return (E) container[(i-1)/2];
    }

    /**
     * getter method for object's left child in array
     * @param i index of object
     * @return left child of the object
     */
    public E getLeftChild(int i){
        return (E) container[(2 * i) + 1];
    }

    /**
     * getter method for object's right child in array
     * @param i index of object
     * @return right child of the object
     */
    public E getRightChild(int i){
        return (E) container[2 * (i + 1)];
    }

    /**
     * implemented compare method for ArrayBST class
     * @param obj1 object to compare
     * @param obj2 object to compare
     * @return result of the comparison
     */
    public int compare(E obj1, E obj2)
    {
        return obj1.compareTo(obj2);
    }

    /**
     * swap method for container data field
     * @param i index to change
     * @param j index to change
     */
    private void swap(int i, int j){
        if(getSize() <= 0) return;
        E temp = (E) container[i];
        container[i] = container[j];
        container[j] = temp;
    }

    /**
     * reallocate method for container data field
     */
    private void reallocate(){
        Object[] temp = new Object [getSize()*2];
        for (int i = 0; i < getContainer().length; i++) {
            temp[i] = container[i];
        }
        setContainer(temp);
    }

    /**
     * isLeaf method to check a node if it is a leaf or not
     * @param index index of the node
     * @return boolean value according to the result
     */
    public boolean isLeaf(int index){
        if(getLeftChild(index) == null && getRightChild(index) == null){
            return true;
        } else {
            return false;
        }
    }

    /**
     * boolean removal method for ArrayBST class
     * @param target object to delete from container
     * @return boolean value according to the result
     */
    public boolean remove(E target){
        return true;
    }

    /**
     * find and return largest value in left child of a node
     * @param index index of the object
     * @return index value of the largest element
     */
    public int searchLeftLarge(int index){
        /*if(2 * (index + 1) >= container.length || container[index] == null){
            return -1;
        }
        if (container[2 * (index + 1)] != null) {
            return searchLeftLarge(2 * (index + 1));
        }*/
        return index;
    }

    /**
     * recursive swap algorithm to help removal methods
     * @param index old index of the object
     * @param newIndex new index of the object
     */
    public void recursiveSwap(int index, int newIndex){
        /*if(2*(index+1) >= container.length){
            return;
        }
        if(container[2*(index+1)] != null){
            if(container[2*(newIndex+1)] == null){
                container[2*(newIndex+1)] = container[2*(index+1)];
            } else {
                add((E) container[2*(newIndex+1)]);
                container[2*(newIndex+1)] = null;
            }
            recursiveSwap(2*(index+1), 2*(newIndex+1));

        }
        if(container[(2*index)+1] != null){
            if (container[(2 * newIndex) + 1] == null) {
                container[(2*newIndex)+1] = container[(2*index)+1];
            } else {
                add((E) container[2*(newIndex+1)]);
                container[(2*newIndex)+1] = null;
            }
            recursiveSwap((2*index)+1, (2*newIndex)+1);
        }*/
    }

    /**
     * removal method for ArrayBST class
     * @param target object to delete from container
     * @return data of removed element from container
     */
    public E delete(E target){
        /*int index = 0;
        while(true){
            if(index >= container.length){
                break;
            }
            int result = compare(target, (E) container[index]);
            if (result == 0){
                //no child
                if(isLeaf(index)){
                    E temp = (E) container[index];
                    container[index] = null;
                    return temp;
                } else if(getLeftChild(index) == null && getRightChild(index) != null){ //only has a right child

                } else if(getLeftChild(index) != null && getRightChild(index) == null){ //only has a left child

                } else if(getLeftChild(index) != null && getRightChild(index) != null){
                    int temp = searchLeftLarge((2*index)+1);
                    if(temp != -1){
                        container[index] = container[temp];
                        container[temp] = null;
                        //recursiveSwap(temp, index);
                    }
                }
                break;
            } else if(result < 0){
                index = (2 * index) + 1;
            } else {
                index = 2 * (index + 1);
            }
        }*/
        return target;
    }

    /**
     * implemented add method to insert new objects to ArrayBST class
     * @param item object to insert
     * @return boolean value according to the result
     */
    public boolean add(E item){
        size++;
        int index = 0;
        while(true){
            if(index >= getContainer().length || getSize() >= getContainer().length){
                reallocate();
            }
            if(container[index] == null){
                container[index] = item;
                break;
            }
            if(compare(item, (E) container[index]) <= 0){
                index = (2 * index) + 1;
            } else {
                index = 2 * (index + 1);
            }
        }
        return true;
    }

    /**
     * search method for ArrayBST class
     * @param target object to search
     * @return true if it is found, else return false
     */
    public boolean contains(E target){
        if(find(target) != null){
            return true;
        } else {
            return false;
        }
    }

    /**
     * search method for ArrayBST class
     * @param target object to search
     * @return object which is found
     */
    public E find(E target){
        return find(target, 0);
    }

    /**
     * recursive search algorithm for ArrayBST class
     * @param target object to search
     * @param parent index of searched element
     * @return object which is found
     */
    private E find(E target, int parent){
        if(parent >= getContainer().length){
            return null;
        }
        if(container[parent] == null){
            return null;
        }
        if(compare(target, (E) container[parent]) == 0){
            return (E) container[parent];
        } else if(compare(target, (E) container[parent]) < 0){
            return find(target, (2 * parent) + 1); // search left subtree
        } else {
            return find(target, 2 * (parent + 1)); // search right subtree
        }
    }

    /**
     * Overridden toString method to print ArrayBST to the console
     * @return formatted string
     */
    public String toString() {
        for (var element:
                getContainer()) {
            if(element == null){
                System.out.print("- ");
            } else {
                System.out.print(element + " ");
            }
        }
        return String.format("");
    }

}

