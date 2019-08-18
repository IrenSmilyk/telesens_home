package telesens.academy.lesson07;

public interface VisualComponent {
    void draw();
    default void draw3D(){
        System.out.println("draw3D");
    }
}
