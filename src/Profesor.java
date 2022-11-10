public class Profesor implements Human{
    private String nume;
    private String prenume;
    private String acronimFacultate;
    private int varsta;
    private String materie;

    @Override
    public int getVarsta() {
        return varsta;
    }

    public Profesor(String nume, String prenume, String acronimFacultate, int varsta, String materie) {
        this.nume = nume;
        this.prenume = prenume;
        this.acronimFacultate = acronimFacultate;
        this.varsta = varsta;
        this.materie = materie;
    }

    @Override
    public void greet() {

    }

    @Override
    public void doWork() {

    }

    @Override
    public String toString() {
        return "Profesor{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", acronimFacultate='" + acronimFacultate + '\'' +
                ", varsta=" + varsta +
                ", materie='" + materie + '\'' +
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
