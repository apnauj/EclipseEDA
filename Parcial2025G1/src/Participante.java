class Participante extends Atleta{
    private String paisParticipa;
    private int anno;

    public Participante(String nombre, String paisOrigen, String paisParticipa) {
        super(nombre, paisOrigen);
        this.paisParticipa = paisParticipa;
    }

    public String getPaisParticipa() {
        return paisParticipa;
    }

    public void setPaisParticipa(String paisParticipa) {
        this.paisParticipa = paisParticipa;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }
    
}