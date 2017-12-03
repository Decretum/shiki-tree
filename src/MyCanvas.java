import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author Shiqi
 */
public class MyCanvas extends JPanel { //TODO GEORGE you can still explain it to me. I've done some research though.
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
     * @param tree the tree to set
     */
    public void setTree(ArrayList<BGStem> tree) {
        this.tree = tree;
    }

    public void draw(BGStem stem) {
        tree.add(stem);
        repaint();
    }

    public void draw(ArrayList<BGStem> tree) {
        setTree(tree);
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
        if (tree == null) {
            return;
        }
        for (int i = 0; i < tree.size(); i++) {
            BGStem stem = tree.get(i);
            g2d.drawLine((int) (stem.xstart + size.width / 2), (int) (size.height - stem.ystart), (int) (stem.xend + size.width / 2), (int) (size.height - stem.yend));
        }
    }

}