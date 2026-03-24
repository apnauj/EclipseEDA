class TotalMedallas{
    private Participante p;
    private int oro;
    private int plata;
    private int bronce;
    public TotalMedallas(Participante p, int oro, int plata, int bronce) {
        super();
        this.p = p;
        this.oro = oro;
        this.plata = plata;
        this.bronce = bronce;
    }
    public Participante getP() {
        return p;
    }
    public void setP(Participante p) {
        this.p = p;
    }
    public int getOro() {
        return oro;
    }
    public void setOro(int oro) {
        this.oro = oro;
    }
    public int getPlata() {
        return plata;
    }
    public void setPlata(int plata) {
        this.plata = plata;
    }
    public int getBronce() {
        return bronce;
    }
    public void setBronce(int bronce) {
        this.bronce = bronce;
    }
    
    
}