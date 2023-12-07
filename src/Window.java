import javax.swing.JFrame;
import java.awt.*;

public class Window extends JFrame implements Runnable{
    //extend:
        // is used when you want attributes of parent class/ interface in your child class/interface
        // a class(sub class)extends another class (super class) and can override the methods defined in the super class
    //Implements:
        // is used when you want attributes of an interface in your class

    Graphics2D g2;
    KL keyListener = new KL();
    public Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //make sure that when you click the 'X', in the right-hand corner of the Window that it will actually close it.
        this.addKeyListener(keyListener);
        g2 = (Graphics2D)this.getGraphics();
    }

    //dt dalta time
    public void update(double dt)
    {
        g2.setColor(Color. BLACK);
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        if
    }

    public void run()
    {
        double lastFrameTime = 0.0;
        while (true){
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;

            update(deltaTime);
        }
    }

}
