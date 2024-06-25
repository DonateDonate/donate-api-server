package donate_api.sever.application.service;

import donate_api.sever.domain.ImageFile;
import donate_api.sever.domain.enums.Category;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

@RequiredArgsConstructor
public class FileService {

    @Value("${file.base.url}")
    private String fileBaseUrl;

    @Value("${file.dir}")
    private String fileDir;

    public String createImageFile(MultipartFile multipartFile, String category) {
        ImageFile imageFile = new ImageFile().create(multipartFile, category, fileDir);
        String imageFileUrl = fileBaseUrl  + imageFile.getUrl();
        try {
            byte[] bytes = multipartFile.getBytes();
            File file = new File(imageFileUrl);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        }catch (IOException e){
            throw new IllegalArgumentException("이미지를 저장하지 못했습니다.");
        }
        return imageFile.getUrl();
    }

    public InputStreamResource getImageFile(String fileName, String category){
        String url = fileBaseUrl + "/" + fileDir + "/" + category + "/" + fileName;
        try {
            File imageFile = new File(url);
            FileInputStream inputStream = new FileInputStream(imageFile);
            return new InputStreamResource(inputStream);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        throw new IllegalArgumentException();
    }
}
