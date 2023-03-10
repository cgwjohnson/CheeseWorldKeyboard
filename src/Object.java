import java.awt.*;

public class Object {

    public int xpos;                //the x position
    public int ypos;                //the y position
    public int width;
    public int height;
                       //the speed of the hero in the y direction
    public Rectangle rec;
    public Image pic;


    public Object (int pXpos, int pYpos, int pWidth, int pHeight) {

        xpos = pXpos;
        ypos = pYpos;
        width = pWidth;
        height = pHeight;
        rec = new Rectangle(xpos, ypos,width,height);

    }
}
