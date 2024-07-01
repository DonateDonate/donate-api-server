package donate_api.sever.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WishTest {

    @DisplayName("title은 0글자 이상 20글자 이하이어야 한다")
    @Test
    public void wishTitleLengthTest(){
        //Arrange
        IllegalArgumentException actual_1 = null;
        IllegalArgumentException actual_2 = null;
        Member member  = makeMember();
        String title1 = "20글자이상20글자이상20글자이상20글자이상20글자이상20글자이상20글자이상20글자이상20글자이상20글자이상20글자이상20글자이상";
        String title2 = null;
        String content = "내용입니다.";
        Float totalDonationAmount = 123F;
        String imageUrl = "url";
        String startDate = "20200210";
        String endDate = "20200211";

        //Act
        try {
            Wish wish = Wish.builder()
                    .member(member)
                    .title(title1)
                    .content(content)
                    .totalDonationAmount(totalDonationAmount)
                    .imageUrl(imageUrl)
                    .startDate(startDate)
                    .endDate(endDate)
                    .build();
        }catch (IllegalArgumentException e){
            actual_1 = e;
        }

        //Act
        try {
            Wish wish = Wish.builder()
                    .member(member)
                    .title(title2)
                    .content(content)
                    .totalDonationAmount(totalDonationAmount)
                    .imageUrl(imageUrl)
                    .startDate(startDate)
                    .endDate(endDate)
                    .build();
        }catch (IllegalArgumentException e){
            actual_2 = e;
        }

        //Assert
        Assertions.assertThat(actual_1).isNotNull();
        Assertions.assertThat(actual_1).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThat(actual_1.getMessage()).isEqualTo("제목은 0글자 이상 20글자 이하이어야 합니다.");

        Assertions.assertThat(actual_2).isNotNull();
        Assertions.assertThat(actual_2).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThat(actual_2.getMessage()).isEqualTo("제목은 0글자 이상 20글자 이하이어야 합니다.");
    }

    @DisplayName("content는 0글자 이상 200글자 이하이어야 한다")
    @Test
    public void wishContentLengthTest(){
        //Arrange
        IllegalArgumentException actual_1 = null;
        IllegalArgumentException actual_2 = null;
        Member member  = makeMember();
        String title = "제목입니다";
        String content_1 = "내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.내용입니다.";
        String content_2 = null;
        Float totalDonationAmount = 123F;
        String imageUrl = "url";
        String startDate = "20200210";
        String endDate = "20200211";

        //Act
        try {
            Wish wish = Wish.builder()
                    .member(member)
                    .title(title)
                    .content(content_1)
                    .totalDonationAmount(totalDonationAmount)
                    .imageUrl(imageUrl)
                    .startDate(startDate)
                    .endDate(endDate)
                    .build();
        }catch (IllegalArgumentException e){
            actual_1 = e;
        }

        //Act
        try {
            Wish wish = Wish.builder()
                    .member(member)
                    .title(title)
                    .content(content_2)
                    .totalDonationAmount(totalDonationAmount)
                    .imageUrl(imageUrl)
                    .startDate(startDate)
                    .endDate(endDate)
                    .build();
        }catch (IllegalArgumentException e){
            actual_2 = e;
        }

        //Assert
        Assertions.assertThat(actual_1).isNotNull();
        Assertions.assertThat(actual_1).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThat(actual_1.getMessage()).isEqualTo("내용은 0글자 200글자 이하이어야 합니다.");

        Assertions.assertThat(actual_2).isNotNull();
        Assertions.assertThat(actual_2).isInstanceOf(IllegalArgumentException.class);
        Assertions.assertThat(actual_2.getMessage()).isEqualTo("내용은 0글자 200글자 이하이어야 합니다.");
    }



    private static Member makeMember(){
        return Member.builder()
                .name("kimjava")
                .birthDate("19990101")
                .account(new Account("은행이름","99999999999999"))
                .imageUrl("imgurlimgurlimgurlimgurl")
                .build();
    }
}