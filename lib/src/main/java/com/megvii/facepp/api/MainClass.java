package com.megvii.facepp.api;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author by licheng on 2018/7/23.
 */

public class MainClass {

    private static int colorToRGB(int alpha, int red, int green, int blue) {

        int newPixel = 0;
        newPixel += alpha;
        newPixel = newPixel << 8;
        newPixel += red;
        newPixel = newPixel << 8;
        newPixel += green;
        newPixel = newPixel << 8;
        newPixel += blue;

        return newPixel;

    }

    /**
     * base64字符串转文件
     *
     * @param base64
     * @return
     */
    public static File base64ToFile(String base64, String outFilePath) {
        File file = null;

        FileOutputStream out = null;
        try {
            // 解码，然后将字节转换为文件
            file = new File(outFilePath);
            if (!file.exists())
                file.createNewFile();
            byte[] bytes = Base64.decode(base64);// 将字符串转换为byte数组
            System.out.println("字符串长度 : " + bytes.length);
            ByteArrayInputStream in = new ByteArrayInputStream(bytes);
            byte[] buffer = new byte[1024];
            out = new FileOutputStream(file);
            int bytesum = 0;
            int byteread = 0;
            while ((byteread = in.read(buffer)) != -1) {
                bytesum += byteread;
                out.write(buffer, 0, byteread); // 文件写操作
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }


    static final String base64 = "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paawrx79oGLd4bmPoK+IdSGJm+tZ5pKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKUdaswdRXuvwFtfN1CM4719e6VFsiUVpgU4CijFGKBS0hryL4/vt8Mz/SvhzU2zM31rPNJRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRSrVu3HzCvov9nSHfcqcV9X2i4QVap1BooooprV5F8fE8zw5MPY18O6qu24ce9Z5pKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKVatQNyK+kf2a5M3AFfVtv90VYFLS0UUUhpjmvKPjb8+hTD2NfD2vptvJB71k4pKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKUVLG2DXuX7POr/ZtYjjLYDGvsvT5hLEpB61eFKKWiiikNQXDbVJr57/aB8TfZLR7dHwT718j6jcG4mZ2OSTVGkooooooooooooooooooooooooooooooooooooooooooooooopacK7P4daqdM1eGQNjDCvub4eawuqaVDIGzkCu1FKKWiiikrC8Vagun6dLMxwFUmvh74xeJ21jWJsPlASBzXlzNmmmkoooooooooooooooooooooooooooooooooooooooooooooooopwq/pspimUg9DX2J+znqn2nSUjLZK172vSnUUClpDTWOK8h+P2t/2d4dmUNhmGK+HdVuTcXDuTkk1n0UUUUUUUUUUUuKMUlFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFFKKngOGFfUX7L1xncma+pY+lPNIaAaWio5jhTXyx+1Pq2GS2Vvwr5bkOSaZRRRRRRRRRRT40LGra2rHtTJbdlPSovKPpTGQim4pKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKKUVLF1r6S/Zek/0xlr62h+6KkNNY4pitTs04VBeHETGvin9pq883xO0efu14YaSiiiiiiiiilAyauWifMDWk82zvVaWct3qENUcgzUJWmFcU2kooooooooooooooooooooooooooooooooqWPrX0v+yzbbrp3x0r6ziGAKeahnbCmoIpMirCnNSLVTVG22zn2r4R/aCn87xjc85wa8nooooooooooqSIZYVoJ8lMmkyag3UBqGahTmh0zU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";

    public static void main(String[] args) throws IOException {

        BufferedImage bufferedImage = ImageIO.read(base64ToFile(base64, "lib/test.jpeg"));

//        BufferedImage grayImage = new BufferedImage(bufferedImage.getWidth(),
//                bufferedImage.getHeight(),
//                bufferedImage.getType());


        for (int i = 0; i < bufferedImage.getWidth(); i++) {
            for (int j = 0; j < bufferedImage.getHeight(); j++) {
                final int color = bufferedImage.getRGB(i, j);

                final int r = (color >> 16) & 0xff;
                final int g = (color >> 8) & 0xff;
                final int b = color & 0xff;
                int gray = (int) (0.3 * r + 0.59 * g + 0.11 * b);

                if (0 != r && 0 != g && 0 != b) {
                  //  System.out.println(i + " : " + j + " --- color ：" + color + " , gray : " + gray + " ， r : " + r + " g : " + g + " b : " + b);
                }

                //  int newPixel = colorToRGB(255, gray, gray, gray);
                //  grayImage.setRGB(i, j, newPixel);
            }
        }
//        File newFile = new File("lib/ok.jpg");
//        ImageIO.write(grayImage, "jpg", newFile);
    }
}
