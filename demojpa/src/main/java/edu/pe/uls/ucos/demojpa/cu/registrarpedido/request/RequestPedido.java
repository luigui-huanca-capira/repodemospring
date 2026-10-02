package edu.pe.uls.ucos.demojpa.cu.registrarpedido.request;
import java.util.List;

public record RequestPedido (List<RequestPedidoItem> items) {

    public record RequestPedidoItem(int idProducto, int cantidad, Double precioUnitario) {

    }
}