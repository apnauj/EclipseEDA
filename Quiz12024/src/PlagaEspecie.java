class PlagaEspecie{
    private String especie;
    private String[] subespecies;
    
    public String getEspecie() {
        return especie;
    }

    public String[] getSubespecies() {
        return subespecies;
    }

    public PlagaEspecie(String especie, String[] subespecies) {
        super();
        this.especie = especie;
        this.subespecies = subespecies;
    }

}