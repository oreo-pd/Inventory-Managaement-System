package com.DSCE;


import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
class IMAGE extends JFrame {

private static final long serialVersionUID = 1L;

// frame
static JFrame f;


static JLabel l;
   
static JLabel l1;

public static void main(String[] args)
{

f = new JFrame("label");
JPanel panel = (JPanel)f.getContentPane();


l = new JLabel("DAYANANDA SAGAR COLLEGE OF ENGINEERING",  JLabel.CENTER);
l.setFont (l.getFont ().deriveFont (40.0f));
//l.setAlignmentX(0);
// l.setAlignmentY(0);
System.out.println("\n\n");
l1 = new JLabel("\nDEPARTMENT OF COMPUTER SCIENCE AND ENGINEERING",  JLabel.LEFT);
l1.setFont (l1.getFont ().deriveFont (20.0f));
l1.setAlignmentX(10);
l1.setAlignmentY(10);
JPanel p = new JPanel();
JLabel label = new JLabel();
       
        label.setIcon(new ImageIcon("C:\\Users\\HP\\Desktop\\im.png"));// your image here
        panel.add(label);
        f.setLocationRelativeTo(null);
        f.pack();
        f.setVisible(true);
// add label to panel
p.add(l);
p.add(l1);
// add panel to frame
f.add(p);

// set the size of frame
f.setSize(1000, 1000);

f.show();

JLabel label1 = new JLabel("<html>First line<br>Second line</html>");
f.add(label1);
f.pack();
f.setVisible(true);

}
} 
