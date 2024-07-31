package model;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RoundButton extends JButton {

    public RoundButton(String label) {
        super(label);
        setContentAreaFilled(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isArmed()) {
            g.setColor(Color.LIGHT_GRAY);
        } else {
            g.setColor(getBackground());
        }
        g.fillOval(0, 0, getSize().width - 1, getSize().height - 1);
        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(getForeground());
        g.drawOval(0, 0, getSize().width - 1, getSize().height - 1);
    }

    @Override
    public boolean contains(int x, int y) {
        int radius = getSize().width / 2;
        Ellipse2D ellipse = new Ellipse2D.Double(0, 0, getSize().width, getSize().height);
        return ellipse.contains(x, y);
    }

    @Override
    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();
        int diameter = Math.max(size.width, size.height);
        size.setSize(diameter, diameter);
        return size;
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        RoundButton roundButton = new RoundButton("Thoát");
        roundButton.setBackground(Color.RED);
        roundButton.setForeground(Color.WHITE);
        roundButton.addActionListener(e -> System.exit(0));

        frame.add(roundButton);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
