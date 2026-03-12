package com.tt1.trabajo.servicios;

import org.springframework.stereotype.Service;

import utilidades.api.ResultadosApi;
import utilidades.client.ApiClient;
import utilidades.client.ApiException;
import utilidades.model.ResultsResponse;

@Service
public class GridService {

    public String obtenerGrid(Integer tok) throws ApiException {
        ApiClient client = new ApiClient();
        client.setBasePath("http://localhost:8080");

        ResultadosApi api = new ResultadosApi(client);
        ResultsResponse response = api.resultadosPost("anpalenq", tok);

        if (response != null && Boolean.TRUE.equals(response.getDone())) {
            return response.getData();
        }

        if (response != null && response.getErrorMessage() != null) {
            return "Error: " + response.getErrorMessage();
        }

        return "Sin datos";
    }
}