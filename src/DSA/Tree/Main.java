package DSA.Tree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree myBst = new BinarySearchTree();
        myBst.insert(47);
        myBst.insert(21);
        myBst.insert(76);
        myBst.insert(18);
        myBst.insert(27);
        myBst.insert(52);
        myBst.insert(82);

        System.out.println(myBst.BFS());
        System.out.println(myBst.DFSPreorder());
        System.out.println(myBst.DFSPostorder());
        System.out.println(myBst.DFSInorder());
    }
}
