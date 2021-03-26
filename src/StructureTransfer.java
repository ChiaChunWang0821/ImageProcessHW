import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class StructureTransfer {

    protected static Mat BufferedImageToMat(BufferedImage image, int imageType, int matType){
        if(image == null){
            return null;
        }

        if(image.getType() != imageType){
            BufferedImage newImage = new BufferedImage(image.getWidth(), image.getHeight(), imageType);

            Graphics2D g = newImage.createGraphics();
            g.setComposite(AlphaComposite.Src);
            g.drawImage(image, 0, 0, null);
            g.dispose();
        }

        byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        Mat mat = Mat.eye(image.getHeight(), image.getWidth(), matType);
        mat.put(0, 0, pixels);
        return mat;
    }

    protected static BufferedImage MatToBufferedImage (Mat mat, ImageType type){
        MatOfByte matOfByte = new MatOfByte();
        String fileExtension = null;
        switch (type){
            case JPG:
                fileExtension = ".jpg";
                break;
            case PNG:
                fileExtension = ".png";
                break;
            case GIF:
                fileExtension = ".gif";
                break;
            case BMP:
                fileExtension = ".bmp";
                break;
        }

        Imgcodecs.imencode(fileExtension, mat, matOfByte);
        byte[] bytes = matOfByte.toArray();
        BufferedImage image = null;

        try {
            InputStream inputStream = new ByteArrayInputStream(bytes);
            image = ImageIO.read(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }
}
