/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tictactoeteamnewt;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author k1742971
 */
public class Cell extends JPanel
    {
        private char counter = ' ';

        public Cell()
        {
           setBorder(new LineBorder(Color.black, 2));
 
        }

        public char getCounter()
        {
            return counter;
        }

        public void setCounter(char c)
        {
            counter = c;
            repaint();
        }
        
        protected void paintComponent(Graphics g)
        {
         super.paintComponent(g);
         
         if (counter == 'X')
         {
          g.setColor(Color.red);
          g.drawLine(40, 40, getWidth() - 40, getHeight() - 40);
          g.drawLine(getWidth() -40, 40, 40, getHeight() - 40);
         }
         
         else if (counter == 'O')
         {
          g.setColor(Color.blue);
          g.drawOval(30, 30, getWidth() - 60, getHeight() - 60);
         }
        }
}