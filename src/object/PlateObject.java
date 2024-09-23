/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import eg.edu.alexu.csd.oop.game.GameObject;

/**
 *
 * @author ranee
 */
public class PlateObject implements GameObject {

    private static final int MAX_MSTATE = 1;
    // an array of sprite images that are drawn sequentially
    private BufferedImage[] spriteImages = new BufferedImage[MAX_MSTATE];
    private int x;
    private int y;
    private boolean visible;
    private int type;
    private boolean leftOrRight;
    private boolean isHorizontalOnly;
    private int colorCode;
    private static int id_general=-1; 
    private int id;

    // know if the plate coming from left or right left = false right = true
    public PlateObject(int posX, int posY, String path) {
        this(posX, posY, path, 0, false);
        this.id=++id_general;
    }

    public int getId() {
        return id;
    }

    public PlateObject(int posX, int posY, String path, int type, boolean leftOrRight) {
        this.x = posX;
        this.y = posY;
        this.type = type;
        this.visible = true;
        this.leftOrRight = leftOrRight;
        // create a bunch of buffered images and place into an array, to be displayed sequentially
        try {
            spriteImages[0] = ImageIO.read(getClass().getResourceAsStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setIsHorizontalOnly(boolean isHorizontalOnly) {
        this.isHorizontalOnly = isHorizontalOnly;
    }

    public int getColorCode() {
        return colorCode;
    }

    public void setColorCode(int colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public boolean isIsHorizontalOnly() {
        return isHorizontalOnly;
    }

    public boolean isLeftOrRight() {
        return leftOrRight;
    }

    public void setLeftOrRight(boolean leftOrRight) {
        this.leftOrRight = leftOrRight;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final PlateObject other = (PlateObject) obj;
//        return this.leftOrRight == other.leftOrRight;
//    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public void setX(int mX) {
        if (this.type == 1) {
            if (mX >= 850) {
                return;
            }
        }
        if (this.type == 2) {
            if (mX <= 50) {
                return;
            }
        }

        this.x = mX;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public void setY(int mY) {
        if (isHorizontalOnly) {
            return;
        }
        this.y = mY;

    }

    @Override
    public BufferedImage[] getSpriteImages() {
        return spriteImages;
    }

    @Override
    public int getWidth() {
        return spriteImages[0].getWidth();
    }

    @Override
    public int getHeight() {
        return spriteImages[0].getHeight();
    }

    @Override
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
