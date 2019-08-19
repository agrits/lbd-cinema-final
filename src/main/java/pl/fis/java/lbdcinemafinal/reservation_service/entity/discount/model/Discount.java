package pl.fis.java.lbdcinemafinal.reservation_service.entity.discount.model;

import pl.fis.java.lbdcinemafinal.reservation_service.entity.ticket.model.Ticket;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/**
 * Represents the discount a user can get on a ticket.
 */
@Entity
@Table(name = "discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20, message = "discount name can be up to 20 characters long")
    @Column(nullable = false)
    private String name;

    @NotNull
    @Column(nullable = false)
    private Double amount;

    @OneToMany(mappedBy = "discount", fetch = FetchType.LAZY)
    private Set<Ticket> tickets;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Set<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(Set<Ticket> tickets) {
        this.tickets = tickets;
    }
}
