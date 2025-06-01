//ChatGPT optimization



class Solution {
    
    // Function to calculate the minimum absolute difference in a kxk grid
    private int findMinAbsDiff(TreeSet<Integer> set) {
        List<Integer> list = new ArrayList<>(set);
        int minDiff = Integer.MAX_VALUE;

        for (int i = 1; i < list.size(); i++) {
            int diff = Math.abs(list.get(i) - list.get(i - 1));
            minDiff = Math.min(minDiff, diff);
        }
        return minDiff == Integer.MAX_VALUE ? 0 : minDiff;
    }
    
    public int[][] minAbsDiff(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m - k + 1][n - k + 1];

        // Iterate over all subgrids
        for (int i = 0; i <= m - k; i++) {
            for (int j = 0; j <= n - k; j++) {
                TreeSet<Integer> set = new TreeSet<>();
                
                // Collect all elements in the kxk subgrid
                for (int x = i; x < i + k; x++) {
                    for (int y = j; y < j + k; y++) {
                        set.add(grid[x][y]);
                    }
                }

                // Find minimum absolute difference in the collected elements
                ans[i][j] = findMinAbsDiff(set);
            }
        }
        
        return ans;
    }
}






//My solution

class Solution {

    void findDistinct(int i,int j,int grid[][],int k,TreeSet<Integer> t) {
        int m = grid.length;
        int n = grid[0].length;

        for(int x = i; x < (i + k);x++) {
            for(int y = j; y < (j + k);y++) {
                t.add(grid[x][y]);
            }
        }

    }

    public int[][] minAbsDiff(int[][] grid, int k) {
         int m = grid.length;
        int n = grid[0].length;
        int ans[][] = new int[m-k+1][n-k+1];

        for(int i = 0;i < m-k+1;i++) {
            for(int j = 0;j < n-k+1;j++) {
                TreeSet<Integer> t = new TreeSet<Integer>();
                findDistinct(i,j,grid,k,t);
                List<Integer> list = new ArrayList<>(t);
                int temp = Integer.MAX_VALUE;
                System.out.print(t);
                for (int z = 1; z < list.size(); z++) {
                    int x = list.get(z);
                    int y = list.get(z-1);
                    temp = Math.min(temp,Math.abs(x-y));
                }
                ans[i][j] = (temp == Integer.MAX_VALUE) ? 0 : temp;
            }
        }
        return ans;
    }
}
