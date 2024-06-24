package donate_api.sever.infra.persistence;

import donate_api.sever.domain.repositories.WishRepository;
import donate_api.sever.infra.persistence.jpa.WishJpaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WishRepositoryImpl implements WishRepository {
    private final WishJpaRepository wishJpaRepository;
}
