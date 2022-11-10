public class Student implements Human {
    private String nume;
    private String prenume;
    private String acronimFacultate;
    private int varsta;
     private int anStudiu;

    @Override
    public int getVarsta() {
        return varsta;
    }

    public Student(String nume, String prenume, String acronimFacultate, int varsta, int anStudiu) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronimFacultate = acronimFacultate;
        this.varsta = varsta;
        this.anStudiu = anStudiu;
    }

    @Override
    public void greet() {

    }

    @Override
    public void doWork() {

    }

    @Override
    public String toString() {
        return "Student{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", acronimFacultate='" + acronimFacultate + '\'' +
                ", varsta=" + varsta +
                ", anStudiu=" + anStudiu +
                '}';
    }

    @Override
    public int compareTo(Human o) {
        if(this.varsta>o.getVarsta())
            return 1;
        else if(this.varsta<o.getVarsta())
            return -1;
        else return 0;
    }
}
