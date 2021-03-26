import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;

public class RBGtoGray {
    protected static Image convert(BufferedImage image, int scale) {
        ImageFilter filter = new GrayFilter(true, scale);
        ImageProducer producer = new FilteredImageSource(image.getSource(), filter);
        Image newImage = Toolkit.getDefaultToolkit().createImage(producer);
        return newImage;
    }
}
