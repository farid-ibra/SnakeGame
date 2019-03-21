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

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author Farid
 */
public class MainWindow extends JFrame {

    private int mGenislik = 600;
    private int mYukseklik = 600;
    public static MainWindow mPencere = null;
    
    

    private MainWindow() {
        super("Snake");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        SetDimension(mGenislik, mYukseklik);
        setResizable(false);
 Database.createTable();
        Snake Y = new Snake();

        add(Y);

        JMenuBar menubar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem newgame = new JMenuItem("New Game");
        setJMenuBar(menubar);

        menubar.add(menu);
        menu.add(newgame);
        newgame.addActionListener(new ActionListener() {
            @Override

            public void actionPerformed(ActionEvent e) {
                newGame();
            }
        });
        
        JMenuItem ScoreBoard = new JMenuItem("High Scores");
        ScoreBoard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.printf("action needed");
                Table testing = new Table(mPencere);
                

            }
        });
        menu.add(ScoreBoard);
    }

    public void newGame() {
        MainWindow newWindow = new MainWindow();
        newWindow.setVisible(true);

        this.dispose();
        mPencere.remove(this);
    }
   
    public static MainWindow BringWindow() {
        if (mPencere == null) {
            mPencere = new MainWindow();
        }

        return mPencere;
    }

    public void SetDimension(int Genislik, int Yukseklik) {
        Dimension Dim = Toolkit.getDefaultToolkit().getScreenSize();

        int PosX = 0;
        int PosY = 0;

        if (mGenislik + 100 > Dim.width) {
            mGenislik = Dim.width - 100;
        }
        if (mGenislik + 100 > Dim.height) {
            mGenislik = Dim.height - 100;
        }

        PosX = (Dim.width - mGenislik) / 2;
        PosY = (Dim.height - mYukseklik) / 2;

        setBounds(PosX, PosY, mGenislik, mYukseklik);

    }
    
    public void EnterName(int score) {
        String inputValue = JOptionPane.showInputDialog(mPencere,"Enter your name to save the score!",("GAME OVER!! snake length: " + score) ,JOptionPane.INFORMATION_MESSAGE);
        if(inputValue != null) {
            Database.adder(inputValue, score);
            Database.getter();
        }
    }
}
