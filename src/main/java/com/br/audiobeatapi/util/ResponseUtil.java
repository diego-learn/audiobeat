package com.br.audiobeatapi.util;

import com.br.audiobeatapi.entity.Base;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static Map<String, Object> formatResponsePagination(Page pages, String entity) {

        Map<String, Object> response = new HashMap<>();
        response.put(entity, pages.getContent());
        response.put("currentPage", pages.getNumber());
        response.put("totalItems", pages.getTotalElements());
        response.put("totalPages", pages.getTotalPages());

        return response;
    }
}
