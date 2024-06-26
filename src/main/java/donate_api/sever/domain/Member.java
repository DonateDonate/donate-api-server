package donate_api.sever.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
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

    public Member(String name) {
        this.name = name;
    }
}
