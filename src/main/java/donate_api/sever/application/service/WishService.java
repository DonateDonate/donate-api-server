package donate_api.sever.application.service;


import donate_api.sever.application.dto.request.CreateWishRequestDto;
import donate_api.sever.domain.Wish;
import donate_api.sever.domain.repositories.WishRepository;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
public class WishService {
    private final WishRepository wishRepository;

    public void createWish(CreateWishRequestDto request) {
    }
}
