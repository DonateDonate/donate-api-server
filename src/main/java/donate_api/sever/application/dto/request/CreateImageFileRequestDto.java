package donate_api.sever.application.dto.request;

import donate_api.sever.domain.enums.Category;
import lombok.Getter;

@Getter
public class CreateImageFileRequestDto {
    private Category category;
    private String filePath;
}
