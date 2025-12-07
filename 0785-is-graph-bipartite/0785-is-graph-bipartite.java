class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                map.putIfAbsent(i, new ArrayList<>());
                map.get(i).add(graph[i][j]);
            }
        }

        int color[] = new int[graph.length];

        for (int i = 0; i < graph.length; i++) {
            if (color[i] != 0)
                continue;
            q.add(i);
            color[i] = 1;
            while (!q.isEmpty()) {
                int parent = q.poll();
                if (map.containsKey(parent)) {
                    for (int child : map.get(parent)) {
                        if (color[child] == 0){
                            color[child] = color[parent] * (-1);
                            q.add(child);
                        }
                        else if (color[child] == color[parent])
                            return false;
                    }
                }
            }
        }
        return true;
    }

}