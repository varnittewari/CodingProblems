public class countUniValues{
    static int count = 0;

    public class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){

    }

    public static int solution(TreeNode root){
        if (root==null)
            return 0;
        if (isUniValued(root))
            count++;
        solution(root.left);
        solution(root.right);
        return count;
    }

    public static boolean isUniValued(TreeNode root){
        if (root==null)
            return true;
        if (root.left!=null && root.val!=root.left.val)
            return false;
        if (root.right!=null && root.val!=root.right.val)
            return false;
        return isUniValued(root.left) && isUniValued(root.right);
    }
}