
# Lautaro Avalos com1
## Decisiones de implementación y desarrollo
##         referisHeuristicaGolosa

### Campeonato
Aquí se inicializan todos los objetos presentes en la UI con
sus respectivas propiedades.

### Controlador
Se encarga de actualizar la UI, de asignarle la matriz de
partidos de cada fecha,de cada liga y de controlar a que matriz se le debe asignar arbitros.Logrando así mantener las clases de servicio e interfaz
separadas sin conocerse entre ellas.

### MVC
En ella se inicia el controlador al que anteriormente se le pasó
como parámetro la UI y un arreglo con las direcciones de los archivos que contienen los calendarios,además se setea el
LookAndFeel acorde al sistema.Uno de los problemas encontrados fue no poder crear esos archivos que contienen los calendarios con extencion JSON 
ya que Eclipse no reconocia algunas clases de la libreria GSON,agregando los GSONsources pudo abrir esas clases pero a la hora de correr el codigo no 
reconocia las clases.
Para solucionar esto serialize los objetos y leo archivos que contienen dichos objetos Calendario.

### Solver Arbitro
Es la clase encargada de copiar los datos de un calendario y asignar a cada partido de cada fecha un arbitro para retornar una lista de fechas con la asignacion realizada,
Para asignar un arbitro se recorren todads las ferchas,al comienzo de cada fecha se ordenan los arbitros teniendo en cuenta el promedio de veces que cada arbitro arbitra 
a los dos equipos del primer partido de dicha fecha,para el primer partido se elige el arbitro con menor promedio y el resto de arbitros de la lista se los va asignando a 
cada partido en el orden de la lista ordenada.Ningun arbitro dirige mas de un partido por fecha.

### Arbitro
Cada Arbitro tiene un arreglo que simula los equipos que va a dirigir,con el metodo sumarPartido() se le suma un partido dirigido por el Arbitro a los 2 equipos del partido (local y visitante),
esto es utilizado a la hora de ordenar los arbitros con el promedio de partidos que dirige a cada equipo.Al construirse un nuevo Arbitro se inicializa su lista de equipos con un cero en
cada posicion.

### Calendario
El constructor recibe una lista de equipo y otra de fechas,la cantidad de equipos de la lista deben ser par y ser uno mas que la cantidad de fechas de la lista de fechas,en todas 
fechas de la lista tienen que aparecer una vez cada equipo,en ninguna de las fechas se repite un partido.Esta clase tambien se encarga de crear una lista de Arbitros con la mitas de
Arbitros que la cantidad de equipos,pasandole como parametro la cantidad de equipos que va a dirigir.Para evitar el aliasing el calendario no tiene getters sino metrodos que copian
sus atributos.

### Fecha
Esta clase contiene una lista de partidos.Dos Fechas son iguales si todos los partidos de una Fecha estan en la lista de la otra y si tienen la misma cantidad de partidos.

### Equipo
Para que un Equipo sea igual al otro tiene que tener el mismo nombre.

### Partido
Cada partido tiene un equio local  ,uno visitante en una lista de size==2 y un numero entero que hace referencia al Arbitro que arbitro ese partido.Dos Partidos son iguales si 
los dos equipos de uno estan en el otro Partido.
