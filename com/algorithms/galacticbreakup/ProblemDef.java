package com.algorithms.galacticbreakup;

import java.util.Scanner;

/**
 * Data structure holding the definition of a galactic breakup problem.
 * 
 * @author Andrew Huffman, Kyle Samuelson
 */
class ProblemDef {
    private int[][] dominions; 

    private int n, m, k;

    /**
     * Constructor
     * @param input the Scanner from which to derive the problem input.
     * @throws ProblemDefMalformatException If the spanner gives invalid data.
     */
    public ProblemDef(Scanner input) throws ProblemDefMalformatException {
        // I. Read n, m, and k
        // II. Read in number of steps.
        // III. For each step...
            // A. Read in the number of dominions.
            // B. Store each dominion.
        
        int numSteps;
        int numDominions;

        // I. Read n, m, and k

        if (input.hasNextInt()) {
            n = input.nextInt();
        }
        else {
            throw new ProblemDefMalformatException("Expecting n.");
        }
        if (input.hasNextInt()) {
            m = input.nextInt();
        }
        else {
            throw new ProblemDefMalformatException("Expecting m.");
            
        }
        if (input.hasNextInt()) {
            k = input.nextInt();
        }
        else {
            throw new ProblemDefMalformatException("Expecting k.");
            
        }
        
        // II. Read in number of steps.
        if (input.hasNextInt()) {
            numSteps = input.nextInt();
        }
        else {
            throw new ProblemDefMalformatException("Expecting number of steps.");
        }

        dominions = new int[numSteps][];

        // III. For each step...
        for (int i = 0; i < numSteps; i++) {

            // A. Read in the number of dominions.
            if (input.hasNextInt()) {
                numDominions = input.nextInt();
            }
            else {
                throw new ProblemDefMalformatException("Expecting number of dominions.");
            }

            // B. Store each dominion.
            dominions[i] = new int[numDominions];

            for (int j = 0; j < numDominions; j++) {
                if (input.hasNextInt()) {
                    dominions[i][j] = input.nextInt();
                }
                else {
                    throw new ProblemDefMalformatException("Expecting dominion definition.");
                }
            }
        }
    }

    /**
     * Gets the number of "steps" (individual lines of breakups) the problem has.
     * @return the number of steps.
     */
    public int getNumSteps() {
        return dominions.length;
    }

    /**
     * Gets the number of dominions in a given, indexed step.
     * @param step the step.
     * @return the number of dominions in step.
     */
    public int getNumDominionsInStep(int step) {
        return dominions[step].length;
    }

    /**
     * Gets the particular dominion value specified at step, index.
     * @param step the step.
     * @param index the index in the step.
     * @return the dominion value, as a 1-D index to the 3-D space.
     */
    public int getDominion(int step, int index) {
        return dominions[step][index];
    }

    /**
     * Gets the specified n-dimension of the 3-D space.
     * @return the n.
     */
    public int getNDimension() {
        return n;
    }

    /**
     * Gets the specified m-dimension of the 3-D space.
     * @return the m.
     */
    public int getMDimension() {
        return m;
    }

    /**
     * Gets the specified k-dimension of the 3-D space.
     * @return the k.
     */
    public int getKDimension() {
        return k;
    }

    /**
     * toString override, for debugging purposes.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(n + " ");
        sb.append(m + " ");
        sb.append(k + " ");

        sb.append(dominions.length);
        sb.append('\n');

        for (int[] step : dominions) {
            sb.append(step.length);
            sb.append(' ');
            for (int i = 0; i < step.length; i++) {
                sb.append(step[i]);
                sb.append(' ');
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
