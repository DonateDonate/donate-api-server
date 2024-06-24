package donate_api.sever.domain;


import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.Getter;

@Getter
@Entity
public class MemberFriend {
    @EmbeddedId
    private MemberFriendId id;
}
