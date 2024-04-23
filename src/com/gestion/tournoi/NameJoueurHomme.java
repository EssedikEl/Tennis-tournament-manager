package com.gestion.tournoi;

import java.util.Random;

public enum NameJoueurHomme {

	Albot("Albot", "Rado", "Moldave", "11/11/1989", "Chisinau", "Droitier", "Jimmy Oganezov", 175, 70),
	Almagro("Almagro", "Nicolas", "Espagnol", "21/08/1985", "Murcie", "Droitier", "Samuel Lopez", 183, 81),
	Alund("Alund", "Martin", "Argentin", "26/12/1985", "Mendoza", "Droitier", "Fabian Blengino", 183, 80),
	Alves("Alves", "Thiago", "Br�silien", "22/05/1982", "S�o Jos� do Rio Preto", "Droitier", "Carlos Albano", 178, 75),
	Gonzalez("Gonzalez", "Alejandro", "Colombienne", "07/02/1989", "Medellin", "Gaucher", "Pablo Fuente", 191, 83),
	Goodall("Goodall", "Josh", "Britannique", "17/10/1985", "Basingstoke", "Droitier", "Peter Lundgren", 188, 74),
	Patience("Patience", "Olivier", "Fran�aise", "25/03/1980", "Evreux", "Droitier", "Cyril Saulnier", 180, 75),
	Djokovic("Djokovic","Novak","Serbe","22/05/1987","Belgrade","Droitier","Marian Vajda",188,79),
	Nadal("Nadal","Rafael","Espagnol","03/06/1986","Manacor","Gaucher","Toni Nadal",185,85),
	Monfils("Monfils","Ga�l","Fran�aise","01/09/1986","Paris","Droitier","Liam Smith",193,85),
	Federer("Federer","Roger","Suisse","08/08/1981","B�le","Droitier","S�verin L�thi et Ivan Ljubicic",185,84),
	Zverev("Zverev","Alexander","Allemande","20/04/1997","Hambourg","Droitier","Alexander Zverev",198,86),
	Napolitano("Napolitano","Stefano","Italien","11/04/1995","Biella","Droitier","Johan Ortegren",196,90),
	Novak("Novak","Dennis","Autrichien","28/08/1993","Wiener Neustadt","Droitier","Gunter Bresnik et Wolfgang Thiem",183,80),
	Olivetti("Olivetti","Albano","Fran�aise","24/11/1991","Haguenau","Droitier","Boris Vallejo",202,104),
	Yani("Yani","Michael","Am�ricain","31/12/1980","Singapour","Droitier","Ed Yani",185,75),
	Wang("Wang","Jimmy","Ta�wanais","08/02/1985","M�dine","Droitier","Vitaly Gorin",178,64),
	Simon("Simon","Gilles","Fran�aise","27/12/1984","Nice","Droitier","NC",183,70),
	Kukushkin("Kukushkin","Mikhail","Kazakh","26/12/1987","Volgograd","Droitier","Anastasia Ulikhina",183,72),
	Jonathan("Dasni�res de Veigy","Jonathan","Fran�aise", "05/01/1987", "N�mes","Gaucher","Thierry Ascione",174,70),
	Lopez("Lopez","Feliciano","Espagnol","20/09/1981","Tol�de","Gaucher","Jose Clavet",188,84),
	Lu("Lu","Yen-Hsun","Ta�wanais","14/08/1983","Taipei","Droitier","Roberto Antonini",180,73),
	LopezPerez("Lopez-Perez","Enrique","Espagnol","03/06/1991","Madrid","Droitier","Victor Recio Garcia",180,76),
	Tessa("Tessa","Louis","Fran�aise","06/04/1998","NC","Droitier","Christophe Fournerie",178,65),
	Ungur("Ungur","Adrian","Roumain","25/01/1985","Pitesti","Droitier","Fabrizio Fanucci",178,73),
	Uchiyama("Uchiyama","Yasutaka","Japonais","05/08/1992","Sapporo","Droitier","Kentaro Masuda",183,78),
	Udomchoke("Udomchoke","Danai","Thailandais","11/08/1981","Bangkok","Droitier","Jan Stoces",173,64),
	Velotti("Velotti","Agustin","Argentin","24/05/1992","Corrientes","Droitier","Ruben R�",174,67),
	Vesely("Vesely","Jiri","Tch�que","10/07/1993","Pribram","Gaucher","Jaroslav et Michal Navratil",198,90),
	WangTak("Wang","tak khunn","Fran�aise","12/10/1991","Paris","Droitier","Jean-Alexis Boulesios",175,66),
	Ward("Ward","James","Britannique","09/02/1987","Londres","Droitier","Mario Leguizamom",190,72),
	Watanuki("Watanuki","Yosuke","Japonais","12/04/1998","Saitama","Droitier","Yusuke Watanaki",180,63),
	Wawrinka("Wawrinka","Stanislas","Suisse","28/03/1985","Lausanne","Droitier","Magnus Norman et Yannick Fatteberg",183,81),
	Williams("Williams","Rhyne","Am�ricain","22/03/1991","Knoxville","Droitier","Andres Pedroso",178,60),
	Wu("Wu","Di","Chinois","14/04/1991","Hu Bei","Droitier","Davide Sanguinetti",173,66),
	Yang("Yang","Tsung-Hua","Ta�wanais","29/03/1991","Taipei","Droitier","Lhen Man",173,75),
	Ymer("Ymer","Mikael","Su�dois","09/09/1998","Sk�vde","Droitier","Frederik Nielsen",183,75),
	Young("Young","Donald","Am�ricain","23/07/1989","Chicago","Gaucher","Donald Sr & Ilona Young",183,72),
	Youzhny("Youzhny","Mikhail","Russe","25/06/1982","Moscou","Droitier","Boris Sobkin",182,78),
	Zeballos("Zeballos","Horacio","Argentin","27/04/1985","Mar del Plata","Gaucher","Alejandro Lombardo",188,83),
	Zemlja("Zemlja","Grega","Slov�ne","29/09/1986","Jesenice","Droitier","Ziga Janskovec",183,78),
	Zhang("Zhang","Ze","Chinois","04/07/1990","Nanjing","Droitier","Guillaume Peyre",188,83),
	Zopp("Zopp","Jurgen","Estonien","29/03/1988","Tallinn","Droitier","Pasi Virtanen",190,82),
	ZverevM("Zverev","Mischa","Allemand","22/08/1987","Moscou","Gaucher","Alexander Zverev",190,81),
	Volandri("Volandri","Filippo","Italien","05/09/1981","Livourne","Droitier","Fabrizio Fanucci",183,73),
	Viola("Viola","Matteo","Italien","07/07/1987","Mestre-Venice","Droitier","Andrea Mantegazza",188,80),
	Vibert("Vibert","Fran�ois-Arthur","Fran�aise","03/08/1990","Bron","Droitier","Bertrand Contzler",188,80),
	Verdasco("Verdasco","Fernando","Espagnol","15/11/1983","Madrid","Gaucher","Sergio Perez",188,81),
	Veic("Veic","Antonio","Croate","18/02/1988","Mali Losinj","Droitier","Goran Prpic",180,74),
	Vatutin("Vatutin","Alexey","Russe","27/10/1992","Volgograd","Droitier","Yuriy Kozlovich et Eduard Davydenko",178,69),
	Vanni("Vanni","Luca","Italienne","04/06/1985","Castel del Piano","Droitier","Fabio Gorietti",198,93),
	VanDer("Van Der Merwe","Izak","Sud-Africain","26/01/1984","Johannesburg","Droitier","Rodrigo Leander",196,88),
	Vagnozzi("Vagnozzi","Simone","Italien","30/05/1983","Ascoli Piceno","Droitier","Mattia Livraghi",173,60),
	Tursunov("Tursunov","Dmitry","Russe","12/12/1982","Moscou","Droitier","Vitaly Gorin",185,84),
	Tsonga("Tsonga","Jo-Wilfried","Fran�aise","17/04/1985","Le Mans","Droitier","Thierry Ascione et Sergi Brugera",188,90),
	Tsitsipas("Tsitsipas","Stefanos","Grec","12/08/1998","Ath�nes","Droitier","Apostolos Tsitsipas",191,83),
	Trungelliti("Trungelliti","Marco","Argentin","31/01/1990","Santiago del Estero","Droitier","Trungelliti Marco",180,78),
	Troicki("Troicki","Viktor","Serbe","10/02/1986","Belgrade","Droitier","Jack Reader",193,85),
	Travaglia("Travaglia","Stafano","Italienne","18/12/1991","Ascoli Piceno","Droitier","Sebastian Vasquez",185,80),
	Torebko("Torebko","Peter","Allemand","10/02/1988","Bytom","Droitier","Chris Spencer",185,81),
	Tomic("Tomic","Bernard","Australien","21/10/1992","Stuttgart","Droitier","John Tomic",193,77),
	Tipsarevic("Tipsarevic","Janko","Serbe","22/06/1984","Belgrade","Droitier","Dirk Hordorff",180,83),
	Tiafoe("Tiafoe","Frances","Am�ricain","20/01/1998","Hyattsville","Droitier","Jose Higueras",188,77),
	Thompson("Thompson","Jordan","Australien","20/04/1994","Sydney","Droitier","Stephen Thompson",183,73),
	Thiem("Thiem","Dominic","Autrichien","03/09/1993","Wiener Neustadt","Droitier","Gunter Bresnik",185,82),
	Teixeira("Teixeira","Maxime","Fran�aise","18/01/1989","La Rochelle","Droitier","Boris Vallejo",188,75),
	Tatlot("Tatlot","Johan S�bastien","Fran�aise","26/03/1996","Sch�lcher","Droitier","J-C Faurel, Alois Beust, Pascal Lassere et S. Poublet",180,80),
	Taberner("Taberner","Carlos","Espagnole","08/08/1997","Valence","Droitier","German Anglada, Jose Altur et Pablo Lozano",183,78),
	Sweeting("Sweeting","Ryan","Am�rican","14/07/1987","Nassau","Droitier","Craig Boynton",195,83),
	Sugita("Sugita","Yuichi","Japonais","18/09/1988","Sendai","Droitier","Braen Aneiros",173,66),
	Struff("Struff","Jan-Lennard","Allemande","25/04/1990","Warstein","Droitier","Ute Strakerjahn et Christoph Reichert",196,87),
	Stepanek("Stepanek","Radek","Tch�que","27/11/1978","Karvina","Droitier","Petr Korda",185,75),
	Stebe("Stebe","Cedrik-Marcel","Allemand","09/10/1990","M�hlacker","Gaucher","Benjamin Ebrahimzadeh",183,72),
	Starace("Starace","Potito","Italien","14/07/1981","B�n�vent","Droitier","Umberto Rianna",188,83),
	Stakhovsky("Stakhovsky","Sergiy","Ukrainien","06/01/1986","Kiev","Droitier","Tibor Toth",193,80),
	Souza("Souza","Joao","Br�silien","27/05/1988","Mogi das Cruzes","Droitier","Ricardo Acioly",193,87),
	Sousa("Sousa","Joao","Portugais","30/03/1989","Guimaraes","Droitier","Frederico Marques",185,73),
	Sorensen("Sorensen","Louk","Irlandaise","07/01/1985","Schw�bisch Hall","Droitier","Kevin Sorensen",175,78),
	Sonego("Sonego","Lorenzo","Italien","11/05/1995","Turin","Droitier","Gipo Arbino",182,73),
	Soeda("Soeda","Go","Japonais","05/09/1984","Fujisawa","Droitier","Davide Sanguinetti",178,73),
	Soderling("S�derling","Robin","Su�dois","14/08/1984","Tibro","Droitier","Fredrik Rosengren",193,87),
	Machado("Machado","Rui","Portugais","10/04/1984","Faro","Droitier","Andre Lopes",177,69),
	Maden("Maden","Yannick","Allemand","28/10/1989","Stuttgart","Droitier","Fidi Beutel",185,68),
	Mahut("Mahut","Nicolas","Fran�aise","21/01/1982","Angers","Droitier","Nicolas Copin et Nicolas Renavand",191,79),
	Majchrzak("Majchrzak","Kamil","Polonais","13/01/1996","Piotrkow Trybunalski","Droitier","Tomasz Iwanski",183,74),
	Malisse("Malisse","Xavier","Belge","19/07/1980","Courtrai","Droitier","Malisse Xavier",185,82),
	Mannarino("Mannarino","Adrian","Fran�aise","29/06/1988","Soizy","Gaucher","Mannarino Adrian",183,66),
	Marchenko("Marchenko","Iiilya","Ukrainien","08/09/1987","Dneprodzerzhinsk","Droitier","Orest Tereschuk",185,78),
	Marie("Marie","Jules","Fran�aise","01/09/1991","Caen","Droitier","Jean- Maris Tenenhaus et Fabrice Marie",185,75),
	Marterer("Marterer","Maximilian","Allemand","15/06/1995","Nuremberg","Gaucher","Markus Wislsperger",191,84),
	Marti("Marti","Javier","Espagnol","11/01/1992","Madrid","Droitier","Oscar Burrieza",182,71),
	Martin("Martin","Fabrice","Fran�aise","11/09/1986","Bayonne","Droitier","Julien Maes",198,97),
	MartinA("Martin","Andrej","Slovaque","20/09/1989","Bratislava","Droitier","Claudio Pistolesi",180,72),
	Martinez("Martinez","Pedro","Espagnol","26/04/1997","Alzira","Droitier","Javier Ferrer",183,77),
	Mathieu("Mathieu","Paul-Henri","Fran�aise","12/01/1982","Strasbourg","Droitier","Olivier Malcor",185,74),
	Matosevic("Matosevic","Marinko","Australien","08/08/1985","Jajce","Droitier","Mark Woodforde",190,87),
	Mayer("Mayer","Florian","Allemand","05/10/1983","Bayreuth","Droitier","Tobias Summerer",191,81),
	MayerL("Mayer","Leonardo","Argentin","15/05/1987","Corrientes","Droitier","Leo Alonso et J. Fernandez",188,83),
	McDonald("McDonald","Mackenzie","Am�ricain","16/04/1995","Piedmont","Droitier","Mat Cloer",178,66),
	Mcgee("Mcgee","James","Irlandaise","10/06/1987","Dublin","Droitier","James Galanis",183,80),
	Mecir("Mecir","Miloslav","Slovaque","20/01/1988","Prague","Droitier","Mecir Miloslav",190,86),
	Medvedev("Medvedev","Daniil","Russe","11/02/1996","Moscou","Droitier","Gilles Cervara",198,83),
	Meffert("Meffert","Dominik","Allemand","09/04/1981","Mayen","Droitier","Tomas Behrend",198,95),
	Mello("Mello","Ricardo","Br�silien","21/12/1980","Campinas","Gaucher","Carlos Albano",175,73),
	Milojevic("Milojevic","Nikola","Serbe","19/06/1995","Belgrade","Droitier","Dejan Petrovic",188,76),
	Mina("Mina","Gianni","Fran�aise","09/02/1992","Les Abymes","Droitier","Olivier Soul�s",185,77),
	Minar("Minar","Ivo","Tch�que","21/05/1984","Prague","Droitier","Karol Dusan",183,85),
	Mmoh("Mmoh","Michael","Am�ricain","10/01/1998","Riyadh","Droitier","Glenn Weiner",185,85),
	Molchanov("Molchanov","Denys","Ukrainien","16/05/1987","Chisinau","Droitier","Oleksandr Dolgopolov",190,77),
	Molleker("Molleker","Rudolf","Allemand","26/10/2000","Sieverodonetsk","Droitier","Jan de Witt",185,75),
	Munar("Munar","Jaume","Espagnol","05/05/1997","Santanyi","Droitier","Carlos Gomez Ferre",183,78),
	Murray("Murray","Andy","Britannique","15/05/1987","Dunblane","Droitier","Ivan Lendl",191,83),
	Musialek("Musialek","Alexis","Fran�aise","04/07/1988","Dax","Droitier","Musialek Alexis",184,80),
	Myneni("Myneni","Saketh","Indien","19/10/1987","Inde","Droitier","Jaymon Crabb",193,85),
	Nedvyesov("Nedvyesov","Alexsandr","Kazakh","15/02/1987","Alushta","Droitier","Nedvyesov Alexsandr",193,81),
	Nieminen("Nieminen","Jarkko","Finlandais","23/07/1981","Masku","Gaucher","Jan de Witt",185,78),
	Nishikori("Nishikori","Kei","Japonais","29/12/1989","Shimane","Droitier","Micha�l Chang et Dante Bottini",178,68),
	Nishioka("Nishioka","Yoshihito","JAponais","27/09/1995","Mie","Droitier","Mitsuru Takada",170,63),
	Norrie("Norrie","Cameron","Britannique","23/08/1995","Johannesburg","Gaucher","Facundo Lugones",188,80),
	Paire("Paire","Benoit","Fran�aise","08/05/1989","Avignon","Droitier","Morgan Bourbon",195,80),
	GonzalezM("Gonzalez","Maximo","Argentin","20/07/1983","Tandil","Droitier","Gustavo Marcaccio",175,70),
	Gombos("Gombos","Norbert","Slovaque","13/08/1990","Galanta","Droitier","Simon Ladislav",196,85),
	Golubev("Golubev","Andrey","Kazakh","22/07/1987","Voljski","Droitier","Yuri Schukin",185,77),
	Gojowczyk("Gojowczyk","Peter","Allemand","15/07/1989","Dachau","Droitier","Marcello Craca",185,83),
	Goffin("Goffin","David","Belge","07/12/1990","Rocourt","Droitier","Thomas Johansson",180,70),
	Giustino("Giustino","Lorenzo","Italien","10/09/1991","Naples","Droitier","Borja Gomez Sanz",183,80),
	Giraldo("Giraldo","Santiago","Colombien","27/11/1987","Pereira","Droitier","Felipe Beron",188,74),
	Gicquel("Gicquel","Marc","Fran�aise","30/03/1977","Tunis","Droitier","J�r�me Potier",188,75),
	Ginepri("Ginepri","Robby","Am�ricain","07/10/1982","Fort Lauderdale","Droitier","Jay Bosworth",183,79),
	Giannessi("Giannessi","Alessandro","Italien","30/05/1990","La Spezia","Gaucher","Gabrio Castrichella",183,81),
	Gensse("Gensse","Augustin","Fran�aise","10/08/1983","Mont-de-Marsan","Droitier","J�rome Prigent",180,77),
	Garin("Garin","Cristian","Chilien","30/05/1996","Arica","Droitier","Andres Schneiter Paul Capdeville",185,85),
	Galovic("Galovic","Viktor","Croate","19/09/1990","Nova Gradiska","Droitier","Daniel Panajotti",193,88),
	Galan("Galan","Daniel Elahi","Colombien","18/06/1996","Bucaramanga","Droitier","Santos Galen",191,72),
	Fucsovics("Fucsovics","Marton","Hongrois","08/02/1992","Nyiregyhaza","Droitier","Attila Savolt",188,80),
	Fritz("Fritz","Taylor","Am�ricain","28/10/1997","Racho Santa-Fe","Droitier","David Nainkin et Christian Groh",193,84),
	Grigelis("Grigelis","Laurynas","Lituanien","14/08/1991","Klaip�da","Droitier","Giuseppe Menga",183,71)
	;

	NameJoueurHomme(String nom, String prenom, String nationalite, String dateNaissance, String lieuNaissance,
			String main, String entraineur, int poids, int taille) {
		this.nom = nom;
		this.prenom = prenom;
		this.nationalite = nationalite;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.main = main;
		this.entraineur = entraineur;
		this.poids = poids;
		this.taille = taille;
	}

	private String nom;
	private String prenom;
	private String nationalite;
	private String dateNaissance;
	private String lieuNaissance;
	private String main;
	private String entraineur;
	private int poids;
	private int taille;
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getNationalite() {
		return nationalite;
	}
	public String getDateNaissance() {
		return dateNaissance;
	}
	public String getLieuNaissance() {
		return lieuNaissance;
	}
	public String getMain() {
		return main;
	}
	public String getEntraineur() {
		return entraineur;
	}
	public int getPoids() {
		return poids;
	}
	public int getTaille() {
		return taille;
	}
	
	public static NameJoueurHomme getRandomJoueurHomme() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
