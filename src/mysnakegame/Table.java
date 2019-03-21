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

/**
 *
 * @author Farid
 */
import javax.swing.*;

public class Table extends JDialog {
    private final JTable table;

    String[] columnNames = {"Name","Score"};

   
    String [][] data = new String[10][2];


    public Table(JFrame frame){
        super(frame);

        for(int i=0;i<10;++i){
            data[i][0] = Database.mTemp[i][0];
            data[i][1] = Database.mTemp[i][1];
        }
       



       table = new JTable(data,columnNames);
        table.setFillsViewportHeight(true);
        add(new JScrollPane(table));
        setSize(400,400);
        setTitle("High Scores");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);


    }

}
