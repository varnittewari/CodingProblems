public class countUniValues{
    static int count = 0;

    public static class TreeNode{
        public int val;
        public TreeNode left;
        public TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){
        TreeNode n1 = new TreeNode(0);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(0);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        n4.left = n6;
        n4.right = n7;
        System.out.println(solution(null));
        count = 0;
        System.out.println(solution(n1));
        count = 0;
        System.out.println(solution(n3));
        count = 0;
        System.out.println(solution(n7));
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