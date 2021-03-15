# Rel Designs
## [1 - Descripcion General](#Descripcion)
## [2 - Entidades Principales](#Entidades)
## [3 - Descripción Servicio Público](#Servicio)
## [3 - Descripción Servicio Privado](#Servicio)
## [4 - Autor](#Autor)
## [5 - Capturas De Pantalla](#Capturas)
## [6 - Diagramas](#Diagramas)

## 1 - :computer: Descripción general <a name="descripcion">
Se desarrollará una aplicación web destinada a la venta de cuadros en una galería de arte, los usuarios podrán navegar por las diferentes categorías de la galería sin necesidad de registrarse. Para formalizar el pedido deberán iniciar sesión y completar su compra.

## 2 - :busts_in_silhouette: Entidades principales <a name="Entidades">
- Items: Cada producto llevará asociado un identificador único, y contendrá datos específicos que lo describan junto al número de stock. 
- Client: Cada ususario tendrá su propio identificador que será unico y otros datos como su dirección y datos personales. El usuario podrá realizar de 0 a N Orders.
- Orders: esta entidad tendrá asociada un número de items y un usuario. Tambien contendrá el coste final total.
- Category: esta entidad llevará asosciado un identificador único y contendrá de 0 a N items que se recojan en ella.
## 3 - :lock: Descripción Servicio Público<a name="Servicio">
- Los usuarios podrán navegar por las distintatas plantillas html y buscar cuadros.
## 4 - :lock: Descripción Servicio Privado
  - Para ver el precio y realizar un pedido, el usuario deberá acceder con sus credenciales.
  - Cuando un usuario realiza un pedido se le enviará un correo electrónico con un pdf donde se incluirá el resumen de su pedido.
  - Servicio de pago online.
## 5 - :trollface: Autor <a name="Autor">
#### Juan Carlos Flores Angulo
- jc.flores@alumnos.urjc.es
- GII + GIC 135
- ##### Github: [FinalBossRel](https://github.com/FinalBossRel)
## 6 - :book: Capturas De Pantalla <a name="Capturas">
  
## 7 - :pencil: Diagramas <a name="Diagramas">
# Diagrama De Navegación
## Diagrama de clases UML
## Diagrama E/R



