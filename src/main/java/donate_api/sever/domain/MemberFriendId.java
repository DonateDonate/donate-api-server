package donate_api.sever.domain;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Embeddable
public class MemberFriendId {

    @MapsId
    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private Long friendId;
}
