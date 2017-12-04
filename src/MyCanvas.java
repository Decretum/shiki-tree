import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * @author Shiqi
 */
public class MyCanvas extends JPanel {
    private ArrayList<BGStem> tree;


    public MyCanvas() {

    }

    /**
     * @param tree the tree to set
     */
    public void setTree(ArrayList<BGStem> tree) {
        this.tree = tree;
    }

    /**
     * @param stem the stem to draw
     */
    public void draw(BGStem stem) {
        tree.add(stem);
        repaint();
    }


    /**
     *
     * @param g
     * draw all the stems in the private ArrayList called tree
     */
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