
package interpreter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import interpreter.ByteCode.bytecode;
import java.util.*;


public class ByteCodeLoader extends Object {

     private final BufferedReader byteCodeReader;
     private Program program;
     
    public ByteCodeLoader(String programFile) throws IOException {
        byteCodeReader = new BufferedReader(new FileReader(programFile));
    }
      /**
     * This function should read one line of source code at a time.
     * For each line it should:
     *      Tokenize string to break it into parts.
     *      Grab correct class name for the given ByteCode from CodeTable
     *      Create an instance of the ByteCode class name returned from code table.
     *      Parse any additional arguments for the given ByteCode and send them to
     *      the newly created ByteCode instance via the init function.
     * 
     * @return 
     */

 public Program loadCodes() {

        String hashKey, hashValue;
        String nextLine;
        bytecode byteCode;
        ArrayList<String> tokenList = new ArrayList<>(); 

       program = new Program();
        try {
            nextLine = byteCodeReader.readLine(); 
            while (nextLine != null) {


                StringTokenizer st = new StringTokenizer(nextLine);

                hashKey = st.nextToken();

                hashValue = CodeTable.getClassName(hashKey);
                byteCode = (bytecode) (Class.forName("interpreter.bytecode." + hashValue).newInstance());


                while (st.hasMoreTokens()) {  //check for things such as literal value & id
                    tokenList.add(st.nextToken());  //ArrayList container, will pass to ByteCode objects 

                }

                byteCode.init(tokenList); 
                program.addCode(byteCode); 
                tokenList.clear();
                
                nextLine = byteCodeReader.readLine();
            }

        } catch (IOException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {

            System.out.println("***Something Went Wrong***");
            //throw new IOException("***End of File***");
        }
        
        program.resolveAddrs(program);
        
        return program;
    }
}

   