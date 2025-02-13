import java.util.HashMap;
import java.util.Map;

public class CharacterFactory {
    private static Map<java.lang.Character, Letter> characterCache = new HashMap<>();

    public static Letter createLetter(char letter) {
        if (characterCache.containsKey(letter)) {
            return characterCache.get(letter);
        } else {
            System.out.println("Creating a new letter " + letter);
            Character character = new Character(letter, "Arial", 10);
            characterCache.put(letter, character);
            return character;
        }
    }
}
