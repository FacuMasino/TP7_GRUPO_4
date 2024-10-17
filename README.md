# TP6_GRUPO_4

## Compilación

### Java Development Kit

&nbsp;
El Java Development Kit (JDK) incluye el compilador de Java, el Java Runtime Environment (JRE) y otras herramientas necesarias.
Se recomienda instalar la última versión disponible (o la versión más reciente soportada) desde el [sitio oficial de Oracle](https://www.oracle.com/cis/java/technologies/downloads/).

### Apache Tomcat

&nbsp;
Se requiere Apache Tomcat para ejecutar aplicaciones web basadas en Java.
Se recomienda instalar la versión 8.5, que puede ser descargada desde el [repositorio de la universidad Unicamp](https://ftp.unicamp.br/pub/apache/tomcat/tomcat-8/v8.5.73/bin/).

&nbsp;
La versión 9 del [sitio oficial de Apache Tomcat](https://tomcat.apache.org/download-90.cgi) no fue probada pero podría ser una alternativa viable.
Versiones más recientes pueden tener problemas de compatibilidad con versiones antiguas del JDK, debido a cambios en los nombres de algunas bibliotecas que necesitan ser importadas en el código fuente.

### MySQL Connector

&nbsp;
Es necesario descargar MySQL Connector (JDBC) desde el [sitio oficial de MySQL](https://dev.mysql.com/downloads/).

&nbsp;
El archivo que indica la ruta de MySQL Connector no está siendo versionado para que no haya que configurar la ubicación del mismo cada vez que otro contribuidor la cambia.
Es necesario crear en el directorio raíz un archivo llamado `.classpath` (sin extensión) que contenga el siguiente código reemplazando `/tu/ruta/al/mysqlconnector.jar` por la ubicación correspondiente.

```xml
<?xml version="1.0" encoding="UTF-8"?>
<classpath>
	<classpathentry kind="src" path="src"/>
	<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/jdk-1.8">
		<attributes>
			<attribute name="owner.project.facets" value="java"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="con" path="org.eclipse.jst.server.core.container/org.eclipse.jst.server.tomcat.runtimeTarget/Apache Tomcat v8.5">
		<attributes>
			<attribute name="owner.project.facets" value="jst.web"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="con" path="org.eclipse.jst.j2ee.internal.web.container"/>
	<classpathentry kind="con" path="org.eclipse.jst.j2ee.internal.module.container"/>
	<classpathentry kind="lib" path="/tu/ruta/al/mysqlconnector.jar">
		<attributes>
			<attribute name="org.eclipse.jst.component.dependency" value="/WEB-INF/lib"/>
		</attributes>
	</classpathentry>
	<classpathentry kind="output" path="build/classes"/>
</classpath>
```

&nbsp;
Podés dejar tu ruta acá abajo anotada para futura referencia:

- Maxi: `/Users/mrmalvicino/eclipse-workspace/mysql-connector-j-9.0.0/mysql-connector-j-9.0.0.jar`
- Facu: `C:/eclipse/facu-libs/mysql-connector-java-5.1.47-bin.jar`

### Propiedades de conexión

&nbsp;
Se deben configurar las credenciales de acceso a la base de datos.
Para ello, hay que crear un archivo llamado `config.properties` en el directorio src con el siguiente código, reemplazando `tupassword` por la contraseña de la base de datos.

```properties
# Dirección del host de la base de datos
db.host=jdbc:mysql://localhost:3306/

# Usuario de la base de datos
db.user=root

# Contraseña del usuario
db.pass=tupassword

# Nombre de la base de datos
db.name=SegurosGroup
```
