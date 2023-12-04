package castle;

public class Renderer {
    private String texture;
    private String color = "\u001B[0m";

    public Renderer(String texture) {
        this.texture = texture;
    }

    public Renderer(String texture, String color) {
        this.texture = texture;
        this.color = color;
    }

    public void Render() {
        System.out.print(color + texture + "\u001B[0m");
    }
}
