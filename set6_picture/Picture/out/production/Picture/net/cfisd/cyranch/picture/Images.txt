


package net.cfisd.cyranch.picture;

/*
 * Note: these methods are public in order for them to be used by other files
 * in this assignment; DO NOT change them to private.  You may add additional
 * private methods to implement required functionality if you would like.
 *
 * You should remove the stub lines from each method and replace them with your
 * implementation that returns an updated image.
 */

import acm.graphics.GImage;

public class Images implements ImageConversions {

    public GImage flipHorizontal(GImage source) {
        // TODO
        int[][] pixelArray = source.getPixelArray();
        int[][] ret = new int[pixelArray.length][pixelArray[0].length];
        for (int i = 0; i < pixelArray.length; i++) {
            for (int j = pixelArray[0].length - 1; j > -1; j--) {
                ret[i][(pixelArray[0].length - 1) - j] = pixelArray[i][j];
            }
        }
        return new GImage(ret);
    }

    public GImage rotateLeft(GImage source) {
        // TODO
        int[][] pixelArray = source.getPixelArray();
        int[][] ret = new int[pixelArray[0].length][pixelArray.length];
        for (int i = 0; i < pixelArray.length; i++) {
            for (int j = 0; j < pixelArray[0].length; j++) {
                ret[j][i] = pixelArray[i][pixelArray[0].length - j - 1];
            }
        }
        return new GImage(ret);
    }

    public GImage rotateRight(GImage source) {
        // TODO
        int[][] pixelArray = source.getPixelArray();
        GImage ret = new GImage(pixelArray);
        ret = rotateLeft(rotateLeft(rotateLeft(ret)));
        return ret;
    }

    public GImage greenScreen(GImage source) {
        int[][] pixels = source.getPixelArray();
        for (int i = 0; i < pixels.length; i++)
            for (int j = 0; j < pixels[i].length; j++) {
                int red = GImage.getRed(pixels[i][j]);
                int green = GImage.getGreen(pixels[i][j]);
                int blue = GImage.getBlue(pixels[i][j]);
                if (green >= Math.max(red, blue) * 2) pixels[i][j] = GImage.createRGBPixel(red, green, blue, 0);
                else pixels[i][j] = GImage.createRGBPixel(red, green, blue);
            }
        return new GImage(pixels);
    }






    public GImage equalize(GImage source) {
        // TODO
        int[] luminosity = new int[256];
        int[][] pixelArray = source.getPixelArray();
        int[][] ret = new int[pixelArray.length][pixelArray[0].length];
        for (int[] ints : pixelArray) {
            for (int j = 0; j < pixelArray[0].length; j++) {
                int pixel = ints[j];
                int lumin = computeLuminosity(GImage.getRed(pixel), GImage.getGreen(pixel), GImage.getBlue(pixel));
                luminosity[lumin]++;
            }
        }
        int[] cumulativeLuminosity = new int[256];
        for (int i = 0; i < cumulativeLuminosity.length; i++){
            for (int j = i; j > -1; j--){
                cumulativeLuminosity[i] += luminosity[j];
            }
        }

        for (int i = 0; i < pixelArray.length; i++){
            for (int j = 0; j < pixelArray[0].length; j++){
                int pixel = pixelArray[i][j];
                int lumin = computeLuminosity(GImage.getRed(pixel), GImage.getGreen(pixel), GImage.getBlue(pixel));
                int rgb = 255 * (cumulativeLuminosity[lumin]) / (pixelArray.length * pixelArray[0].length);
                int newPixel = GImage.createRGBPixel(rgb, rgb, rgb);
                ret[i][j] = newPixel;
            }
        }
        return new GImage(ret);
    }

    public GImage negative(GImage source) {
        // TODO
        int[][] pixelArray = source.getPixelArray();
        for (int i = 0; i < pixelArray.length; i++) {
            for (int j = 0; j < pixelArray[0].length; j++) {
                int pixel = GImage.createRGBPixel(255 - GImage.getRed(pixelArray[i][j]), 255 - GImage.getGreen(pixelArray[i][j]), 255 - GImage.getBlue(pixelArray[i][j]));
                pixelArray[i][j] = pixel;
            }
        }
        return new GImage(pixelArray);
    }

    public GImage translate(GImage source, int dx, int dy) {
        // TODO
        int[][] pixelArray = source.getPixelArray();
        int[][] ret = new int[pixelArray.length][pixelArray[0].length];
        if (dx <= -1) {
            dx = dx + pixelArray[0].length;
        }
        if (dy <= -1) {
            dy = dy + pixelArray.length;
        }
        for (int i = 0; i < pixelArray.length; i++) {
            for (int j = 0; j < pixelArray[0].length; j++) {
                int rowIndex = (i + dy) % pixelArray.length;
                int colIndex = (j + dx) % pixelArray[0].length;
                ret[rowIndex][colIndex] = pixelArray[i][j];
            }
        }
        return new GImage(ret);
    }

    public GImage blur(GImage source) {
        int[][] pixelArray = source.getPixelArray();
        int[][] ret = new int[pixelArray.length][pixelArray[0].length];
        for (int i = 0; i < pixelArray.length; i++) {
            for (int j = 0; j < pixelArray[0].length; j++) {
                int[] indexes = new int[]{-1, 0, 1};
                int redSum = 0;
                int greenSum = 0;
                int blueSum = 0;
                int count = 0;
                for (int k : indexes) {
                    for (int l : indexes) {
                        if (isValid(pixelArray, i + k, j + l)) {
                            int pixel = pixelArray[i + k][j + l];
                            redSum += GImage.getRed(pixel);
                            greenSum += GImage.getGreen(pixel);
                            blueSum += GImage.getBlue(pixel);
                            count++;
                        }
                    }
                }
                ret[i][j] = GImage.createRGBPixel(redSum/count, greenSum/count, blueSum/count);
            }
        }
        return new GImage(ret);
    }


    private boolean isValid(int[][] pixelArray, int r, int c) {
        return (r >= 0 && r < pixelArray.length) && (c >= 0 && c < pixelArray[0].length);
    }

}
