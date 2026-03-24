class Evento{
    private String Diciplina;
    private String nombreEvento;
    private Participante[] participantes;
    private Medalla[] medallas;
    public Evento(String diciplina, String nombreEvento, Participante[] participantes, Medalla[] medallas) {
        super();
        Diciplina = diciplina;
        this.nombreEvento = nombreEvento;
        this.participantes = participantes;
        this.medallas = medallas;
    }
    public Medalla[] getMedallas() {
        return medallas;
    }
    public void setMedallas(Medalla[] medallas) {
        this.medallas = medallas;
    }
    public String getDiciplina() {
        return Diciplina;
    }
    public void setDiciplina(String diciplina) {
        Diciplina = diciplina;
    }
    public String getNombreEvento() {
        return nombreEvento;
    }
    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }
    public Participante[] getParticipantes() {
        return participantes;
    }
    public void setParticipantes(Participante[] participantes) {
        this.participantes = participantes;
    }
    
 
}