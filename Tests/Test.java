import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.awt.*;

public class Test {

    public static void main(String[]args)throws ScriptException {
       String[] s = "abcdefghijkl".split("");
        for (String d:s
             ) {
            System.out.println(d);

        }
    }
}
