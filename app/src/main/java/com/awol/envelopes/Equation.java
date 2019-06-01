package com.awol.envelopes;

public class Equation {
    private int leftCoeff;
    private int rightCoeff;
    private int leftConst;
    private int rightConst;
    private int solution;

    public Equation (int solution) {
        leftCoeff = 4;
        leftConst = 3;
        rightCoeff = 2;
        rightConst = (rightCoeff - leftCoeff)*solution + leftConst;
    }
}
