public class Main {
    public static void main(String[] args) {
        PlayerLinkedList playerLinkedList = new PlayerLinkedList();
        playerLinkedList.addToFront(new Player(1, "Heathcliff", 999));
        playerLinkedList.addToFront(new Player(2, "Asuna", 100));
        playerLinkedList.addToFront(new Player(3, "LethalBacon", 300));
        playerLinkedList.addToFront(new Player(4, "HPDeskjet", 700));

        
        playerLinkedList.printLinkedList();
    }
}
