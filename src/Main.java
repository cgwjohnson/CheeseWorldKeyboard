//K. Chun 8/2018

//*******************************************************************************
//Import Section
//Add Java libraries needed for the game
//import java.awt.Canvas;

//Graphics Libraries

import java.awt.Graphics2D;
import java.awt.image.BufferStrategy;
import java.awt.*;
import javax.swing.*;

/***
 * Step 0 for keyboard control - Import
 */
import java.awt.event.*;

/***
 * Step 1 for keyboard control - implements KeyListener
 */
public class Main implements Runnable, KeyListener {

    //Variable Definition Section

    //Sets the width and height of the program window
    final int WIDTH = 1000;
    final int HEIGHT = 700;

    //Declare the variables needed for the graphics
    public JFrame frame;
    public Canvas canvas;
    public JPanel panel;
    public BufferStrategy bufferStrategy;

    //Declare the variables needed for images
    public Image cheesePic;

    public Image scrollPic;
    public Image switchOffPic;
    public Image switchOnPic;
    public Image lightOffPic;
    public Image lightOnPic;
    public Image doorPic;
    public Image winDoor;

    public Image flowersPic;
    public Image flower1Pic;
    public Image flower2Pic;
    public Image flowerBoxPic;
    public Image detectivePic;
    public Image hench1Pic;
    public Image hench2Pic;

    public Image flyPic;
    public Image speedPic;
    public Image AMCHeroPic;
    public Image pinkHair;
    public Image mossyPic;

    public Image startScreen;
    public Image titlePic;
    public Image background1;
    public Image background2;
    public Image background2mid;
    public Image background2front;
    public Image background3;
    public Image background3mid;
    public Image background3front;
    public Image endScreen;

    //Declare the character objects
    public Object scroll;
    public Object Switch;
    public Object light;
    public Object flowers;
    public Object flower1;
    public Object flower2;
    public Object flowerBox;
    public Object door;
    public Object door2;
    public Object door3;
    public Object door4;
    public Object door5;
    public Object door6;
    public Object title;
    public Object userScreen;

    public Hero detecty;
    public Hero theCheese;
    public Hero AMCHero;
    public Hero fly;
    public Hero speed;

    public Henchman friend1;
    public Henchman friend2;
    public Villain user;
    public Platform mossy;
    public Platform mossy2;
    public Platform mossy3;
    public Platform mossy4;
    public Platform mossy5;
    public Platform mossy6;
    public Platform mossy7;
    public Platform mossy8;
    public Platform mossy9;
    public Platform mossy10;
    public Platform mossy11;
    public Platform mossy12;
    public Platform mossy13;
    public Platform mossy14;
    public Platform mossy15;
    public Platform mossy16;
    public Platform mossy17;
    public Platform mossy18;
    public Platform mossy19;


