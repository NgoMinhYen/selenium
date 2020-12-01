package core;

public enum PictureToMove {
    PICTURE1("High Tatras"),
    PICTURE2("High Tatras 2"),
    PICTURE3("High Tatras 3"),
    PICTURE4("High Tatras 4");
    private final String PictureToMove;

    PictureToMove(String s) {
        this.PictureToMove = s;
    }

    public String getPictureToMove() {
        return this.PictureToMove;
    }
}
