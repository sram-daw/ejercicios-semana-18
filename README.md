# Ejercicios semana 18 PROGRAMACIÓN: Lectura y escritura de objetos

## Anotaciones previas
Vamos a hacer una serie de ejercicios para practicar el uso de lectura y
escritura de ficheros, tanto de texto plano como binarios y objetos.

## Ejercicios
Cada ejercicio puede ser una clase que se instancia o utiliza desde un
Main.java.

### Ejercicio 1
Crea un método que reciba por parámetro una cadena de caracteres y
una ruta y/o nombre de fichero. El método debe almacenar la cadena de
caracteres en el lugar indicado y devolver una señal si fue capaz de
completar la acción o no.

### Ejercicio 2
Crea un método que reciba por parámetro una ruta y/o nombre de fichero.
El método debe devolver, formateado como cadena de caracteres, el valor
del fichero. Si hubo algún error, debe de envíar la cadena del error.

### Ejercicio 3
Crea un método que reciba 3 parámetros: cadena de caracteres, una ruta
y/o nombre de fichero y un valor booleano que, si es true, añada valores al
final del fichero y si es false, sobreescriba el fichero. El método debe la
cadena de caracteres al fichero (bien al final o sobreescribiendo dependiendo del tercer parámetro) e indicar si la operación fue
completada con éxito o hubo algún error.

### Ejercicio 4
Crea un método que reciba tres parámetros: un objeto, una ruta y/o nombre
de fichero y un valor booleano.
Se almacenará en el fichero indicado el objeto. Dependiendo del valor
booleano, se añadirá al final del fichero o no.
Pista: Ten en cuenta que puede ser cualquier objeto, puedes usar
generalidad.

### Ejercicio 5
Crea un método que reciba por parámetro una ruta y/o nombre de fichero
para retornar valores de objetos almacenados. Ten en cuenta que no se
sabe que tipo de objeto va a devolver el método.
Pista: Usa generalidad o un parámetro adicional con el tipo de objeto.

### Ejercicio 6
Almacenar los objetos de uno en uno (abrir el fichero, transformar el objeto a
bytecode, escribir en el fichero y cerrar) es altamente ineficiente. Crea un
método que reciba por parámetro una lista de objetos, una ruta y/o nombre
de fichero y un valor booleano. Dependiendo del valor booleano, se sobreescribirá el fichero o se añadirán al final del fichero. Devuelve un
mensaje de confirmación si la operación fue correcta o el error ocurrido.

### Ejercicio 7
Como anteriormente, crea un método que reciba por parámetro una ruta
y/o nombre de fichero. Debe devolver una lista de objetos si no ocurren
errores.
Pista: No se tiene porqué conocer el tipo de objetos, por lo que puedes usar
generalidad o agregar un parámetro para indicarlo.