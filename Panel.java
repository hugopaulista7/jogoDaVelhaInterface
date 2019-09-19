import javax.swing.JOptionPane;
import javax.swing.JFrame;
import java.awt.GridLayout;

class Panel {
    private JFrame panel;
    private Button[] buttons = new Button[9];
    Panel() {
        this.panel = new JFrame();
        for (int i = 0; i < 9; i++) {
            buttons[i] = new Button();
            buttons[i].resize(50, 50);
            int aux = i + 1;
            buttons[i].setChar(String.valueOf(aux).charAt(0));
        }
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

    private void insertButtons() {
        for(int i = 0; i < this.buttons.length; i++) {
            this.panel.add(this.buttons[i].get());
            System.out.println(this.buttons[i].getChar());
        }
    }

    private void setGrid() {
        // this.panel.setLayout(new GridLayout(3, 3));
        this.panel.setDefaultLookAndFeelDecorated(true); 
        this.insertButtons();
    }

    public void initPanel(int width, int height) {
        this.resize(width, height);
        this.exitOperation();
        this.setGrid();
        this.show();
    }
}
