package bird;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Bird {

    //图片
    BufferedImage image;
    //位置
    int x, y;
    //宽高
    int width, height;
    //大小
    int size;


    //重力
    double g;

    //位移时间间隔
    double t;

    //最初上抛速度
    double v0;

    //当前速度
    double speed;

    //经过t秒后位移
    double s;

    //小鸟倾角
    double alpha;

    //小鸟动画
    BufferedImage[] images;
    int index;//每帧数组下标

    public Bird() throws IOException {
        image = ImageIO.read(new File("C:\\Users\\Cen\\Desktop\\cangku\\bird\\src\\bird\\1.png"));
        width = image.getWidth();
        height = image.getHeight();
        x = 132;
        y = 280;
        size = 40;


        g = 4;
        v0 = 20;
        t = 0.25;
        speed = v0;
        s = 0;
        alpha = 0;

        images = new BufferedImage[8];
        for (int i = 1; i < 8; i++) {
            images[i] = ImageIO.read(new File("C:\\Users\\Cen\\Desktop\\cangku\\bird\\src\\bird\\"+i + ".png"));
        }
        index = 0;
    }

    //飞行一帧
    public void fly() {
        index++;
        image = images[(index / 12) % 8];
    }

    //移动一步
    public void step() {
        double v0 = speed;
        s = v0 * t + g * t * t / 2;
        y = y - (int) s;
        double v = v0 - g * t;
        speed = v;
        alpha = Math.atan(s / 8);
    }

    //向上
    public void flappy() {
        speed = v0;
    }

    //检查是否触底
    public boolean hit(Ground ground) {
        boolean hit = y + size / 2 > ground.y;
        if (hit) {
            y = ground.y - size / 2;
            alpha = -3.14159 / 2;
        }
        return hit;
    }

    //检查是否碰到柱子

    public boolean hit(Column column) {
        //是否在范围内
        if (x > column.x - column.width / 2 - size / 2 && x < column.x + column.width / 2 + size / 2) {
            //是否在缝隙中
            if (y > column.y - column.gap / 2 + size / 2 && y < column.y + column.gap / 2 - size / 2) {
                return false;
            }
            return true;
        }
        return false;
    }


}
