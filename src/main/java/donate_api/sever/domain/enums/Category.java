package donate_api.sever.domain.enums;

import lombok.Getter;

@Getter
public enum Category {
    MEMBER("member"),
    WISH("wish");

    private String value;

    Category(String value) {
        this.value = value;
    }
}
