package 第三周;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class PlayerControl extends KeyAdapter {
    GameFrame frame;

    public PlayerControl(GameFrame frame) {
        this.frame = frame;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case 38:
                frame.heroPlane.up = true;
                break;
            case 40:
                frame.heroPlane.down = true;
                break;
            case 37:
                frame.heroPlane.left = true;
                break;
            case 39:
                frame.heroPlane.right = true;
                break;
            case 66:
                addBullet();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case 38:
                frame.heroPlane.up = false;
                break;
            case 40:
                frame.heroPlane.down = false;
                break;
            case 37:
                frame.heroPlane.left = false;
                break;
            case 39:
                frame.heroPlane.right = false;
                break;
        }
    }

    private void addBullet() {
        frame.bullets.add(new Bullet(frame.heroPlane.x + 10,frame.heroPlane.y - 50));
    }
}
