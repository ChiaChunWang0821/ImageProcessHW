import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageWriter {
    protected static void write(Image image, ImageType type, String filename) {
        BufferedImage bufferedImage = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_INT_RGB);
        switch (type){
            case JPG:
                try {
                    bufferedImage.createGraphics().drawImage(image, 0, 0, Color.WHITE, null);
                    ImageIO.write(bufferedImage, "jpg", new File(filename));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case PNG:
                try {
                    ImageIO.write(bufferedImage, "png", new File(filename));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case GIF:
                try {
                    ImageIO.write(bufferedImage, "gif", new File(filename));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case BMP:
                try {
                    ImageIO.write(bufferedImage, "bmp", new File(filename));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                break;
        }
    }
}
