class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 2)
                    q.add(new Node(i, j, 0));
        int ans = 0;
        while (!q.isEmpty()) {
            Node curr = q.poll();
            ans = curr.t;
            if (isValid(curr.i + 1, curr.j, grid)) {
                q.add(new Node(curr.i + 1, curr.j, curr.t + 1));
                grid[curr.i+1][curr.j]=2;
            }
            if (isValid(curr.i - 1, curr.j, grid)) {
                q.add(new Node(curr.i - 1, curr.j, curr.t + 1));
                grid[curr.i-1][curr.j]=2;
            }
            if (isValid(curr.i, curr.j - 1, grid)) {
                q.add(new Node(curr.i, curr.j - 1, curr.t + 1));
                grid[curr.i][curr.j-1]=2;
            }
            if (isValid(curr.i, curr.j + 1, grid)) {
                q.add(new Node(curr.i, curr.j + 1, curr.t + 1));
                grid[curr.i][curr.j+1]=2;
            }
        }
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == 1)
                    return -1;
        return ans;
    }

    private boolean isValid(int i, int j, int[][] grid) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1)
            return true;
        return false;
    }
}

class Node {
    int i;
    int j;
    int t;

    Node(int i, int j, int t) {
        this.i = i;
        this.j = j;
        this.t = t;
    }

    @Override
    public String toString() {
        return i + ":" + j;
    }
}