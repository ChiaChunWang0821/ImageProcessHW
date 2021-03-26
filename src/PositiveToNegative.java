import java.awt.*;
import java.awt.image.BufferedImage;

public class PositiveToNegative {
    protected static Image convert(BufferedImage image) {
        for(int y = 0; y < image.getHeight(); y++){
            for(int x = 0; x < image.getWidth(); x++){
                int rgb = image.getRGB(x, y);
                int a = (rgb >> 24) & 0xff;
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = (rgb) & 0xff;

                r = 255 - r;
                g = 255 - g;
                b = 255 - b;
                rgb = (a << 24) | (r << 16) | (g << 8) | (b);

                image.setRGB(x, y, rgb);
            }
        }
        return image;
    }
}