    // Main method definition
    // This is the code that runs first and automatically
    public static void main(String[] args) {
        Main myApp = new Main();   //creates a new instance of the game
        new Thread(myApp).start();               //creates a threads & starts up the code in the run( ) method
    }
    // Constructor Method - setup portion of the program
    // Initialize your variables and construct your program objects here.
    public Main() {
        setUpGraphics();
        /***
         * Step 2 for keyboard control - addKeyListener(this) to the canvas
         */
        canvas.addKeyListener(this);
        //load images
       cheesePic = Toolkit.getDefaultToolkit().getImage("cheese.gif");
        theCheese = new Hero(-1000, 300, 3, -4);

        pinkHair = Toolkit.getDefaultToolkit().getImage("Villain.png");
        user = new Villain(0.0, 650.0, 0.0, 0.0, pinkHair);
        userScreen = new Object(470,100,100,130);

        mossyPic = Toolkit.getDefaultToolkit().getImage("platform.png");
        mossy = new Platform(10,175, 100,30);
        mossy2 = new Platform(130,230, 250,50);
        mossy3 = new Platform(440,350, 150,40);
        mossy4 = new Platform(660,250, 80,20);
        mossy5 = new Platform(780,150, 80,18);
        mossy6 = new Platform(900,100, 100,30);
        mossy7 = new Platform(250,500, 100,30);
        mossy8 = new Platform(670,470, 150,30);

        mossy9 = new Platform(125,200, 200,40);
        mossy10 = new Platform(430,120, 200,50);
        mossy11 = new Platform(280,465, 150,30);
        mossy12 = new Platform(410,310, 150,30);
        mossy13 = new Platform(680,290, 150,30);
        mossy14 = new Platform(845,350, 150,30);

        mossy15 = new Platform(-20,350, 150,30);
        mossy16 = new Platform(185,180, 150,30);
        mossy17 = new Platform(580,470, 150,30);
        mossy18 = new Platform(340,500, 150,30);
        mossy19 = new Platform(870,150, 150,30);

        scrollPic = Toolkit.getDefaultToolkit().getImage("scroll.png");
        scroll = new Object(275,460, 40,40);
        lightOffPic = Toolkit.getDefaultToolkit().getImage("lightOff.png");
        lightOnPic = Toolkit.getDefaultToolkit().getImage("lightOn.png");
        light = new Object(45,125, 35,50);
        switchOffPic = Toolkit.getDefaultToolkit().getImage("switchOff.png");
        switchOnPic = Toolkit.getDefaultToolkit().getImage("switchOn.png");
        Switch = new Object(935,50, 35,50);
        doorPic = Toolkit.getDefaultToolkit().getImage("door.png");
        door = new Object(896,475, 130,170);

        door2 = new Object(-30,478, 130,170);
        door3 = new Object(856,210, 130,170);

        door4 = new Object(-20,210, 130,170);
        door6 = new Object(896,478, 130,170);
        winDoor = Toolkit.getDefaultToolkit().getImage("winDoor.png");
        door5 = new Object(896,10, 130,170);


        flowersPic = Toolkit.getDefaultToolkit().getImage("flowers.png");
        flowers = new Object(670,525, 130,65);
        flower1Pic = Toolkit.getDefaultToolkit().getImage("flower1.png");
        flower1 = new Object(730,565, 20,20);
        flower2Pic = Toolkit.getDefaultToolkit().getImage("flower2.png");
        flower2 = new Object(710,560, 25,25);
        flowerBoxPic = Toolkit.getDefaultToolkit().getImage("flowerBox.png");
        flowerBox = new Object(670,575, 130,60);
        detectivePic = Toolkit.getDefaultToolkit().getImage("detective.png");
        detecty = new Hero(780,400,300,250);
        hench1Pic = Toolkit.getDefaultToolkit().getImage("hench1.png");
        friend1 = new Henchman(510,15,90,120);
        hench2Pic = Toolkit.getDefaultToolkit().getImage("hench2.png");
        friend2 = new Henchman(465,40,80,100);

        flyPic = Toolkit.getDefaultToolkit().getImage("flight.png");
        fly = new Hero(300,400,100,130);
        speedPic = Toolkit.getDefaultToolkit().getImage("speed.png");
        speed = new Hero(600,400,100,130);
        AMCHeroPic = Toolkit.getDefaultToolkit().getImage("annoying.png");
        AMCHero = new Hero(200,400,250,140);

        titlePic = Toolkit.getDefaultToolkit().getImage("title.png");
        title = new Object(200,65, 600,50);
        startScreen = Toolkit.getDefaultToolkit().getImage("startscreen.png");
        background1 = Toolkit.getDefaultToolkit().getImage("background.jpg");
        background2 = Toolkit.getDefaultToolkit().getImage("background2.png");
        background2mid = Toolkit.getDefaultToolkit().getImage("background2mid.jpg");
        background2front = Toolkit.getDefaultToolkit().getImage("background2front.png");
        background3 = Toolkit.getDefaultToolkit().getImage("background3.jpg");
        background3mid = Toolkit.getDefaultToolkit().getImage("background3mid.png");
        background3front = Toolkit.getDefaultToolkit().getImage("background3front.png");
        endScreen = Toolkit.getDefaultToolkit().getImage("endscreen.jpg");

        //create (construct) the objects needed for the game




    } // CheeseWorld()


//*******************************************************************************
//User Method Section

    // main thread
    // this is the code that plays the game after you set things up
    public void moveThings() {
        user.move2();
//        detecty.detect(2);
//        fly.fly(3,2);
        land();
        turnOn();
        theIdea();
        thePlan();
        move1to2();
        aGift();
        hasflowers();
        friendship();
        hasfriends();
        gotCaught();
        move2to3();
        gotStopped();
        move3toEnd();
    }

