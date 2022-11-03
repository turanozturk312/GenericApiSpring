package com.example.elasticmanagerjson.gantv2.Controller;

import com.example.elasticmanagerjson.APIConstants;
import com.example.elasticmanagerjson.EafadResponse;
import com.example.elasticmanagerjson.MessageCodeEnum;
import com.example.elasticmanagerjson.gantv2.Entity.File;
import com.example.elasticmanagerjson.gantv2.Service.FileService;
import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping(APIConstants.API_URL + APIConstants.GANTT_FILES)
@RequiredArgsConstructor
@CrossOrigin
public class FileController {

    private final FileService fileService;

    @PostMapping("/Upload")
    @CrossOrigin
    public Map<String,Object> uploadFile(@RequestParam("files[]") MultipartFile file) throws Exception {
        File model = fileService.saveFile(file);
        String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath().path(APIConstants.API_URL + APIConstants.GANTT_FILES + "/Download/").
                path(model.getId().toString()).toUriString();
        Map<String,Object> fileResponse = new HashMap<>();
        fileResponse.put("id",model.getId());
        fileResponse.put("name",model.getFileName());
        fileResponse.put("downloadUrl",fileUri);
        return fileResponse;
    }

    @GetMapping("/Download/{fileId}")
    public ResponseEntity<Resource> downloadFile(@PathVariable Long fileId) {
        File model = fileService.getFile(fileId);
        return ResponseEntity.ok().
                header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + model.getFileName() + "\"").
                body(new ByteArrayResource(model.getFileData()));
    }

    @DeleteMapping("/Delete/{fileId}")
    public EafadResponse<Boolean> deleteFile(@PathVariable Long fileId){
        return new EafadResponse<>(
                HttpStatus.OK,
                MessageCodeEnum.INFO,
                Arrays.asList("File Deleted"),
                fileService.deleteFile(fileId)
        );
    }

}
