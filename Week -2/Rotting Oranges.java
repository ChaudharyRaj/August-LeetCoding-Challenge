/*In a given grid, each cell can have one of three values:

the value 0 representing an empty cell;
the value 1 representing a fresh orange;
the value 2 representing a rotten orange.
Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.


Input: [[2,1,1],[1,1,0],[0,1,1]]
Output: 4
Example 2:

Input: [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.
Example 3:

Input: [[0,2]]
Output: 0
Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 

Note:

1 <= grid.length <= 10
1 <= grid[0].length <= 10
grid[i][j] is only 0, 1, or 2.*/


class Solution {
    
    class pair{
        int x;
        int y;
        pair(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int orangesRotting(int[][] grid) {
    
        Queue<pair> q = new LinkedList<>();
        int time = 0, rotten = 0, total = 0;
        
        for(int i =0; i< grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 || grid[i][j] == 2) total++;
                
                if(grid[i][j] == 2) q.add(new pair(i,j)); 
            }
        }
        
        if(total == 0) return 0;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            rotten += size;
            if(rotten ==   total) return time;
            time++;
            
            for(int i=0; i<size; i++){
                pair p = q.peek();
                
                if(p.x + 1 < grid.length && grid[p.x + 1][p.y] == 1){
                    grid[p.x + 1][p.y] = 2;
                    q.add(new pair(p.x + 1,p.y));
                }
                
                if(p.x - 1 >= 0 && grid[p.x -1][p.y] == 1){
                    grid[p.x -1][p.y] = 2;
                    q.add(new pair(p.x - 1, p.y));
                }
                
                if(p.y + 1 < grid[0].length && grid[p.x][p.y + 1] == 1){
                    grid[p.x][p.y + 1] = 2;
                    q.add(new pair(p.x, p.y + 1));
                }
                
                if(p.y - 1 >= 0 && grid[p.x][p.y -1] == 1){  
                    grid[p.x][p.y -1] = 2;
                    q.add(new pair(p.x, p.y -1));
                }
                q.poll();
            }
        }
        return -1;
    }
}