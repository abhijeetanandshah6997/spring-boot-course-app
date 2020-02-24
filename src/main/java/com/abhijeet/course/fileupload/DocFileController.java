package com.abhijeet.course.fileupload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class DocFileController {

    @Autowired
    private DocFileService docFileService;

    @RequestMapping("/documentFiles")
    public List<DocFile> getAllDocFiles(){
        return docFileService.getAllDocFiles();
    }

    @RequestMapping("/documentFiles/{id}")
    public DocFile getDocFile(@PathVariable int id){
        return docFileService.getDocFile(id).get();
    }

    @PostMapping("/uploadFile")
    public DocFileUploadResponse uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = docFileService.storeFile(file);
        String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/downloadFile/")
                .path(fileName)
                .toUriString();
        DocFile docFileStatus = docFileService.addDocFile(new DocFile(fileName, fileDownloadUri, file.getSize(), file.getContentType()));
        String fileDBStatus;
        if (docFileStatus.getId() > 0) {
            fileDBStatus = "success";
        }
        else {
            fileDBStatus = "failure";
        }
        return new DocFileUploadResponse(fileName, fileDownloadUri,
                file.getContentType(), file.getSize(), fileDBStatus);
    }

    @PostMapping("/uploadMultipleFiles")
    public List<DocFileUploadResponse> uploadMultipleFiles(@RequestParam("files") MultipartFile[] files) {
        return Arrays.stream(files)
                .map(this::uploadFile)
                .collect(Collectors.toList());
    }

    @GetMapping("/downloadFile/{fileName:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName, HttpServletRequest request) {
        // Load file as Resource
        Resource resource = docFileService.loadFileAsResource(fileName);

        // Try to determine file's content type
        String contentType = null;
        try {
            contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
        } catch (IOException ex) {
            System.out.println("Could not determine file type.");
        }

        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(contentType))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }
}
