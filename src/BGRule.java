import java.util.ArrayList;

/**
 * @author Shiqi
 *
 */
public class BGRule {
    protected int forkNum;
    protected double angle;
    protected double initialStemLength;

    /**
     *
     * @param forkNum
     * @param angle
     * @param initialStemLength
     */
    public BGRule(int forkNum, double angle, double initialStemLength){
        this.forkNum = forkNum;
        this.angle = angle;
        this.initialStemLength = initialStemLength;
    }

    /**
     *
     * @param tree
     * @param stem
     * @return
     * According to current rule, generate from a given stem
     */
    public ArrayList<BGStem> generateFromStem(ArrayList<BGStem> tree,BGStem stem) {
        if (forkNum % 2 != 0) {
            BGStem center = new BGStem();
            center.calculateNextStemBasedOnCurrentStem(stem.length, stem.xstart, stem.ystart, stem.xend, stem.yend, stem.angle);
            tree.add(center);
        }
        for (int i = 1; i <= forkNum / 2; i++) {
            BGStem left = new BGStem();
            left.calculateNextStemBasedOnCurrentStem(stem.length, stem.xstart, stem.ystart, stem.xend, stem.yend, stem.angle + angle * i);
            tree.add(left);
            BGStem right = new BGStem();
            right.calculateNextStemBasedOnCurrentStem(stem.length, stem.xstart, stem.ystart, stem.xend, stem.yend, stem.angle - angle * i);
            tree.add(right);
        }
        return tree;
    }

    /**
     * @return the forkNum
     */
    public int getForkNum() {
        return forkNum;
    }

    /**
     * @return the angle
     */
    public double getAngle() {
        return angle;
    }

    /**
     * @return the initialStemLength
     */
    public double getInitialStemLength() {
        return initialStemLength;
    }

}