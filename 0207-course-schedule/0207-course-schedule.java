class Solution {
    private Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean canFinish(int courses, int[][] preq) {
        int[] indeg = new int[courses];
        Queue<Integer> q = new LinkedList<>();
        for (int vert[] : preq) {
            addEdge(vert[0], vert[1]);
            indeg[vert[1]]++;
        }
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < courses; i++)
            if (indeg[i] == 0)
                q.add(i);
        if (q.isEmpty())
            return false;
        int count = 0;
        for (int i = 0; i < courses; i++) {
            if (!visited.contains(i)) {
                while (!q.isEmpty()) {
                    int parent = q.poll();
                    visited.add(parent);
                    count++;
                    if (!map.containsKey(parent))
                        continue;
                    for (int child : map.get(parent))
                        if (--indeg[child] == 0)
                            q.add(child);
                }
            }
        }
        if (count == courses)
            return true;
        return false;

    }

    private void addEdge(int src, int dest) {
        map.putIfAbsent(src, new ArrayList<>());
        map.get(src).add(dest);
    }
}