    public void move3toEnd(){
        if(user.rec.intersects(door6.rec)&&user.in3==true){
            user.in1=false;
            user.in2=false;
            user.in3=false;
            user.startscreen=false;
            user.endscreen=true;
        }
    }
    public void gotStopped(){
        if(user.rec.intersects(fly.rec)&&user.in3==true){
            user.teleport(0,210);
        }
        if(user.rec.intersects(speed.rec)&&user.in3==true){
            user.teleport(0,210);
        }
        if(user.rec.intersects(AMCHero.rec)&&user.in3==true){
            user.teleport(0,210);
        }
    }
    public void move2to3(){
        if(user.rec.intersects(door3.rec)&& user.hasHenches==true &&user.in2==true){
            user.in1=false;
            user.in2=false;
            user.in3=true;
            user.teleport(0,210);
        }
    }
    public void gotCaught(){
        if(user.rec.intersects(detecty.rec)&&user.in2==true){
            user.teleport(0,650);
        }

    }
    public void friendship(){
        if(user.rec.intersects(friend1.rec)&&user.in2==true&& user.hasFlowers==false&&user.hasHenches==false){
          user.noFriends=true;
          user.hasHenches=false;
        }
        if(user.rec.intersects(friend1.rec)&&user.in2==true&& user.hasFlowers==true){
            user.noFriends=false;
            user.hasFlowers=false;
            user.hasHenches=true;
        }
        if(user.rec.intersects(friend2.rec)&&user.in2==true&& user.hasFlowers==true){
            user.noFriends=false;
            user.hasFlowers=false;
            user.hasHenches=true;
        }
    }
    public void hasfriends(){
        if(user.noFriends==false&&user.hasFlowers==false&&user.hasHenches==true){
            flower1.xpos=(int)friend1.xpos+60;
            flower1.ypos=(int)friend1.ypos+35;
            friend1.xpos=(int)user.xpos-85;
            friend1.ypos=(int)user.ypos+5;

            flower2.xpos=(int)friend2.xpos+60;
            flower2.ypos=(int)friend2.ypos+40;
            friend2.xpos=(int)user.xpos-160;
            friend2.ypos=(int)user.ypos+30;
        }
    }
    public void aGift(){
        if(user.rec.intersects(flower1.rec)&&user.in2==true&&user.hasHenches==false){
//            flower1.xpos=(int)user.xpos+70;
//            flower1.ypos=(int)user.ypos+60;
            user.hasFlowers=true;
        }
        if(user.rec.intersects(flower2.rec)&&user.in2==true&&user.hasHenches==false){
//            flower2.xpos=(int)user.xpos+80;
//            flower2.ypos=(int)user.ypos+55;
            user.hasFlowers=true;
        }
    }
    public void hasflowers(){
        if(user.hasFlowers==true){
            flower1.xpos=(int)user.xpos+60;
            flower1.ypos=(int)user.ypos+50;
            flower2.xpos=(int)user.xpos+70;
            flower2.ypos=(int)user.ypos+45;
        }
    }
    public void move1to2(){
        if(user.rec.intersects(door.rec)&& user.didSwitch==true && user.touchedLight==true && user.hasScroll==true&&user.in1==true){
            user.in1=false;
            user.in2=true;
            user.teleport(0,650);
        }
    }
    public void thePlan(){
        if(user.rec.intersects(scroll.rec)&&user.touchedLight==true&&user.in1==true){
            user.hasScroll=true;
        }
    }
    public void theIdea(){
        if(user.rec.intersects(light.rec)&&user.didSwitch==true&&user.in1==true){
            user.touchedLight=true;
            System.out.println("touched");
        }
    }
    public void turnOn(){
        if(user.rec.intersects(Switch.rec)&& user.didSwitch==false&&user.in1==true){
            user.didSwitch=true;
        }
    }
    public void land(){
        if(user.recFoot.intersects(mossy.rec)&& user.isIntersecting==false && user.dy>0){
           // user.ypos=mossy.ypos;
            //user.dy=0;
            user.isIntersecting=true;
            user.isJumping=false;
            user.hasLanded=true;
//            System.out.println("is intersecting");
        }
        if(!user.recFoot.intersects(mossy.rec)){  //! is the same as writing ==false at end
            user.isIntersecting=false;
        }
    }
//    public void pressStart(){
//        if(user.start==true&&user.startscreen==true&&user.in1==false&&user.in2==false&&user.in3==false&&user.endscreen==false){
//            user.startscreen=false;
//            user.in1=true;
//            user.in2=false;
//            user.in3=false;
//            user.teleport(0,650);
//        }
//    }
//    public void start(){
//        if(user.in1==false&&user.in2==false&&user.in3==false&&user.endscreen==false){
//            user.startscreen=true;
//            user.start=false;
//            user.in1=false;
//            user.in2=false;
//            user.in3=false;
//            user.teleport(100,650);
//        }
//    }

