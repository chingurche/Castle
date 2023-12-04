package castle;

public class RenderPipeline {
    public static void RenderHierarchy() {
        var hierarchy = Hierarchy.getInstance();


        clearConsole();

        for (int i = 0; i < hierarchy.SIZE.y; i++) {
            for (int j = 0; j < hierarchy.SIZE.x; j++) {
                System.out.print("+ -- ");
            }
            System.out.println("+");
            for (int j = 0; j < hierarchy.SIZE.x; j++) {
                System.out.print("| ");

                var obj = hierarchy.getObjectOn(new Vector2(j, i));
                if (obj != null) {
                    obj.renderer.Render();
                    System.out.print(" ");
                }
                else {
                    System.out.print("   ");
                }
            }
            System.out.println("|");
        }
        for (int j = 0; j < hierarchy.SIZE.x; j++) {
            System.out.print("+ -- ");
        }
        System.out.println("+");
    }

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
