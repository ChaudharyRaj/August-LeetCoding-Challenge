/*Given a binary tree, return the vertical order traversal of its nodes values.

For each node at position (X, Y), its left and right children respectively will be at positions (X-1, Y-1) and (X+1, Y-1).

Running a vertical line from X = -infinity to X = +infinity, whenever the vertical line touches some nodes, we report the values of the nodes in order from top to bottom (decreasing Y coordinates).

If two nodes have the same position, then the value of the node that is reported first is the value that is smaller.

Return an list of non-empty reports in order of X coordinate.  Every report will have a list of values of nodes.

 

Example 1:



Input: [3,9,20,null,null,15,7]
Output: [[9],[3,15],[20],[7]]
Explanation: 
Without loss of generality, we can assume the root node is at position (0, 0):
Then, the node with value 9 occurs at position (-1, -1);
The nodes with values 3 and 15 occur at positions (0, 0) and (0, -2);
The node with value 20 occurs at position (1, -1);
The node with value 7 occurs at position (2, -2).
Example 2:



Input: [1,2,3,4,5,6,7]
Output: [[4],[2],[1,5,6],[3],[7]]
Explanation: 
The node with value 5 and the node with value 6 have the same position according to the given scheme.
However, in the report "[1,5,6]", the node value of 5 comes first since 5 is smaller than 6.
 

Note:

The tree will have between 1 and 1000 nodes.
Each node's value will be between 0 and 1000.*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
class Solution {
    
    class NewRoot{
        TreeNode root;
        int row;
        int column;
        NewRoot(TreeNode t, int r, int col){
            this.root=t; this.row=r; this.column=col;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root){
        Map<Integer, List<NewRoot>> map=new TreeMap<>();
        Queue<NewRoot> queue=new LinkedList<>();
        List<List<Integer>> res=new ArrayList<>();
        if(root==null) return res;
        queue.offer(new NewRoot(root,0,0));
        
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                NewRoot tmp=queue.poll();
                TreeNode tmpNode=tmp.root;
                int tmpRow=tmp.row;
                int tmpCol=tmp.column;
                List<NewRoot> tmpList=map.getOrDefault(tmpCol, new ArrayList<>());
                tmpList.add(tmp);
                map.put(tmpCol, tmpList);
                if(tmpNode.left!=null){
                    queue.offer(new NewRoot(tmpNode.left, tmpRow+1, tmpCol-1));
                }
                if(tmpNode.right!=null){
                    queue.offer(new NewRoot(tmpNode.right, tmpRow+1, tmpCol+1));
                }
            }
        }
        
        for(Map.Entry<Integer, List<NewRoot>> entry:map.entrySet()){
            List<NewRoot> list=entry.getValue();
            List<Integer> result=new ArrayList<>();
            Collections.sort(list, (a,b)->{
               if(a.row==b.row){
                   return a.root.val-b.root.val;
               } else{
                   return a.row-b.row;
               }
            });
            for(NewRoot nr:list){
                result.add(nr.root.val);
            }
            res.add(result);
        } 
        return res;
    }
}