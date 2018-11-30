/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter.ByteCode;
import java.util.ArrayList;
import interpreter.*;

/**
 *
 * @author shubham
 */
public abstract class bytecode {

    public abstract void init(ArrayList<String> arg);
    public abstract void execute(VirtualMachine vm);
    
}

