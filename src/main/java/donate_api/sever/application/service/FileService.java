package donate_api.sever.application.service;

import donate_api.sever.domain.ImageFile;
import donate_api.sever.domain.enums.Category;
import org.springframework.web.multipart.MultipartFile;

public class FileService {

    public ImageFile createImageFile(MultipartFile multipartFile, Category category, String filePath) {
        return new ImageFile().create(multipartFile,category,filePath);
    }
}
