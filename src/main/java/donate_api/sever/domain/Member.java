package donate_api.sever.domain;

import jakarta.persistence.*;

@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String birthDate;

    @Embedded
    private Account account;

    private String imageUrl;
}
