package entities;

public class Patent {

    public String name;
    public double influence;

    public Patent(int answer) {
        switch (answer) {
            case 1:
                this.name = "Genin";
                this.influence = 1;
            case 2:
                this.name = "Chunin";
                this.influence = 1.5;
            case 3:
                this.name = "Jounin";
                this.influence = 2.5;
            case 4:
                this.name = "Tokubetsu Jounin";
                this.influence = 4;
            case 5:
                this.name = "Kage";
                this.influence = 6;
            case 6:
                this.name = "Saikounin";
                this.influence = 5;
        }
    }
}
