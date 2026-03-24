class Medalla{
    private String tipo;
    private Participante ganador;
    public Medalla(String tipo, Participante ganador) {
        super();
        this.tipo = tipo;
        this.ganador = ganador;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public Participante getGanador() {
        return ganador;
    }
    public void setGanador(Participante ganador) {
        this.ganador = ganador;
    }
    
}