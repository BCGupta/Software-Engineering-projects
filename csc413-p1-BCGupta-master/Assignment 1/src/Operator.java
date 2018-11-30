import java.util.HashMap;
public abstract class Operator {
  // The Operator class should contain an instance of a HashMap
  // This map will use keys as the tokens we're interested in,
  // and values will be instances of the Operators.

  // Example:
  // Where does this declaration go? What should its access level be?
  // Class or instance variable? Is this the right declaration?
  static HashMap operators = new HashMap();
  // operators.put( "+", new AdditionOperator() );
  // operators.put( "-", new SubtractionOperator() );
static{
        operators.put("#", new PoundOperator());
        operators.put("!", new ExclamationOperator());
        operators.put("+", new AdditionOperator());
        operators.put("-", new SubtractionOperator());
        operators.put("*", new MultiplicationOperator());
        operators.put("/", new DivisionOperator());
    }

public static boolean check( String token ) {
        return token.equals("+")|| token.equals("-")||token.equals("*") ||
               token.equals("/")|| token.equals("^")|| token.equals("(")||token.equals(")");
    }
  public abstract int priority();
  public abstract Operand execute( Operand op1, Operand op2 );

}
