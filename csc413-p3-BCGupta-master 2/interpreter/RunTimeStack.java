package interpreter;

import java.util.ArrayList;
import java.util.Stack;
import java.util.*;

public class RunTimeStack {

    private final ArrayList runTimeStack;
    private final Stack<Integer> framePointer;

    public RunTimeStack() 
    {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        //Add initial Frame Pointer, main is the entry
        // point of our language, so its frame pointer is 0.
        framePointer.add(0);
    }
    
         public void dump() {
        Iterator iterator = framePointer.iterator();
        int frameCount = (Integer)iterator.next();
        
        if(iterator.hasNext()) {
            frameCount = (Integer)iterator.next();
        }
        
        System.out.print("[");
        if(!runTimeStack.isEmpty()) {
            System.out.print(runTimeStack.get(0));
        }
        
        for(int i = 1; i < runTimeStack.size(); i++) {
            if(i == frameCount) {
                System.out.print("] [" + runTimeStack.get(i));
                if(iterator.hasNext()){
                    frameCount = (Integer)iterator.next();
                }
            }else
                System.out.print("," + runTimeStack.get(i));
        }
        System.out.println("]");
    }
    
    public Integer getValue(int n) {
        return (int) runTimeStack.get(n);
    }
    
    public Integer peek() {
        return (int) runTimeStack.get(runTimeStack.size()-1);
    }
    
    public Integer peekFrame() {
        return framePointer.peek();
    }
    
    public int pop() {
        return (int) runTimeStack.remove(runTimeStack.size() - 1);
    }
    
    public int push(int i) {
        runTimeStack.add(i);
        return i;
    }
    
    public void newFrameAt(int offset) {
        framePointer.push(runTimeStack.size() - offset);
    }
    
    public void popFrame() {
              int topindex = (runTimeStack.size()) - 1;
        Integer returnVal = (Integer) runTimeStack.get(runTimeStack.size()-1);
        Integer bottom = framePointer.pop();
        for (; topindex >= bottom; topindex--) {
            runTimeStack.remove(topindex);

        }

        runTimeStack.add(returnVal);
    }
    
    public int store(int offset) {
        int storeValue = (runTimeStack.size() - 1);
        runTimeStack.remove(runTimeStack.size() - 1);
        runTimeStack.set(framePointer.peek() + offset, storeValue);
        return storeValue;
    }
    
    public int load(int offset) {
        int loadValue = (framePointer.peek() + offset);
        runTimeStack.add(loadValue);
        return loadValue;
    }
    
    public Integer push(Integer i) {
        runTimeStack.add(i);
        return i;
    }
    
    public int getRunStackSize() {
        return runTimeStack.size();
    }
    
}
    





   