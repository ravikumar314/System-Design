public class Player {

    String name;
    PlayingPiece playingPiece ;
    public Player(String name, PlayingPiece piece){
        this.name = name;
        this.playingPiece = piece;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPlayingPiece(PlayingPiece piece) {
        this.playingPiece = piece;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }
}
