package util.test;

import org.junit.jupiter.api.Test;

import static util.ImageCheck.imageFromURL;
import static util.ImageCheck.imageURLChecked;

import java.awt.image.BufferedImage;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for the ImageCheck class functions
 */
public class TestImage {
    private static String normURL = "https://www.cs.ubc.ca/~norm";
    // Wikipedia logo from: https://nl.wikipedia.org/wiki/Wikipedialogo#/media/File:Wikipedia_logo_nohat_only_wikipedia.png
    // Licensed under CC BY-SA 3.0: https://creativecommons.org/licenses/by-sa/3.0/
    private static String wikiImageURL = "https://upload.wikimedia.org/wikipedia/commons/3/38/Wikipedia_logo_nohat_only_wikipedia.png";
    private static String defaultImageURL = "http://png-2.findicons.com/files/icons/1995/web_application/48/smiley.png";
    public static BufferedImage defaultImage = imageFromURL(defaultImageURL);

    @Test
    public void testimageFromURL() {
        // test if the default picture is returned when provided an invalid image url
        BufferedImage normImage = imageFromURL(normURL);
        assertTrue(compareImages(normImage, defaultImage));
        // test if the image doesn't match with the default one when  a correct url is provided
        BufferedImage wikiImg = imageFromURL(wikiImageURL);
        assertFalse(compareImages(wikiImg, defaultImage));
    }

    @Test
    public void testimageURLChecked() {
        // test an incorrect url
        String url = imageURLChecked(normURL);
        assertEquals(url, defaultImageURL);
        // test a correct url
        String wikiUrl = imageURLChecked(wikiImageURL);
        assertEquals(wikiUrl, wikiImageURL);
    }

    /**
     * solution from:
     * https://stackoverflow.com/questions/11006394/is-there-a-simple-way-to-compare-bufferedimage-instances
     *
     * Helper function that compares two images pixel by pixel.
     *
     * @param imgA the first image.
     * @param imgB the second image.
     * @return whether the images are both the same or not.
     */
    public static boolean compareImages(BufferedImage imgA, BufferedImage imgB) {
        // The images must be the same size.
        if (imgA.getWidth() != imgB.getWidth() || imgA.getHeight() != imgB.getHeight()) {
            return false;
        }

        int width  = imgA.getWidth();
        int height = imgA.getHeight();

        // Loop over every pixel.
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // Compare the pixels for equality.
                if (imgA.getRGB(x, y) != imgB.getRGB(x, y)) {
                    return false;
                }
            }
        }

        return true;
    }
}
