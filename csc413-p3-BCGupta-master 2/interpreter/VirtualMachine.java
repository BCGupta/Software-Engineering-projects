package interpreter;

import java.util.Stack;
import interpreter.ByteCode.Dump;
import interpreter.ByteCode.bytecode;


/**
 *
 * @author shubham
 */

public class VirtualMachine {
    
    
    protected int pc = 0;
    protected boolean isRunning;
    protected boolean dump = false;
    protected Stack<Integer> returnAddrs;
    protected Program program;
    protected RunTimeStack runStack;
    
    public VirtualMachine(Program program) {
        this.program = program;
    }
    
    public void executeProgram() {
        
        runStack = new RunTimeStack();
        returnAddrs = new Stack<>();
        isRunning = true;
        while(isRunning) {
            bytecode code = program.getCode(pc);
            code.execute(this);
            if (dump && !(code instanceof Dump)) {
                System.out.println(code.toString());
                //runStack.dump();
            }
            pc++;
        }
    }
    
    public void setPC(int target) {
        pc = target;
    }
    
    public int getPC() {
        return pc;
    }
    
    public void setRunning(boolean running) {
        isRunning = running;
    }
    
    public boolean getRunning() {
        return isRunning;
    }
    
    public void DumpOn() {
        dump = true;
    }
    
    public void DumpOff() {
        dump = false;
    }
    
    public int popRetAddrs() {
        return returnAddrs.pop();
    }
    
    public void pushRetAddrs(int addrs) {
        returnAddrs.push(addrs);
    }
    
    public int vmPeek() {
        return runStack.peek();
    }
    
    public Integer vmPop() {
        return runStack.pop();
    }
    
    public void vmPush(int n) {
         runStack.push(n);
    }
    
    public Integer vmPush(Integer i) {
        return runStack.push(i);
    }
    
    public void vmframeAt(int offset) {
        runStack.newFrameAt(offset);
    }
    
    public void vmPopFrame() {
        runStack.popFrame();
    }
    
    public Object vmPeekFrame() {
        return runStack.peekFrame();
    }
    
    public int vmStore(int offset) {
        return runStack.store(offset);
    }
    
    public int vmLoad(int offset) {
        return runStack.load(offset);
    }
    
    public int getRunStackSize() {
        return runStack.getRunStackSize();
    }
    
    public RunTimeStack newRunTimeStack() {
       RunTimeStack runTimeStack = new RunTimeStack();
       return runTimeStack;
    }
    
    public Stack newReturnAddrsStack() {
        Stack returnStack = new Stack();
        return returnStack;
    }
    
}
