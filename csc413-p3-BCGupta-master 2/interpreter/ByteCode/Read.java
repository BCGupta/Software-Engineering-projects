/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;
import  interpreter.VirtualMachine;
import  java.util.*;
/**
 *
 * @author shubham
 */
public class Read extends bytecode {
     Scanner scanner = new Scanner(System.in);
    
    @Override
    public void init(ArrayList<String> args) {
    }
    
    @Override
    public void execute(VirtualMachine vm) {
        
        System.out.print("Enter a number: ");
        int userInputer = scanner.nextInt();
        vm.vmPush(userInputer);
        
    }
    
    @Override
    public String toString() {
        return "READ";
    }

}
