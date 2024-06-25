package donate_api.sever.application.service;

import donate_api.sever.domain.ImageFile;
import donate_api.sever.domain.enums.Category;
import org.springframework.core.io.InputStreamResource;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;

public class FileService {

    public String createImageFile(MultipartFile multipartFile, String category) {
        String filePath = "/Users/mac-00220/sanha/image";
        ImageFile imageFile = new ImageFile().create(multipartFile, category, filePath);

        try {
            byte[] bytes = multipartFile.getBytes();
            File file = new File(imageFile.getUrl());
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bytes);
            fileOutputStream.close();
        }catch (IOException e){
            throw new IllegalArgumentException("이미지를 저장하지 못했습니다.");
        }
        return imageFile.getUrl();
    }

    public InputStreamResource getImageFile(String fileName, String category){
        String filePath = "/Users/mac-00220/sanha/image";
        String url = filePath + "/" + category + "/" + fileName;
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
