package ui;

import org.openstreetmap.gui.jmapviewer.Layer;
import org.openstreetmap.gui.jmapviewer.MapMarkerCircle;
import twitter4j.Status;

import java.awt.*;
import java.awt.image.BufferedImage;

import static util.ImageCheck.imageFromURL;
import static util.ImageCheck.imageURLChecked;
import static util.TweetLocation.statusCoordinate;

public class MapMarkerPrettier extends MapMarkerCircle {
    public static final double defaultMarkerSize = 5.0;
    private BufferedImage profileImage;
    private Status status;
    private String profileImgURL;

    public MapMarkerPrettier(Layer layer, Color color, Status status) {
        super(layer, null, statusCoordinate(status), defaultMarkerSize, STYLE.FIXED, getDefaultStyle());
        setColor(color);
        setBackColor(color);
        this.status = status;

        // set the profile image (url) to the correct or default image
        profileImage = imageFromURL(status.getUser().getProfileImageURL());
        profileImgURL = imageURLChecked(status.getUser().getProfileImageURL());
    }

    // getter for the Twitter profile image
    public String getProfileImgURL() {
        return profileImgURL;
    }
    // getter for the Twitter status text
    public String getStatusText() {
        return status.getText();
    }

    /**
     * override for the paint function in MapMarkerCircle to draw a marker of:
     * - a (larger) circle with the color of the query, with on top of that:
     * - an (smaller) image of the Twitter profile that has a tweet matching the query
     */
    @Override
    public void paint(Graphics g, Point position, int radius) {
        int width = this.profileImage.getWidth(null) / 2;
        int height = this.profileImage.getHeight(null) / 2;

        g.setColor(this.getColor());
        g.fillOval(position.x - width, position.y - height, width * 2, height * 2);
        g.drawImage(this.profileImage, position.x - (width / 2), position.y - (height / 2), width, height, null);
    }
}