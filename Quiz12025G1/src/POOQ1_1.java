import java.util.*;


abstract class Persona{
    protected String tipoDocumento;
    protected String documento;
    protected String nombre;
    public Persona(String tipoDocumento, String documento, String nombre) {
        super();
        this.tipoDocumento = tipoDocumento;
        this.documento = documento;
        this.nombre = nombre;
    }
	public String getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
    
    
    
    
}

class Paciente extends Persona{
    private int edad;
    private String eps;
	public Paciente(String tipoDocumento, String documento, String nombre, int edad, String eps) {
		super(tipoDocumento, documento, nombre);
		this.edad = edad;
		this.eps = eps;
	}
    
}

class PersonalSalud extends Persona{
    protected String noCarnet;
    protected String departamento;
	public PersonalSalud(String tipoDocumento, String documento, String nombre, String noCarnet, String departamento) {
		super(tipoDocumento, documento, nombre);
		this.noCarnet = noCarnet;
		this.departamento = departamento;
	}
	public String getNoCarnet() {
		return noCarnet;
	}
	public void setNoCarnet(String noCarnet) {
		this.noCarnet = noCarnet;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}

class Medico extends PersonalSalud{
    private String especialidad;
    private boolean cirujano;
	public Medico(String tipoDocumento, String documento, String nombre, String noCarnet, String departamento,
			String especialidad, boolean cirujano) {
		super(tipoDocumento, documento, nombre, noCarnet, departamento);
		this.especialidad = especialidad;
		this.cirujano = cirujano;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public boolean isCirujano() {
		return cirujano;
	}
	public void setCirujano(boolean cirujano) {
		this.cirujano = cirujano;
	}
	
	

}

class Enfermero extends PersonalSalud{
    private String sala;

	public Enfermero(String tipoDocumento, String documento, String nombre, String noCarnet, String departamento,
			String sala) {
		super(tipoDocumento, documento, nombre, noCarnet, departamento);
		this.sala = sala;
	}
    
    

}

class Operacion{
    private String codigo;
    private Paciente paciente;
    private Medico cirujano;
    private Medico anesteciologo;
    private Enfermero[] enfermeros;
    private PersonalSalud[] personalApoyo;
    private boolean resultado;
    private int salon;
    public Operacion(String codigo, Paciente paciente, Medico cirujano, Medico anesteciologo, Enfermero[] enfermeros,
            PersonalSalud[] personalApoyo, boolean resultado, int salon) {
        super();
        this.codigo = codigo;
        this.paciente = paciente;
        this.cirujano = cirujano;
        this.anesteciologo = anesteciologo;
        this.enfermeros = enfermeros;
        this.personalApoyo = personalApoyo;
        this.resultado = resultado;
        this.salon = salon;
    }
    public String getCodigo() {
        return codigo;
    }
    public Paciente getPaciente() {
        return paciente;
    }
    public Medico getCirujano() {
        return cirujano;
    }
    public Medico getAnesteciologo() {
        return anesteciologo;
    }
    public Enfermero[] getEnfermeros() {
        return enfermeros;
    }
    public PersonalSalud[] getPersonalApoyo() {
        return personalApoyo;
    }
    public boolean isResultado() {
        return resultado;
    }
    public int getSalon() {
        return salon;
    }
    
    //Verdadero si el enfermero participo
    public boolean participoEnfermero(String tipodoc, String doc) {
    	int i = 0;
    	while (i < enfermeros.length && 
    		      !(enfermeros[i].getTipoDocumento().equals(tipodoc) && enfermeros[i].getDocumento().equals(doc))) {
    		    i++;
    		}
    	if(i == (enfermeros.length)) return false; 
        return true;
    }
}

class EEnfermero extends Exception {
	public EEnfermero(String s) {
		super(s);
	}
}

class Hospital{
    private Operacion[] operacionesProgramadas;
    private PersonalSalud[] personal;
    private Paciente[] pacientes;
    public Hospital(Operacion[] operacionesProgramadas, PersonalSalud[] personal, Paciente[] pacientes) {
        super();
        this.operacionesProgramadas = operacionesProgramadas;
        this.personal = personal;
        this.pacientes = pacientes;
    }
    
    
    
    // Lista de Enfermeros, lanzar excepcion si no hay enfermeros en la lista de personal
    public Enfermero[] listaEnfermeros() throws EEnfermero{
    	Enfermero[] enfermeros = new Enfermero[0];
        for(PersonalSalud ps : personal) {
        	if(ps instanceof Enfermero) {
        		enfermeros = Arrays.copyOf(enfermeros, enfermeros.length+1);
        		enfermeros[enfermeros.length - 1] = (Enfermero)ps;
        	}
        }
        if(enfermeros.length == 0) throw new EEnfermero("No hay enfermeros en la lista del personal");
        return enfermeros;
    }
    
    // Cirugias en que participo un enfermero determinado, dado tipo de documento y numero de documento
    
    public Operacion[] operacionesEnfermero(String tipodoc, String doc) {
    	Operacion[] operacionesEnfermero = new Operacion[0];
    	for(Operacion o : operacionesProgramadas) {
    		if(o.participoEnfermero(tipodoc, doc)) {
    			operacionesEnfermero = Arrays.copyOf(operacionesEnfermero, operacionesEnfermero.length + 1);
    			operacionesEnfermero[operacionesEnfermero.length - 1] = o;
    		}
    	}
        return operacionesEnfermero;
    }
    
   
    
