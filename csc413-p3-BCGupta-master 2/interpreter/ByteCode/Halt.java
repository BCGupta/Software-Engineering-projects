/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

/**
 *
 * @author shubham
 */
public class Halt extends bytecode {
    
      @Override
    public void init(ArrayList<String> args) {
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        vm.setRunning(false);
    }
    
    @Override
    public String toString() {
        return "HALT";
    }
    
}

