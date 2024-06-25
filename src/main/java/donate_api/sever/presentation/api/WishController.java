package donate_api.sever.presentation.api;

import donate_api.sever.application.dto.request.CreateImageFileRequestDto;
import donate_api.sever.application.dto.request.CreateWishRequestDto;
import donate_api.sever.application.service.WishService;
import donate_api.sever.domain.ImageFile;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
public class WishController {
    private final WishService wishService;

    @PostMapping("/wish")
    public ResponseEntity<Object> wishCreate(@RequestPart("imageFile") MultipartFile multipartFile, @RequestPart("wishInfo") CreateWishRequestDto request){
        wishService.createWish(request,multipartFile);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
