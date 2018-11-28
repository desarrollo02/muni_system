/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author diaz
 */
public class FormEnableContribuyente {
    
    private boolean tipoPersona;
    private boolean cedula;
    private boolean nombres;
    private boolean apellidos;
    private boolean ruc;
    private boolean empresa;
    private boolean barrio;
    private boolean direccion;
    private boolean nroCasa;
    private boolean lineaBaja;
    private boolean celular;
    private boolean email;
    private boolean botonNuevo;
    private boolean botonBuscar;
    private boolean botonEditar;
    private boolean botonCacelar;
    private boolean botonGuardar;

    public void formContribuyenteBotones(boolean botonNuevo, boolean botonBuscar, boolean botonEditar, boolean botonCacelar, boolean botonGuardar) {
        this.botonNuevo = botonNuevo;
        this.botonBuscar = botonBuscar;
        this.botonEditar = botonEditar;
        this.botonCacelar = botonCacelar;
        this.botonGuardar = botonGuardar;
    }

    
    
    public void formContribuyenteCampos(boolean tipoPersona, boolean cedula, boolean nombres, boolean apellidos, boolean ruc, boolean empresa, boolean barrio, boolean direccion, boolean nroCasa, boolean lineaBaja, boolean celular, boolean email) {
        this.tipoPersona = tipoPersona;
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.ruc = ruc;
        this.empresa = empresa;
        this.barrio = barrio;
        this.direccion = direccion;
        this.nroCasa = nroCasa;
        this.lineaBaja = lineaBaja;
        this.celular = celular;
        this.email = email;
    }
    
    

    public boolean isTipoPersona() {
        return tipoPersona;
    }

    public void setTipoPersona(boolean tipoPersona) {
        this.tipoPersona = tipoPersona;
    }

    public boolean isCedula() {
        return cedula;
    }

    public void setCedula(boolean cedula) {
        this.cedula = cedula;
    }

    public boolean isNombres() {
        return nombres;
    }

    public void setNombres(boolean nombres) {
        this.nombres = nombres;
    }

    public boolean isApellidos() {
        return apellidos;
    }

    public void setApellidos(boolean apellidos) {
        this.apellidos = apellidos;
    }

    public boolean isRuc() {
        return ruc;
    }

    public void setRuc(boolean ruc) {
        this.ruc = ruc;
    }

    public boolean isEmpresa() {
        return empresa;
    }

    public void setEmpresa(boolean empresa) {
        this.empresa = empresa;
    }

    public boolean isBarrio() {
        return barrio;
    }

    public void setBarrio(boolean barrio) {
        this.barrio = barrio;
    }

    public boolean isDireccion() {
        return direccion;
    }

    public void setDireccion(boolean direccion) {
        this.direccion = direccion;
    }

    public boolean isNroCasa() {
        return nroCasa;
    }

    public void setNroCasa(boolean nroCasa) {
        this.nroCasa = nroCasa;
    }

    public boolean isLineaBaja() {
        return lineaBaja;
    }

    public void setLineaBaja(boolean lineaBaja) {
        this.lineaBaja = lineaBaja;
    }

    public boolean isCelular() {
        return celular;
    }

    public void setCelular(boolean celular) {
        this.celular = celular;
    }

    public boolean isEmail() {
        return email;
    }

    public void setEmail(boolean email) {
        this.email = email;
    }

    public boolean isBotonNuevo() {
        return botonNuevo;
    }

    public void setBotonNuevo(boolean botonNuevo) {
        this.botonNuevo = botonNuevo;
    }

    public boolean isBotonBuscar() {
        return botonBuscar;
    }

    public void setBotonBuscar(boolean botonBuscar) {
        this.botonBuscar = botonBuscar;
    }

    public boolean isBotonEditar() {
        return botonEditar;
    }

    public void setBotonEditar(boolean botonEditar) {
        this.botonEditar = botonEditar;
    }

    public boolean isBotonCacelar() {
        return botonCacelar;
    }

    public void setBotonCacelar(boolean botonCacelar) {
        this.botonCacelar = botonCacelar;
    }

    public boolean isBotonGuardar() {
        return botonGuardar;
    }

    public void setBotonGuardar(boolean botonGuardar) {
        this.botonGuardar = botonGuardar;
    }
}