    public void checkIntersections() {

    }

    public void run() {
        while (true) {
            moveThings();           //move all the game objects
            checkIntersections();   // check character crashes
            render();               // paint the graphics
            pause(20);         // sleep for 20 ms
        }
    }

    //paints things on the screen using bufferStrategy
    public void render() {
        Graphics2D g = (Graphics2D) bufferStrategy.getDrawGraphics();
        g.clearRect(0, 0, WIDTH, HEIGHT);
        //draw characters to the screen
//        g.drawImage(mouse1.pic, mouse1.xpos, mouse1.ypos, mouse1.width, mouse1.height, null);
       // g.drawImage(theCheese.pic, theCheese.xpos, theCheese.ypos, theCheese.width, theCheese.height, null);
       if(user.in1==false&&user.in2==false&&user.in3==false&&user.endscreen==false&&user.startscreen==true&&user.start==false){
           g.drawImage(startScreen,0,0,1000,700,null);
           g.drawImage(titlePic, title.xpos, title.ypos, title.width, title.height, null);
           g.drawImage(pinkHair, userScreen.xpos, userScreen.ypos, userScreen.width, userScreen.height, null);
           g.setColor(Color.green);
//            g.setFont();
           g.drawString("press space bar to start", 280, 655);
       }
       if(user.in1==true&&user.in2==false&&user.start==true) {
           g.drawImage(background1,0,0,1000,700,null);
           g.drawImage(mossyPic, mossy.xpos, mossy.ypos, mossy.width, mossy.height, null);
           g.drawRect(mossy.xpos, mossy.ypos, mossy.width, mossy.height);
           g.drawImage(mossyPic, mossy2.xpos, mossy2.ypos, mossy2.width, mossy2.height, null);
           g.drawImage(mossyPic, mossy3.xpos, mossy3.ypos, mossy3.width, mossy3.height, null);
           g.drawImage(mossyPic, mossy4.xpos, mossy4.ypos, mossy4.width, mossy4.height, null);
           g.drawImage(mossyPic, mossy5.xpos, mossy5.ypos, mossy5.width, mossy5.height, null);
           g.drawImage(mossyPic, mossy6.xpos, mossy6.ypos, mossy6.width, mossy6.height, null);
           g.drawImage(mossyPic, mossy7.xpos, mossy7.ypos, mossy7.width, mossy7.height, null);
           g.drawImage(mossyPic, mossy8.xpos, mossy8.ypos, mossy8.width, mossy8.height, null);

           g.drawImage(scrollPic, scroll.xpos, scroll.ypos, scroll.width, scroll.height, null);

           if (user.didSwitch == false) {
               g.drawImage(lightOffPic, light.xpos, light.ypos, light.width, light.height, null);
               g.drawImage(switchOffPic, Switch.xpos, Switch.ypos, Switch.width, Switch.height, null);
           } else if (user.didSwitch == true&&user.touchedLight==false) {
               g.drawImage(lightOnPic, light.xpos, light.ypos, light.width, light.height, null);
               g.drawImage(switchOnPic, Switch.xpos, Switch.ypos, Switch.width, Switch.height, null);
               g.setColor(Color.green);
//            g.setFont();
               g.drawString("you have an idea!", 450, 655);
           }
           if(user.touchedLight==true&&user.hasScroll==false){
               g.drawImage(lightOnPic, light.xpos, light.ypos, light.width, light.height, null);
               g.drawImage(switchOnPic, Switch.xpos, Switch.ypos, Switch.width, Switch.height, null);
               g.setColor(Color.green);
//            g.setFont();
               g.drawString("your idea is to take over the world! but how? you need a plan", 350, 655);
           }
           if(user.hasScroll==true){
               g.drawImage(lightOnPic, light.xpos, light.ypos, light.width, light.height, null);
               g.drawImage(switchOnPic, Switch.xpos, Switch.ypos, Switch.width, Switch.height, null);
               g.setColor(Color.green);
//            g.setFont();
               g.drawString("how to take over the world: 1) get henchmen 2) evade the heroes 3) take over the world!!", 275, 655);
           }
           g.drawImage(doorPic, door.xpos, door.ypos, door.width, door.height, null);
           g.drawImage(user.pic, (int)user.xpos, (int)user.ypos, user.width, user.height, null);
       }
       if(user.in1==false&&user.in2==true&&user.in3==false){
           g.drawImage(background2,0,0,1000,700,null);
           g.drawImage(background2mid,0,625,1000,155,null);
           g.drawImage(flowersPic, flowers.xpos, flowers.ypos, flowers.width, flowers.height, null);
           g.drawImage(flowerBoxPic, flowerBox.xpos, flowerBox.ypos, flowerBox.width, flowerBox.height, null);
           g.drawImage(doorPic, door2.xpos, door2.ypos, door2.width, door2.height, null);
           g.drawImage(doorPic, door3.xpos, door3.ypos, door3.width, door3.height, null);
           g.drawImage(mossyPic, mossy9.xpos, mossy9.ypos, mossy9.width, mossy9.height, null);
           g.drawImage(mossyPic, mossy10.xpos, mossy10.ypos, mossy10.width, mossy10.height, null);
           g.drawImage(mossyPic, mossy11.xpos, mossy11.ypos, mossy11.width, mossy11.height, null);
           g.drawImage(mossyPic, mossy12.xpos, mossy12.ypos, mossy12.width, mossy12.height, null);
           g.drawImage(mossyPic, mossy13.xpos, mossy13.ypos, mossy13.width, mossy13.height, null);
           g.drawImage(mossyPic, mossy14.xpos, mossy14.ypos, mossy14.width, mossy14.height, null);

           g.drawImage(hench1Pic, friend1.xpos, friend1.ypos, friend1.width, friend1.height, null);
           g.drawImage(hench2Pic, friend2.xpos, friend2.ypos, friend2.width, friend2.height, null);

           g.drawImage(user.pic, (int)user.xpos, (int)user.ypos, user.width, user.height, null);
           g.drawImage(flower1Pic, flower1.xpos, flower1.ypos, flower1.width, flower1.height, null);
           g.drawImage(flower2Pic, flower2.xpos, flower2.ypos, flower2.width, flower2.height, null);
           g.drawImage(detectivePic, detecty.xpos, detecty.ypos, detecty.width, detecty.height, null);
           g.drawImage(background2front,0,495,1000,203,null);
           if(user.noFriends==true){
               g.setColor(Color.green);
//            g.setFont();
               g.drawString("'you want us to follow you? i don't know. maybe if you were to show that you care about us, like giving a gift...'", 200, 655);
           }

       }
       if(user.in1==false&&user.in2==false&&user.in3==true){
            g.drawImage(background3,0,0,1000,700,null);
           g.drawImage(background3mid,0,625,1000,155,null);
            g.drawImage(doorPic, door4.xpos, door4.ypos, door4.width, door4.height, null);
           g.drawImage(doorPic, door6.xpos, door6.ypos, door6.width, door6.height, null);

            g.drawImage(mossyPic, mossy15.xpos, mossy15.ypos, mossy15.width, mossy15.height, null);
            g.drawImage(mossyPic, mossy16.xpos, mossy16.ypos, mossy16.width, mossy16.height, null);
            g.drawImage(mossyPic, mossy17.xpos, mossy17.ypos, mossy17.width, mossy17.height, null);
            g.drawImage(mossyPic, mossy18.xpos, mossy18.ypos, mossy18.width, mossy18.height, null);
            g.drawImage(mossyPic, mossy19.xpos, mossy19.ypos, mossy19.width, mossy19.height, null);
           g.drawImage(winDoor, door5.xpos, door5.ypos, door5.width, door5.height, null);

            g.drawImage(flyPic, fly.xpos, fly.ypos, fly.width, fly.height, null);
            g.drawImage(speedPic, speed.xpos, speed.ypos, speed.width, speed.height, null);
            g.drawImage(AMCHeroPic, AMCHero.xpos, AMCHero.ypos, AMCHero.width, AMCHero.height, null);

            g.drawImage(hench1Pic, friend1.xpos, friend1.ypos, friend1.width, friend1.height, null);
            g.drawImage(hench2Pic, friend2.xpos, friend2.ypos, friend2.width, friend2.height, null);

            g.drawImage(user.pic, (int)user.xpos, (int)user.ypos, user.width, user.height, null);
           g.drawImage(background3front,0,600,1000,103,null);
        }
       if(user.in1==false&&user.in2==false&&user.in3==false&&user.startscreen==false&&user.endscreen==true){
           g.drawImage(endScreen,0,0,1000,700,null);
           g.drawImage(pinkHair, userScreen.xpos, userScreen.ypos, userScreen.width, userScreen.height, null);
           g.drawImage(hench1Pic, 370, 105, friend1.width, friend1.height, null);
           g.drawImage(hench2Pic, 560, 130, friend2.width, friend2.height, null);
           g.setColor(Color.green);
//            g.setFont();
           g.drawString("maybe taking over the world was the friends we made along the way", 290, 655);
       }
        g.dispose();
        bufferStrategy.show();
    }

