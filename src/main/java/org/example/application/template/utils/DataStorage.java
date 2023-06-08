package org.example.application.template.utils;

import org.example.application.template.modelStructure.POJOResponse;
import org.springframework.stereotype.Service;

@Service
public interface DataStorage {

    Boolean createXLSFileByPOJO(POJOResponse response);

    Boolean updateXLSFileWithPOJO(POJOResponse response);

}