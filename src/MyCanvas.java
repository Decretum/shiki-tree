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
public class MyCanvas extends JPanel {
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
        System.out.println("Canvas: I've got the tree!");
    }

    /**
     *
     */
    public MyCanvas() {
        // TODO Auto-generated constructor stub
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
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = getSize();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, size.width, size.height);
        g2d.setColor(Color.black);
        if(tree == null)
            return;
        for(int i = 0; i < tree.size(); i++){
            BGStem stem = tree.get(i);
            g2d.drawLine((int) stem.xstart + 550, 600 - (int) stem.ystart + 100, (int) stem.xend + 550, 600 - (int) stem.yend + 100);
            // System.out.println("canvas: I sleep!");
        }
    }

}