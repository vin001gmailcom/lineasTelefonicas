/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad de los Andes (Bogot� - Colombia)
 * Departamento de Ingenier�a de Sistemas y Computaci�n
 * Licenciado bajo el esquema Academic Free License version 2.1
 *
 * Proyecto Cupi2
 * Ejercicio: Avi�n
 * Autor: Katalina Marcos - Febrero 2005
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */
package uniandes.cupi2.avion.mundo;

import java.util.ArrayList;

/**
 * Pasajero del avi�n
 */
public class Pasajero
{

    //-----------------------------------------------------------------
    // Atributos
    //-----------------------------------------------------------------
    /**
     * C�dula del pasajero
     */
    private int cedula;
    
    /**
     * Nombre del pasajero
     */
    private String nombre;
    
    /**
     * Lista de pel�culas del pasajero.
     */
    private ArrayList<Pelicula> listaDePeliculas;

    //-----------------------------------------------------------------
    // Constructores
    //-----------------------------------------------------------------

    /**
     * Crea a un pasajero con su c�dula y nombre <br>
     * <b>post: </b>El pasajero tiene sus datos b�sicos c�dula y nombre asignados.
     * @param unaCedula - c�dula del pasajero - unaCedula >0
     * @param unNombre - nombre del pasajero - unNombre != ""
     */
    public Pasajero( int unaCedula, String unNombre )
    {
        cedula = unaCedula;
        nombre = unNombre;        
        listaDePeliculas = new ArrayList<>();
    }

    //-----------------------------------------------------------------
    // M�todos
    //-----------------------------------------------------------------

    /**
     * Retorna la c�dula del pasajero
     * @return cedula del pasajero
     */
    public int darCedula( )
    {
        return cedula;
    }

    /**
     * Retorna el nombre del pasajero
     * @return nombre del pasajero
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Indica si el pasajero es igual a otro.
     * @param otroPasajero - pasajero a comparar - otroPasajero != null
     * @return true si es el mismo pasajero, false en caso contrario
     */
    public boolean igualA( Pasajero otroPasajero )
    {
        if( cedula == otroPasajero.darCedula( ) )
            return true;
        else
            return false;
    }
    
    /**
     * Devuelve la lista de pel�culas del pasajero.
     * @return Lista de pel�culas del pasajero.
     */
    public ArrayList<Pelicula> darPeliculas()
    {
    	return listaDePeliculas;
    }
    
    /**
     * Agrega una pel�cula a la lista.
     * @param nombre Nombre de la pel�cula. nombre !="" && nombre !=null.
     * @param genero G�nero de la pel�cula. genero !="" && genero !=null.
     * @param duracion Duraci�n en minutos de la pel�cula. duracion > 0.
     * @param director Director de la pel�cula. director != null && director !="".
     */
    public void agregarPelicula(String nombre, String genero, int duracion, String director)
    {
    	Pelicula pelicula = new Pelicula(nombre, genero, duracion, director);
    	listaDePeliculas.add(pelicula);
    }
    
    /**
     * Devuelve la duraci�n total de las pel�culas programadas por el pasajero.
     * @return Suma de la duraci�n de cada una de las pel�culas del pasajero.
     */
    public int darDuracionTotalPeliculas()
    {
    	int sumatoriaDuracionPelicula = 0;
    	for (int i = 0; i < listaDePeliculas.size(); i++) {
			Pelicula pelicula = listaDePeliculas.get(i);
			sumatoriaDuracionPelicula += pelicula.darDuracion();
		}
    	return sumatoriaDuracionPelicula;
    }
    
    /**
     * Devuelve una lista de las pel�culas que pertenecen a un g�nero determinado por par�metro. 
     * @param genero G�nero al que pertencen las pel�culas.
     * @return Lista de las pel�culas que pertenecen al g�nero.
     */
    public ArrayList<Pelicula> darPeliculasGenero(String genero)
    {
    	ArrayList<Pelicula> listaPeliculasConGeneroIndicado = new ArrayList<>();
    	for (int i = 0; i < listaDePeliculas.size(); i++) {
			Pelicula pelicula = listaDePeliculas.get(i);
			if(pelicula.darGenero().equals(genero)) {
				listaPeliculasConGeneroIndicado.add(pelicula);
			}
		}    	
    	return listaPeliculasConGeneroIndicado;
    }
    
    /**
     * Determina si hay dos pel�culas que tengan la misma duraci�n.
     * @return True si hay dos pel�culas con la misma duraci�n, false de lo contrario.
     */
    public boolean tienePeliculasMismaDuracion()
    {
    	for (int i = 0; i < listaDePeliculas.size(); i++) {
			Pelicula pelicula = listaDePeliculas.get(i);
			for(int j = 0; j< listaDePeliculas.size();j++) {
				Pelicula pelicula2 = listaDePeliculas.get(j);
				if(!pelicula.darNombre().equalsIgnoreCase(pelicula2.darNombre()) &&  pelicula.darDuracion() == pelicula2.darDuracion()) {
					return true;
				}
			}
		}        	
    	return false;
    }
    
    
    
    
}