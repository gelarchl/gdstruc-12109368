public class PlayerLinked {
    private PlayerNode head;

    public void addToFront(Player player) {
        PlayerNode newNode = new PlayerNode(player);
        newNode.setNextPlayerNode(head);
        head = newNode;
    }
    public void printLinkedList() {
        System.out.print("[HEAD] -> ");
        PlayerNode current = head;

        while (current != null) {
            System.out.print(current.getPlayer() + " -> ");
            current = current.getNextPlayerNode();
        }
        System.out.print("NULL");
    }
}
