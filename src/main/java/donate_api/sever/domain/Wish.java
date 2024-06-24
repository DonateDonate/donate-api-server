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


    public Wish(Member member, String name, String title, String content, Float totalDonationAmount, String imageUrl, String startDate, String endDate) {
        this.member = member;
        this.name = name;
        this.title = title;
        this.content = content;
        this.totalDonationAmount = totalDonationAmount;
        this.imageUrl = imageUrl;
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
