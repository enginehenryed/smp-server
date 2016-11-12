package net.swmaestro.portal.attachment.util;

import net.swmaestro.portal.common.util.CommonUtil;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by junha on 2016. 10. 15..
 */
@Component("attachmentUtil")
public class AttachmentUtil {
    private static String filePath = "";


    public static String storeFile(MultipartFile multipartFile, String fileExtension) throws IOException {
        String storedFileName = CommonUtil.getRandomString();

        if (fileExtension != null && fileExtension.length() > 0) {
            storedFileName = String.join(".", storedFileName, fileExtension);
        }

        File file = new File(filePath, storedFileName);
        multipartFile.transferTo(file);

        return storedFileName;
    }

    public static String storeFile(MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        String storedFileName = CommonUtil.getRandomString();

        if (fileName.contains(".")) {
            String fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
            storedFileName = String.join(".", storedFileName, fileExtension);
        }

        File file = new File(filePath, storedFileName);
        multipartFile.transferTo(file);

        return storedFileName;
    }

    public static FileSystemResource getFileSystemResource(String fileName) {
        return new FileSystemResource(new File(filePath, fileName));
    }


    public static String getFilePath() {
        return filePath;
    }

    public static void setFilePath(String filePath) {
        AttachmentUtil.filePath = filePath;
    }
}
