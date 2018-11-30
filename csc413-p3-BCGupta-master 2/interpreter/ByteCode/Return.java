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
public class Return extends bytecode {
      String funcname = "";
    int topValue;
    
    @Override
    public void init(ArrayList<String> args) {
        if(!args.isEmpty()) {
            funcname = args.get(0);
        }
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        vm.vmPopFrame();
        vm.setPC(vm.popRetAddrs());
        topValue = vm.vmPeek();
    }
    
    @Override
    public String toString() {
        return "RETURN " + funcname;
    }

}
