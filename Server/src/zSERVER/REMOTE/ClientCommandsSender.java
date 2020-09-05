/*
 *@author Hoàng Ngọc Long 64121
 */

package zSERVER.REMOTE;

import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JPanel;

/**
 * @author Hoàng Ngọc Long 64121
 */
public class ClientCommandsSender implements KeyListener,
        MouseMotionListener,MouseListener {

    private Socket cSocket = null;
    private JPanel cPanel = null;
    private PrintWriter writer = null;
    private Rectangle clientScreenDim = null;

   public ClientCommandsSender(Socket s, JPanel p, Rectangle r) {
        cSocket = s;
        cPanel = p;
        clientScreenDim = r;
        //Liệt Kê Sự Kiện 
        cPanel.requestFocus();
        cPanel.addKeyListener(this);
        cPanel.addMouseListener(this);
        cPanel.addMouseMotionListener(this);
        try {
             // chuẩn bị gởi các sự kiện cho client
            writer = new PrintWriter(cSocket.getOutputStream());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
    }

    //Not implemeted yet
    public void mouseDragged(MouseEvent e) {
         writer.println(EnumCommands.MOVE_MOUSE.getAbbrev());
    	 double xScale = clientScreenDim.getWidth()/cPanel.getWidth();
    	 double yScale = clientScreenDim.getHeight()/cPanel.getHeight();
    	 writer.println((int)(e.getX() * xScale));
         writer.println((int)(e.getY() * yScale));
    	 writer.flush();
    }

    public void mouseMoved(MouseEvent e) {
        double xScale = clientScreenDim.getWidth()/cPanel.getWidth();
        System.out.println("xScale: " + xScale);
        double yScale = clientScreenDim.getHeight()/cPanel.getHeight();
        System.out.println("yScale: " + yScale);
        System.out.println("Mouse Moved");
        writer.println(EnumCommands.MOVE_MOUSE.getAbbrev());
        writer.println((int)(e.getX() * xScale));
        writer.println((int)(e.getY() * yScale));
        writer.flush();
    }

    //this is not implemented
    public void mouseClicked(MouseEvent e) {
    }

    public void mousePressed(MouseEvent e) {
        System.out.println("Mouse Pressed");
        // bao client thuc hien su kien mouse click
        writer.println(EnumCommands.PRESS_MOUSE.getAbbrev());
        int xButton = MouseEvent.BUTTON1_DOWN_MASK; // mặc định gởi nhấn chuột trái 
        if (e.getButton() == MouseEvent.BUTTON3) { // nếu là chuột phải
            xButton = MouseEvent.BUTTON3_DOWN_MASK; // gởi sự kiện nhấn chuột phải
        }
        writer.println(xButton);
        writer.flush();
    }

    public void mouseReleased(MouseEvent e) {
        System.out.println("Mouse Released");
        writer.println(EnumCommands.RELEASE_MOUSE.getAbbrev());
        int button = e.getButton();
        int xButton = MouseEvent.BUTTON1_MASK; // mặc định gởi thả chuột trái 
        if (button == MouseEvent.BUTTON3) { // nếu là chuột phải
            xButton = MouseEvent.BUTTON3_MASK; // gởi sự kiện thả chuột phải
        }
        writer.println(xButton);
        writer.flush();
    }

    //not implemented
    public void mouseEntered(MouseEvent e) {
    }

    //not implemented
    public void mouseExited(MouseEvent e) {

    }

    //not implemented
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        System.out.println("Key Pressed");
        writer.println(EnumCommands.PRESS_KEY.getAbbrev());
        writer.println(e.getKeyCode());
        writer.flush();
    }

    public void keyReleased(KeyEvent e) {
        System.out.println("Mouse Released");
        writer.println(EnumCommands.RELEASE_KEY.getAbbrev());
        writer.println(e.getKeyCode());
        writer.flush();
    }

}
