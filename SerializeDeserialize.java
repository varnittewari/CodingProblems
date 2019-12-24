import java.util.*;

/*Given the root to a binary tree, implement serialize(root), which serializes the tree into a string, 
and deserialize(s), which deserializes the string back into the tree. */

public class SerializeDeserialize {

    public static void main(String[] args){
        
    }

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root==null)
            return "";
        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder ans = new StringBuilder();
        TreeNode curr = root;
        boolean allNulls = false;
        q.add(curr);
        while (!q.isEmpty() && !allNulls){
            int size = q.size();
            allNulls= true;
            for (int i=0 ; i < size; i++){
                curr = q.remove();
                if (curr==null){
                    ans.append("null,");
                    continue;
                }
                if (curr.left!=null || curr.right!=null)
                    allNulls = false;
                ans.append(curr.val+",");
                q.add(curr.left);
                q.add(curr.right);
            }
        }
        ans.deleteCharAt(ans.length()-1);
        return ans.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("") || data.equals("null"))
            return null;
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        int idx = 1;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode curr = root;
        q.add(curr);
        while (!q.isEmpty() && idx<nodes.length){
            int size = q.size();
            for (int i=0; i<size; i++){
                curr = q.remove();
                String left = idx<nodes.length?nodes[idx++]:"null";
                String right = idx<nodes.length?nodes[idx++]:"null";
                if (!left.equals("null")){
                    curr.left = new TreeNode(Integer.parseInt(left));
                    q.add(curr.left);
                }
                if (!right.equals("null")){
                    curr.right = new TreeNode(Integer.parseInt(right));
                    q.add(curr.right);
                }
            }
        }
        return root;
    }
}