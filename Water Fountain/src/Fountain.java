import java.util.Random;
import java.io.File;
import processing.core.PImage;

/**
 * This class, Fountain, creates a graphic visual of a fountain 
 * that shoots water outwards from the
 * image, and can be moved by a mouse.
 * 
 * @author Chinmay Koimuttum
 */
public class Fountain {

  private static Random randGen;
  private static PImage fountainImage;
  private static int positionX;
  private static int positionY;
  private static Droplet[] droplets;
  private static int startColor;
  private static int endColor;

  /**
   * This method searches droplets array and sets ages greater than maxAge as null.
   * 
   * @param maxAge
   */
  private static void removeOldDroplets(int maxAge) {
    for (int i = 0; i < droplets.length; i++) {
      if (droplets[i] != null && droplets[i].getAge() > maxAge) {
        droplets[i] = null;
      }
    }
  }

  /**
   * This method updates the position, velocity, and drawing of a 
   * droplet based on given index.
   * 
   * @param index
   */
  private static void updateDroplet(int index) {

    Utility.fill(droplets[index].getColor(), droplets[index].getTransparency());
    Utility.circle(droplets[index].getPositionX(), droplets[index].getPositionY(),
        droplets[index].getSize());
    droplets[index].setVelocityY(droplets[index].getVelocityY() + 0.3f);
    droplets[index].setPositionX(droplets[index].getPositionX() + droplets[index].getVelocityX());
    droplets[index].setPositionY(droplets[index].getPositionY() + droplets[index].getVelocityY());
  }

  /**
   * This method checks for null values in droplets array to 
   * create new droplets with distinct
   * characteristics
   * 
   * @param numbDroplets
   */
  private static void createNewDroplets(int numbDroplets) {

    for (int i = 0; i < droplets.length; i++) {
      if (numbDroplets == 0) {
        break;
      }
      if (droplets[i] == null) {
        droplets[i] = new Droplet();

        droplets[i].setPositionX(positionX + (randGen.nextFloat() * 6 - 3));
        droplets[i].setPositionY(positionY + (randGen.nextFloat() * 6 - 3));
        droplets[i].setSize((float) (Math.random() * ((11 - 4) + 1)) + 4);

        droplets[i].setColor(Utility.lerpColor(startColor, endColor, randGen.nextInt()));
        droplets[i].setVelocityX((float) (Math.random() * ((1 - (-1)) + 1)) - 1);
        droplets[i].setVelocityY((float) (Math.random() * ((-5 + 10) + 1)) - 10);
        droplets[i].setAge((int) (Math.random() * ((40 - 0) + 1)) + 0);
        droplets[i].setTransparency((int) (Math.random() * ((127 - 32) + 1)) + 32);
        numbDroplets = numbDroplets - 1;
      }
    }
  }

  /**
   * Main method
   * 
   * @param args
   */
  public static void main(String args[]) {

    Utility.runApplication();
  }

  public static void setup() {

    testUpdateDroplet();
    testRemoveOldDroplets();

    startColor = Utility.color(23, 141, 235);
    endColor = Utility.color(23, 200, 255);

    positionX = Utility.width() / 2;
    positionY = Utility.height() / 2;

    randGen = new Random();

    fountainImage = Utility.loadImage("images" + File.separator + "fountain.png");
    droplets = new Droplet[800];
  }

  /**
   * The method draw creates overall for the droplets
   * 
   */
  public static void draw() {
    Utility.background(Utility.color(253, 245, 230));

    Utility.image(fountainImage, positionX, positionY);

    createNewDroplets(10);

    for (int i = 0; i < droplets.length; i++) {
      if (droplets[i] != null) {
        updateDroplet(i);
        droplets[i].setAge(droplets[i].getAge() + 1);
      }

    }
    removeOldDroplets(80);
  }

  /**
   * This method allows mouse to move fountain's position
   * 
   */
  public static void mousePressed() {
    positionX = Utility.mouseX();
    positionY = Utility.mouseY();
  }

  /**
   * This method creates a screenshot of the rendered visual of the fountain
   * 
   * @param key
   */
  public static void keyPressed(char key) {

    if (key == 's' || key == 'S') {
      Utility.save("screenshot.png");
    }
  }

  /**
   * This tester initializes the droplets array to hold at least three droplets. 
   * Creates a single droplet at position (3,3) with velocity (-1,-2). 
   * Then checks whether calling updateDroplet() on this droplet’s index 
   * correctly results in changing its position to (2.0, 1.3).
   *
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testUpdateDroplet() {
    droplets = new Droplet[3];
    droplets[0] = new Droplet();
    droplets[1] = new Droplet();
    droplets[2] = new Droplet();

    droplets[1].setPositionX(3f);
    droplets[1].setPositionY(3f);
    droplets[1].setVelocityX(-1.0f);
    droplets[1].setVelocityY(-2.0f);
    updateDroplet(1);
    float expectedXPos = 2.0f;
    float expectedYPos = 1.3f;
    if (Math.abs(droplets[1].getPositionX() - expectedXPos) < 0.01
        && Math.abs(droplets[1].getPositionY() - expectedYPos) < 0.01) {
      return true;
    }
    return false;
  }

  /**
   * This tester initializes the droplets array to hold at least three droplets. 
   * Calls removeOldDroplets(6) on an array with three droplets 
   * (two of which have ages over six and another that does not). 
   * Then checks whether the old droplets were removed and 
   * the young droplet was left alone.
   *
   * @return true when no defect is found, and false otherwise
   */
  private static boolean testRemoveOldDroplets() {
    droplets = new Droplet[3];
    droplets[0] = new Droplet();
    droplets[1] = new Droplet();
    droplets[2] = new Droplet();
    droplets[0].setAge(24);
    droplets[1].setAge(34);
    droplets[2].setAge(5);
    removeOldDroplets(6);
    if (droplets[0] != null && droplets[1] != null && droplets[2] == null) {
      return false;
    }
    return true;
  }
}
