/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shubham
 */

class DivisionOperator extends Operator {

    @Override
    public int priority() {
        return 3;
    } // end priority

    @Override
    public Operand execute(Operand opd1, Operand opd2) {
        Operand result = new Operand(opd2.getValue() / opd1.getValue());

        return result;
    } 
} 