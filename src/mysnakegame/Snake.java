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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;
/**
 *
 * @author Farid
 */
   
public class Snake extends JLabel {

    Body mHead = new Body();

    public Timer mTimer = null;

    public Food mYem = new Food();

    public Random mRandom = null;
    
    public Rock mRock = new Rock();

    public ArrayList<Body> Liste = new ArrayList<Body>();
    
    //public ArrayList<Rock> Arr = new ArrayList<Rock>();
    

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;

        Rectangle2D rect = new Rectangle2D.Double(5, 5, getWidth() - 10, getHeight() - 10);

        g2.setColor(Color.red);

        g2.setStroke(new BasicStroke(10));

        g2.draw(rect);

    }

    Snake() {
        mRandom = new Random(System.currentTimeMillis());
        addKeyListener(new KlavyeKontrol());
        setFocusable(true);
        mTimer = new Timer(100, new TimerKontrol());
        mTimer.start();
        Liste.add(mHead);
        for (int i = 1; i < 3; i++) {
            AddTail();
        }
        add(mYem);
        add(mHead);
        
        for(int i=0;i<8;i++)
        {
            add(mRock.LotsOfRock().get(i));
        }
    }

    public void AddTail() {
        Body K = Liste.get(Liste.size() - 1).KutuOlustur();

        Liste.add(K);
        add(K);
    }

    public void AddFood() {
        int Width = getWidth() - 40 - mYem.mGenislik;
        int Height = getHeight() - 40 - mYem.mGenislik;

        int PosX = 30 + Math.abs(mRandom.nextInt()) % Width;
        int PosY = 30 + Math.abs(mRandom.nextInt()) % Height;

        PosX = PosX - PosX % 20;
        PosY = PosY - PosY % 20;

        for (int i = 0; i < Liste.size(); i++) {
            if ((PosX == Liste.get(i).getX()) && (PosY == Liste.get(i).getY())) {
                AddFood();
                return;
            }
        }

        mYem.setPosition(PosX, PosY);
    }

    public void MoveAll() {
        for (int i = Liste.size() - 1; i > 0; i--) {
            Body Onceki = Liste.get(i - 1);
            Body Sonraki = Liste.get(i);

            Liste.get(i).Hareket();
            Sonraki.mYon = Onceki.mYon;
        }
        mHead.Hareket();
    }

    public boolean Collision() {
        int Kalem = 10;

        int genislik = getWidth();
        int yukseklik = getHeight();

        if (mHead.getX() <= 10) {
            return true;
        }
        if (mHead.getX() + mHead.mGenislik >= genislik - Kalem) {
            return true;
        }
        if (mHead.getY() <= 10) {
            return true;
        }
        if (mHead.getY() + mHead.mGenislik >= yukseklik - Kalem) {
            return true;
        }

        for (int i = 1; i < Liste.size(); i++) {
            int X = Liste.get(i).getX();
            int Y = Liste.get(i).getY();

            if ((X == mHead.getX()) && (Y == mHead.getY())) {
                return true;
            }
        }

        if (mYem.getX() == mHead.getX() && (mYem.getY() == mHead.getY())) {
            AddTail();
            AddFood();
        }
        for(int i=0; i<8;i++)
        {
        if(mYem.getX()==mRock.Arr.get(i).getX() && mYem.getY()==mRock.Arr.get(i).getY())
        {
            AddFood();
        }
        }
        for(int i=0; i<8;i++)
        {
        
        if(mHead.getX()==mRock.Arr.get(i).getX() && mHead.getY()==mRock.Arr.get(i).getY())
        {
            return true;
        }
        }
        return false;
    }

    class KlavyeKontrol implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                if (mHead.mYon != YON.SAG) {
                    mHead.mYon = YON.SOL;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                if (mHead.mYon != YON.SOL) {
                    mHead.mYon = YON.SAG;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                if (mHead.mYon != YON.ASAGI) {
                    mHead.mYon = YON.YUKARI;
                }
            }
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                if (mHead.mYon != YON.YUKARI) {
                    mHead.mYon = YON.ASAGI;
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }

    }

    class TimerKontrol implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            MoveAll();
            if (Collision()) {
                mTimer.stop();
                MainWindow.mPencere.EnterName(Liste.size());
            }
        }

    }

}
