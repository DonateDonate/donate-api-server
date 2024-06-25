package donate_api.sever.application.service;


import donate_api.sever.application.dto.request.CreateWishRequestDto;
import donate_api.sever.domain.Member;
import donate_api.sever.domain.Wish;
import donate_api.sever.domain.repositories.MemberRepository;
import donate_api.sever.domain.repositories.WishRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class WishService {
    private final WishRepository wishRepository;
    private final MemberRepository memberRepository;
    private final FileService fileService;

    @Transactional
    public void createWish(CreateWishRequestDto request, MultipartFile multipartFile) {
        String imageCategory = "wish";
        String imageUrl = fileService.createImageFile(multipartFile, imageCategory);

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));

        Wish wish = Wish.builder()
                .member(member)
                .title(request.getTitle())
                .content(request.getContent())
                .totalDonationAmount(request.getTotalDonationAmount())
                .imageUrl(imageUrl)
                .startDate(request.getStartDate())
                .endDate(request.getEndDate())
                .build();

        wishRepository.save(wish);
    }
}
