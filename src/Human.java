public interface Human extends Comparable<Human>{
    public void greet();
    public void doWork();
    public String toString();

    @Override
    public int compareTo(Human o);
    public int getVarsta();

}
