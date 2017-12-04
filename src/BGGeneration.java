import java.util.ArrayList;

/**
 * @author Shiqi
 */
public class BGGeneration {
    private BGRule rule;
    private BGStem firstStem;
    private int iteration;
    private int lastRoundGeneratedNum = 1;
    protected ArrayList<BGStem> tree = new ArrayList<BGStem>();

    /**
     * @param rule
     * @param iteration use given rule and number of iteration to generate one tree.
     */
    public BGGeneration(BGRule rule, int iteration) {
        this.rule = rule;
        this.iteration = iteration;
        firstStem = new BGStem(rule.initialStemLength, 0.0, 0.0, 0.0, rule.initialStemLength, 90);
        tree.add(firstStem);
        generate();//generate the whole tree
    }

    /**
     * based on current rule, generate the whole tree.
     */
    private void generate() {
        for (int i = 1; i <= iteration; i++) {
            int from = tree.size() - 1;
            int to = tree.size() - lastRoundGeneratedNum;
            for (int j = from; j >= to; j--) {
                tree = rule.generateFromStem(tree, tree.get(j));
            }
            lastRoundGeneratedNum = calculateGeneratedNum(i);
        }
    }

    /**
     * @param iteration
     * @return generatedNum
     */
    public int calculateGeneratedNum(int iteration) {
        int generatedNum = (int) Math.pow(rule.forkNum, iteration);
        return generatedNum;
    }

}