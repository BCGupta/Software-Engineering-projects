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
public class Write extends bytecode  {
    
     @Override
    public void init(ArrayList<String> args) {
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        int n = vm.vmPeek();
        System.out.println(n);
    }
    
    @Override
    public String toString() {
        return "WRITE";
    }

}
