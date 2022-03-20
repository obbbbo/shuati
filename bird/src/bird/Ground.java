package bird;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

//地面类
public class Ground {
    //图片
    BufferedImage image;


    public int y;
    public int x;
    public int width;
    public  int heigth;



    public int gap;



    public Ground() throws IOException {
        image = ImageIO.read(new File("C:\\Users\\Cen\\Desktop\\cangku\\bird\\src\\bird\\ground.png"));
        width = image.getWidth();
        heigth = image.getHeight();
        x=0;
        y=500;


    }

    //向左一步
    public void step(){
        x--;
        if(x==-109){
            x=0;
        }
    }


}
