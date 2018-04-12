package trineryTree;

/**
 * Created by amit.k.mannur on 3/29/2018.
 */

public class TrinaryTree {
    private TreeNode root;

    /**
     * @param args
     */
    public static void main(String[] args) {
        TrinaryTree tree = new TrinaryTree();
        int[] a = {5, 4, 9, 5, 7, 2, 2};
        for (int anA : a) {
            tree.insert(anA);
        }
        tree.display(tree.getRoot());
        System.out.println();
        System.out.println();
        boolean flag = tree.remove(5);
        if (flag) {
            System.out.println("Element Removed Successfully");
            tree.display(tree.getRoot());
        } else {
            System.out.println("Element Not Found");
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    private void insert(int data) {
        TreeNode node = new TreeNode();
        node.setData(data);

        if (root == null) {
            root = node;
        } else {
            TreeNode pointer = root;

            while (pointer != null) {
                node.setParent(pointer);
                if (pointer.getData() > data)
                    pointer = pointer.getLeft();
                else if (pointer.getData() < data)
                    pointer = pointer.getRight();
                else {
                    pointer.setCount(pointer.getCount() + 1);
                    break;
                }

            }
            pointer = node.getParent();
            if (pointer.getData() > node.getData())
                node.getParent().setLeft(node);
            else if (pointer.getData() < node.getData())
                node.getParent().setRight(node);

        }
    }

    public boolean remove(int value) {
        TreeNode pointer = root;
        if (pointer == null) {
            return false;
        } else {
            if (pointer.getData() == value) {

                if (pointer.getCount() > 1) {
                    pointer.setCount(pointer.getCount() - 1);
                    return true;
                } else if (pointer.getCount() == 1) {

                    TreeNode children = pointer.getRight();
                    TreeNode child = children;
                    TreeNode previous = new TreeNode();
                    while (children != null) {
                        previous = children;
                        children = children.getLeft();
                    }
                    children = previous;
                    children.setData(child.getData());
                    child = null;
                    return true;
                }
            }
        }
        return false;
    }

    public void display(TreeNode root) {
        if (root == null) {
            return;
        }
        for (int i = 1; i <= root.getCount(); i++) {
            System.out.println(root.getData());
        }
        display(root.getLeft());
        display(root.getRight());

    }
}
