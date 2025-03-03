package hello.upload.domain;

import lombok.Data;

@Data
public class UploadFile {

    private String uploadFileName; // 고객이 업로드 한 파일명
    private String storeFileName; // 서버 내부에서 관리하는 파일명

    public UploadFile(String originalFilename, String storeFileName) {
        this.uploadFileName = originalFilename;
        this.storeFileName = storeFileName;
    }
}
