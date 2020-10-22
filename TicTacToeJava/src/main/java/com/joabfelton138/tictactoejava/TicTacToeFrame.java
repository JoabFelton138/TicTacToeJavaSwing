/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tictactoeteamnewt;

/**
 *
 * @author k1730992
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.JFrame;

public class TicTacToeFrame extends JFrame

{
   private boolean gameOver = false;
   private char whoseTurnIsItAnyway = 'X'; // Indicates players turn
   private Cell[][] cells = new Cell[4][4]; //two dimensional array for cell grid, 4x4 as requestyed
   JLabel jLabelStatus = new JLabel("X's turn to play!"); // Label status creation, notification indicating player turn
   JButton clearData = new JButton("Reset"); // Label status creation, clear data from the list
   private char counter = ' ';
   
   /**
    * No-argument Constructor
    */ 
   public TicTacToeFrame()
    {
     
    JPanel panel = new JPanel(new GridLayout (4,4,0,0));
      
      for (int i = 0; i < 4; i++)// Represents rows
      {
        for (int j = 0; j < 4; j++) //Represents Columns
         {
          panel.add(cells[i][j] = new Cell()); //fill gridlayout with cells
           cells[i][j].addMouseListener(new MyMouseListener());
         } 
       }
     
      JPanel bottomPanel = new JPanel(new GridLayout(1,2,0,0));
      JPanel resetPanel = new JPanel(new GridLayout(1,2,0,0));
      
      panel.setBorder(new LineBorder(Color.BLACK,2)); // set border of grid to black at two pixels thick]
      bottomPanel.setBorder(new LineBorder(Color.BLACK,2));
      
      jLabelStatus.setBorder(new LineBorder(Color.BLACK,2));
      clearData.setBorder(new LineBorder(Color.BLACK,2));
      
      add(panel, BorderLayout.CENTER);
      add(bottomPanel, BorderLayout.SOUTH);
      
      bottomPanel.add(jLabelStatus);
      bottomPanel.add(resetPanel);
      
      resetPanel.add(clearData);
    
    }
    
    public void resetGame()
   {
       clearData.addActionListener(new ActionListener() 
      {
	public void actionPerformed(ActionEvent evt) 
        {
         if (gameOver == true)
         {
          for(int i = 0; i < 4; i++)
            {
                for(int j = 0; j < 4; j++)
                {
                    cells[i][j].setCounter(' ');
                }
            }
          
          gameOver = false;
          
          jLabelStatus.setText("New game - " + whoseTurnIsItAnyway + "s turn to play!"); 
         }
        }
     });

   }
   
    
   /**
   */
    public boolean isFull()
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
            {
                if (cells[i][j].getCounter() == ' ')
                {
                    return false;
                }

            }
        }
            return true;
    }
        
    public boolean hasWon(char counter)
    {
        
        //would need to check rows, columns and diagonals for win
        for (int i = 0; i < 4;i++)
        {
           //check rows for win
           if ((cells[i][0].getCounter() == counter) && (cells[i][1].getCounter() == counter) && (cells[i][2].getCounter() == counter)&& (cells[i][3].getCounter() == counter))
               
           {
               return true;
           }
        }
        //check columns for win
        for (int j = 0; j < 4;j++)
        {
            if((cells[0][j].getCounter() == counter) && (cells[1][j].getCounter() == counter) && (cells[2][j].getCounter() == counter)&& (cells[3][j].getCounter() == counter))
            {
                return true;
            }
        }
        //check diagonally for win
        if (((cells[0][0].getCounter() == counter) && (cells[1][1].getCounter() == counter) && (cells[2][2].getCounter() == counter)&& (cells[3][3].getCounter() == counter)))
        {
            return true;
        }
        //check diagonally for win
        if (((cells[0][3].getCounter() == counter) && (cells[1][2].getCounter() == counter) && (cells[2][1].getCounter() == counter)&& (cells[3][0].getCounter() == counter)))
        {
            return true;
        }
            return false;
    }

    /**
     * @return the counter
     */
    public char getCounter() {
        return counter;
    }

    /**
     * @param counter the counter to set
     */
    public void setCounter(char counter) {
        this.counter = counter;
    }

    /**
     * @return the gameOver
     */
    public boolean isGameOver() {
        return gameOver;
    }

    /**
     * @param gameOver the gameOver to set
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }
    
        
        private class MyMouseListener extends MouseAdapter 
        {
            @Override
            public void mousePressed(MouseEvent e)
            {
              Cell cell = (Cell) e.getSource();
                               
              if(isGameOver())
              {
                  return;
              }
              if (cell.getCounter() != ' ')
              {
                  jLabelStatus.setText(whoseTurnIsItAnyway + "Invalid move, Cell is Occupied! Try Again!"); 
              }
              else if (cell.getCounter() == ' ' && whoseTurnIsItAnyway != ' ')
              {
                  cell.setCounter(whoseTurnIsItAnyway); 
              }
              
              if (hasWon(whoseTurnIsItAnyway))
              {
                 
                  jLabelStatus.setText(whoseTurnIsItAnyway + " Won! Game Over.");
                  JOptionPane.showMessageDialog(null, whoseTurnIsItAnyway + " Won! Click reset to play again!");
                  whoseTurnIsItAnyway = ' '; 
                  setGameOver(true);
                  resetGame();
              }
              
              else if(isFull()) 
              { 
                 
                     jLabelStatus.setText("Draw! Game Over");
                     whoseTurnIsItAnyway = ' ';
                     JOptionPane.showMessageDialog(null, "Draw! Click reset to play again!");
                     setGameOver(true);
                     resetGame();
                
              }
             
             //may have accidentally found a way for a player to take two turns 
            for (int i = 0; i < 4; i++)
            {
                    for (int j = 0; j < 4; j++)
                    {   
                        if ((cells[i][j].getCounter() == 'X') || (cells[i][j].getCounter() == 'O')) //first == ' '. second = x set to o. third = o
                        {
                        
                        if(whoseTurnIsItAnyway == 'X') 
                        {
                            whoseTurnIsItAnyway = 'O';
                            jLabelStatus.setText(whoseTurnIsItAnyway + "'s turn to play");
                        }
              
                        else
                        {
                            whoseTurnIsItAnyway = 'X';
                            jLabelStatus.setText(whoseTurnIsItAnyway + "'s turn to play");
                        }
                        
                        }
                    }
            }
            
            
            if(whoseTurnIsItAnyway == 'X') 
              {
                 whoseTurnIsItAnyway = 'O';
                 jLabelStatus.setText(whoseTurnIsItAnyway + "'s turn to play");
              }
              
              else
              {
                  whoseTurnIsItAnyway = 'X';
                  jLabelStatus.setText(whoseTurnIsItAnyway + "'s turn to play");
              }
        }       
      }
    }  