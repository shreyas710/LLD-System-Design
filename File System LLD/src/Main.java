public class Main {
    public static void main(String[] args) {
        Directory movieDirectory = new Directory("movie");

        File border = new File("border");
        movieDirectory.add(border);

        Directory comedyDirectory = new Directory("comedy");
        File hulchul = new File("hulchul");
        comedyDirectory.add(hulchul);
        movieDirectory.add(comedyDirectory);

        movieDirectory.ls();
    }
}