# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def rotateRight(self, head: ListNode, k: int) -> ListNode:
        if not head or not head.next or k == 0:
            return head

        # Find length and tail
        length = 1
        tail = head
        while tail.next:
            tail = tail.next
            length += 1

        # Normalize k
        k %= length
        if k == 0:
            return head

        # Make it circular
        tail.next = head

        # Find new tail: (length - k - 1) steps from head
        steps = length - k
        new_tail = head
        for _ in range(steps - 1):
            new_tail = new_tail.next

        # Break the circle
        new_head = new_tail.next
        new_tail.next = None

        return new_head