    /***
     * Step 3 for keyboard control - add required methods
     * You need to have all 3 even if you aren't going to use them all
     */
    public void keyPressed(KeyEvent event) {
        //This method will do something whenever any key is pressed down.
        //Put if( ) statements here
        char key = event.getKeyChar();     //gets the character of the key pressed
        int keyCode = event.getKeyCode();  //gets the keyCode (an integer) of the key pressed
        System.out.println("Key Pressed: " + key + "  Code: " + keyCode);

        if (keyCode == 39) { // d
            user.right = true;
        }
        if (keyCode == 37) { // a
            user.left = true;
        }

        if (keyCode == 83) { // s
            user.down = true;
        }
        if (keyCode == 87) { // w
            user.up = true;
        }
        if (keyCode == 32) { // spacebar - 32, 38 is up arrow
            user.start=true;
            user.in1=true;
            System.out.println("on");
        }
    }//keyPressed()

    public void keyReleased(KeyEvent event) {
        char key = event.getKeyChar();
        int keyCode = event.getKeyCode();
        //This method will do something when a key is released
        if (keyCode == 39) { // d
            user.right = false;
        }
        if (keyCode == 37) { // a
            user.left = false;
        }
        if (keyCode == 83) { // s
            user.down = false;
        }
        if (keyCode == 87) { // w
            user.up = false;
        }
        if (keyCode == 38) { // spacebar - 32, 38 is up arrow
            user.dy=-30;
            user.isJumping=true;
            user.hasLanded=false;
        }
        if (keyCode == 32) { // spacebar - 32, 38 is up arrow
            user.start=true;
            user.in1=true;
            System.out.println("off");
        }


    }//keyReleased()

