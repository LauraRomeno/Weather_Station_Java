/**
 * Aquesta classe guarda la infomraci� de les estacions meteorol�giques 
 * @author Laura Romero Huete
 *
 */
public class Station {
	/**
	 * Primerament de clarem les diferents variables privades que utilitzarem dins de la classe
	 */
	
	private double latitude, longitude, maxt, mint, currenttem;
	private int maxs, mins, update, currentwind, dia, mes, hora, minut, diamax, mesmax, horamax, minutmax, raincity;
	
	/**
	 * Tamb� inicialitzarem les variables est�tiques de la nostre classe
	 */

	private static int rain;
	/**
	 * El m�tode restart inicialitza els valors de les variables, les maximes i les que sumen a 0 i les minimes a un valor bastant elevat perque les entrades siguin sempre inferiors
	 * @param latitude
	 * @param longitude
	 */
	public void restart (double latitude, double longitude){
		this.latitude=latitude;			//suposem que les coordenades s�n correctes
		this.longitude=longitude;
		
		maxt=-200;
		mint=200;
		currenttem=0;
		maxs=0;
		mins=1000;
		update=0;
		raincity=0;
		
	}
	/**
	 * M�tode per demanar la pluja total de totes les ciutats
	 * @return pluja
	 */
	public static int getRain(){return rain;}//
	/**
	 * M�tode per demanar la latitud 
	 * @return laitud
	 */
	public double getLatitude(){	return latitude;}		//
	/**
	 * M�tode per demanar la longitud
	 * @return longitud
	 */
	public double getLongitude(){return longitude;}//
	/**
	 * M�tode per demanar la temperatura m�xima enregistrada en una ciutat
	 * @return temperatura m�xima
	 */
	public double getMaxt(){return maxt;}//
	/**
	 * M�tode per demanar la temperatura m�nima enregistrada en una ciutat
	 * @returntemperatura m�nima
	 */
	public double getMint(){return mint;}//
	/**
	 * M�tode per demanar la ultima temperatura enregistrada
	 * @return temperatura actual
	 */
	public double getCurrenttem(){return currenttem;}//
	/**
	 * M�tode per demanar la velocitat de vent m�xima enregistrada
	 * @return velocitat m�xima del vent
	 */
	public int getMaxs(){return maxs;}//
	/**
	 * M�tode per demanar la velocitat minima del vent enregistrada
	 * @returnvelocitat minima del vent
	 */
	public int getMins(){return mins;}//
	/**
	 * M�tode per demanar el numero de vegades que s'han actualitzar les dades
	 * @return numero d'actualitzacions
	 */
	public int getUpdate(){return update;}//
	/**
	 * M�tode per demanar la velocitat del vent actual
	 * @return velocitat actual del vent
	 */
	public int getCurrentwind(){return currentwind;}//
	/**
	 * M�tode per dememanar el dia de la �ltima actualitzaci�
	 * @return dia
	 */
	public int getCurrentday(){return dia;}//
	/**
	 * M�tode per demanar el mes de la �ltima actualitzaci�
	 * @return mes
	 */
	public int getCurrentmonth(){return mes;}//
	/**
	 * M�tode per demanar la hora de la �ltima actualitzaci�
	 * @return hora
	 */
	public int getCurrenthour(){return hora;}//
	/**
	 * M�tode per demanar el minut de la �ltima actualitzaci�
	 * @return
	 */
	public int getCurrentminute(){return minut;}//
	/**
	 * M�tode per demanar el dia en que es van enregistrar temperatures m�ximes
	 * @return dia de temperatures m�ximes
	 */
	public int getMaxday(){return diamax;}//
	/**
	 * M�tode per demanar el mes en que es van enregistrar temperatures m�ximes
	 * @return mes de temperatures m�ximes
	 */
	public int getMaxmonth(){return mesmax;}//
	/**
	 * M�tode per demanar la hora en que es van enregistrar temperatures m�ximes
	 * @return hora de les temperatures m�ximes
	 */
	public int getMaxhour(){return horamax;}//
	/**
	 * M�tode per demanar el minut en que es van enregistrar temperatures m�ximes
	 * @return minut de les temperatures m�ximes
	 */
	public int getMaxminute(){return minutmax;}//
	/**
	 * M�tode per demanar el total de pluj acumulat en una ciutat
	 * @return total de pluja acumulat en una ciutat
	 */
	public int getRaincity(){return raincity;}
	
	/**
	 * M�tode per actualitzar els valor d'una ciutat, augmnetar la pluja total i augmentar el contador d'actualitzacions de la ciutat
	 * @param temperatura
	 * @param vent
	 * @param pluja
	 * @param dia
	 * @param mes
	 * @param hora
	 * @param minut
	 */
	public void update(float temperatura, int vent, int pluja, int dia, int mes, int hora, int minut){		
			currenttem=temperatura;
			update++;
		if (currenttem>maxt){
			maxt=currenttem;
			diamax=dia;
			mesmax=mes;
			horamax=hora;
			minutmax=minut;			
		}
		if (currenttem<mint) {mint=currenttem;}
		
		
		this.dia=dia;
		this.mes=mes;
		this.hora=hora;
		this.minut=minut;
		currentwind=vent;
		
		if (currentwind>maxs){maxs=currentwind;}
		if (currentwind<mins){mins=currentwind;}
		
		raincity=raincity+pluja;
		rain=rain+pluja;

	}
	
	/**
	 * M�tode per transformar la temperatura actual de graus celcius a Farenheit
	 * @return la temperatura actual en Farenheit
	 */
	public double Farenheit (){
		double temF;
		temF=currenttem*1.8+32;
		return temF;
	}
	
	/**
	 * M�tode per transformar la velocitat actual del vent de Kpm a mph
	 * @return velocitat del vent en mph
	 */
	public double Milles (){
		double windm;
		windm=currentwind*0.6213;
		return windm;
	}
	
	/**
	 * M�tode per tornar a restaurar els valors inicials d'una ciutat
	 */
	public void Restart (){
		maxt=-200;
		mint=200;
		currenttem=0;
		maxs=0;
		mins=1000;
		rain=0;
		update=0;
	}

	/**
	 * M�tode per comparar la pluja de dues ciutat
	 * @param city
	 * @param city2
	 * @return la ciutat amb menys pluja
	 */
	public Station isLess(Station city){
		
		if (this.raincity<city.raincity) return this;
		else return city;
	}
	
	/**
	 * M�tode per copiar els �ltims valors enregistrats de vent, temperatura i pluja d'una ciutat a una altre
	 * @param City
	 */
	public void copycity(Station City){
		City.currenttem=this.currenttem;
		City.currentwind=this.currentwind;
		City.raincity=this.raincity;		
	}
	
	/**
	 * M�tode per escriure per pantalla les temperatures extremes d'una ciutat
	 */
	public String toString(){
		return ("La ciutat que ha acumulat m�s pluja �s la que te com a latitud: "+getLatitude()+ " i com a longitud: "+getLongitude());
	}
	
	/**
	 * M�tode per comparar la maxima temperatura d'una ciutat
	 */
	
	public int Numstation(Station Tarragona, Station Barcelona){
		
		int num=0;
		if (maxt>=Tarragona.maxt){
			if (maxt>=Barcelona.maxt) num=1;
		}
		else 	{if(Tarragona.maxt>Barcelona.maxt) { num=3;}
				else num=2;
				}
		return num;
	}
	
	
	
	
	
}
