
    class Solution {
    ArrayList<Integer>[] adj;
    int[] ans;
    int[] last;

    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }

        int[] newParent = parent.clone();

        last = new int[26];
        Arrays.fill(last, -1);

        dfs(0, newParent, s);

        adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 1; i < n; i++) {
            adj[newParent[i]].add(i);
        }
        ans = new int[n];
        calculate(0);

        return ans;
    }

    void dfs(int node, int[] newParent, String s) {
        int ch = s.charAt(node) - 'a';

        int previous = last[ch];

        if (previous != -1) {
            newParent[node] = previous;
        }

        last[ch] = node;

        for (int child : adj[node]) {
            dfs(child, newParent, s);
        }

      
        last[ch] = previous;
    }

    int calculate(int node) {
        int size = 1;

        for (int child : adj[node]) {
            size += calculate(child);
        }

        ans[node] = size;
        return size;
    }
}
