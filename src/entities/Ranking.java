package entities;

public class Ranking {

    public char name;
    public double xpPerLine;

    public Ranking(char name) {
        switch (name) {
            case 'D':
                this.name = 'D';
                this.xpPerLine = 0.5;
                break;
            case 'C':
                this.name = 'C';
                this.xpPerLine = 1.5;
                break;
            case 'B':
                this.name = 'B';
                this.xpPerLine = 4.5;
                break;
            case 'A':
                this.name = 'A';
                this.xpPerLine = 10;
                break;
            case 'S':
                this.name = 'S';
                this.xpPerLine = 20;
                break;
        }
    }
}
