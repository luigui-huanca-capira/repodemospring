package edu.pe.uls.ucos.demojpa.cu.registrarpedido.response;
import java.util.List;

public record ResponsePedido(int idPedido, List<ResponsePedidoItem> items) {

    public record ResponsePedidoItem(String nombre, int cantidad) {}
}
