package com.mduran.ninjareadertres;

public class Usuario {

    // Variables de Instancia
    String usuario = "";
    String clave = "";
    boolean genero = false;

    public Usuario(String usuario, String clave, boolean genero) {
        this.usuario = usuario;
        this.clave = clave;
        this.genero = genero;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public boolean isGenero() {
        return genero;
    }

    public void setGenero(boolean genero) {
        this.genero = genero;
    }
}
