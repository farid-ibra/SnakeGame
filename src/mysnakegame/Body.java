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
import javax.swing.JLabel;

/**
 *
 * @author Farid
 */
public class Body extends JLabel {

    public int mGenislik = 20;

    public int mYon = YON.SAG;

    Body() {

        setBounds(100, 100, mGenislik, mGenislik);

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D rect = new Rectangle2D.Double(1, 1, getWidth() - 2, getHeight() - 2);

        g2.setColor(Color.black);

        g2.setStroke(new BasicStroke(2));

        g2.draw(rect);

        g2.setColor(Color.red);

        g2.fill(rect);

    }

    public void SolaGit() {
        int PosX = getX();
        int PosY = getY();

        PosX -= mGenislik;
        setBounds(PosX, PosY, mGenislik, mGenislik);
    }

    public void SagaGit() {
        int PosX = getX();
        int PosY = getY();

        PosX += mGenislik;
        setBounds(PosX, PosY, mGenislik, mGenislik);
    }

    public void YukariGit() {
        int PosX = getX();
        int PosY = getY();

        PosY -= mGenislik;
        setBounds(PosX, PosY, mGenislik, mGenislik);
    }

    public void AsagiGit() {
        int PosX = getX();
        int PosY = getY();

        PosY += mGenislik;
        setBounds(PosX, PosY, mGenislik, mGenislik);
    }

    public Body KutuOlustur() {
        Body K = new Body();

        int X = getX();
        int Y = getY();

        K.setBounds(X, Y, mGenislik, mGenislik);

        K.mYon = -mYon;
        K.Hareket();
        K.mYon = mYon;
        return K;
    }

    public void Hareket() {
        if (mYon == YON.SOL) {
            SolaGit();
        } else if (mYon == YON.SAG) {
            SagaGit();
        } else if (mYon == YON.ASAGI) {
            AsagiGit();
        } else {
            YukariGit();
        }
    }
}
