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
public class GoTo extends bytecode {
    
    String label = "";
    int targetAddr;
    
    @Override
    public void init(ArrayList<String> args) {
        label = (String)args.get(0);
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        vm.setPC(targetAddr);
    }
    
    @Override
    public String toString() {
        return "GOTO " + label;
    }
    
    public void setLabel(String newLabel) {
        label = newLabel;
    }
    
    public String getLabel() {
        return label;
    }
    
    public int getTargetAddress() {
        return targetAddr;
    }
    
    public void setTargetAddress(int newAddress) {
        targetAddr = newAddress;
    }
    
}