    // Operaciones negativas en las que ha participado cada personal, en el orden en que estan en personal
    //tenga en cuenta el medico, el anestesiologo, enfermeros y personal que participo
    
    public int[] cantidadNegativas() {
    	int[] resultados = new int[personal.length];
    	for(Operacion o: operacionesProgramadas) {
    		if(!(o.isResultado())) {
    			for (int i = 0; i < personal.length; i++) {
    				PersonalSalud ps = personal[i];
    				boolean sumar = false;
    				if(!sumar && (ps == o.getAnesteciologo() || ps == o.getCirujano())) {
    					sumar = true;
    				}
    				if (!sumar && ps instanceof Enfermero) {
    				    for (int k = 0; k < o.getEnfermeros().length; k++) {
    				         if (ps == o.getEnfermeros()[k]) {
    				        	 sumar = true;
    				          }
    				      }
    				} 
    				if(!sumar) {
    					int j = 0;
						while(j != o.getPersonalApoyo().length && ps != o.getPersonalApoyo()[j]) {
							j++;
						}
						if(j != o.getPersonalApoyo().length) sumar = true;
    				}
						
    				if(sumar) resultados[i]++;
    			}
    		}
    	}
        return resultados;
    }
}



public class POOQ1_1 {
    
    private Hospital hospital;
    
    
    public POOQ1_1(Hospital hospital) {
        super();
        this.hospital = hospital;
    }
    

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tipo=Integer.parseInt(in.nextLine());
        String[] parametros=null;
        if (tipo==2) parametros=in.nextLine().split(",");
        String[] cantidades=in.nextLine().split(",");
        Operacion[] operacionesProgramadas=new Operacion[Integer.parseInt(cantidades[2])];
        PersonalSalud[] personal= new PersonalSalud[Integer.parseInt(cantidades[1])];
        Paciente[] pacientes=new Paciente[Integer.parseInt(cantidades[0])];
        int cantPS = 0,cantO=0,cantP=0;
        String line;
        while (!(line=in.nextLine()).equals("")) {
            String[] datos=line.split(",");
            if (datos[0].equals("p"))
                pacientes[cantP++]=new Paciente(datos[1], datos[2], datos[3], Integer.parseInt(datos[4]), datos[5]);
            else if (datos[0].equals("o")) {
                //Operacion(String codigo, Paciente paciente, Medico cirujano, Medico anesteciologo, Enfermero[] enfermeros,
                //PersonalSalud[] personalApoyo, boolean resultado, int salon)
                String[] listEnf=null;
                if (!datos[4].equals(""))
                    listEnf=datos[4].split(" ");
                Enfermero[] enfermeros=null;
                if (listEnf!=null && listEnf.length!=0) {
                    enfermeros=new Enfermero[listEnf.length];
                    int i=0;
                    for (String e:listEnf) {
                        enfermeros[i++]=(Enfermero) personal[Integer.parseInt(e)];
                    }
                }
                String[] lisPers=null;
                if (!datos[5].equals(""))
                    lisPers=datos[5].split(" ");
                PersonalSalud[] apoyo=null;
                if (lisPers!=null && lisPers.length!=0) {
                    apoyo=new PersonalSalud[lisPers.length];
                    int i=0;
                    for (String e:lisPers) {
                        apoyo[i++]= personal[Integer.parseInt(e)];
                    }
                }
                operacionesProgramadas[cantO++]=new Operacion(datos[0]+datos[1], pacientes[Integer.parseInt(datos[1])], 
                        (Medico)personal[Integer.parseInt(datos[2])], (Medico)personal[Integer.parseInt(datos[3])], 
                        enfermeros, apoyo,Boolean.parseBoolean(datos[6]), Integer.parseInt(datos[7]));
            }else if (datos[0].equals("s")){
                personal[cantPS++]= new PersonalSalud(datos[1], datos[2], datos[3], datos[4], datos[5]);
            } else if (datos[0].equals("m")) {
                personal[cantPS++]= new Medico(datos[1], datos[2], datos[3], datos[4], datos[5],datos[6],Boolean.parseBoolean(datos[7]));
            } else if (datos[0].equals("e")) {
                personal[cantPS++]= new Enfermero(datos[1], datos[2], datos[3], datos[4], datos[5],datos[6]);
            }
                
        }
        
        POOQ1_1 quiz=new POOQ1_1(new Hospital(operacionesProgramadas, personal, pacientes));
        
        if (tipo==1) {
        	try {
        		Enfermero[] le=quiz.hospital.listaEnfermeros();
                for(Enfermero e:le)
                    System.out.println(e.getNombre());
        	} catch (EEnfermero e) {
        		System.out.println(e.getMessage());
        	}
            
        }
        if (tipo==2) {
            Operacion[] op=quiz.hospital.operacionesEnfermero(parametros[0],parametros[1]);
            for (Operacion o:op)
                System.out.println(o.getCodigo()+ " "+ o.getCirujano().getEspecialidad()+ " "+ o.getSalon());
        }else if(tipo==3) { // Cantidad negativa
            int[] cantidad=quiz.hospital.cantidadNegativas();
            for (int i=0;i<cantidad.length;i++) {
                System.out.println(personal[i].getNoCarnet()+": "+cantidad[i]);
            }
        }
        in.close();


    }

}