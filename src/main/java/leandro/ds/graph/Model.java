package leandro.ds.graph;

public class Model {
    private String local;
    private String closeness;

    public Model(String local, String closeness)
    {
        this.local = local;
        this.closeness = closeness;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getCloseness() {
        return closeness;
    }

    public void setCloseness(String closeness) {
        this.closeness = closeness;
    }

    
}
