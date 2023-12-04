package castle;

public class Renderer {
    private final String texture;
    private final String color;

    public Renderer(String texture, String color) {
        this.texture = texture;
        this.color = color;
    }

    public void render() {
        System.out.print(color + texture + "\u001B[0m");
    }
}
