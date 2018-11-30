/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;
import interpreter.VirtualMachine;
import java.util.ArrayList;
/**
 *
 * @author shubham
 */
public class FalseBranch extends bytecode{
    String label = "";
    int targetAddress;
    
    @Override
    public void init(ArrayList<String> args) {
        label = (String)args.get(0);
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        int branch = vm.vmPop();
        if(branch == 0) {
            vm.setPC(targetAddress);
        }
    }
    
    @Override
    public String toString() {
        return "FALSE " + label;
    }
    
    public String getLabel() {
        return label;
    }
    
    public void setLabel(String newLabel) {
        label = newLabel;
    }
    
    public int getTargetAddress() {
        return targetAddress;
    }
    
    public void setTargetAddress(int newAddress) {
        targetAddress = newAddress;
    }
    
}