    public void keyTyped(KeyEvent event) {
        // handles a press of a character key (any key that can be printed but not keys like SHIFT)
        // we won't be using this method, but it still needs to be in your program
    }//keyTyped()

    //Graphics setup method
    public void setUpGraphics() {
        frame = new JFrame("Main");   //Create the program window or frame.  Names it.

        panel = (JPanel) frame.getContentPane();  //sets up a JPanel which is what goes in the frame
        panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));  //sizes the JPanel
        panel.setLayout(null);   //set the layout

        // creates a canvas which is a blank rectangular area of the screen onto which the application can draw
        // and trap input events (Mouse and Keyboard events)
        canvas = new Canvas();
        canvas.setBounds(0, 0, WIDTH, HEIGHT);
        canvas.setIgnoreRepaint(true);

        panel.add(canvas);  // adds the canvas to the panel.

        // frame operations
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //makes the frame close and exit nicely
        frame.pack();  //adjusts the frame and its contents so the sizes are at their default or larger
        frame.setResizable(false);   //makes it so the frame cannot be resized
        frame.setVisible(true);      //IMPORTANT!!!  if the frame is not set to visible it will not appear on the screen!

        // sets up things so the screen displays images nicely.
        canvas.createBufferStrategy(2);
        bufferStrategy = canvas.getBufferStrategy();
        canvas.requestFocus();
        System.out.println("DONE graphic setup");

    }

    //Pauses or sleeps the computer for the amount specified in milliseconds
    public void pause(int time) {
        //sleep
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {

        }
    }

}//class
