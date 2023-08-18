package view;

import javax.swing.JOptionPane;

public class ViewManager {
    public void showGraphicMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public double readGraphicDouble(String message) {
        return Double.parseDouble(JOptionPane.showInputDialog(message));
    }

    public long readGraphicLong(String message) {
        return Long.parseLong(JOptionPane.showInputDialog(message));
    }

    public short readGraphicShort(String message) {
        return Short.parseShort(JOptionPane.showInputDialog(message));
    }

    public void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
