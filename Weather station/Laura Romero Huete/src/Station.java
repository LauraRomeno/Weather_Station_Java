/**
 * Aquesta classe guarda la infomració de les estacions meteorològiques 
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
	 * També inicialitzarem les variables estàtiques de la nostre classe
	 */

	private static int rain;
	/**
	 * El mètode restart inicialitza els valors de les variables, les maximes i les que sumen a 0 i les minimes a un valor bastant elevat perque les entrades siguin sempre inferiors
	 * @param latitude
	 * @param longitude
	 */
	public void restart (double latitude, double longitude){
		this.latitude=latitude;			//suposem que les coordenades són correctes
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
	 * Mètode per demanar la pluja total de totes les ciutats
	 * @return pluja
	 */
	public static int getRain(){return rain;}//
	/**
	 * Mètode per demanar la latitud 
	 * @return laitud
	 */
	public double getLatitude(){	return latitude;}		//
	/**
	 * Mètode per demanar la longitud
	 * @return longitud
	 */
	public double getLongitude(){return longitude;}//
	/**
	 * Mètode per demanar la temperatura màxima enregistrada en una ciutat
	 * @return temperatura màxima
	 */
	public double getMaxt(){return maxt;}//
	/**
	 * Mètode per demanar la temperatura mínima enregistrada en una ciutat
	 * @returntemperatura mínima
	 */
	public double getMint(){return mint;}//
	/**
	 * Mètode per demanar la ultima temperatura enregistrada
	 * @return temperatura actual
	 */
	public double getCurrenttem(){return currenttem;}//
	/**
	 * Mètode per demanar la velocitat de vent màxima enregistrada
	 * @return velocitat màxima del vent
	 */
	public int getMaxs(){return maxs;}//
	/**
	 * Mètode per demanar la velocitat minima del vent enregistrada
	 * @returnvelocitat minima del vent
	 */
	public int getMins(){return mins;}//
	/**
	 * Mètode per demanar el numero de vegades que s'han actualitzar les dades
	 * @return numero d'actualitzacions
	 */
	public int getUpdate(){return update;}//
	/**
	 * Mètode per demanar la velocitat del vent actual
	 * @return velocitat actual del vent
	 */
	public int getCurrentwind(){return currentwind;}//
	/**
	 * Mètode per dememanar el dia de la última actualització
	 * @return dia
	 */
	public int getCurrentday(){return dia;}//
	/**
	 * Mètode per demanar el mes de la última actualització
	 * @return mes
	 */
	public int getCurrentmonth(){return mes;}//
	/**
	 * Mètode per demanar la hora de la última actualització
	 * @return hora
	 */
	public int getCurrenthour(){return hora;}//
	/**
	 * Mètode per demanar el minut de la última actualització
	 * @return
	 */
	public int getCurrentminute(){return minut;}//
	/**
	 * Mètode per demanar el dia en que es van enregistrar temperatures màximes
	 * @return dia de temperatures màximes
	 */
	public int getMaxday(){return diamax;}//
	/**
	 * Mètode per demanar el mes en que es van enregistrar temperatures màximes
	 * @return mes de temperatures màximes
	 */
	public int getMaxmonth(){return mesmax;}//
	/**
	 * Mètode per demanar la hora en que es van enregistrar temperatures màximes
	 * @return hora de les temperatures màximes
	 */
	public int getMaxhour(){return horamax;}//
	/**
	 * Mètode per demanar el minut en que es van enregistrar temperatures màximes
	 * @return minut de les temperatures màximes
	 */
	public int getMaxminute(){return minutmax;}//
	/**
	 * Mètode per demanar el total de pluj acumulat en una ciutat
	 * @return total de pluja acumulat en una ciutat
	 */
	public int getRaincity(){return raincity;}
	
	/**
	 * Mètode per actualitzar els valor d'una ciutat, augmnetar la pluja total i augmentar el contador d'actualitzacions de la ciutat
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
	 * Mètode per transformar la temperatura actual de graus celcius a Farenheit
	 * @return la temperatura actual en Farenheit
	 */
	public double Farenheit (){
		double temF;
		temF=currenttem*1.8+32;
		return temF;
	}
	
	/**
	 * Mètode per transformar la velocitat actual del vent de Kpm a mph
	 * @return velocitat del vent en mph
	 */
	public double Milles (){
		double windm;
		windm=currentwind*0.6213;
		return windm;
	}
	
	/**
	 * Mètode per tornar a restaurar els valors inicials d'una ciutat
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
	 * Mètode per comparar la pluja de dues ciutat
	 * @param city
	 * @param city2
	 * @return la ciutat amb menys pluja
	 */
	public Station isLess(Station city){
		
		if (this.raincity<city.raincity) return this;
		else return city;
	}
	
	/**
	 * Mètode per copiar els últims valors enregistrats de vent, temperatura i pluja d'una ciutat a una altre
	 * @param City
	 */
	public void copycity(Station City){
		City.currenttem=this.currenttem;
		City.currentwind=this.currentwind;
		City.raincity=this.raincity;		
	}
	
	/**
	 * Mètode per escriure per pantalla les temperatures extremes d'una ciutat
	 */
	public String toString(){
		return ("La ciutat que ha acumulat més pluja és la que te com a latitud: "+getLatitude()+ " i com a longitud: "+getLongitude());
	}
	
	/**
	 * Mètode per comparar la maxima temperatura d'una ciutat
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
