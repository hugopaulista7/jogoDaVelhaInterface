import javax.swing.JLabel;
class Display {
    private JLabel display;
    
    Display() {
        this.display = new JLabel("Turno: ");
    }

    public JLabel get() {
        return this.display;
    }
}