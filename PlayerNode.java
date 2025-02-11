public class PlayerNode {
    private Player player;
    private PlayerNode nextPlayerNode;

    public PlayerNode(Player player) {
        this.player = player;
    }

    public PlayerNode getNextPlayerNode() {
        return nextPlayerNode;
    }

    public void setNextPlayerNode(PlayerNode nextPlayerNode) {
        this.nextPlayerNode = nextPlayerNode;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }
}
