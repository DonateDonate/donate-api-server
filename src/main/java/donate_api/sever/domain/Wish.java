package donate_api.sever.domain;

import io.micrometer.common.util.StringUtils;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Wish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Member member;

    private String title;

    private String content;

    private Float totalDonationAmount;

    private String imageUrl;

    private String startDate;

    private String endDate;

    @OneToMany(mappedBy = "wish")
    private List<Donate> donateList = new ArrayList<>();

    public void addDonateList(Donate donate){
        donateList.add(donate);
    }

    @Builder
    public Wish(Member member,String title, String content, Float totalDonationAmount, String imageUrl, String startDate, String endDate) {

        if(StringUtils.isBlank(title) || title.length() >20){
            throw new IllegalArgumentException("제목은 0글자 이상 20글자 이하이어야 합니다.");
        }

        if(StringUtils.isBlank(content) || content.length() > 200){
            throw new IllegalArgumentException("내용은 0글자 200글자 이하이어야 합니다.");
        }

        if(totalDonationAmount == null){
            throw new NullPointerException("총 모금액은 null이어서는 안됩니다.");
        }

        if(StringUtils.isBlank(imageUrl)){
            throw new NullPointerException("이미지는 null이어서는 안됩니다.");
        }

        if(StringUtils.isBlank(startDate) || StringUtils.isBlank(endDate)){
            throw new NullPointerException("기간은 null이어서는 안됩니다.");
        }

        this.member = member;
        this.title = title;
        this.content = content;
        this.totalDonationAmount = totalDonationAmount;
        this.imageUrl = imageUrl;
        this.startDate = startDate;
        this.endDate = endDate;
    }
}
