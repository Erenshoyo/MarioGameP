package STA;

import static org.lwjgl.glfw.GLFW.GLFW_FALSE;
import static org.lwjgl.glfw.GLFW.GLFW_PRESS;

public class KeyListener {
    private static KeyListener instance;
    private boolean KeyPressed[] = new boolean[350];

    private KeyListener(){

    }

    public static KeyListener get(){
        if(KeyListener.instance == null){
            KeyListener.instance = new KeyListener();
        }

        return KeyListener.instance;
    }

    public static void keyCallback(long window, int key, int scancode, int action, int mods) {
        if(action == GLFW_PRESS){
            get().KeyPressed[key] = true;
        }else if(action == GLFW_FALSE){
            get().KeyPressed[key] = false;
        }
    }

    public static boolean isKeyPressed(int keyCode){
            return get().KeyPressed[keyCode];
    }

}
