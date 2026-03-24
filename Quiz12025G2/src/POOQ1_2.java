import java.lang.reflect.Executable;
import java.util.*;

abstract class Producto{
    protected String codigo;
    protected String nombre;
    protected double precio;
    protected String marca;
    public Producto(String codigo, String nombre, double precio, String marca) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.marca = marca;
    }
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
    
    

}

class Bolso extends Producto{
    protected String tipo;
    protected double peso;
    protected String color;
	public Bolso(String codigo, String nombre, double precio, String marca, String tipo, double peso, String color) {
		super(codigo, nombre, precio, marca);
		this.tipo = tipo;
		this.peso = peso;
		this.color = color;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
    
    
    
}

class Equipaje extends Bolso{
    private double ancho, alto, largo;
    private boolean cabina;
	public Equipaje(String codigo, String nombre, double precio, String marca, String tipo, double peso, String color,
			double ancho, double alto, double largo, boolean cabina) {
		super(codigo, nombre, precio, marca, tipo, peso, color);
		this.ancho = ancho;
		this.alto = alto;
		this.largo = largo;
		this.cabina = cabina;
	}
	public double getAncho() {
		return ancho;
	}
	public void setAncho(double ancho) {
		this.ancho = ancho;
	}
	public double getAlto() {
		return alto;
	}
	public void setAlto(double alto) {
		this.alto = alto;
	}
	public double getLargo() {
		return largo;
	}
	public void setLargo(double largo) {
		this.largo = largo;
	}
	public boolean isCabina() {
		return cabina;
	}
	public void setCabina(boolean cabina) {
		this.cabina = cabina;
	}
    
    
}

class Cartera extends Bolso{
    private char sexo;

	public Cartera(String codigo, String nombre, double precio, String marca, String tipo, double peso, String color,
			char sexo) {
		super(codigo, nombre, precio, marca, tipo, peso, color);
		this.sexo = sexo;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
    
    
    
}

class Juguete extends Producto{
    private int edad;
    private String tipo;
	public Juguete(String codigo, String nombre, double precio, String marca, int edad, String tipo) {
		super(codigo, nombre, precio, marca);
		this.edad = edad;
		this.tipo = tipo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
    
    
    
}

class Calzado extends Producto{
    private double talla;
    private String color;
    private String estilo;
	public Calzado(String codigo, String nombre, double precio, String marca, double talla, String color,
			String estilo) {
		super(codigo, nombre, precio, marca);
		this.talla = talla;
		this.color = color;
		this.estilo = estilo;
	}
	public double getTalla() {
		return talla;
	}
	public void setTalla(double talla) {
		this.talla = talla;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getEstilo() {
		return estilo;
	}
	public void setEstilo(String estilo) {
		this.estilo = estilo;
	}
    
    
    
}

class Empaque{
    Producto producto;
    int cantidad;
    public Empaque(Producto producto, int cantidad) {
        super();
        this.producto = producto;
        this.cantidad = cantidad;
    }
    public Producto getProducto() {
        return producto;
    }
    public int getCantidad() {
        return cantidad;
    }
    
}

class Paquete{
    private String codigo;
    private Producto principal;
    private Empaque[] productosAdicionales;
    private Empaque[] regalos;
    private double precioTotal;
    public Paquete(String codigo, Producto principal, Empaque[] productosAdicionales, Empaque[] regalos,
            double precioTotal) {
        super();
        this.codigo = codigo;
        this.principal = principal;
        this.productosAdicionales = productosAdicionales;
        this.regalos = regalos;
        this.precioTotal = precioTotal;
    }
    
    public int cantidadProductoPaquete(String codigo) {
    	int ans = 0;
    	if(principal.getCodigo().equals(codigo)) {
     	   ans++;
        }
    	if(productosAdicionales != null) {
    		for(Empaque e : productosAdicionales) {
        		if(e.getProducto().getCodigo().equals(codigo)) {
        			ans+=e.getCantidad();
        		}
        	}
    	}
    	
    	if(regalos != null ) {
    		for(Empaque e : regalos) {
        		if(e.getProducto().getCodigo().equals(codigo)) {
        			ans+=e.getCantidad();
        		}
        	}
    	}
    	
    	return ans;
    }
    
    
    
    public boolean buscarProducto(String codigo) {
       if(principal.getCodigo().equals(codigo)) {
    	   return true;
       }
       if(productosAdicionales != null) {
    	   int i = 0;
    	   while(i < productosAdicionales.length) {
        	   if(productosAdicionales[i].getProducto().getCodigo().equals(codigo)) {
        		   return true;
        	   }
        	   i++;
           }
       }
       
       if(regalos != null) {
    	   int j = 0;
           while(j < regalos.length) {
        	   if(regalos[j].getProducto().getCodigo().equals(codigo)) {
        		   return true;
        	   }
        	   j++;
           }
       }

        return false;
    }
    
    //Cantidad de un producto en paquetes, tenga en cuenta que puede aparecer en diferentes lugares
    



	@Override
	public String toString() {
		return codigo + "-" + principal.getNombre();
	}

    
    
}

class EJuguete extends Exception{
	public EJuguete(String s) {
		super(s);
	}
}


class TiendaOnline{
    Producto[] productos;
    Paquete[] paquetes;
    public TiendaOnline(Producto[] productos, Paquete[] paquetes) {
        super();
        this.productos = productos;
        this.paquetes = paquetes;
    }
    
    public Producto[] getProductos() {
        return productos;
    }

    public Paquete[] getPaquetes() {
        return paquetes;
    }



