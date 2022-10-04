
package com.sistemas.exmenes.entidades;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


//La anotacion Entity sirve para que la tabla sea una entidad y se mapee a la BD
 @Entity
public class UsuarioRol {
   
   //Indica al campo que va ser unico
   @Id 
   
   //Indica que cada ves que se haga un nuevo registro sea autoicrementable
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long usuarioRolId;
   
   //Relacion de "Uno a muchos"
   @ManyToOne(fetch = FetchType.EAGER)
   private Usuario usuario;
   
   @ManyToOne
   private Rol rol;

    public Long getUsuarioRolId() {
        return usuarioRolId;
    }

    public void setUsuarioRolId(Long usuarioRolId) {
        this.usuarioRolId = usuarioRolId;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
   
   
    
}
