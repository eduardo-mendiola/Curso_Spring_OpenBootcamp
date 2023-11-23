## Spring Boot

Proyecto Spring Boot con las dependencias / starters:

Starters para persistencia:
* H2
* Spring Data JPA

Starters para web:
* Spring Web
* Spring Boot Dev tools

Aplicación API REST con acceso a base de datos para persistir la información.

El acceso se puede realizar desde Postman o Navegador.

## Entidad Book

1. Book
2. BookRepository
3. BookController
   1. Buscar todos los libros
   2. Buscar un solo libro
   3. Crear un nuevo libro
   4. Actualizar un libro existente
   5. Borrar un libro
   6. Borrar todos los libros



## Algunas anotaciones comunes de Springdoc con OpenAPI Swagger:

1. **@OpenAPIDefinition:**
   - Descripción: Se utiliza para personalizar la definición OpenAPI global.
   - Ejemplo:
     ```java
     @OpenAPIDefinition(info = @Info(title = "My API", version = "1.0"))
     ```

2. **@Operation:**
   - Descripción: Permite personalizar las operaciones (métodos) en el controlador.
   - Ejemplo:
     ```java
     @Operation(summary = "Get all books", description = "Get a list of all books")
     ```

3. **@Parameter:**
   - Descripción: Define parámetros para operaciones específicas.
   - Ejemplo:
     ```java
     @Parameter(name = "id", description = "Book ID", required = true)
     ```

4. **@ApiResponse:**
   - Descripción: Define las respuestas de una operación.
   - Ejemplo:
     ```java
     @ApiResponse(responseCode = "200", description = "Successful operation")
     ```

5. **@RequestBody:**
   - Descripción: Define un cuerpo de solicitud para una operación.
   - Ejemplo:
     ```java
     @RequestBody(description = "Book details", required = true)
     ```

6. **@Hidden:**
   - Descripción: Oculta la operación en la documentación Swagger.
   - Ejemplo:
     ```java
     @Hidden
     ```

7. **@SecurityRequirement:**
   - Descripción: Especifica los requisitos de seguridad para una operación.
   - Ejemplo:
     ```java
     @SecurityRequirement(name = "bearerAuth")
     ```

8. **@Tag:**
   - Descripción: Asocia operaciones con etiquetas personalizadas.
   - Ejemplo:
     ```java
     @Tag(name = "Books", description = "API for book operations")
     ```

9. **@Operation:**
   - Descripción: Utilizada para personalizar la información de una operación en la documentación Swagger.
   - Ejemplo:
     ```java
     @Operation(summary = "Obtener todos los libros", description = "Recupera la lista completa de libros.")
     ```
10. **@PathVariable:**
    - Descripción: Utilizada para mapear variables de la URI a parámetros de método en un controlador.
    - Ejemplo:
      ```java
      @GetMapping("/libro/{id}")
      public ResponseEntity<Libro> obtenerLibroPorId(@PathVariable Long id) {
          // ...
      }
      ```

11. **@RequestBody:**
    - Descripción: Indica que un parámetro de método debería estar vinculado al cuerpo de la solicitud.
    - Ejemplo:
      ```java
      @PostMapping("/libro")
      public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro) {
          // ...
      }
      ```

12. **@ResponseStatus:**
    - Descripción: Anotación que se puede utilizar en una clase o en un método para indicar el código de estado HTTP que se debe devolver.
    - Ejemplo:
      ```java
      @ResponseStatus(HttpStatus.CREATED)
      @PostMapping("/libro")
      public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro) {
          // ...
      }
      ```

13. **@RestController:**
    - Descripción: Una anotación compuesta que combina @Controller y @ResponseBody, que se utiliza para definir controladores REST.
    - Ejemplo:
      ```java
      @RestController
      @RequestMapping("/api")
      public class LibroController {
          // ...
      }
      ```



### Replace swagger 2 annotations with swagger 3 annotations (it is already included with springdoc-openapi-starter-webmvc-ui dependency). Package for swagger 3 annotations is io.swagger.v3.oas.annotations.

@Api → @Tag

@ApiIgnore → @Parameter(hidden = true) or @Operation(hidden = true) or @Hidden

@ApiImplicitParam → @Parameter

@ApiImplicitParams → @Parameters

@ApiModel → @Schema

@ApiModelProperty(hidden = true) → @Schema(accessMode = READ_ONLY)

@ApiModelProperty → @Schema

@ApiOperation(value = "foo", notes = "bar") → @Operation(summary = "foo", description = "bar")

@ApiParam → @Parameter

@ApiResponse(code = 404, message = "foo") → @ApiResponse(responseCode = "404", description = "foo")