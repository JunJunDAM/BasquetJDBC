/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basquetjdbc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author DAM
 */
public class BasquetJDBC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int opcion = 0;
        boolean salir = false;
        do{
            menu();
            opcion = pedirEntero();
            switch(opcion){
                case 1:
                    //Ejercicio 1
                    crearJugador();
                    break;
                    
                case 2:
                    //Ejercicio 2
                    crearEquipo();
                    break;
                    
                case 3:
                    //Ejercicios del 3 - 12
                    consultaJugador();
                    break;
                    
                case 4:
                    //Ejercicios del 15 - 18
                    consultaEquipo();
                    break;
                    
                case 5:
                    //ranking
                    //Ejercicio 13
                    break;
                    
                case 6:
                    System.out.println("****************************************************************************");
                    salir = true;
                    break;
                    
                default: System.err.println("Opcion Incorrecta");
            }
        }while(salir == true);
        
    }
    
    public static void crearEquipo(){
        String nombre;
        do{
            nombre = pedirCadena("********** Introduce el nombre del equipo: ");
            if(nombre.equalsIgnoreCase("")){
                System.err.println("No puedes dejar este espacio en blanco");
            }
        }while(nombre.equalsIgnoreCase(""));
        
        String ciudad;
        do{
            ciudad = pedirCadena("********** Introduce donde esta ubicado " + nombre + ": ");
            if(nombre.equalsIgnoreCase("")){
                System.err.println("No puedes dejar este espacio en blanco");
            }
        }while(nombre.equalsIgnoreCase(""));
        
        int dia = 0;
        int mes = 0;
        int anyo = 0;
        Date fechaCreacion;
        do{
            System.out.print("********** Introduce el dia en que nacio " + nombre + ": ");
            dia = pedirEntero();
            
            if(dia > 0 && dia < 32){
                System.err.println("********** Ves a infantil, que te aprovaron por pena");
            }
        }while(dia > 0 && dia < 32);
        
        do{
            System.out.print("********** Introduce el mes: ");
            mes = pedirEntero();
            
            if(mes > 0 && mes < 13){
                System.err.println("********** Ves a infantil, que te aprovaron por pena");
            }
        }while(mes > 0 && mes < 13);
        
        do{
            System.out.print("********** Introduce el anyo: ");
            anyo = pedirEntero();
            
            if(anyo > 2017){
                System.err.println("ESTAMOS EN 2017 !!");
            }
            if(anyo < 1891){
                System.err.println("El basquet se invento en el anyo 1891");
            }
        }while(anyo > 2000 && anyo < 1970);
        fechaCreacion = new Date(anyo, mes, dia);
        
        Equipo e = new Equipo(nombre, ciudad, fechaCreacion);
        
        BasquetBBDD gestor = new BasquetBBDD();
        try{
            gestor.insertarEquipoBD(e);
            System.out.println("********** " + nombre + ": " + "(" + anyo + ")" + ciudad);
        }catch(SQLException ex){
            System.err.println("Error: " + ex.getMessage());
        }
    }
    
    public static void crearJugador(){
        String nombre;
        do{
            nombre = pedirCadena("********** Introduce el nombre del jugador: ");
            if(nombre.equalsIgnoreCase("")){
                System.err.println("No puedes dejar este espacio en blanco");
            }
        }while(nombre.equalsIgnoreCase(""));
        
        int dia = 0;
        int mes = 0;
        int anyo = 0;
        Date fechaNacimiento;
        do{
            System.out.print("********** Introduce el dia en que nacio " + nombre + ": ");
            dia = pedirEntero();
            
            if(dia > 0 && dia < 32){
                System.err.println("********** Ves a infantil, que te aprovaron por pena");
            }
        }while(dia > 0 && dia < 32);
        
        do{
            System.out.print("********** Introduce el mes: ");
            mes = pedirEntero();
            
            if(mes > 0 && mes < 13){
                System.err.println("********** Ves a infantil, que te aprovaron por pena");
            }
        }while(mes > 0 && mes < 13);
        
        do{
            System.out.print("********** Introduce el anyo: ");
            anyo = pedirEntero();
            
            if(anyo > 2000){
                System.err.println("Edad minima : 18");
            }
            if(anyo < 1970){
                System.err.println("Demasiado mayor");
            }
        }while(anyo > 2000 && anyo < 1970);
        fechaNacimiento = new Date(anyo, mes, dia);
        
        int canastas = pedirEntero();
        int asistencias = pedirEntero();
        int rebotes = pedirEntero();
        
        String posicion;
        int error1 = 0;
        ArrayList posiciones = new ArrayList<>();
        posiciones.add("Alero");
        posiciones.add("Base");
        posiciones.add("Pivot");
        posiciones.add("Escolta");
        posiciones.add("Ala-pivot");
        
        do{
            posicion = pedirCadena("********** En que posicion jugara " + nombre + "? : ");
            for (int i = 0; i < posiciones.size(); i++) {
                if(posicion.equalsIgnoreCase((String) posiciones.get(i))){
                    error1 = 0;
                }else{
                    error1 += 1;
                }
            }
        }while(error1 == 1);
        
        String equipo;
        int error2 = 0;
        do{
            equipo = pedirCadena("********** Introduce en que equipo jugara" + nombre);
        }while(error2 == 1);
        
        Jugador j = new Jugador(nombre, fechaNacimiento, canastas, asistencias, rebotes, posicion, equipo);
        
        BasquetBBDD gestor = new BasquetBBDD();
        try{
            gestor.instertarJugadorBD(j);
            System.out.println("********** " + nombre + ": " + (2017 - anyo) + " anyos, " + posicion + ", " + equipo);
        }catch(SQLException ex){
            System.err.println("Error: " + ex.getMessage());
        }
        
        
    }
    
    public static void consultaEquipo(){
        int opcion = 0;
        boolean salir = false;
        do{
            menuEquipo();
            opcion = pedirEntero();
            switch(opcion){
                case 1:
                    
                    break;
                    
                case 2:
                    
                    break;
                    
                case 3:
                    
                    break;
                    
                case 4:
                    
                    break;
                    
                case 5:
                    System.out.println("********** Volviendo al Menu principal                **********");
                    salir = true;
                    break;
                    
                default: System.err.println("Opcion Incorrecta");
            }
        }while(salir == true);
        salir = false;
    }
    
    public static void consultaJugador(){
        int opcion = 0;
        boolean salir = false;
        do{
            menuJugador();
            opcion = pedirEntero();
            switch(opcion){
                case 1:
                    break;
                    
                case 2:
                    break;
                    
                case 3:
                    break;
                    
                case 4:
                    break;
                    
                case 5:
                    break;
                    
                case 6:
                    break;
                    
                case 7:
                    break;
                    
                case 8:
                    break;
                    
                case 9:
                    break;
                    
                case 10:
                    break;    
                    
                case 11:
                    System.out.println("********** Volviendo al Menu principal                **********");
                    salir = true;
                    break;
                    
                default: System.err.println("Opcion Incorrecta");
            }
        }while(salir == true);
        salir = false;
    }
    
    public static void menuJugador(){
        System.out.println("****************************************************************************");
        System.out.println("**********          Consultas de jugador                          **********");
        System.out.println("****************************************************************************");
        System.out.println("********** [1] - Modificar estadisticas de jugador                **********");
        System.out.println("********** [2] - Traspasar Jugador                                **********");
        System.out.println("********** [3] - Retirar Jugador                                  **********");
        System.out.println("********** [4] - Informacion de jugador                           **********");
        System.out.println("********** [5] - Informacion de jugador sin nombre                **********");
        System.out.println("********** [6] - Jugadores con un rango de canastas               **********");
        System.out.println("********** [7] - Jugadores con un rango de asistencias            **********");
        System.out.println("********** [8] - Jugadores con la misma posicion                  **********");
        System.out.println("********** [9] - Jugadores por fecha de nacimiento                **********");
        System.out.println("********** [10] - Media de estadisticas por posicion              **********");
        System.out.println("********** [11] - Salir                                           **********");
        System.out.println("****************************************************************************");
        System.out.println("********** Escoge una opcion: ");
    }
    
    public static void menuEquipo(){
        System.out.println("****************************************************************************");
        System.out.println("**********          Consultas de equipo                           **********");
        System.out.println("****************************************************************************");
        System.out.println("********** [1] - Localidad                                        **********");
        System.out.println("********** [2] - Plantilla                                        **********");
        System.out.println("********** [3] - Jugadores por posicion                           **********");
        System.out.println("********** [4] - Jugador con mas canastas                         **********");
        System.out.println("********** [5] - Salir                                            **********");
        System.out.println("****************************************************************************");
        System.out.println("********** Escoge una opcion: ");
    }
    
    public static void menu(){
        System.out.println("****************************************************************************");
        System.out.println("**********          STUCOM LIGA DE BASQUET INFORMACION            **********");
        System.out.println("****************************************************************************");
        System.out.println("********** [1] - Crear nuevo equipo                               **********");
        System.out.println("********** [2] - Crear nuevo jugador                              **********");
        System.out.println("********** [3] - Consultas de jugador                             **********");
        System.out.println("********** [4] - Consultas de equipo                              **********");
        System.out.println("********** [5] - Ranking Jugadores                                **********");
        System.out.println("********** [6] - Salir                                            **********");
        System.out.println("****************************************************************************");
        System.out.println("********** Escoge una opcion: ");
    }
    
    private static String pedirCadena(String mensaje){
	 BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
	 String respuesta="";
	 boolean error;
	 do{
		 try{
		 System.out.print(mensaje);
		 respuesta=br.readLine();
		 error=false;
		 }catch(IOException ex){
			 System.out.println("Error de entrada/salida");
			 error=true;
		 }
	 }while(error);
	 return respuesta;
    }
    
    private static double pedirDouble(String mensaje){
	 BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
	 double respuesta=0;
	 boolean error;
	 do{
		 try{
			 System.out.print(mensaje);
			 respuesta=Double.parseDouble(br.readLine());
			 error=false;
		 }catch(IOException ex){
			 System.out.println("Error de entrada/salida");
			 error=true;
		 }catch(NumberFormatException ex){
			 System.out.println("No has introducido un numero decimal");
			 error=true;
		 }
	 }while(error);
	 return respuesta;
    }
    
    private static int pedirEntero(){
	 BufferedReader br=new BufferedReader (new InputStreamReader(System.in));
	 int numero=0;
	 boolean error=false;
	 do{
		try {
			numero = Integer.parseInt(br.readLine());
		} 
		catch (IOException ex) {
			System.out.println("Error de entrada y salida");
		} 
		catch (NumberFormatException ex){
			System.out.println("No has introducido un nº entero.");
		}
	 }while(error);
	 return numero;
 }
}