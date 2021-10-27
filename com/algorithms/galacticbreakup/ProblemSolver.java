package com.algorithms.galacticbreakup;

import java.util.Scanner;

public class ProblemSolver {
    private Galaxy galaxy;
    private ProblemDef problem;

    public ProblemSolver(ProblemDef pd) {
        problem = pd;
        
        galaxy = new Galaxy(pd.getNDimension(), pd.getMDimension(), pd.getKDimension());
    }


    public int solve() {
        for (int i = problem.getNumSteps() - 1; i >= 0; i--) {

            for (int j = 0; j < problem.getNumDominionsInStep(i); j++) {
                galaxy.formDominionExNihilo(
                    new Dominion(problem.getDominion(i, j), 
                        problem.getNDimension(), 
                        problem.getMDimension(), 
                        problem.getKDimension()
                    )
                );
            }
            
        }

        return galaxy.getMonthSeparated();
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int numProblems = s.nextInt();

        for (int i = 0; i < numProblems; i++) {
            ProblemDef pd = new ProblemDef(s);
            ProblemSolver ps = new ProblemSolver(pd);
            
            System.out.println(ps.solve());
        }
    }
}
