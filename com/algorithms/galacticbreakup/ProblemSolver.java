package com.algorithms.galacticbreakup;

public class ProblemSolver {
    private Galaxy galaxy;
    private ProblemDef problem;

    public ProblemSolver(ProblemDef pd) {
        problem = pd;
        
        galaxy = new Galaxy(pd.getNDimension(), pd.getMDimension(), pd.getKDimension());
    }


    public int solve() {
        return 0;
    }
}
