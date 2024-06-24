package donate_api.sever.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    private String name;
    private String title;
    private String content;
    private Float totalDonationAmount;
    private String imageUrl;
    private String startDate;
    private String endDate;
}
