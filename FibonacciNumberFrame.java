/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.tut.ui;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 *
 * @author MNCEDISI
 */
public class FibonacciNumberFrame extends JFrame
{
    private JPanel headingPNL;
    private JPanel computerNumAndUserRespondPNL;
    private JPanel computerAndUserGridPNL;
    private JPanel userAnswerAndQuestionPNL;
    private JPanel buttonPNL;
    
    private JLabel headingLBL;
    private JLabel computerNumLBL;
    private JLabel userQuestionLBL;
    
    private JTextField userRespondTxtFLD;
    
    private JTextArea areaTxtA;
    
    private JButton doneBTN;
    private JButton againBTN;
    private JButton exitBTN;
    
    private Random random;

    private int score;
    
    public FibonacciNumberFrame()
    {
        setTitle("Fibonacci Number");
        setSize(380, 320);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setDefaultLookAndFeelDecorated(true);
        setLocationRelativeTo(null);
        
        random = new Random();
        headingPNL = new JPanel(new FlowLayout(FlowLayout.CENTER));
        computerNumAndUserRespondPNL = new JPanel(new FlowLayout(FlowLayout.LEFT));      
        userAnswerAndQuestionPNL = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 5));
        computerAndUserGridPNL = new JPanel(new GridLayout(2, 1 ));
        buttonPNL = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 3));
        
        headingLBL = new JLabel("Fibonacci Game");
        headingLBL.setFont(new Font(null, Font.BOLD, 30));
        headingLBL.setForeground(Color.PINK);
        
        computerNumLBL = new JLabel("   Press[AGAIN] To start");
        
        userQuestionLBL = new JLabel("Fibonacci Number [Yes/No]:");
        
        userRespondTxtFLD = new JTextField(10);
        
        //Creating textarea
        areaTxtA = new JTextArea(6, 30);
        areaTxtA.setBorder(new TitledBorder(new LineBorder(Color.BLUE, 3), "Display"));
        areaTxtA.setEditable(false);
        
        //Creating a button
        doneBTN = new JButton("DONE");
        doneBTN.addActionListener(new DoneBTN());
        
        againBTN = new JButton("AGAIN");
        againBTN.addActionListener(new AgainBTN());
        
        exitBTN = new JButton("EXIT");
        exitBTN.addActionListener(new ExitBTN());
        
        userAnswerAndQuestionPNL.add(userQuestionLBL);
        userAnswerAndQuestionPNL.add(userRespondTxtFLD);
        
        //First collective
        headingPNL.add(headingLBL );
       
        //Second collective
        computerAndUserGridPNL.add(computerNumLBL);
        computerAndUserGridPNL.add(userAnswerAndQuestionPNL);
        computerNumAndUserRespondPNL.add(computerAndUserGridPNL , BorderLayout.NORTH);
        computerNumAndUserRespondPNL.add(areaTxtA , BorderLayout.SOUTH);
        
        //Thrid collective
        buttonPNL.add(doneBTN);
        buttonPNL.add(againBTN);
        buttonPNL.add(exitBTN);
        
        add(headingPNL , BorderLayout.NORTH);
        add(computerNumAndUserRespondPNL , BorderLayout.CENTER);
        add(buttonPNL , BorderLayout.SOUTH);
        
        setVisible(true);
    }

    private class AgainBTN implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
           
            int generatedNum = random.nextInt(91) + 10;
            computerNumLBL.setText("   Computer Number :"+generatedNum);
            
            String userAnswer = userRespondTxtFLD.getText();
            
            for (int i = 0; i < 100; i++) 
            {
                int fibanocciNum = getFibanocciNum(i);
                
                if(fibanocciNum >=10  && fibanocciNum <=100)
                {
                    if(generatedNum==fibanocciNum && userAnswer.equalsIgnoreCase("yes"))
                        score++;
                }
                    
                else
                    if(fibanocciNum >100)
                        break;
            }
        }

        private int getFibanocciNum(int i)
        {
            if(i<=1)
                return i;
            else
                return getFibanocciNum(i - 1) + getFibanocciNum(i - 2);
        }
    }

    private class ExitBTN implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            System.exit(0);
        }
    }

    private class DoneBTN implements ActionListener 
    {
        @Override
        public void actionPerformed(ActionEvent e) 
        {
            String output = "Your score :"+score;
            areaTxtA.setText(output);
        }
    }
}
