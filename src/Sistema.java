import java.util.ArrayList;

public class Sistema {
    public ArrayList<Equipo> equipos;
    public ArrayList<Servicio> mantenimientos;
    public ArrayList<Usuarios> usuarios;

    public Sistema(ArrayList<Equipo> equipos, ArrayList<Usuarios> usuarios, ArrayList<Servicio> mantenimientos) {
        this.equipos = equipos;
        this.mantenimientos = mantenimientos;
        this.usuarios = usuarios;
        atts();
    }

    public boolean addEquipo(Object[] row){
        Equipo nuevo_equipo = new Equipo(row);
        try{
            this.equipos.add(nuevo_equipo);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean equipoExiste(String nombre){
        for(Equipo equipo: this.equipos){
            if(equipo.num_control.toLowerCase().compareTo(nombre.toLowerCase()) == 0 ||
                    equipo.num_control.toUpperCase().compareTo(nombre) == 0){
                return true;
            }
        }
        return false;
    }


    public void modifyEquipo(int index, Object[] new_data){
        this.equipos.remove(index);
        this.equipos.add(index, new Equipo(new_data));
    }

    public Object[][] getEquipoByFilter(String filter, String lookup){
        Object[][] mappedAtts = {
                {1, "Equipo"}, {2, "Marca"}, {3, "Modelo"}, {4, "Area"}
        };
        int index_att = -1;
        for(Object[] att: mappedAtts){
            if(att[1] == filter){
                index_att = (int)att[0];
            }
        }
        //ArrayList<Object[]> results = new ArrayList<>();
        Object[][] results = new Object[999][];
        int cont = 0;
        if(index_att != -1){
            for(Equipo equipo: equipos){
                Object[] e = equipo.getAsRow();
                if(e[index_att].toString().toLowerCase().contains(lookup.toLowerCase()) ||
                        e[index_att].toString().toUpperCase().contains(lookup.toUpperCase())){
                    results[cont] = e;
                    cont++;
                }
            }
        }
        return results.length>0? results: null;
    }

    public Object[][] getEquiposMantoByMonth(int num_month){
        Object[][] results = new Object[this.equipos.size()][];
        int cont = 0;
        for(Equipo equipo: this.equipos){
            Object[] e = equipo.getAsRow();
            if(Integer.parseInt(equipo.prox_mantto.split("/")[1]) == num_month){
                Object[] result = {equipo.num_control, equipo.equipo};
                results[cont] = concatArrays(result, markedDay(Integer.parseInt(equipo.prox_mantto.split("/")[1])));
                cont++;
            }
        }
        return results;
    }

    public Object[] markedDay(int num_day){
        Object[] result = new  Object[num_day];
        for(int i=0;i<num_day;i++){
            if(i+1 == num_day){
                result[i] = "X";
            }else{
                result[i] = "";
            }
        }
        return result;
    }

    public boolean addUsuario(Object[] row){
        Usuarios nuevo_usuario = new Usuarios(row);
        try{
            this.usuarios.add(nuevo_usuario);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public boolean usuarioExiste(String nombre){
        for(Usuarios user: this.usuarios){
            if(user.nombre.toLowerCase().compareTo(nombre.toLowerCase()) == 0 ||
            user.nombre.toUpperCase().compareTo(nombre) == 0){
                return true;
            }
        }
        return false;
    }

    public Object[] getUsuarioByName(String nombre){
        for(Usuarios user: this.usuarios){
            if(user.nombre.toLowerCase().compareTo(nombre.toLowerCase()) == 0 ||
                    user.nombre.toUpperCase().compareTo(nombre) == 0){
                return user.getAsRow();
            }
        }
        return null;
    }

    public void modifyUsuario(int index, Object[] new_data){
        this.usuarios.remove(index);
        this.usuarios.add(index, new Usuarios(new_data));
    }

    public boolean addServicio(Object[] row){
        Servicio nuevo_servicio = new Servicio(row);
        try{
            this.mantenimientos.add(nuevo_servicio);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    public void atts(){
        System.out.println("//////////////////////////////////////");
        System.out.println("EQUIPOS/");
        System.out.println(this.equipos.toString());
        System.out.println("//////////////////////////////////////");
        System.out.println("USUARIOS");
        System.out.println(this.usuarios.toString());
        System.out.println("//////////////////////////////////////");
        System.out.println("MANTTOS");
        System.out.println(this.mantenimientos.toString());
        System.out.println("//////////////////////////////////////");

    }

    public Object[] concatArrays(Object[] array1, Object[] array2){
        Object[] result = new Object[array1.length + array2.length];
        System.out.println(result.length);
        int limit = array1.length<=array2.length? array1.length : array2.length;
        int i;
        int f;
        for(i=0;i<array1.length;i++){
            result[i] = array1[i];
        }
        for(f = 1;f<=array2.length;f++, i++){
            result[i] =  array2[f-1];
        }
        return result;
    }
}
