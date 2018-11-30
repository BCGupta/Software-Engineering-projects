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
 * @author James
 */
public class Args extends bytecode {
    
    int n;
    
    @Override
    public void init(ArrayList<String> args) {
        n = Integer.parseInt(args.get(0));
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        vm.vmframeAt(n);
    }
    
    @Override
    public String toString() {
        return "ARGS " + n;
    }
    
}