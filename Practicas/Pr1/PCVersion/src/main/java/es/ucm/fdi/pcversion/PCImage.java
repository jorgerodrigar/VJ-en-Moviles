package es.ucm.fdi.pcversion;

import java.awt.Image;

import es.ucm.fdi.interfaces.ImageInterface;

public class PCImage implements ImageInterface {
    private Image image_;

    public PCImage(Image image){ image_ = image;}
    public int getWidth(){return image_.getWidth(null);}
    public int getHeight(){return image_.getHeight(null);}
    public Image getImage(){return image_;}
}
