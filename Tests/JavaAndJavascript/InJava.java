package JavaAndJavascript;

import java.awt.*;
import java.applet.Applet;
public class InJava extends Applet{
    public void sayHello() {
        Graphics g = getGraphics();
        g.drawString("Hello from JAVA!", 10, 10);
    }
}