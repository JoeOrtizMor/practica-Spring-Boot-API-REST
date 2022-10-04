
package com.sistemas.exmenes.entidades;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//La anotacion Entity sirve para que la tabla sea una entidad y se mapee a la BD
@Entity

//Nombre de la tabla
@Table(name = "roles")
public class Rol {
    
    //Indica al campo que va ser unico
    @Id
    private Long rolId;
    
    private String nombre;
    
    private String rolNombre;
    
    //LAZY: Para poder obtener roles, se tiene que indicar
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "rol")
    private Set<UsuarioRol> usuarioRoles = new HashSet<>();
    
    public Rol(){
        
    }
    
    public Rol(Long rolId, String rolNombre){
         this.rolId = rolId;
        this.rolNombre = rolNombre;
    }

    public Long getRolId() {
        return rolId;
    }

    public void setRolId(Long rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<UsuarioRol> getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(Set<UsuarioRol> usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    public String getRolNombre() {
        return rolNombre;
    }

    public void setRolNombre(String rolNombre) {
        this.rolNombre = rolNombre;
    }
    
    
}
