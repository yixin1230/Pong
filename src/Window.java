import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyEvent;

public class Window extends JFrame implements Runnable{
    //extend:
        // is used when you want attributes of parent class/ interface in your child class/interface
        // a class(sub class)extends another class (super class) and can override the methods defined in the super class
    //Implements:
        // is used when you want attributes of an interface in your class

    public Graphics2D g2;
    public KL keyListener = new KL();
    public Rect ai, ballRect, playerOne;
    public PlayerController playerController;
    public AiController aiController;
    public Ball ball;

    public Window() {
        this.setSize((int)Constants.SCREEN_WIDTH, (int)Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        Constants.TOOLBAR_HEIGHT = this.getInsets().top;
        Constants.TOOLBAR_BOTTOM = this.getInsets().bottom;

        g2 = (Graphics2D)this.getGraphics();

        playerOne = new Rect(20, 20, 10, 100,  Color.CYAN);
        playerController = new PlayerController(playerOne, keyListener);

        ai = new Rect(750, 20 , 10, 100, Color.WHITE);
        ballRect = new Rect(400, 300, 10,10, Color.WHITE);
        ball = new Ball(ballRect, playerOne, ai);

        aiController = new AiController(new PlayerController(ai), ballRect);
    }

    //dt delta time
    public void update(double dt)
    {
        g2.setColor(Color. BLACK);
        g2.fillRect(0, 0, (int)Constants.SCREEN_WIDTH, (int)Constants.SCREEN_HEIGHT);
        ai.draw(g2);
        ballRect.draw(g2);
        playerOne.draw(g2);

        playerController.update(dt);
        ball.update(dt);
        aiController.update(dt);

    }

    public void run()
    {
        double lastFrameTime = 0.0;
        while (true){
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;
            update(deltaTime);

            try{
                //If I don't use try and catch, it will show 'error: unreported exception InterruptedExecption;
                // must be caught or declared'
                Thread.sleep(50);
                //My rectangle constantly "vibrated", then disappeared.
                //The reason for this in my case was, that the update process was too fast, therefore the background
                //constantly "overprinted" the rectangle. Had to send the thread to sleep in every cycle.
            }
            catch(InterruptedException e)
            {

            }

        }
    }

}
