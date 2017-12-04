/**
 * @author Shiqi
 *
 */
public class BGStem {
    double length;
    double xstart;
    double ystart;
    double xend;
    double yend;
    double angle;

    public BGStem() {

    }

    /**
     *
     * @param length
     * @param xstart
     * @param ystart
     * @param xend
     * @param yend
     * @param angle
     */
    public BGStem(double length, double xstart, double ystart, double xend, double yend, double angle) {
        this.length = length;
        this.xstart = xstart;
        this.ystart = ystart;
        this.xend = xend;
        this.yend = yend;
        this.angle = angle;
    }

    /**
     *
     * @param length
     * @param xstart
     * @param ystart
     * @param xend
     * @param yend
     * @param angle
     */
    public void calculateNextStemBasedOnCurrentStem(double length, double xstart, double ystart, double xend, double yend, double angle) { // TODO GEORGE I used all these parameters
        this.angle = angle;
        this.length = length / 2;
        this.xstart = xend;
        this.ystart = yend;
        this.xend = xend + this.length * Math.cos(Math.toRadians(angle));
        this.yend = yend + this.length * Math.sin(Math.toRadians(angle));
    }

    @Override
    public String toString() {
        return "BGStem [length=" + length + ", start: (" + xstart + " , " + ystart + "), end: (" + xend + " , "
                + yend + ")]";
    }

}