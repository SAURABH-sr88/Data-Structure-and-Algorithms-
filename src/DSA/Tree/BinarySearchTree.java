package DSA.Tree;

import org.w3c.dom.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    Node root;

    public class Node{
        int data;
        Node left;
        Node right;

        public Node(int data){
            this.data = data;
        }
    }

    public Boolean insert(int data){
        Node node = new Node(data);
        if (root == null){
            root = node;
            return true;
        }
        Node temp = root;
        while (true){
            if (node.data == temp.data) return false;
            if (node.data < temp.data){
                if (temp.left == null){
                    temp.left = node;
                    return true;
                }
                temp = temp.left;
            }else {
                if (temp.right == null){
                    temp.right = node;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public Boolean contains(int data){
        Node temp = root;
        while (temp != null){
            if (data < temp.data){
                temp = temp.left;
            } else if (data > temp.data) {
                temp = temp.right;
            }else {
                return true;
            }
        }
        return false;
    }

    // Recursive Binary search tree

    private Boolean rContains(Node currentNode, int value){
        if (currentNode == null) return false;
        if (currentNode.data == value) return true;
        if (value < currentNode.data){
            return rContains(currentNode.left, value);
        }else {
            return rContains(currentNode.right, value);
        }
    }
    public Boolean rContains(int value){
        return rContains(root, value);
    }

    private Node rInsert(Node currentNode, int value){
        if (currentNode == null) return new Node(value);
        if (value < currentNode.data){
            currentNode.left = rInsert(currentNode.left, value);
        } else if (value > currentNode.data) {
            currentNode.right = rInsert(currentNode.right, value);
        }
        return currentNode;
    }
    public void rInsert(int value){
        if (root == null) root = new Node(value);
        rInsert(root, value);
    }

    private Node Delete(Node currentNode, int value){
        if (currentNode == null) return null;
        if (value < currentNode.data){
            currentNode.left = Delete(currentNode.left, value);
        }
        if (value > currentNode.data){
            currentNode.right = Delete(currentNode.right, value);
        }else {
            if (currentNode.right == null && currentNode.left == null){
                return null;
            } else if (currentNode.left == null) {
                currentNode = currentNode.right;
            } else if (currentNode.right == null) {
                currentNode = currentNode.left;
            }else {
                int subMinTree = minValue(currentNode.right);
                currentNode.data = subMinTree;
                currentNode.right = Delete(currentNode.right, subMinTree);
            }

        }
        return currentNode;
    }
    public void Delete(int value){
        root = Delete(root, value);
    }
    public int minValue(Node currentNode){
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode.data;
    }

    // Tree Traversal

    public ArrayList<Integer> BFS(){
        Node currentNode = root;
        Queue<Node> queue = new LinkedList<>();
        ArrayList<Integer> results = new ArrayList<>();
        queue.add(currentNode);
        while (queue.size() > 0) {
            currentNode = queue.remove();
            results.add(currentNode.data);
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return results;
    }

    public ArrayList<Integer> DFSPreorder(){
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse{
            Traverse (Node currentNode){
                results.add(currentNode.data);
                if (currentNode.left != null){
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null){
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSPostorder(){
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse{
            Traverse (Node currentNode){
                if (currentNode.left != null){
                    new Traverse(currentNode.left);
                }
                if (currentNode.right != null){
                    new Traverse(currentNode.right);
                }
                results.add(currentNode.data);
            }
        }
        new Traverse(root);
        return results;
    }

    public ArrayList<Integer> DFSInorder(){
        ArrayList<Integer> results = new ArrayList<>();
        class Traverse{
            Traverse (Node currentNode){
                if (currentNode.left != null){
                    new Traverse(currentNode.left);
                }
                results.add(currentNode.data);
                if (currentNode.right != null){
                    new Traverse(currentNode.right);
                }
            }
        }
        new Traverse(root);
        return results;
    }
}





