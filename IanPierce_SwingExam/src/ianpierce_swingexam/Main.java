/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ianpierce_swingexam;

import java.awt.*;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.nio.file.*;
import java.io.*;
import java.util.Scanner;

/**
 *
 * @author User
 * ITSE 2317-10z1
 *
 * Project Name/Description
 */

public class Main {

    static JFrame Window = new JFrame();//creating instance of JFrame
        
    static JTextField Input = new JTextField();
    
    
    
    static String pattern = "(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>\\s]).{6,20}$";
    
    static JLabel SecretLabel = new JLabel("Secret Color");
    
    static JButton Quit = new JButton("Quit");
    
    public static void main(String[] args) {
        Input.setBounds(250,10,200,30);//x axis, y axis, width, height
        Input.setFont(new Font("Courier New", Font.BOLD, 30));
         
        SecretLabel.setBounds(20,5,300, 40);
        SecretLabel.setFont(new Font("Courier New", Font.BOLD, 30));
        SecretLabel.setForeground(Color.red);
  
        Quit.setBounds(200,120,100, 40);

        Window.add(Quit);
        Window.add(Input);
        Window.add(SecretLabel);

        Window.setSize(480,200);
        Window.setLayout(null);
        Window.setVisible(true);
        
        validateInput();
        
        SecretLabel.addMouseListener(new MouseAdapter() 
        {  
            public void mousePressed(MouseEvent e)  
            {  
                SecretLabel.setForeground(Color.blue);
            }
            public void mouseReleased(MouseEvent e)
            {
                SecretLabel.setForeground(Color.red);
            }
        }); 
        
        Input.addKeyListener(new KeyAdapter() 
        {  
            public void keyReleased(KeyEvent e)
            {
                validateInput();
            }
        }); 
        
        Quit.addActionListener(e -> System.exit(0));
        
    }
    
    private static void validateInput()
  {
    String text = Input.getText();
    if (Input.getText().equals(""))
    {
      Quit.setEnabled(false);
      Quit.setVisible(false);
    }
    else if(Input.getText().equals("blue"))
    {
      Quit.setEnabled(true);
      Quit.setVisible(true);
    }
    else
    {
      Quit.setEnabled(false);
      Quit.setVisible(false);
    }
  }

}
