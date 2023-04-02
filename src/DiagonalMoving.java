import javax.swing.*;

public class DiagonalMoving {
    public DiagonalMoving() {
        JFrame.setDefaultLookAndFeelDecorated(true);
        GUIdiagonalMoving app = new GUIdiagonalMoving();
        app.setVisible(true);
    }
    public static void main(String[] arg) {
        new DiagonalMoving();
    }
}
class GUIdiagonalMoving extends JFrame{
    JLabel label = new JLabel();
    public GUIdiagonalMoving() {
        super("MovingDiagonal");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon ocean = new ImageIcon("ocean.jpg");
        setContentPane(new JLabel(ocean));
        pack();
        ImageIcon shrimp = new ImageIcon("shrimp.png");
        label.setBounds(-shrimp.getIconWidth(), -23-shrimp.getIconHeight(), shrimp.getIconWidth(), shrimp.getIconHeight());
        label.setIcon(shrimp);
        add(label);
        setVisible(true);
        MovingWay(ocean.getIconWidth(), ocean.getIconHeight());
    }
    void MovingWay(int w, int h) {
        final int[] pixelway = {0};
        int pixelstep = 1;
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true) {
                        if (label.getLocation().x <= w & label.getLocation().y <= h) {
                            label.setLocation(label.getLocation().x+pixelstep, label.getLocation().y+pixelstep);
                            pixelway[0] += pixelstep;
                        } else {
                            label.setLocation((label.getLocation().x-pixelway[0]), label.getLocation().y-pixelway[0]);
                            pixelway[0] = 0;
                        }
                        Thread.sleep(18);
                    }
                }
                catch(Exception e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();
    }
}