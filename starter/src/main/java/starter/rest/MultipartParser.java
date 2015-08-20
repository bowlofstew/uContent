package starter.rest;

import org.elasticsearch.common.lang3.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class MultipartParser {
    private MultipartHttpServletRequest request;
    private Json body;
    private List<MultipartFile> files;

    public MultipartParser(MultipartHttpServletRequest request) {
        this.request = request;
    }

    public Json getBody() {
        return body;
    }

    public List<MultipartFile> getFiles() {
        return files;
    }

    public MultipartParser invoke() throws IOException {
        body = new Json();
        files = new ArrayList<>();
        Map<String, MultipartFile> fileMap = request.getFileMap();
        for (String name : fileMap.keySet()) {
            MultipartFile item = fileMap.get(name);
            if (item.isEmpty()) continue;
            files.add(item);
        }
        Map<String, String[]> parameterMap = request.getParameterMap();
        for (String key : parameterMap.keySet()) {
            body.put(key, parameterMap.get(key)[0]);
        }

        return this;
    }
}