package MODELO;

/**
 *
 * @author DragonKael
 */
public class musuario {
    int id_usuario;
    String nombre_usuario,
	nombre ,
	apaterno ,
        amaterno ,
	email ,
	contrasenia,
        creado_en; 
    boolean es_activo ,
	es_administrador;    

    public musuario() {
    }

    public musuario(int id_usuario, String nombre_usuario, String nombre, String apaterno, String amaterno, String email, String contrasenia, String creado_en, boolean es_activo, boolean es_administrador) {
        this.id_usuario = id_usuario;
        this.nombre_usuario = nombre_usuario;
        this.nombre = nombre;
        this.apaterno = apaterno;
        this.amaterno = amaterno;
        this.email = email;
        this.contrasenia = contrasenia;
        this.creado_en = creado_en;
        this.es_activo = es_activo;
        this.es_administrador = es_administrador;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApaterno() {
        return apaterno;
    }

    public void setApaterno(String apaterno) {
        this.apaterno = apaterno;
    }

    public String getAmaterno() {
        return amaterno;
    }

    public void setAmaterno(String amaterno) {
        this.amaterno = amaterno;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getCreado_en() {
        return creado_en;
    }

    public void setCreado_en(String creado_en) {
        this.creado_en = creado_en;
    }

    public boolean isEs_activo() {
        return es_activo;
    }

    public void setEs_activo(boolean es_activo) {
        this.es_activo = es_activo;
    }

    public boolean isEs_administrador() {
        return es_administrador;
    }

    public void setEs_administrador(boolean es_administrador) {
        this.es_administrador = es_administrador;
    }
}
