/**
 *
 */

import java.util.ArrayList;

/**
 * @author Shiqi
 *
 */
public class BGGeneration {
    private BGRule rule;
    private BGStem firstStem;
    private int iteration;
    private int lastRoundGeneratedNum = 1;
    protected ArrayList<BGStem> tree = new ArrayList<BGStem>();

    //use given rule and number of iteration to generate one tree.
    public BGGeneration(BGRule rule, int iteration) {
        this.rule = rule;
        this.iteration = iteration;
        firstStem = new BGStem(rule.initialStemLength, 0.0, 0.0, 0.0, rule.initialStemLength, 90);
        tree.add(firstStem);// add the first stem into our generation
        generate();//generate the whole tree
    }

    /**
     * based on current rule, generate the whole tree.
     */
    private void generate() {
        for (int i = 1; i <= iteration; i++) {
            System.out.println("\nGeneration " + i + " begins!");
            System.out.println("lastRoundGeneratedNum: " + lastRoundGeneratedNum);
            System.out.println("Tree size when start: " + tree.size());
            System.out.println("index from " + (tree.size() - 1) + " to " + (tree.size() - lastRoundGeneratedNum));
            int from = tree.size() - 1;
            int to = tree.size() - lastRoundGeneratedNum;
            for (int j = from; j >= to; j--) {
                System.out.println("Generate from: " + j);
                tree = rule.generateFromStem(tree, tree.get(j));
            }
            lastRoundGeneratedNum = calculateGenerationNum(i);
            System.out.println("Tree size when end: " + tree.size());
        }
        System.out.println("All stems we have: " + tree.size());

    }

    public int calculateGenerationNum(int iteration) {
        return (int) Math.pow(rule.forkNum, iteration);
    }


    /**
     * @return the firstStem
     */
    public BGStem getFirstStem() {
        return firstStem;
    }

    /**
     * @return the iteration
     */
    public int getIteration() {
        return iteration;
    }

}