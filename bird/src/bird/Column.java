package bird;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

//柱子
public class Column {

    //图片
    BufferedImage image;

    public int y;
    public int x;
    public int width;
    public int height;
    public int gap;//缝隙
    int distance;//间距
    Random random = new Random();


    //初始化
    public Column(int n) throws IOException {


        image = ImageIO.read(new File("C:\\Users\\Cen\\Desktop\\cangku\\bird\\src\\bird\\column.png"));
        width = image.getWidth();
        height = image.getHeight();

        gap = 144;
        distance = 245;
        x = 500 + (n - 1) * distance;
        y = random.nextInt(218) + 132;

    }

    //向左一步

    public void step(){
        x--;
        if(x==-width/2){
            x=distance*2-width/2;
            y=random.nextInt(218)+132;
        }
    }
}
