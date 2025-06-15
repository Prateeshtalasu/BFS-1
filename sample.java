//ourse Schedule (https://leetcode.com/problems/course-schedule/)
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create adjacency list representation of the graph
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Build the graph
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
        }

        // Array to track visited nodes (0: unvisited, 1: visiting, 2: visited)
        int[] visited = new int[numCourses];

        // Check for cycles using DFS
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, graph, visited)) {
                return false;
            }
        }

        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> graph, int[] visited) {
        // If node is currently being visited, we found a cycle
        if (visited[node] == 1) {
            return true;
        }

        // If node has been visited before, no cycle found
        if (visited[node] == 2) {
            return false;
        }

        // Mark node as being visited
        visited[node] = 1;

        // Visit all neighbors
        for (int neighbor : graph.get(node)) {
            if (hasCycle(neighbor, graph, visited)) {
                return true;
            }
        }

        // Mark node as visited
        visited[node] = 2;

        return false;
    }
}

//
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> store = new LinkedList<>();
        store.add(root);
        while (!store.isEmpty()) {
            int levelsize = store.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelsize; i++) {
                TreeNode node = store.poll();
                level.add(node.val);
                if (node.left != null) {
                    store.add(node.left);
                }
                if (node.right != null) {
                    store.add(node.right);
                }
            }
            result.add(level);

        }
        return result;

    }
}