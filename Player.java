class Player {
    private String name;
    private String selectedChar;
    private int points;
    Player() {
        this.name = "";
        this.selectedChar = "";
        this.points = 0;
    }

    public int getPoints() {
        return this.points;
    }

    public String getName() {
        return this.name;
    }

    public String getSelectedChar() {
        return this.selectedChar;
    }

    public void setSelectedChar(String text) {
        this.selectedChar = text;
    }

    public void setName(String text) {
        this.name = text;
    }

    public void addPoint(int point) {
        this.points += point;
    }

    public boolean validateChar(String text) {
        if (text.toLowerCase().charAt(0) == 'x' || text.toLowerCase().charAt(0) == 'o') {
            return true;
        }
        return false;
    }


}