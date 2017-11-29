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

    public BGStem(){

    }

    public BGStem(double length, double xstart, double ystart, double xend, double yend, double angle) {
        this.length = length;
        this.xstart = xstart;
        this.ystart = ystart;
        this.xend = xend;
        this.yend = yend;
        this.angle = angle;
    }

    public void calculate(double length, double xstart, double ystart, double xend, double yend,double angle) {
        this.angle = angle;
        this.length = length / 2;
        this. xstart = xend;
        this.ystart = yend;
        this.xend = xend + this.length * Math.cos(Math.toRadians(angle));
        //System.out.println("cos(" + angle +") : "+ Math.cos(angle));
        this.yend = yend + this.length * Math.sin(Math.toRadians(angle));
        //System.out.println("sin(" + angle +") : "+ Math.sin(angle));
    }



    @Override
    public String toString() {
        return "BGStem [length=" + length + ", start: (" + xstart + " , " + ystart + "), end: (" + xend + " , "
                + yend + ")]";
    }


}