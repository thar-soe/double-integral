//Thar Soe

import java.util.*;
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class doubleIntegralDriver
{
    private static final int FRAME_WIDTH = 800;
    private static final int FRAME_HEIGHT = 400;
    public static JLabel equation = new JLabel("Equation:");

    public static JTextField getstart1 = new JTextField(2);
    public static JTextField getstop1 = new JTextField(2);
    public static JTextField getstart2 = new JTextField(2);
    public static JTextField getstop2 = new JTextField(2);
    public static JTextField getEquation = new JTextField(20);
    public static JButton calculate = new JButton("Calculate");
    public static JLabel integral1 = new JLabel("\u222B");
    public static JLabel integral2 = new JLabel("\u222B");
    public static JLabel dxdy = new JLabel("dydx");
    public static JLabel answer= new JLabel("0.0");
    final static JFrame frame = new JFrame();

    static String lower1,upper1,lower2,upper2;
    static String function;

   //Double Integration Call 
    public static void main (String[]args)
    {
        javax.swing.SwingUtilities.invokeLater(new Runnable() 
            {
                public void run() 
                {
                    createAndShowGUI();
                    class  CalculateListener implements ActionListener {
                        public void actionPerformed(ActionEvent event)
                        {
                            lower1=getstart1.getText();
                            upper1=getstop1.getText();
                            lower2=getstart2.getText();
                            upper2=getstop2.getText();

                            JFrame ansFrame = new JFrame("value");
                            ansFrame.setSize(150,100);

                            answer = new JLabel(Double.toString(doubleIntegral.doubleIntegral(lower1,upper1,lower2,upper2,getEquation.getText())));
                            Insets insets = frame.getInsets();
                            Dimension size = answer.getPreferredSize();
                            answer.setBounds(150 + insets.left, 120 + insets.top, size.width, size.height);
                            ansFrame.add(answer);
                            ansFrame.setResizable ( false );
                            ansFrame.setVisible(true);
                        }
                    }
                    ActionListener calculateListener = new CalculateListener();
                    calculate.addActionListener(calculateListener);
                    frame.setVisible(true);
                }
            }
        );
    }

    public static void addComponentsToPane(Container panel)
    {
        Insets insets = panel.getInsets();

        integral1.setFont(new Font("Arial", Font.PLAIN, 30));
        integral2.setFont(new Font("Arial", Font.PLAIN, 30));
        panel.add(equation);
        panel.add(integral1);
        panel.add(integral2);
        panel.add(getstart1);
        panel.add(getstart2);
        panel.add(getstop1);
        panel.add(getstop2);
        panel.add(getEquation);
        panel.add(dxdy);
        panel.add(calculate);

        Dimension size = integral1.getPreferredSize();
        integral1.setBounds(45 + insets.left, 50 + insets.top, size.width, size.height);

        size = integral2.getPreferredSize();
        integral2.setBounds(120 + insets.left, 50 + insets.top, size.width, size.height);

        size = getstart1.getPreferredSize();
        getstart1.setBounds(60 + insets.left, 75 + insets.top, size.width, size.height);

        size = getstop1.getPreferredSize();
        getstop1.setBounds(60 + insets.left, 25 + insets.top, size.width, size.height);

        size = getstart2.getPreferredSize();
        getstart2.setBounds(140 + insets.left, 75 + insets.top, size.width, size.height);

        size = getstop2.getPreferredSize();
        getstop2.setBounds(140 + insets.left, 25 + insets.top, size.width, size.height);

        size = getEquation.getPreferredSize();
        getEquation.setBounds(200 + insets.left, 50 + insets.top, size.width, size.height);

        size = dxdy.getPreferredSize();
        dxdy.setBounds(455 + insets.left, 55 + insets.top, size.width, size.height);

        size = calculate.getPreferredSize();
        calculate.setBounds(275 + insets.left, 100 + insets.top,size.width, size.height);

    }

    private static void createAndShowGUI() 
    {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        Insets insets = frame.getInsets();
        frame.setSize(FRAME_WIDTH + insets.left + insets.right, FRAME_HEIGHT + insets.top + insets.bottom);
        frame.setTitle("The Double Integral");
        frame.setResizable ( false );

    }
}
