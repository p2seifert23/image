import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments 
     */
    public Picture ()
    {
        /* not needed but use it to show students the implicit call to super()
         * child constructors always call a parent constructor 
         */
        super();  
    }

    /**
     * Constructor that takes a file name and creates the picture 
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName)
    {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width)
    {
        // let the parent class handle this width and height
        super(width,height);
    }

    /**
     * Constructor that takes a picture and creates a 
     * copy of that picture
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture)
    {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image)
    {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////

    /**
     * Method to return a string with information about this picture.
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString()
    {
        String output = "Picture, filename " + getFileName() + 
            " height " + getHeight() 
            + " width " + getWidth();
        return output;

    }

    /** Method to set the blue to 0 */
    public void zeroBlue()
    {
        Pixel[][] pix = this.getPixels2D();

        for (int r = 0; r < pix.length; r++)
        {
            for (int c = 0; c < pix[r].length; c++)
            {
                pix[r][c].setBlue(0); 
            }
        }
    }

    public void keepBlue()
    {
        Pixel[][] pix = this.getPixels2D();

        for (Pixel[] row: pix)
        {
            for (Pixel p: row)
            {
                p.setRed(0);
                p.setGreen(0); 
            }
        }
    }

    public void grayscale1()
    {
        Pixel[][] pix = this.getPixels2D();

        for (int r = 0; r < pix.length; r++)
        {
            for (int c = 0; c < pix[r].length; c++)
            {
                int blue = pix[r][c].getBlue(); 
                int red = pix[r][c].getRed(); 
                int green = pix[r][c].getGreen(); 

                int total = (blue+red+green)/3; 
                //System.out.println(total); 

                pix[r][c].setBlue(total);
                pix[r][c].setRed(total);
                pix[r][c].setGreen(total);
            }
        }
    }

    /** Method that mirrors the picture around a 
     * vertical mirror in the center of the picture
     * from left to right */
    public void mirrorVertical()
    {
        Pixel[][] pix = this.getPixels2D();
        

        for (int r = 0; r < pix.length; r++)
        {
            for (int c = 0; c < pix[r].length/2; c++)
            {
                Color c1 = pix[r][c].getColor(); 
                int endIndex = pix[0].length - c-1; 
                pix[r][endIndex].setColor(c1); 
            }
        }
    }
    
    public void mirrorHorizontal()
    {
        Pixel[][] pix = this.getPixels2D();
    
        for (int r = 0; r < pix.length/2; r++)
        {
            for (int c = 0; c < pix[r].length; c++)
            {
                Color c1 = pix[r][c].getColor(); 
                int endIndex = pix.length - r -1; 
                pix[endIndex][c].setColor(c1); 
            }
        }
    }
    
    public void mirrorDiagonal()
    {
        Pixel[][] pix = this.getPixels2D();
    
        for (int r = 0; r < pix.length/2; r++)
        {
            for (int c = 0; c < pix[r].length/2; c++)
            {
                Color c1 = pix[r][c].getColor(); 
                int endIndex = pix.length - r -1; 
                pix[endIndex][c].setColor(c1); 
            }
        }
    }

    /** Mirror just part of a picture of a temple */
    public void mirrorTemple()
    {
        Pixel[][] pix = this.getPixels2D();

        for (int r = 0; r < 100; r++)
        {
            for (int c = 0; c < pix[r].length/2; c++)
            {
                Color c1 = pix[r][c].getColor(); 
                int endIndex = pix[0].length - c-1; 
                pix[r][endIndex].setColor(c1); 
            }
        }
    }

    /** copy from the passed fromPic to the
     * specified startRow and startCol in the
     * current picture
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic, 
    int startRow, int startCol)
    {

    }

    /** Method to create a collage of several pictures */
    public void createCollage()
    {

    }

    /** Method to show large changes in color 
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist)
    {

    }

    /* Main method for testing - each class in Java can have a main 
     * method 
     */
    public static void main(String[] args) 
    {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
