package domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_customers")
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Builder
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true, length = 14)
    private String cpf;

    private String phone;
}