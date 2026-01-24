/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */

/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    let dummy = new ListNode(0);
    dummy.next = head;

    let fast = dummy;
    let slow = dummy;

    // Move fast n + 1 steps ahead
    for (let i = 0; i <= n; i++) {
        fast = fast.next;
    }

    // Move both pointers
    while (fast !== null) {
        fast = fast.next;
        slow = slow.next;
    }

    // Remove the nth node from end
    slow.next = slow.next.next;

    return dummy.next;
};