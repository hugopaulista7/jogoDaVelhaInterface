import javax.swing.JButton;

class Button {
    private JButton button;
    
    Button() {   
        this.button = new JButton();
    }

    public JButton get() {
        return this.button;
    }

    public void resize(int width, int height) {
        this.button.setSize(width, height);
    }
    
    public void setChar(char c) {
        this.button.setText(String.valueOf(c));
    }

    public String getChar() {
        return this.button.getText();
    }

}