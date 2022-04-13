import java.util.Comparator;

public class HeapTree<E extends Comparable<E>> extends BinaryTree<E>
        implements Comparator<E> {
    private int height;
    private int totalNodes;
    private int powerOf2;

    /**
     * Constructor for HeapTree class
     */
    HeapTree(){
        height = 0;
        totalNodes = 0;
        powerOf2 = 0;
    }

    /**
     * compare method to make comparisons between two comparable object
     * @param obj1 comparable object
     * @param obj2 comparable object
     * @return an integer value according to the result
     */
    public int compare(E obj1, E obj2)
    {
        return obj1.compareTo(obj2);
    }

    /**
     * recursive method to make heap from a binary tree
     * @param node
     */
    private void heapify(Node<E> node){
        if (node.parent == null){
            root = node;
            return;
        }
        else if(compare(node.data, node.parent.data) < 0){
            if(node.right != null){
                node.right.parent = node.parent;
            } if (node.left != null){
                node.left.parent = node.parent;
            }

            if(node.parent.left == node){
                node.parent.left = node.parent;
            } else {
                node.parent.right = node.parent;
            }

            Node<E> temp_right = node.right;
            Node<E> temp_left = node.left;

            node.right = node.parent.right;
            node.left = node.parent.left;
            node.parent.right = temp_right;
            node.parent.left = temp_left;

            node.parent = node.parent.parent;
            if(node.parent != null){
                if(node.parent.left == node){
                    node.parent.left = node;
                } else {
                    node.parent.right = node;
                }
            }
            heapify(node);
        }
    }

    /**
     * recursive add method to insert new elements to the heap
     * @param target object to add
     * @param limit max height of heap
     * @param current current height of heap
     * @param parentNode current node at the recursion
     * @return boolean value according to the result
     */
    private boolean add(E target, int limit, int current, Node<E> parentNode){
        if(limit == 0){
            this.root = new Node<>(target);
            return true;
        }
        if(limit - 1 == current){
            if(parentNode.left == null){
                parentNode.left = new Node<>(target, parentNode);
                heapify(parentNode.left);
                return true;
            } else if(parentNode.right == null){
                parentNode.right = new Node<>(target, parentNode);
                heapify(parentNode.right);
                return true;
            }
            return false;
        } else {
            if(add(target, limit, current+1, parentNode.left))
                return true;
            else return add(target, limit, current + 1, parentNode.right);
        }
    }

    /**
     * public add method to insert new node to the heap
     * @param target object to insert
     */
    public void add(E target){
        totalNodes++;
        add(target, height, 0, root);
        if(powerOf2 == 0){
            totalNodes = 0;
            powerOf2=2;
            height++;
        } else if(totalNodes == powerOf2){
            totalNodes = 0;
            powerOf2 *= 2;
            height++;
        }
    }
}
