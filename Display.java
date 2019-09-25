import javax.swing.JLabel;
class Display {
    private JLabel display;
    
    Display() {
        this.display = new JLabel();
    }

    public void setLabel(String text) {
        this.display.setText(text);
    }

    public JLabel get() {
        return this.display;
    }

    public String getLabel() {
        return this.display.getText();
    }
}