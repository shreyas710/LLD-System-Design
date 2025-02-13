public class Character implements Letter {
    private char character;
    private String fontType;
    private int size;           // intrinsic data

    Character(char character, String fontType, int size) {
        this.character = character;
        this.fontType = fontType;
        this.size = size;
    }

    @Override
    public void display(int row, int col) {
        System.out.println(character + " " + row + " " + col);
        // display character of font at row, col
    }
}
