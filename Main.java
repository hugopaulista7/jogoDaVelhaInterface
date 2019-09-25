import javax.swing.JOptionPane;

class Main {
    public static void main(String[] args) {
        Panel panel = new Panel();
        JOptionPane dialog = new JOptionPane();
        Player player1 = new Player();
        Player player2 = new Player();
        int panelWidth = 1200, panelHeight = 800;
        panel.initPanel(panelWidth, panelHeight);

        dialog.showMessageDialog(null, "Jogo da Velha com Interface");
        String text = dialog.showInputDialog(null, "Jogador 1 digite seu nome");
        player1.setName(text);
        text = dialog.showInputDialog(null, "Jogador 2 digite seu nome");
        player2.setName(text);

        text = "";

        text = dialog.showInputDialog(null,  player1.getName() + " digite o caractere que irá usar no jogo:");
        if (player1.validateChar(text)) {
            player1.setSelectedChar(text);
        }

        boolean valid = false;
        while(!valid) {
            text = "";
        
            text = dialog.showInputDialog(null,  player2.getName() + " digite o caractere que irá usar no jogo:");    
            if (!player1.getSelectedChar().toLowerCase().equals(text.toLowerCase())  && player2.validateChar(text)) {
                player2.setSelectedChar(text);
                valid = true;
                break;
            }

            dialog.showMessageDialog(null, "O caractere deve ser diferente do primeiro jogador!");
            continue;
        }

        panel.showPlayerNameOnDisplay(player1);
        panel.showPlayerNameOnDisplay(player2);

        panel.show();

        /**jogo iniciado */
        int current = 0;
        valid = false;
        String message = " por favor selecione no tabuleiro a celula que deseja jogar";
        while (!valid) {
            if (current == 0) {
                dialog.showMessageDialog(null, player1.getName() + message);

            } else {
                dialog.showMessageDialog(null, player2.getName() + message);
            }

            current = (current == 0 ? 1 : 0);

            
        }
    }
}

