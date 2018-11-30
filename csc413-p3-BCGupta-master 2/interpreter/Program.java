package interpreter;

import interpreter.ByteCode.Label;
import interpreter.ByteCode.FalseBranch;
import interpreter.ByteCode.Call;
import interpreter.ByteCode.GoTo;
import interpreter.ByteCode.bytecode;
import java.util.*;
import java.util.ArrayList;

/**
 *
 * @author shubham
 */
public class Program extends Object {
    
    
    private final ArrayList<Object> byteCodeList;
    private ArrayList<bytecode> program;
    static HashMap<String, Integer> byteCodeLabels;
    
    public Program() {
        byteCodeList = new ArrayList();
        byteCodeLabels = new HashMap<>();
        program = new ArrayList<>();
        
    }

    protected bytecode getCode(int pc) {
        return this.program.get(pc);
    }

    public int getSize() {
        return this.program.size();
    }
    
    public void addCode(bytecode byteCode) {
        if(byteCode instanceof Label) {
            Label labelBranch = (Label)byteCode;
            addLabel(labelBranch.getLabel(),byteCodeList.size());
        }
        byteCodeList.add(byteCode);
    }
    
    public void resolveAddrs(Program program) {
        
        for (Object byteCodeList1 : byteCodeList) {
            if (byteCodeList1 instanceof GoTo) {
                GoTo changeBranch = (GoTo) byteCodeList1;
                changeBranch.setTargetAddress(byteCodeLabels.get(changeBranch.getLabel()));
            } else if (byteCodeList1 instanceof FalseBranch) {
                FalseBranch changeBranch = (FalseBranch) byteCodeList1;
                changeBranch.setTargetAddress(byteCodeLabels.get(changeBranch.getLabel()));
            } else if (byteCodeList1 instanceof Call) {
                Call changeBranch = (Call) byteCodeList1;
                changeBranch.setTargetAddress(byteCodeLabels.get(changeBranch.getLabel()));
            }
        }
    }
    
    static public void addLabel(String key, int branch) {
        byteCodeLabels.put(key, branch);
    }
    
    static public String getBranch(String branch) {
        return byteCodeLabels.get(branch).toString();
    }
    
    
}