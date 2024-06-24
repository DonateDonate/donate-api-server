package donate_api.sever.application.dto.request;

import lombok.Getter;

@Getter
public class CreateWishRequestDto {
    private Long memberId;
    private String title;
    private String content;
    private Float totalDonationAmount;
    private String imageUrl;
    private String startDate;
    private String endDate;
}
