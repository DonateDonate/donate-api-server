package donate_api.sever.presentation.api;

import donate_api.sever.application.dto.request.CreateImageFileRequestDto;
import donate_api.sever.application.service.FileService;
import donate_api.sever.domain.enums.Category;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
public class TestController {
    private final FileService fileService;

    @PostMapping("/upload")
    public void test(@RequestPart MultipartFile multipartFile, @RequestPart CreateImageFileRequestDto request){
        fileService.createImageFile(multipartFile, request.getCategory(),request.getFilePath());
    }
}
