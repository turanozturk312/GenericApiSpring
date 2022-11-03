package com.example.elasticmanagerjson.gantv2.Service;

import com.example.elasticmanagerjson.gantv2.Entity.File;
import com.example.elasticmanagerjson.gantv2.Repository.FileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class FileService {
    private final FileRepository fileRepo;

    public File saveFile(MultipartFile file) throws Exception {
        String filename = StringUtils.cleanPath(file.getOriginalFilename());

        try {
            /*
            if (filename.contains("...")) {
                throw new FileSaveException(FileErrors.INVALID_FILE + filename);
            }

             */
            File model = new File(filename, file.getContentType(), file.getBytes());
            return fileRepo.save(model);

        } catch (Exception e) {
            //throw new FileSaveException(FileErrors.FILE_NOT_STORED, e);
            throw  new Exception(e);
        }
    }

    public File getFile(Long fileId) {
        return fileRepo.findById(fileId).get();
    }

    public File getFileByName(String fileName) {
        return fileRepo.findByFileName(fileName).get();
    }

    public List<File> getListOfFiles(){
        return fileRepo.findAll();
    }

    public Boolean deleteFile(Long fileId){
        fileRepo.deleteById(fileId);
        return true;
    }

    public File update(File file, Long fileId){
        return fileRepo.save(file);
    }

}
