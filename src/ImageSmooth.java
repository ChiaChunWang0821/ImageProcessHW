import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageSmooth {

    protected static void convert(boolean smooth, String inputFile, String outputFile, double deviationX, double deviationY){
        try{
            System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
            Mat inputMat = Imgcodecs.imread(inputFile, Imgcodecs.IMREAD_COLOR);
            Mat outputMat = new Mat(inputMat.rows(),inputMat.cols(),inputMat.type());
            Imgproc.GaussianBlur(inputMat, outputMat, new Size(0,0), deviationX, deviationY);

            if(smooth == false){
                Core.addWeighted(inputMat, 1.5, outputMat, -0.5, 0, outputMat);
            }

            Imgcodecs.imwrite(outputFile, outputMat);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
