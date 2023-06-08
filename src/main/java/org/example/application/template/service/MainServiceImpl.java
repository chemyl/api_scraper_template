package org.example.application.template.service;

import lombok.extern.log4j.Log4j;
import org.example.application.template.controller.ApiControllerService;
import org.example.application.template.modelStructure.POJOResponse;
import org.example.application.template.utils.DataStorageImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@Log4j
@EnableScheduling
public class MainServiceImpl implements MainService {

    private final ApiControllerService apiControllerService;
    private final DataStorageImpl dataStorage;

    public MainServiceImpl(ApiControllerService apiControllerService, DataStorageImpl dataStorage) {
        this.apiControllerService = apiControllerService;
        this.dataStorage = dataStorage;
    }

    @Override
    @Bean
    @Scheduled(fixedRate = 10000)
    public void jsonToPojoToXls() {
        log.debug("################METHOD EXECUTED#################");
        POJOResponse pojoResponse = new POJOResponse(apiControllerService.getResponseFromActivityURL());
        log.debug("MainService: Response received");
        log.debug("MainService: POJO created");
        dataStorage.updateXLSFileWithPOJO(pojoResponse);
    }
}
