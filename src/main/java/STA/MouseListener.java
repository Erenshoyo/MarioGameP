package STA;

import static org.lwjgl.glfw.GLFW.GLFW_PRESS;
import static org.lwjgl.glfw.GLFW.GLFW_RELEASE;

public class MouseListener {
    private static MouseListener instance;
    private double scrollx, scrolly;
    private double xPos, yPos, lasty, lastx;
    private boolean mouseButtonPressed[] = new boolean[3];
    private boolean isDragging;

    private MouseListener(){
        this.scrollx = 0.0;
        this.scrolly = 0.0;
        this.xPos = 0.0;
        this.yPos = 0.0;
        this.lastx = 0.0;
        this.lasty = 0.0;
    }

    public static MouseListener get(){
        if(MouseListener.instance == null){
            MouseListener.instance = new MouseListener();
        }

        return MouseListener.instance;
    }

    public static void mousePosCallback(long window, double xpos, double ypos){
        get().lastx = get().xPos;
        get().lasty = get().yPos;
        get().xPos = xpos;
        get().yPos = ypos;
        get().isDragging = get().mouseButtonPressed[0] || get().mouseButtonPressed[1]|| get().mouseButtonPressed[2];
    }

    public static void mouseButtonCallBack(long window, int button, int action, int mods){
        if(action == GLFW_PRESS){
            if(button < get().mouseButtonPressed.length){
                get().mouseButtonPressed[button] = true;
            }
        } else if (action == GLFW_RELEASE){
            if(button < get().mouseButtonPressed.length){
                get().mouseButtonPressed[button] = false;
                get().isDragging = false;
            }
        }
    }

    public static void mouseScrollCallback(long window, double xOffset, double yOffset){
        get().scrollx = xOffset;
        get().scrolly = yOffset;
    }

    public static void endFrame(){
        get().scrollx = 0;
        get().scrolly = 0;
        get().lastx = get().xPos;
        get().lasty = get().yPos;
    }

    public static float getx(){
        return (float)get().xPos;
    }

    public static float gety(){
        return (float)get().yPos;
    }

    public static float getDx(){
        return (float)(get().lastx- get().xPos);
    }

    public static float getDy(){
        return (float)(get().lasty- get().yPos);
    }

    public static float getScrollX(){
        return (float)get().scrollx;
    }

    public static float getScrolly(){
        return (float)get().scrolly;
    }

    public static boolean isDragging(){
        return get().isDragging;
    }

    public static boolean mouseButtonDown(int button){
        if(button < get().mouseButtonPressed.length){
            return get().mouseButtonPressed[button];
        } else {
            return false;
        }
    }
}
