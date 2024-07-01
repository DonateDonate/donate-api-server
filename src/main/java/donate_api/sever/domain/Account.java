package donate_api.sever.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@Embeddable
@NoArgsConstructor
public class Account {

    @Column(name = "account_name")
    private String name;

    @Column(name = "account_number")
    private String number;

    public Account(String name, String number) {
        this.name = name;
        this.number = number;
    }
}
