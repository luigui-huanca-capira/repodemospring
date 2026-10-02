package edu.pe.uls.ucos.demojpa.dominio.entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sec_pedido")
    @SequenceGenerator(
        name = "sec_pedido",
        sequenceName = "sec_pedido",
        allocationSize = 1
    )
    private Integer id;

    @Column(name = "fecha_pedido", nullable = false)
    private LocalDateTime fechaPedido;

    private double total;

    @OneToMany(
        mappedBy = "pedido",
        cascade = CascadeType.ALL,
        orphanRemoval = true
    )
    private List<PedidoItem> items = new ArrayList<>();

    @PrePersist
    protected void prePersist() {
        if (fechaPedido == null) {
            fechaPedido = LocalDateTime.now();
        }
    }

    public void agregarItem(Producto producto, int cantidad, Double precioUnitario) {
        PedidoItem item = new PedidoItem();
        item.setPedido(this);
        item.setProducto(producto);
        item.setPrecioUnitario(precioUnitario);
        //item.setPedido(this);
        item.setCantidad(cantidad);
        items.add(item);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDateTime fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<PedidoItem> getItems() {
        return items;
    }

    public void setItems(List<PedidoItem> items) {
        this.items = items;
    }
}