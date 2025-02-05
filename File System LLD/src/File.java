public class File implements FileSystem {
    String name;

    public File(String name) {
        this.name = name;
    }

    public void ls() {
        System.out.println("file name: " + name);
    }
}
