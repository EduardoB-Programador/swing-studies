package view;

import javax.swing.*;
import java.awt.*;

/**This class has the purpose of anottating all the windows I make while learning how to use javax.swing
 * <p>
 * The methods will be called in the {@link controller.App#main(String[])} method
 * used to run all the windows made in this class
 * <p>
 * I'll probably comment the already tested and used windows, but I'll try to keep them in order from the first to the
 * last one made intending to show the progressive development of my windows using swing.
 * <p>
 * @see <a href="https://github.com/EduardoB-Programador">My GitHub</a>
 * @author EduardoB-Programador
 * */

public class Windows {

    public static void firstWindow() {

        //Creating a JFrame object
        JFrame frame = new JFrame("Simple swing");

        //Making the JFrame visible on screen
        frame.setVisible(true);

        /*When you create a new JFrame object it is not visible by default, so you need to make it visible
         * using the method setVisible(boolean)*/

        /*In fact, you can use the setVisible() method when creating the JFrame object, like this:
         * JFrame frame = new JFrame("Simple swing").setVisible(true);*/

        //When the window is closed the entire aplication ends, as if System.exit() ran
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /*There are more close operations to explore, those are constans so mention the class name then set
         * the operation, as in: JFrame.EXIT_ON_CLOSE*/

        //Setting the intial size of the window
        frame.setSize(500, 300);

        //Setting the initial window's initial position
        frame.setLocation(300, 300);

        /*Another option to define both the intial size and coodinates at the same time is the method
         * setBounds(int x, int y, int width, int height)*/

        Container contentPane = frame.getContentPane();
        Container subContentPane = new Container();

        contentPane.add(subContentPane);

        JButton closeB = new JButton("Close");

        subContentPane.add(closeB);

        subContentPane.setBounds(
                contentPane.getX() / 2,
                contentPane.getY() / 2,
                200, 200
        );


        closeB.setBounds(
                subContentPane.getX(),
                subContentPane.getY(),
                subContentPane.getWidth() / 2, subContentPane.getHeight() / 2
        );

    }

    public static void secondWindow() {
        //Creating the frame
        JFrame frame = new JFrame("Simple Swing 2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Setting location
        frame.setLocation(400, 400);

        //Adding two buttons
        JButton closeB = new JButton("Close");
        JButton helpB = new JButton("Help");

        //Getting the contentPane
        Container contentPane = frame.getContentPane();

        //Adding the buttons
        contentPane.add(closeB);
        contentPane.add(helpB);

        //Read frame.pack() documentation
        frame.pack();

        frame.setVisible(true);

        /*Until here, it can be seen that the only button displayed was the "help" button, that doesn't mean that we
        lost the other button, it's just that the layout manager did its job but not in the way we expect it to do it,
        meaning, if we go check how many components the contentPane container has, it will show us 2 components,
        so where is the close button? That is indeed one good question, lemme check*/

        /*Apparently the book won't say it now, so here's some cool classes*/

        //Point class
        //Creating a Point object with the coordinates bellow
        Point p = new Point(20, 40);

        //Getting the objects coordinates
        int x = (int) p.getX();
        int y = (int) p.getY();

        //Setting the x and y coordinates again
        p.setLocation(10, 60);

        /*This class represents coordinates, basically, and can be used to set a location instead of passing
        the X and Y axis*/

        //Dimension class
        //Creating a Dimension object
        Dimension d = new Dimension(200, 20);

        //Getting the height and width
        int width = (int) d.getWidth();
        int height = (int) d.getHeight();

        /*Most of the classes' names are self-explanatory, and also their methods, but well, this one defines a
        dimensional object, that has width and height, can replace raw numbers from setSize() for example*/

        //Insets class
        //Creating an Insets object
        Insets ins = new Insets(20, 5, 5, 5);

        //Getting the top, left, bottom, and right values
        int top = ins.top;
        int left = ins.left;
        int bottom = ins.bottom;
        int right = ins.right;

        /*This class is an interesting one, beginning with what it represents, "represents spaces that are left
        around the container", looks like the CSS position, and I'm almost sure it does the same thing*/

        //Rectangle class
        //Creating a Rectangle object with no parameters
        Rectangle r1 = new Rectangle();

        //Creating a Rectangle object with only the Point object parameter
        Rectangle r2 = new Rectangle(new Point(10, 10));

        //Creating a Rectangle object with both Point and Dimension objects as parameters
        Rectangle r3 = new Rectangle(new Point(10, 10), new Dimension(200, 100));

        //Creating a Rectangle object passing raw numbers as parameters
        Rectangle r4 = new Rectangle(10, 10, 200, 100);

        /*This class, makes a rectangle, impressive, well, it use is more useful than just a simple rectangle,
        it can replace the setBounds() raw number input, I think that's about it*/

    }

    public static void thirdWindow() {
        JFrame frame = new JFrame("Simple swing 3");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();

        //Layout managers
        contentPane.setLayout(new FlowLayout());

        //Setting the BorderLayout as the layout manager for a JPanel
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        //Getting the layout manager
        LayoutManager lManager = frame.getLayout();

        /*The FlowLayout tries to place all components in a single row, if all components do not fit in one row
        it starts another one.*/

        for (int i = 1; i <= 3; i++) {
            contentPane.add(new Button("Button " + i));
        }

        frame.pack();
        frame.setVisible(true);

        /*The alingment of the FlowLayout is at the moment, center, but this alingment can change, using the
        setAlingment() method, or passing the alignment type at the constructor;
        FlowLayout fLayout = new FlowLayout(FlowLayout.RIGHT);

        or
        fLayout.setAlignment(FlowLayout.RIGHT);
        */
    }

    public static void fourthWindow() {
        JFrame frame = new JFrame("simple swing 4");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Component orientation
        frame.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);

        //Setting the Layout Manager as FlowLayout with the LEADING alignment
        frame.setLayout(new FlowLayout(FlowLayout.LEADING));
        frame.setLocation(400, 400);

        Container contentPane = frame.getContentPane();

        for (int i = 1; i <= 5; i++) {
            contentPane.add(new Button("Button " + i));
        }

        frame.pack();
        frame.setVisible(true);

        /*Just watch the execution, there is nothing to explain until here*/

    }

    public static void fifthWindow() {
        JFrame frame = new JFrame("FlowLayout nesting");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Those last numbers are repectively horizontal gap and vertical gap
        frame.getContentPane().setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));

        JPanel panel = new JPanel();

        for (int i = 1; i <= 30; i++) {
            panel.add(new Button("Button " + i));
        }

        frame.getContentPane().add(panel);

        frame.pack();
        frame.setVisible(true);

        /*In this window I'm intending to show this kind of problem, well, here we have the ContentPane
        using the FlowLayout and the JPanel using it as well (JPanel uses it by standard), as said before
        the FlowLayout tries to put all the components in a single row, if it can't, it'll try to put them in the
        next row, but if they are using this layout as well, we can't see beyond the first row, there's a whole
        better explanation to this, but I simply cannot explain why this happens, aside from the fact that I can
        understand, just cannot explain how. :)*/

    }

}
