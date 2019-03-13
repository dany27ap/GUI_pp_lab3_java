package com.dlegacy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends WindowAdapter implements ActionListener{
    private JButton []butoane;
    private JFrame frame;
    private JTextField nameBook;
    private JLabel text;
    BackEnd actiune;


    public GUI(){
        frame = new JFrame("PP_Lab3");
        nameBook = new JTextField("");
        butoane = new JButton[8];
        text = new JLabel("Name of file: ");
        actiune = new BackEnd("detail.txt");

        text.setBounds(0,200, 200, 30);
        nameBook.setBounds(150, 200, 200, 30);
        butoane[0] = new JButton("Space");
        butoane[1] = new JButton("New Line");
        butoane[2] = new JButton("No. Page");
        butoane[3] = new JButton("Author");
        butoane[4] = new JButton("Chapter");
        butoane[5] = new JButton("Ro Char.");
        butoane[6] = new JButton("Save File");
        butoane[7] = new JButton("Print File");

        butoane[0].setBounds(10,20, 100, 30);
        butoane[1].setBounds(150,20, 100, 30);
        butoane[2].setBounds(300,20, 100, 30);
        butoane[3].setBounds(10,80, 100, 30);
        butoane[4].setBounds(150,80, 100, 30);
        butoane[5].setBounds(300,80, 100, 30);
        butoane[6].setBounds(10,140, 100, 30);
        butoane[7].setBounds(150,140, 100, 30);

        butoane[7].addActionListener(this);

        frame.add(text);
        frame.add(butoane[0]);
        frame.add(butoane[1]);
        frame.add(butoane[2]);
        frame.add(butoane[3]);
        frame.add(butoane[4]);
        frame.add(butoane[5]);
        frame.add(butoane[6]);
        frame.add(butoane[7]);

        frame.add(nameBook);
        frame.addWindowListener(this);
        frame.setSize(500, 300);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == butoane[0]){
            actiune.mSpace();
        }
        if(e.getSource() == butoane[1]){
            actiune.mLine();
        }
        if(e.getSource() == butoane[2]){
            actiune.noPage();
        }
        if(e.getSource() == butoane[3]){
            actiune.printFile();
        }
        if(e.getSource() == butoane[4]){
            actiune.mChapter();
        }
        if(e.getSource() == butoane[5]){
            actiune.printFile();
        }
        if(e.getSource() == butoane[6]){
            actiune.saveFile();
        }
        if(e.getSource() == butoane[7]){
            actiune.printFile();
        }
    }

    public void windowClosing(WindowEvent e){
        int a = JOptionPane.showConfirmDialog(frame, "Save document?");
        if(a == JOptionPane.YES_OPTION){
            actiune.saveFile();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (a == JOptionPane.NO_OPTION){
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        } else if (a == JOptionPane.CANCEL_OPTION){
            frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        }
    }

}