    //Lista de juguetes, lanzar una excepcion si no hay juguetes que diga: No hay juguetes en la tienda
    public Juguete[] listaJuguetes() throws EJuguete{
    	Juguete[] juguetes = new Juguete[0];
        for(Producto j : productos) {
        	if(j instanceof Juguete) {
        		juguetes = Arrays.copyOf(juguetes, juguetes.length + 1);
        		juguetes[juguetes.length - 1] = (Juguete)j;
        	}
        }
        if(juguetes.length == 0) throw new EJuguete("No hay juguetes en la tienda");
        return juguetes;
    }
    
    // Paquetes en los que hay un producto determinado, ya sea que aparezca como producto principal o dentro de los adicionales o de regalo
    
        public Paquete[] paquetePorProducto(String codigo) {
        	Paquete[] ans = new Paquete[0];
            for (Paquete p : paquetes) {
            	if(p.buscarProducto(codigo)) {
            		ans = Arrays.copyOf(ans, ans.length+1);
            		ans[ans.length - 1] = p;
            	}
            }
            return ans;
        }
        
        public int[] cantidadPorProductoPaquete() {
        	int[] ans = new int[productos.length];
            for(int i = 0; i < productos.length; i++) {
            	String codProducto = productos[i].getCodigo();
            	for (Paquete p : paquetes) {
            		if(p.buscarProducto(codProducto)) {
            			ans[i]+=p.cantidadProductoPaquete(codProducto);
            		}
            	}
            }
            return ans;
        }
        
    
}


public class POOQ1_2 {
    
    private TiendaOnline tienda;
    
    
    public POOQ1_2(TiendaOnline tienda) {
        this.tienda = tienda;
    }


    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int tipo=Integer.parseInt(in.nextLine());
        String parametros="";
        if (tipo==2) parametros=in.nextLine();
        String[] cantidades=in.nextLine().split(",");
        Producto[] productos=new Producto[Integer.parseInt(cantidades[0])];
        Paquete[] paquetes=new Paquete[Integer.parseInt(cantidades[1])];
        int cantPD = 0,cantPQ=0;
        String line;
        while (!(line=in.nextLine()).equals("")) {
            String[] datos=line.split(",");
            if (datos[0].equals("p")) {
                String[] listAdicionales=null;
                if (!datos[3].equals(""))
                    listAdicionales=datos[3].split(" ");
                Empaque[] empaqueAdicional=null;
                if (listAdicionales!=null && listAdicionales.length!=0) {
                    empaqueAdicional=new Empaque[listAdicionales.length/2];
                    
                    for (int i=0, j=0;i<listAdicionales.length;i+=2, j++) {
                        empaqueAdicional[j]=new Empaque(productos[Integer.parseInt(listAdicionales[i])],Integer.parseInt(listAdicionales[i+1]));
                    }
                }
                String[] listRegalos=null;
                if (!datos[4].equals(""))
                    listRegalos=datos[4].split(" ");
                Empaque[] empaqueRegalo=null;
                if (listRegalos!=null && listRegalos.length!=0) {
                    empaqueRegalo=new Empaque[listRegalos.length/2];
                    for (int i=0, j=0;i<listRegalos.length;i+=2, j++) {
                        empaqueRegalo[j]=new Empaque(productos[Integer.parseInt(listRegalos[i])],Integer.parseInt(listRegalos[i+1]));
                    }
                }
                paquetes[cantPQ++]=new Paquete(datos[1], productos[Integer.parseInt(datos[2])], empaqueAdicional, empaqueRegalo, Double.parseDouble(datos[5]));
            }else if (datos[0].equals("j")){
                //Juguetes(String codigo, String nombre, double precio, String marca, int edad, int tipo)
                //j,14213,Juego de dados,76900,,6,didactico
                productos[cantPD++]= new Juguete(datos[1], datos[2], Double.parseDouble(datos[3]), datos[4], Integer.parseInt(datos[5]), datos[6]);
            } else if (datos[0].equals("b")) {
                productos[cantPD++]= new Bolso(datos[1], datos[2], Double.parseDouble(datos[3]), datos[4], datos[5], Double.parseDouble(datos[6]), datos[7]);
            } else if (datos[0].equals("e")) {
                productos[cantPD++]= new Equipaje(datos[1], datos[2], Double.parseDouble(datos[3]), datos[4], datos[5], 
                        Double.parseDouble(datos[6]), datos[7],
                        Double.parseDouble(datos[8]),Double.parseDouble(datos[9]), Double.parseDouble(datos[10]), Boolean.parseBoolean(datos[11]));
            } else if (datos[0].equals("c")) {
                productos[cantPD++]= new Cartera(datos[1], datos[2], Double.parseDouble(datos[3]), datos[4], datos[5], 
                        Double.parseDouble(datos[6]), datos[7], datos[8].charAt(0));
            }
                
        }
        
        POOQ1_2 quiz=new POOQ1_2(new TiendaOnline(productos,paquetes));
        
        if (tipo==1) {
        	try {
        		Juguete[] lj=quiz.tienda.listaJuguetes();
                for(Juguete j:lj)
                    System.out.println(j.getNombre());
        	} catch (EJuguete e) {
        		System.out.println(e.getMessage());
        	}
            
            
        }
        if (tipo==2) {
            Paquete[] paq=quiz.tienda.paquetePorProducto(parametros);
            for (Paquete p:paq)
                System.out.println(p);
        }else if(tipo==3) { 
            int[] cant=quiz.tienda.cantidadPorProductoPaquete();
            for (int i=0;i<cant.length;i++)
                System.out.println(quiz.tienda.productos[i].getCodigo()+" "+cant[i]);
        }
        in.close();

    }
}