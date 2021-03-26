import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class EnhanceContrast {
    protected static Image convert(BufferedImage image) {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat readMat = BufferedImageToMat(image);
        Mat writeMat = new Mat(readMat.rows(), readMat.cols(), readMat.type());
        Imgproc.equalizeHist(readMat, writeMat);
        return MatToBufferedImage(writeMat);
    }

    private static Mat BufferedImageToMat(BufferedImage image){
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ImageIO.write(image, "jpg", byteArrayOutputStream);
            byteArrayOutputStream.flush();
            return Imgcodecs.imdecode(new MatOfByte(byteArrayOutputStream.toByteArray()), Imgcodecs.IMREAD_UNCHANGED);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static BufferedImage MatToBufferedImage (Mat mat){
        try {
            MatOfByte matOfByte = new MatOfByte();
            Imgcodecs.imencode(".jpg", mat, matOfByte);
            return ImageIO.read(new ByteArrayInputStream(matOfByte.toArray()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
