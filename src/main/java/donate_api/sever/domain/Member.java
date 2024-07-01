package donate_api.sever.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Getter
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

    @OneToMany(mappedBy = "member")
    private List<Wish> wishList = new ArrayList<>();

    @Builder
    public Member(String name, String birthDate, Account account, String imageUrl) {
        this.name = name;
        this.birthDate = birthDate;
        this.account = account;
        this.imageUrl = imageUrl;
    }
}
