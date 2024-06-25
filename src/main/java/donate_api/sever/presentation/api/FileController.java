package donate_api.sever.presentation.api;


import donate_api.sever.application.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class FileController {

    private final FileService fileService;

    @GetMapping("/images")
    public ResponseEntity<Object> images(@RequestParam("fileName") String fileName, @RequestParam("category") String category){

        InputStreamResource imageFile = fileService.getImageFile(fileName, category);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return ResponseEntity.ok()
                .headers(headers)
                .body(imageFile);
    }
}
