/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tictactoeteamnewt;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author k1730992
 */
public class Main 
{
  public static void main(String[] args)
  {
      JFrame frame = new TicTacToeFrame();
      frame.setTitle("tictactoe");
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true); 
      frame.setSize(600,600);
  }
}
