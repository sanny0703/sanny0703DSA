package BinarySearchTree;

/**
 * Find inorder successor of a node in BST
 */
public class InorderSuccessor {
    public static int suc(TreeNode root,int key){
        TreeNode successor = null;
        while( root != null){
            if(key>=root.val){ // if key > then root is not a potential candidate, go right we find bigger values
                root = root.right;
            }else{
                successor = root; // if we found something,this can be a candidate ,but let's try can we find something less than this
                root = root.left;
            }
        }
        return successor!= null? successor.val:-1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5, new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)), new TreeNode(6));
        System.out.println(suc(root, 3));
    }
}
