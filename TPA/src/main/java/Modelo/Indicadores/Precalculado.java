package Modelo.Indicadores;

import DB.TiposDeRepositorios.TipoDeRepositorio;
import Modelo.Empresa.Empresa;
import Modelo.Empresa.Periodo;
import Modelo.Usuarios.Usuario;

import java.math.BigDecimal;

public class Precalculado implements TipoDeRepositorio {

    private long idUsuario;
    private String nombreUsuario;

    private long idIndicador;
    private String nombreIndicador;

    private long idEmpresa;
    private String nombreEmpresa;

    private long idPeriodo;
    private Integer anioPeriodo;

    BigDecimal valor;

    public Precalculado(Usuario usuario, Indicador indicador, Empresa empresa, Periodo periodo, BigDecimal valor){
        this.idUsuario = usuario.getId();
        this.nombreUsuario = usuario.getNombre();
        this.idIndicador = indicador.getId();
        this.nombreIndicador = indicador.getNombre();
        this.idEmpresa = empresa.getId();
        this.nombreEmpresa = empresa.getNombre();
        this.idPeriodo = periodo.getId();
        this.anioPeriodo = periodo.getAnio();
        this.valor = valor;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public long getIdIndicador() {
        return idIndicador;
    }

    public void setIdIndicador(long idIndicador) {
        this.idIndicador = idIndicador;
    }

    public String getNombreIndicador() {
        return nombreIndicador;
    }

    public void setNombreIndicador(String nombreIndicador) {
        this.nombreIndicador = nombreIndicador;
    }

    public long getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(long idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public long getIdPeriodo() {
        return idPeriodo;
    }

    public void setIdPeriodo(long idPeriodo) {
        this.idPeriodo = idPeriodo;
    }

    public Integer getAnioPeriodo() {
        return anioPeriodo;
    }

    public void setAnioPeriodo(Integer anioPeriodo) {
        this.anioPeriodo = anioPeriodo;
    }

    @Override
    public String getNombre() {
        return null;
    }
}
