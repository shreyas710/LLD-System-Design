public class Main {
    public static void main(String[] args) {
        Letter object1 = CharacterFactory.createLetter('t');
        object1.display(0,0);

        Letter object2 = CharacterFactory.createLetter('t');
        object1.display(0,6);
    }
}