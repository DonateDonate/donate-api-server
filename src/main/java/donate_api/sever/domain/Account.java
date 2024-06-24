package donate_api.sever.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Embeddable // 값 타입 정의
@NoArgsConstructor // 기본 생성자 필수
public class Account {

    @Column(name = "account_name")
    private String name;

    @Column(name = "account_number")
    private String number;
}
