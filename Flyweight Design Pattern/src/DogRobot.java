public class DogRobot implements Robot {
    private String type;
    private Sprites body;

    DogRobot(String type, Sprites body) {
        this.type = type;
        this.body = body;
    }

    public String getType() {
        return type;
    }

    public Sprites getBody() {
        return body;
    }

    @Override
    public void display(int x, int y) {
        //use the humanoid sprites object and X and Y coordinate to render the image.
    }
}
