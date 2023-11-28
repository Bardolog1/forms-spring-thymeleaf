	Curso Spring : https://www.udemy.com/course/spring-framework-5/

	anotaciones:
	
		-@Valid : es de jakarta y sirve para las validaciones de campos o de datos, se debe indicar en el POJO, medianta anotaciones, que requisitos debe cumplir el atributo
		-@NotEmpty : valida que el campo no este vacio, es requerido
		-@Email :  realiza validaciones de campos de email, se debe importar de jakarta.validation, ya que de hibernet esta deprecated
		-@Size(min=NUM_MIN, max=NUM_MAX)  : se usa para las validaciones de tamaños de valores, se debe definir con un min y un maximo, segun se requiera
		-@Pattern(regexp = "EXP_REGULAR") : se usa para crear validaciones personalizadas a partir de expresiones regulares, con el atributo "regexp"
		-@SessionAttributes("[NOMBRE_OBJETO]") : se usa para la persistencia de datos, esta etiqueta permite que solo se alteren los campos modificados por el usuario y no actualice la base de datos con campos null, se le debe asignar un nombre que debe ser el mismo del objeto que estamos manipulando, todos los datos del objeto se guardaran en una sesion http
		
