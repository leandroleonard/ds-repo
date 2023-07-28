package leandro.ds.queue;

public class Person
{
    private String name;
    private boolean priority;

    public Person(){}

    public Person(String name, boolean priority) {
        this.name = name;
        this.priority = priority;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public boolean isPriority() {
        return priority;
    }
    
    public void setPriority(boolean priority) {
        this.priority = priority;
    }
}
