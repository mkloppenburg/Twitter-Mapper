package util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/**
 * A set of functions to check if an image from a provided url can be loaded
 * and if not return a default pre-checked option.
 */
public class ImageCheck {
    // URL to a default pre-checked image to be used in case images can't be loaded properly
    private static String defaultImageURL = "http://png-2.findicons.com/files/icons/1995/web_application/48/smiley.png";
    public static BufferedImage defaultImage = imageFromURL(defaultImageURL);

    /**
     * Checks if the provided URL leads to a valid image
     * @param url to be checked for a valid image
     * @return a default BufferedImage or a valid checked one
     */
    public static BufferedImage imageFromURL(String url) {
        try {
            BufferedImage img = ImageIO.read(new URL(url));
            if (img == null) return defaultImage;
            return img;
        } catch (IOException e) {
            return defaultImage;
        }
    }

    /**
     * Checks if the provided URL leads to a valid image
     * @param url to be checked for a valid image
     * @return the url to the default image or valid image
     */
    public static String imageURLChecked(String url) {
        try {
            BufferedImage img = ImageIO.read(new URL(url));
            if (img == null) return defaultImageURL;
            return url;
        } catch (IOException e) {
            return defaultImageURL;
        }
    }
}
