/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author shubham
 */

class PoundOperator extends Operator {

    @Override
    public int priority() {
        return 0;
    } // end priority

    @Override
    public Operand execute(Operand opd1, Operand opd2) {
        return null;
    } // end execute
} // end PoundOperator
