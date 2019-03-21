// Farid Ibrahimli
//
// DQWMYW
//
// PSE_Second_Assignment
//
// 2019/01/07 16:30:20
//
// This solution was submitted and prepared by Farid Ibrahimli, DQWMYW for the
// Snake game assignment of the Practical software engineering I. course.
//
// I declare that this solution is my own work.
//
// I have not copied or used third party solutions.
//
// I have not passed my solution to my classmates, neither  made it public.
//
// Students’ regulation of Eötvös Loránd University (ELTE Regulations
// Vol. II. 74/C. § ) states that as long as a student presents another
// student’s work - or at least the significant part of it - as his/her own
// performance, it will count as a disciplinary fault. The most serious
// consequence of a disciplinary fault can be dismissal of the student from
// the University.
package mysnakegame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author Farid
 */
public class Rock extends JLabel {

    public int mGenislik = 20;
    Random mRandom = new Random();
    public static ArrayList<Rock> Arr = new ArrayList<Rock>();
    Rock() {

        int Width = getWidth() - 90 - mGenislik;
        int Height = getHeight() - 90 - mGenislik;

        int PosX = 20 * (int) (Math.random()%400 * 20) ;
        int PosY = 20 * (int) (Math.random()%400 * 20) ;

        PosX = PosX - PosX % 20;
        PosY = PosY - PosY % 20;
        
        setPosition(PosX, PosY);
        
       

    }
    
   public ArrayList<Rock>  LotsOfRock()
   {
       for(int i=0; i<8;i++)
       {
           
        Rock m1 =new Rock();
        
        Arr.add(m1);
       }
       return Arr;
   }  

    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D ellipse = new Rectangle2D.Double(1, 1, mGenislik - 2, mGenislik - 2);

        g2.setColor(Color.black);

        g2.setStroke(new BasicStroke(2));

        g2.draw(ellipse);

        g2.setColor(Color.black);

        g2.fill(ellipse);

    }

    public void setPosition(int PosX, int PosY) {
        setBounds(PosX, PosY, mGenislik, mGenislik);
    }

}
