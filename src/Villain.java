
import java.awt.*;

public class Villain {


    public double xpos;                //the x position
    public double ypos;                //the y position
    public int width;
    public int height;
    public boolean isAlive;            //a boolean to denote if the hero is alive or dead.
    public double dx;                    //the speed of the hero in the x direction
    public double dy;                   //the speed of the hero in the y direction
    public double ddy;
    public Rectangle rec;
    public Rectangle recFoot;
    public Image pic;

    //movement booleans
    public boolean right;
    public boolean left;
    public boolean down;
    public boolean up;
    public boolean isJumping;
    public boolean hasLanded;
    public boolean isIntersecting;
    public boolean didSwitch=false;
    public boolean touchedLight=false;
    public boolean hasScroll=false;
    public boolean hasFlowers=false;
    public boolean noFriends=false;
    public boolean hasHenches=false;
    public boolean start=false;
    public boolean startscreen=true;
    public boolean in1=false;
    public boolean in2=false;
    public boolean in3=false;
    public boolean endscreen=false;




    public Villain(double pXpos, double pYpos, double dxParameter, double dyParameter, Image picParameter) {

        xpos = pXpos;
        ypos = pYpos;
        width = 100;
        height = 130;
        dx = dxParameter;
        dy = dyParameter;
        pic = picParameter;
        isAlive = true;
        isIntersecting = false;
        rec = new Rectangle((int)xpos,(int)ypos, 80, height-20);
        recFoot = new Rectangle ((int)xpos, (int)ypos-height+20, width, 20);

    } // constructor

    //move( ) method for a keyboard controlled character
    public void move() {
        xpos = xpos + dx;
        ypos = ypos + dy;

        if(right == true){
           dx = 2;
        } else if (left == true) {
            dx = -2;
        } else { // (right == false && left == false)
            dx = 0;
        }

        if(down == true){
            dy = 2;
        } else if (up == true) {
            dy = -2;
        } else {
            dy = 0;
        }

        if(xpos>1000-width){ // right
            xpos = 1000-width;
        }
        if(xpos < 0) { // left
            xpos = 0;
        }
        if(ypos>630-height){ // down
            ypos = 630-height;
        }
        if(ypos < 0) { // up
            ypos = 0;
        }


        //always put this after you've done all the changing of the xpos and ypos values
        rec = new Rectangle((int)xpos, (int)ypos, width, height);
        recFoot = new Rectangle ((int)xpos, (int)ypos, width, 20);

    }

    public void Jump(){
        //boolean/if conditions
       // dy=-20;
       // ypos = ypos + dy;

        //need to make dx like a boolean about if jump, can't change
    }

    public void move2() {
        xpos = xpos + dx;
        ypos = ypos + dy;

        if(right == true){
            dx = 8;
        } else if (left == true) {
            dx = -8;
        } else { // (right == false && left == false)
            dx = 0;
        }

//        if(up == true){
//            dy = -20;
//            dy=dy+2;
//        } else {
//            dy = 0;
//        }

        if (isJumping==true){
            dy=dy+3;
            if(hasLanded){
                dy=0;
            }

        }

        if(xpos>1000-width){ // right
            xpos = 1000-width;
        }
        if(xpos < 0) { // left
            xpos = 0;
        }

        if(ypos>630-height){ // down
            ypos = 630-height;
        }
        if(ypos < 0) { // up
            ypos = 0;
        }
        //always put this after you've done all the changing of the xpos and ypos values
        rec = new Rectangle((int)xpos, (int)ypos, width, height);
        recFoot = new Rectangle ((int)xpos, (int)ypos-height+20, width, 20);
    }
    public void teleport(int pX, int pY){
        xpos=pX;
        ypos=pY;
    }

    //how to make words appear:
    //g.setColor or g.setFont
    //g.drawString("score"+ score, x, y);

}
