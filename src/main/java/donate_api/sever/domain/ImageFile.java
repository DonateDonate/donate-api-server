package donate_api.sever.domain;

import donate_api.sever.domain.enums.Category;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

@Getter
@NoArgsConstructor
@Entity
public class ImageFile {

    @Id
    private Long id;
    private String mimeType;
    private long size;
    private String fileName;
    private String url;
    private String category;
    private byte[] file;

    @Builder
    public ImageFile(String mimeType, long size, String fileName, String url, String category, byte[] file) {
        this.mimeType = mimeType;
        this.size = size;
        this.fileName = fileName;
        this.url = url;
        this.category = category;
        this.file = file;
    }

    public ImageFile create(MultipartFile multipartFile, String category,String fileDir){
        String fileName = String.valueOf(UUID.randomUUID());
        String url = "/" +fileDir + "/" + category + "/" +fileName;
        String mimeType = null;

        Path savePath = Paths.get(url);
        try {
            mimeType = Files.probeContentType(savePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

       return ImageFile.builder()
                .mimeType(mimeType)
                .fileName(fileName)
                .url(url)
                .size(multipartFile.getSize())
                .category(category)
                .build();
    }
}
