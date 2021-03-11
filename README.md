# Rel Designs
## [1 - Descripcion General](#Descripcion)
## [2 - Entidades Principales](#Entidades)
## [3 - Descripción Servicio Interno](#Servicio)
## [4 - Autor](#Autor)
## [5 - Capturas De Pantalla](#Capturas)
## [6 - Diagramas](#Diagramas)

## 1 - :computer: Descripción general <a name="descripcion">
Se desarrollará una aplicación web destinada a la venta de comida latinoamericana a domicilio, en la que los usuarios podrán navegar por las diferentes categorías de las comidas ofertadas sin necesidad de registrarse. Para formalizar el pedido deberán iniciar sesión con su usuario y completar su compra.

## 2 - :busts_in_silhouette: Entidades principales <a name="Entidades">
- Producto: Cada producto llevará asociado un identificador único, y contendrá datos específicos que lo describan junto al número de stock. 
- Cliente: Cada ususario tendrá su propio nombre de usuario, que será unico para cada uno, a parte de otros datos como su dirección y otros datos personales. El usuario podrá realizar de 0 a N pedidos.
- Pedido: esta entidad tendrá asociada un numero de productos y un usuario, asociandolos. Esta entidad tambien contendrá el coste final total.
- Categoría de productos: esta entidad llevará asosciado un identificador único y contendrá de 1 a N productos que se recojan en ella.
## 3 - :lock: Descripción servicio interno <a name="Servicio">
- Cuando el usuario hace un pedido se le enviará un correo electrónico con un pdf donde se incluirá el resumen de su pedido.
- Servicio de pago online.

## 4 - :trollface: Autor <a name="Autor">
#### Juan Carlos Flores Angulo
- jc.flores@alumnos.urjc.es
- GII + GIC 135
- ##### Github: [FinalBossRel](https://github.com/FinalBossRel)
## 5 - :book: Capturas De Pantalla <a name="Capturas">
## 6 - :pencil: Diagramas <a name="Diagramas">
# Diagrama De Navegación
## Diagrama de clases UML
## Diagrama E/R



