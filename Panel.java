import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.JFrame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Panel implements ActionListener {
    private JFrame mainPanel;
    private JPanel buttonsPanel;
    private JPanel displayPanel;
    private Button[] gameButtons = new Button[9];
    private Button newGameButton;
    private Display turnDisplay = new Display();
    private Player current;

    private Player player1;
    private Player player2;

    private int turnCounter;
    Panel() {
    }

    private JFrame get() {
        return this.mainPanel;
    }

    public void show() {
        this.mainPanel.setVisible(true);
    }

    private void resize(int width, int height) {
        this.mainPanel.setSize(width, height);
    }

    private void exitOperation() {
        this.mainPanel.setDefaultCloseOperation(this.mainPanel.EXIT_ON_CLOSE);
    }

    private void insertButtons() {
        for (int i = 0; i < this.gameButtons.length; i++) {
            this.buttonsPanel.add(this.gameButtons[i].get());
        }
        this.displayPanel.add(this.newGameButton.get());
    }

    private void setPanelGrid(JPanel panel, int rows, int columns) {
        panel.setLayout(new GridLayout(rows, columns));
    }

    public void setPlayers(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
    }

    private void setFrameGrid(JFrame frame, int rows, int columns, boolean defaultLook) {
        frame.setLayout(new GridLayout(rows, columns));
        frame.setDefaultLookAndFeelDecorated(defaultLook);
    }

    private void insertDisplay(Display display) {
        this.displayPanel.add(display.get());
    }

    private void setGrid() {
        this.setFrameGrid(this.mainPanel, 1, 2, true);

        this.setPanelGrid(this.buttonsPanel, 3, 3);

        this.setPanelGrid(this.displayPanel, 4, 2);

        this.insertButtons();
        this.turnDisplay.setLabel("Turno: ");
        this.insertDisplay(this.turnDisplay);

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
            this.gameButtons[i].addEvent(this);
        }
        this.newGameButton = new Button();
        this.newGameButton.setString("Novo jogo");
        this.newGameButton.addEvent(this);
    }

    public void clearAll() {
        
    }

    public void initPanel(int width, int height) {
        this.turnCounter = 0;
        this.clearAll();
        this.initializeAllPanels();
        this.initializeAllButtons();
        this.resize(width, height);
        this.exitOperation();
        this.setGrid();
        // this.show();
    }

    public void showPlayerNameOnDisplay(Player player) {
        Display display = new Display();
        display.setLabel(player.getName() + " | " + player.getSelectedChar());
        this.insertDisplay(display);
    }

    public void setCurrentPlayer(Player p) {
        this.current = p;
    }

    public void game() {
        this.turnCounter++;
        this.turnDisplay.setLabel("Turno: " + this.current.getName());
        JOptionPane.showMessageDialog(null, this.current.getName() + " selecione a posição");
    }

    public void changeCurrent() {
        this.current = this.current == this.player1 ? this.player2 : this.player1;
        this.game();
    }

    private void resetGame() {
        this.clearAll();
    }

    private int countOccurrencesOf(String str, String ch) {
        int counter = 0;

        for (int i = 0; i < str.length(); i++ ) {
            if (str.toCharArray()[i] == ch.charAt(0) ) {
                counter++;
            }
        }

        return counter;
    }

    private char validateRows() {
        String previous;
        for (int i= 0; i <= 6; i = i + 3) {
            previous = "";
            for (int j = 0; j < 3; j++) {
                previous += this.gameButtons[j + i].getChar();
            }
            int countX = this.countOccurrencesOf(previous.toLowerCase(), "x");
            int countO = this.countOccurrencesOf(previous.toLowerCase(), "o");
            if (countX == 3) {
                return previous.charAt(0);
            }
            if (countO == 3 ) {
                return previous.charAt(0);
            }

        }

        return 'f';
    }

    private char validateColumns() {
        String previous;

        for (int j = 0; j < 3; j++) {
            previous = "";
            for (int i= 0; i <= 6; i = i + 3) {
                previous += this.gameButtons[j + i].getChar();
            }
            int countX = this.countOccurrencesOf(previous.toLowerCase(), "x");
            int countO = this.countOccurrencesOf(previous.toLowerCase(), "o");

            if (countX == 3) {
                return previous.charAt(0);
            }
            if (countO == 3 ) {
                return previous.charAt(0);
            }

        }

        return 'f';
    }

    private char validateDiagonals() {

        String previous;
        previous = "";
    /**diagonal principal */
        for (int i = 0; i < 9; i = i + 4) {
            previous += this.gameButtons[i].getChar();
            int countX = this.countOccurrencesOf(previous.toLowerCase(), "x");
            int countO = this.countOccurrencesOf(previous.toLowerCase(), "o");
            if (countX == 3) {
                return previous.charAt(0);
            }
            if (countO == 3 ) {
                return previous.charAt(0);
            }
        }
        /** diagonal secundaria */
        previous = "";
        for (int i = 0; i < 7; i = i + 2) {
            previous += this.gameButtons[i].getChar();

            int countX = this.countOccurrencesOf(previous.toLowerCase(), "x");
            int countO = this.countOccurrencesOf(previous.toLowerCase(), "o");

            if (countX == 3) {
                return previous.charAt(0);
            }
            if (countO == 3 ) {
                return previous.charAt(0);
            }
        }

        return 'f';
    }

    private void validate() {
        char r = this.validateRows();
        char c = this.validateColumns();
        char d = this.validateDiagonals();
        System.out.print(this.current.getSelectedChar() + " 235");
        if (String.valueOf(r) == this.current.getSelectedChar()) {
            System.out.print(r + " 237");
            JOptionPane.showMessageDialog(null, this.current.getName() + " Ganhou!");
            this.current = null;
        }
        if (String.valueOf(c) == this.current.getSelectedChar()) {
            System.out.print(c + "242");
            JOptionPane.showMessageDialog(null, this.current.getName() + " Ganhou!");
            this.current = null;
        }
        if (String.valueOf(d) == this.current.getSelectedChar()) {
            System.out.print(d + " 247");
            JOptionPane.showMessageDialog(null, this.current.getName() + " Ganhou!");
            this.current = null;
        }
    }

    private void checkWin() {
        if (this.turnCounter > 3) {
            this.validate();
            if (this.current == null ) {
                this.resetGame();
            }
        }
        return ;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (this.turnCounter > 8) {
            JOptionPane.showMessageDialog(null, "Deu velha!");
            this.resetGame();
            return ;
        }
        if (command.equals("Novo jogo")) {
            this.initPanel(1200, 800);
            SwingUtilities.updateComponentTreeUI(this.mainPanel);
        } else {
            int pos = Integer.parseInt(command) > 0 ? Integer.parseInt(command) - 1 : 0;
            this.gameButtons[pos].setChar(this.current.getSelectedChar().charAt(0));

            this.checkWin();
            this.changeCurrent();
        }


    }
}
