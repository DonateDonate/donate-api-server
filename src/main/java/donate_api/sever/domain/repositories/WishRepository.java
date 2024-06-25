package donate_api.sever.domain.repositories;

import donate_api.sever.domain.Wish;

public interface WishRepository {
    void save(Wish wish);
}
