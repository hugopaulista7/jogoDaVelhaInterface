import javax.swing.JOptionPane;
import javax.swing.JFrame;

class Panel {
    private JFrame panel;    
    Panel() {
        this.panel = new JFrame();
    }

    private JFrame get() {
        return this.panel;
    }

    private void show() {
        this.panel.setVisible(true);
    }

    private void resize(int width, int height) {
        this.panel.setSize(width, height);
    }

    private void exitOperation() {
        this.panel.setDefaultCloseOperation(this.panel.EXIT_ON_CLOSE);
    }
    public void initPanel(int width, int height) {
        this.resize(width, height);
        this.exitOperation();
        this.show();
    }
}
