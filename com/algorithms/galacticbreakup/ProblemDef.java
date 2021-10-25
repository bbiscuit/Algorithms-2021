package com.algorithms.galacticbreakup;

import java.util.Scanner;

/**
 * Data structure holding the definition of a galactic breakup problem.
 * 
 * @author Andrew Huffman and Kyle Samuelson
 * @version Oct 25, 2021
 */
class ProblemDef {
    private int[][] dominions; 
    private int n;
    private int m;
    private int k;
    
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

    public int getNumSteps() {
        return dominions.length;
    }

    public int getNumDominionsInStep(int step) {
        return dominions[step].length;
    }

    public int getDominion(int step, int index) {
        return dominions[step][index];
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public int getK() {
        return k;
    }

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
