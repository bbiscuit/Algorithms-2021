package com.algorithms.galacticbreakup;

import java.util.Scanner;

class Main {
    

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        ProblemDef pd = new ProblemDef(s);

        System.out.println("Num steps: " + pd.getNumSteps());
        for (int i = 0; i < pd.getNumSteps(); i++) {
            System.out.println("Dominoes in step " + i + ": " + pd.getNumDominionsInStep(i));
        }

        System.out.println(pd);

        s.close();
    }

}
