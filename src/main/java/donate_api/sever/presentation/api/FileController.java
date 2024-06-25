package donate_api.sever.presentation.api;


import donate_api.sever.application.service.FileService;
import lombok.AllArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class FileController {

    private final FileService fileService;

    @GetMapping("/images/{category}/{fileName}")
    public ResponseEntity<Object> images(@PathVariable("category") String category, @PathVariable("fileName") String fileName){

        InputStreamResource imageFile = fileService.getImageFile(fileName, category);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);

        return ResponseEntity.ok()
                .headers(headers)
                .body(imageFile);
    }
}
