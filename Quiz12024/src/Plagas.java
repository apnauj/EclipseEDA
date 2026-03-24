import java.util.*;

public class Plagas {
    private Producto[] productos;
    public Producto[] getProductos() {
        return productos;
    }
    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }
    
    //Completar
    //Devolver la lista de productos por plaga en el mismo orden que se encuentran en la lista
    public Producto[] productosPorPlaga(String subplaga) throws EProductosNoEncontrados{
    	Producto[] ans = new Producto[0];
    	for(Producto p : productos) {
    		if(p.isPlaga(subplaga)) {
    			ans = Arrays.copyOf(ans, ans.length+1);
    			ans[ans.length-1] = p;
    		}
    	}
    	if(ans.length == 0) throw new EProductosNoEncontrados("No tenemos productos para ese tipo de plaga");
        return null;        
    }
    public static void main(String[] args) {
        Plagas plaga=new Plagas();
        Producto[] prod=new Producto[0];
        Scanner in = new Scanner(System.in);
        double tipo=Integer.parseInt(in.nextLine());
        String subplaga=in.nextLine();
        String line=in.nextLine();
        String[] tipo_nombre=line.split(",");
        while ((line=in.nextLine()).compareTo("")!=0) {
            String[] especie_subespecies=line.split(",");
            Producto p = null;
            PlagaEspecie[] plagasF=new PlagaEspecie[0];
            PlagaEspecie pe;
            while((!line.equals("")) && especie_subespecies[0].compareTo("p")!=0) {
                String[] subesp=new String[especie_subespecies.length-1];
                System.arraycopy(especie_subespecies, 1,subesp, 0, especie_subespecies.length-1);
                pe=new PlagaEspecie(line, especie_subespecies);
                plagasF=Arrays.copyOf(plagasF, plagasF.length+1);
                plagasF[plagasF.length-1]=pe;
                if (tipo_nombre[1].equals("fumigar")) {
                    if (tipo==1) {
                        p=new ProductoFumigacion(tipo_nombre[2],tipo_nombre[3]);
                        for (PlagaEspecie plagae:plagasF) 
                            p.addPlagaEspecie(plagae.getEspecie(), plagae.getSubespecies());
                    }else
                        p=new ProductoFumigacion(tipo_nombre[2],plagasF,tipo_nombre[3]);
                }else {
                    if (tipo==1) {
                        p=new ProductoTrampa(tipo_nombre[2],tipo_nombre[3]);
                        for (PlagaEspecie plagae:plagasF) 
                            p.addPlagaEspecie(plagae.getEspecie(), plagae.getSubespecies());
                    }else
                        p=new ProductoTrampa(tipo_nombre[2],plagasF,tipo_nombre[3]);
                }
                line=in.nextLine();
                if (!line.equals("")) especie_subespecies=line.split(",");
            }
            prod=Arrays.copyOf(prod, prod.length+1);
            prod[prod.length-1]=p;
            tipo_nombre=especie_subespecies;
        }
        plaga.setProductos(prod);
        if (tipo==1) {
            for(Producto pr:plaga.productos)
                System.out.println(pr.getNombre());
        }
        if (tipo==2) {
            for(Producto pr:plaga.productos)
                if (pr.isPlaga(subplaga))
                    System.out.println(pr.getNombre());
        }else if(tipo==3) {
            Producto[] productosPlaga;
            try {
            	productosPlaga = plaga.productosPorPlaga(subplaga);
                for(Producto pr:productosPlaga)
                    System.out.println(pr.getNombre());
            } catch (EProductosNoEncontrados e) {
				System.out.println(e.getMessage());
			}
                
        }
        in.close();

    }

}