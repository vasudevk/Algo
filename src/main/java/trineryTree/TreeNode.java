package trineryTree;

/**
 * Created by amit.k.mannur on 3/29/2018.
 */

public class TreeNode {

        private int count=1;
        private TreeNode parent;
        private TreeNode left;
        private TreeNode right;
        private int data;

        public int getData() {
            return data;
        }
        public void setData(int data) {
            this.data = data;
        }
        public int getCount() {
            return count;
        }
        public void setCount(int count) {
            this.count = count;
        }
        public TreeNode getParent() {
            return parent;
        }
        public void setParent(TreeNode point) {
            this.parent = point;
        }
        public TreeNode getLeft() {
            return left;
        }
        public void setLeft(TreeNode left) {
            this.left = left;
        }
        public TreeNode getRight() {
            return right;
        }
        public void setRight(TreeNode right) {
            this.right = right;
        }
}
