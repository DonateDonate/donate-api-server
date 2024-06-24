package donate_api.sever.presentation.api;

import donate_api.sever.application.dto.request.CreateImageFileRequestDto;
import donate_api.sever.application.service.FileService;
import donate_api.sever.domain.enums.Category;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Slf4j
@AllArgsConstructor
@RestController
public class TestController {
    private final FileService fileService;

    @PostMapping("/upload")
    public void test(@RequestPart("fileData") MultipartFile multipartFile, @RequestPart("request") CreateImageFileRequestDto request){

        log.info(multipartFile.getContentType());
        log.info(multipartFile.getOriginalFilename());
        log.info(request.getFilePath());
        fileService.createImageFile(multipartFile, request.getCategory(),request.getFilePath());
    }
}
