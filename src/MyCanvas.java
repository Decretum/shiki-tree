import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author Shiqi
 *
 */
public class MyCanvas extends JPanel { // todo shiki Good use of inheritance here :) I hope you know how it works because if not I should probably explain it to you later
    private ArrayList<BGStem> tree;
//	private double xstart;
//	private double ystart;
//	private double xend;
//	private double yend;

    /**
     * @param tree2
     */
    public MyCanvas(ArrayList<BGStem> tree2) {
        tree = tree2;
        System.out.println("Canvas constructor invoked");
    }

    /**
     *
     */
    public MyCanvas() {

    }

    /**
     * @param tree
     *            the tree to set
     */
    public void setTree(ArrayList<BGStem> tree) {
        this.tree = tree;
    }

    public void draw(BGStem stem) {
        tree.add(stem);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = getSize();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, size.width, size.height);
        g2d.setColor(Color.black);
        if(tree == null) // TODO SHIKI I generally suggest using  { } even for these one-line statements just for code quality and clarity.
            return;
        for(int i = 0; i < tree.size(); i++){ // TODO SHIKI please put a space between your ) and {. It's not a huge deal but I see you forget to do this a lot.
            BGStem stem = tree.get(i);
            g2d.drawLine((int) stem.xstart + 550, 600 - (int) stem.ystart + 100, (int) stem.xend + 550, 600 - (int) stem.yend + 100);
            // System.out.println("canvas: I sleep!"); // TODO SHIKI don't forget to remove your comments that you used to debug your program before turning it in.
        }
    }

}