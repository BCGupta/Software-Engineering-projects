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
public class Store extends bytecode {
        int n;
    String id = "";
    
    @Override
    public void init(ArrayList<String> args) {
        if(args.size() == 1) {
            n = Integer.parseInt(args.get(0));
        } else {
            id = args.get(args.size() - 1);
            n = Integer.parseInt(args.get(0));
        }
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        vm.vmStore(n);
    }
    
    @Override
    public String toString() {
        return "STORE " + n + " " + id;
    }

}
