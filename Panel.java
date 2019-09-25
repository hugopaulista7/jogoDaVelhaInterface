import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridLayout;

class Panel {
    private JFrame mainPanel;
    private JPanel buttonsPanel;
    private JPanel displayPanel;
    private Button[] gameButtons = new Button[9];
    private Button newGameButton;
    private Display turnDisplay = new Display();
    Panel() {
    }

    private JFrame get() {
        return this.mainPanel;
    }

    private void show() {
        this.mainPanel.setVisible(true);
    }

    private void resize(int width, int height) {
        this.mainPanel.setSize(width, height);
    }

    private void exitOperation() {
        this.mainPanel.setDefaultCloseOperation(this.mainPanel.EXIT_ON_CLOSE);
    }

    private void insertButtons() {
        for(int i = 0; i < this.gameButtons.length; i++) {
            this.buttonsPanel.add(this.gameButtons[i].get());
        }
        this.displayPanel.add(this.newGameButton.get());
    }

    private void setPanelGrid(JPanel panel, int rows, int columns) {
        panel.setLayout(new GridLayout(rows, columns));
    }

    private void setFrameGrid(JFrame frame, int rows, int columns, boolean defaultLook) {
        frame.setLayout(new GridLayout(rows, columns));
        frame.setDefaultLookAndFeelDecorated(defaultLook);
    }

    private void setGrid() {
        this.setFrameGrid(this.mainPanel, 1, 2, true);

        this.setPanelGrid(this.buttonsPanel, 3, 3);

        this.setPanelGrid(this.displayPanel, 4, 1);
        
        this.insertButtons();
        
        this.mainPanel.add(this.buttonsPanel);
        this.mainPanel.add(this.displayPanel);
    }

    private void initializeAllPanels() {
        this.mainPanel = new JFrame("Jogo da Velha - Hugo Paulista");
        this.buttonsPanel = new JPanel();
        this.displayPanel = new JPanel();
    }

    private void initializeAllButtons() {
        for (int i = 0; i < this.gameButtons.length; i++) {
            this.gameButtons[i] = new Button();
            this.gameButtons[i].resize(50, 50);
            int aux = i + 1;
            this.gameButtons[i].setChar(String.valueOf(aux).charAt(0));
        }
        this.newGameButton = new Button();
        this.newGameButton.setString("Novo jogo");
    }

    public void initPanel(int width, int height) {
        this.initializeAllPanels();
        this.initializeAllButtons();
        this.resize(width, height);
        this.exitOperation();
        this.setGrid();
        this.show();
    }
}
