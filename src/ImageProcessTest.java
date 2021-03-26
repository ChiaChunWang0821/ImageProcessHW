public class ImageProcessTest {
    public static void main(String[] args)
    {
//        String read_filename = "C:\\Users\\User\\Desktop\\1091 影像處理\\作業\\109522116王佳君\\data\\4\\origin.jpg";
//        String write_filename = "C:\\Users\\User\\Desktop\\1091 影像處理\\作業\\109522116王佳君\\data\\4\\convert.jpg";
//        BufferedImage readImage = ImageReader.read(read_filename);
//        ImageWriter.write(PositiveToNegative.convert(readImage), ImageType.JPG, write_filename);
//        System.out.println("FINISH!!");

        String read_filename = "./src/data/4/origin.jpg";
        String write_filename = "./src/data/4/smooth.jpg";
//        String write_filename = "./src/data/4/sharpen.jpg";
        double deviationX = 20;
        double deviationY = 5;
        ImageSmooth.convert(true, read_filename, write_filename, deviationX, deviationY);
        System.out.println("FINISH!!");
    }
}
