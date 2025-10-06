import java.util.Stack;
import java.util.HashMap;
import java.util.Map;

public class Semantico implements Constants
{
    Stack<Integer> binaries = new Stack<Integer>();
    Map<String, Integer> map = new HashMap<String, Integer>();
    
    Integer i, ii;
    String var = "";

    public void executeAction(int action, Token token)	throws SemanticError
    {
        System.out.println("Ação #"+action+", Token: "+token);

        switch(action) {
            case 1: //Binario
                System.out.println(Integer.parseInt(token.getLexeme(), 2));
                binaries.push(Integer.parseInt(token.getLexeme(), 2));
                break;
            case 2: //Variável
                binaries.push(map.get(token.getLexeme()));
                break;
            case 3: //Imprimir
                System.out.println(Integer.toBinaryString(binaries.pop()));
                break;
            case 4: //Atribuir a variável
                var = token.getLexeme();
                break;
            case 5: //Variável
                Integer ok = binaries.pop();
                map.put(var, ok);
                System.out.println(var + " - " + ok);
                break;
            case 6: //Soma
                i = binaries.pop();
                ii = binaries.pop();
                System.out.println(i + ii);
                binaries.push(i + ii);
                break;
            case 7: //Subtração
                ii = binaries.pop();
                i = binaries.pop();
                System.out.println(i - ii);
                binaries.push(i - ii);
                break;
            case 8: //Multiplicação
                i = binaries.pop();
                ii = binaries.pop();
                System.out.println(i * ii);
                binaries.push(i * ii);
                break;
            case 9: //Divisão
                ii = binaries.pop();
                i = binaries.pop();
                System.out.println(Math.round((i.floatValue() / ii.floatValue())));
                binaries.push(Math.round((i.floatValue() / ii.floatValue())));
                break;
            case 10: //Exponenciação
                ii = binaries.pop();
                i = binaries.pop();
                System.out.println(Math.pow(i.doubleValue(), ii.doubleValue()));
                binaries.push((int) Math.pow(i.doubleValue(), ii.doubleValue()));
                break;
            case(11): //Log
                i = binaries.pop();
                ii = binaries.pop();
                
                System.out.println(Math.log(i.doubleValue()) / Math.log(ii.doubleValue()));
                binaries.push((int) Math.round(Math.log(i.doubleValue()) / Math.log(ii.doubleValue())));
                break;
        }
    }	
}
