package es.ucm.fdi.pcversion;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Graphics2D;

import javax.swing.JFrame;

import es.ucm.fdi.interfaces.AbstractGraphics;
import es.ucm.fdi.interfaces.GraphicsInterface;
import es.ucm.fdi.interfaces.ImageInterface;
import es.ucm.fdi.utils.Vector2;

/**
 * Implementacion de la interfaz grafica para la plataforma PC
 */
public class PCGraphics extends AbstractGraphics implements GraphicsInterface {
    private Graphics2D g_;
    private JFrame window_;

    public PCGraphics(JFrame window){
        window_ = window;
    }

    public ImageInterface newImage(String name){
        PCImage image = null;
        try{
            image = new PCImage(javax.imageio.ImageIO.read(new java.io.File(name)));
        }
        catch(Exception e){
            System.err.println("PCGraphics: Error leyendo la imagen");
        }
        return image;
    }

    public void clear(int color){
        g_.setColor(new Color(color));
        g_.fillRect(0,0,getWindowWidth(),getWindowHeight());
    }

    public void drawImage(ImageInterface image, int srcLeft, int srcTop, int srcRight, int srcBottom,
                          float dstLeft, float dstTop, float dstRight, float dstBottom, int alpha){

        // reposicionamiento y reescalado -> ASPECT-RATIO
        Vector2 position = logicToPhysic(dstLeft, dstTop);
        Vector2 scale = scaleImage(dstRight, dstBottom);

        float a = (float)alpha/255.0f;  // en PC el alpha va de 0 a 1

        // clamp de alpha, ya que al salirse del intervalo se invierte
        if(alpha < 0) alpha = 0;
        else if (alpha > 1) alpha = 1;

        try{
            Composite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER , a);
            g_.setComposite(comp);
        }
        catch(Exception e){
            System.err.println("Error setting alpha");
        }

        if(image != null)
            g_.drawImage(((PCImage)image).getImage(), (int)position.x, (int)position.y, (int)scale.x + (int)position.x,
                    (int)scale.y + (int)position.y, srcLeft, srcTop, srcRight + srcLeft, srcBottom + srcTop, null);
    }

    public void drawImageRaw(ImageInterface image, int srcLeft, int srcTop, int srcRight, int srcBottom,
                          float dstLeft, float dstTop, float dstRight, float dstBottom, int alpha){

        float a = (float)alpha/255.0f;  // en PC el alpha va de 0 a 1

        // clamp de alpha, ya que al salirse del intervalo se invierte
        if(alpha < 0) alpha = 0;
        else if (alpha > 1) alpha = 1;

        try{
            Composite comp = AlphaComposite.getInstance(AlphaComposite.SRC_OVER , a);
            g_.setComposite(comp);
        }
        catch(Exception e){
            System.err.println("Error setting alpha");
        }

        if(image != null)
            g_.drawImage(((PCImage)image).getImage(), (int)dstLeft, (int)dstTop, (int)dstRight + (int)dstLeft,
                    (int)dstBottom + (int)dstTop, srcLeft, srcTop, srcRight + srcLeft, srcBottom + srcTop, null);
    }

    public void setGraphics(Graphics2D g){g_ = g;}

    // ASPECT-RATIO
    public void scaleCanvas(){
        super.scaleCanvas(getWindowWidth(), getWindowHeight());
    }

    public int getWindowWidth(){return window_.getWidth();}
    public int getWindowHeight(){return window_.getHeight();}
}
