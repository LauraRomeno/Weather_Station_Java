/**
 * Aquest projecte implementa tots els m�todes creats a la classe Station que recull la informaci� d'una estaci� meteorol�gica de catalunya
 * @author Laura Romero Huete
 *
 */
public class LauraRomeroHuete_P1 {

	public static void main(String[] args) {
		/**
		 * Seguidament creem les tres estacions meteorol�giques
		 */
		Station tarragona = new Station();			//creem tres objectes de tres ciutats de catalunya
		Station manresa = new Station();
		Station barcelona = new Station();
		
		/**
		 * Restaurem els valors de les Estacions per tal de poder enregistrar valors m�s endavant
		 */
		tarragona.restart(41.115,1.2499);	//inicilitzem les 3 ciutats i passem la seva localitzaci� geogr�fica (latitud i longitud)
		manresa.restart(41.73,1.83 );
		barcelona.restart(41.38,2.17);
		
		/**
		 * Cridant el m�tode update actualitzem els valors de les ciutats
		 */
		tarragona.update(17, 9, 0, 20, 9, 8, 25);	//fem un update de les 3 ciutats on passem la temperatura, la pluja, el vent i la data(dia, mes, hora i minut)
		manresa.update(16, 5, 12, 16, 10, 15, 32);					
		barcelona.update(19, 10, 3, 7, 7, 16, 36);
		
		/**
		 * Escrivim per pantalla alguns dels valors de temperatura, pluja i vent de les ciutats
		 */
		System.out.println("La temperatura actual a Tarragona en farenheit es "+tarragona.Farenheit());
		System.out.println("El vent actual a la ciuat de Manresa es de "+manresa.Milles()+"mph");
		System.out.println("Les ultimes dades de Barcelona s�n: "+barcelona.getCurrentwind()+"kph de vent i "+barcelona.getCurrenttem()+"�C");
		System.out.println("Les coordenades geog�fiques de Manresa s�n: "+manresa.getLatitude()+", "+manresa.getLongitude());
		System.out.println("a Tarragona el ven m�xim ha estat de: "+tarragona.getMaxs()+" kph i el minim de: "+tarragona.getMins());
		/**
		 * Cridant el m�tode update actualitzem els valors de les ciutats
		 */
		tarragona.update(22, 15, 30, 5, 5, 13, 45);					//fem un update de les 3 ciutats
		manresa.update(34, 10, 0, 9, 8, 12, 0);
		barcelona.update(22, 5, 21, 6, 6, 15, 30);
		
		/**
		 * Escrivim per pantalla alguns dels valors de temperatura, pluja i vent de les ciutats
		 */
		System.out.println("La temperatura m�xima a Manresa �s de "+manresa.getMaxt()+"�C, i la minima �s de "+manresa.getMint()+"�C");
		//en la linia superior mostrem les temperatures maxime si minimes enregistrades a la ciutat de Manresa
		System.out.println("La temperatura maxima i minima de Manresa es va enrregistrar a les "+manresa.getMaxhour()+" hores i "+manresa.getMaxminute()+" minuts el dia "+manresa.getMaxday()+" del mes"+manresa.getMaxmonth());
		//en la linia superior mostrem la hora el minut el dia i el mes (en aquest ordre) en el que es van enrregistrar les dades maximes ensenyades en la linia superior
		System.out.println("L'�ltima actualitzaci� del temps a Tarragona ha estat el dia "+tarragona.getCurrentday()+" del mes " +tarragona.getCurrentmonth()+" a les "+tarragona.getCurrenthour()+ " hores i "+tarragona.getCurrentminute()+" minuts");
		//en la liia superior mostrem per pantalla les ultimes temperatures actualitzades a la ciutat de Tarragona i el dia, mes, hora i minut en que es van actualitzar
		
		/**
		 * Mostrem per pantalla la quantitat de vegades que s'ha actualitzat una esaci�
		 */
		System.out.println("La ciutat de Tarragona s'ha actualitzat "+tarragona.getUpdate()+ " vegades");
		
		
		/**
		 * Restaurem els valors de la ciutat de Barcelona
		 */
		barcelona.restart(41.38,2.17);
		/**
		 * Escrivim per pantalla alguns dels valors de temperatura, pluja i vent de les ciutats
		 */
		System.out.println("Despr�s de la restauraci� de la ciutat de Barcelona les dades s�n: dia "+barcelona.getCurrentday()+" del mes " +barcelona.getCurrentmonth()+" a les "+barcelona.getCurrenthour()+ " hores i "+barcelona.getCurrentminute()+" minuts");
		System.out.println("Temperatura actual a BCN: "+barcelona.getCurrenttem()+"�C, i un vent de  " +barcelona.getCurrentwind()+"kph");
			
		/**
		 * Comparem la puja acumulada en dues ciutats
		 */
		System.out.println(manresa.isLess(tarragona)+" ha acumulat menys pluja");
		
		/**
		 * Copiem els �ltims valors de Temperatura, vent i pluja de la ciutat de Manresa a la ciutat de Barcelona
		 */
		manresa.copycity(barcelona);
		System.out.println("Temperatura actual, vent i aumulaci� de pluja de Barcelona s�n ara iguals que a manresa: "+barcelona.getCurrenttem()+"�C,un vent de  " +barcelona.getCurrentwind()+"kph i una pluja de "+barcelona.getRaincity());

		
		/**
		 * Compara la temperatura maxima de cada ciutat
		 */
				
		switch(manresa.Numstation(tarragona, barcelona)){
		
		case 1: System.out.println("\nA Manresa s'han detectat temperatures m�ximes"); break;
		case 2: System.out.println("\nA Barcelona s'han detectat temperatures m�ximes"); break;
		case 3: System.out.println("\nA Tarragona s'han detectat temperatures m�ximes"); break;
		}
		
		
		/**
		 * Imprimim per pantalla la pluja total de totes les estacions			
		 */
		System.out.println("\nEl total de pluja acumulat en les tres ciutats es de "+Station.getRain());
		
		
		
		
		
	}
}
