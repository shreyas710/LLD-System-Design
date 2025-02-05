import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    String name;
    List<FileSystem> fileSystems;

    public Directory(String name) {
        this.name = name;
        fileSystems = new ArrayList<>();
    }

    public void add(FileSystem fileSystemObj) {
        fileSystems.add(fileSystemObj);
    }

    public void ls() {
        System.out.println("Directory " + name + " has " + fileSystems.size() + " filesystems");
        for (FileSystem fileSystem : fileSystems) {
            fileSystem.ls();
        }
    }
}
