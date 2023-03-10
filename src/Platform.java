import java.awt.*;

public class Platform {
    public int xpos;                //the x position
    public int ypos;                //the y position
    public int width;
    public int height;
    public double dx;                    //the speed of the hero in the x direction
    public double dy;                   //the speed of the hero in the y direction
    public Rectangle rec;
    public Image pic;
    public int[] platform=new int[8];

    public Platform (int pXpos, int pYpos, int pWidth, int pHeight) {

        xpos = pXpos;
        ypos = pYpos;
        width = pWidth;
        height = pHeight;
       rec = new Rectangle(xpos, ypos,width,height);

    }
    // notes: your dy is positive only way. if dy is pos and rec intersecting

}

