/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;
import  interpreter.VirtualMachine;
import  java.util.ArrayList;
/**
 *
 * @author shubham
 */
public class Pop extends bytecode{
      int n;
    
    @Override
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        for(int i = 0; i < n; i++) {
            vm.vmPop();
        }
    }
    
    @Override
    public String toString(){
        return "POP " + n;
    }

    public int getNumPop() {
        return n;
    }
    
}
