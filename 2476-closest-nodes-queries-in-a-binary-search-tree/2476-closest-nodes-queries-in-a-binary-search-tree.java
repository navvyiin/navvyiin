import java.util.*;

class Solution {

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> sorted = new ArrayList<>();
        inorder(root, sorted);

        List<List<Integer>> result = new ArrayList<>();

        for (int q : queries) {
            int floor = getFloor(sorted, q);
            int ceil = getCeil(sorted, q);

            result.add(Arrays.asList(floor, ceil));
        }

        return result;
    }

    // In-order traversal to get sorted values
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    // Largest value <= target
    private int getFloor(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) <= target) {
                ans = list.get(mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // Smallest value >= target
    private int getCeil(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        int ans = -1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) >= target) {
                ans = list.get(mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}