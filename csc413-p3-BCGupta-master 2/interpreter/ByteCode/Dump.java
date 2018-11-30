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
public class Dump extends bytecode{
 
    
    String label;
    
    @Override
    public void init(ArrayList<String> args) {
        label = (String)args.get(0);
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        if(label.equals("ON")) {
            vm.DumpOn();
        } else {
            vm.DumpOff();
        }
    }
    
    @Override
    public String toString() {        
        return "DUMP " + label;
    }
    
    public String getLabel() {
        return label;
    }
    
}

