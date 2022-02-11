package leetcode.dfsandbfs;

import java.util.*;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 */
public class ShortestPath {

    public static class Solution{
        private int dir[][] = new int[][]{{0,1},{0,-1},{1,0},{-1,0},{1,-1},{-1,1},{-1,-1},{1,1}};

        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;

            if(grid[0][0] == 1 || grid[n-1][m-1] == 1) return -1;

            boolean[][] visited = new boolean[n][m];
            visited[0][0] = true;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});

            int ans = 0;
            //큐가 빌때까지 반복
            while (!queue.isEmpty()) {
                int size = queue.size();
                //큐 사이즈만큼 반복
                for(int i=0;i<size;i++) {
                    int[] pop = queue.poll();
                    //다왔다면
                    if(pop[0]==n-1 && pop[1]==m-1) {
                        return ans+1;
                    }
                    for (int k=0;k<8;k++) {
                        int nextX = dir[k][0]+pop[0];
                        int nextY = dir[k][1]+pop[1];

                        if(nextX>=0 && nextX<n && nextY>=0 && nextY<m && !visited[nextX][nextY] && grid[nextX][nextY]==0) {
                            queue.add(new int[]{nextX,nextY});
                            visited[nextX][nextY]=true;
                        }

                    }
                }
                ans++;
            }

            return -1;
        }
    }
}
