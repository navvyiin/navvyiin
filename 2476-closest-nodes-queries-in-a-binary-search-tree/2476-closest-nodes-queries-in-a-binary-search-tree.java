import java.util.*;

class Solution {
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<Integer> sorted = new ArrayList<>();
        inorder(root, sorted);

        List<List<Integer>> ans = new ArrayList<>(queries.size());

        for (int q : queries) {
            int floor = getFloor(sorted, q);
            int ceil = getCeil(sorted, q);
            ans.add(Arrays.asList(floor, ceil));
        }

        return ans;
    }

    // In-order traversal to get sorted values
    private void inorder(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorder(node.left, list);
        list.add(node.val);
        inorder(node.right, list);
    }

    // Largest value <= target
    private int getFloor(List<Integer> arr, int target) {
        int l = 0, r = arr.size() - 1;
        int res = -1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr.get(mid) <= target) {
                res = arr.get(mid);
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return res;
    }

    // Smallest value >= target
    private int getCeil(List<Integer> arr, int target) {
        int l = 0, r = arr.size() - 1;
        int res = -1;

        while (l <= r) {
            int mid = (l + r) >>> 1;
            if (arr.get(mid) >= target) {
                res = arr.get(mid);
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res;
    }
}