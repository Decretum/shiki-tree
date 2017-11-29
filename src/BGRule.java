import java.util.ArrayList;

/**
 * @author Shiqi
 *
 */
public class BGRule {
    protected int forkNum;
    protected double angle;
    protected double initialStemLength;

    public BGRule(int forkNum, double angle, double initialStemLength){
        this.forkNum = forkNum;
        this.angle = angle;
        this.initialStemLength = initialStemLength;
    }

    /*
     * According to current rule, generate from a given stem
     */
    public ArrayList<BGStem> generateFromStem(ArrayList<BGStem> tree,BGStem stem) {
        if (forkNum % 2 != 0) {
            BGStem center = new BGStem();
            center.calculate(stem.length, stem.xstart, stem.ystart, stem.xend, stem.yend, stem.angle);
            tree.add(center);
        }
        for (int i = 1; i <= forkNum / 2; i++) { // TODO SHIKI I changed the code a bit so you have less duplicate code.
            BGStem left = new BGStem();
            left.calculate(stem.length, stem.xstart, stem.ystart, stem.xend, stem.yend, stem.angle + angle * i);
            tree.add(left);
            BGStem right = new BGStem();
            right.calculate(stem.length, stem.xstart, stem.ystart, stem.xend, stem.yend, stem.angle - angle * i);
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