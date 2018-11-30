/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shubham
 */

class AdditionOperator extends Operator {

    @Override
    public int priority() {
        return 2;
    } // end priority

    @Override
    public Operand execute(Operand opd1, Operand opd2) {
        Operand result = new Operand(opd1.getValue() + opd2.getValue());

        return result;
    }
    
}
