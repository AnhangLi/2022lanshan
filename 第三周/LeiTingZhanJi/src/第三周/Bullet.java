package 第三周;

import javax.swing.*;
import java.awt.*;


public class Bullet {
    int x;
    int y;
    int width = 60;
    int height = 60;
    int speed = 15;


    Image img = new ImageIcon("img/bullet5.gif").getImage();

    public Bullet() {
    }

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

}
