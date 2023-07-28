package leandro.ds.binarytrees;

public class Model {
    int number;
    int level;
    int column;
    
    public Model(int number, int level, int column) {
        this.number = number;
        this.level = level;
        this.column = column;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
