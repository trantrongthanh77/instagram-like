package com.cozwork.application.message;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.domain.Pageable;

public class PagingResponse extends Response {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("total_pages")
    private Integer totalPages;

    @JsonProperty("total_items")
    private Long totalItems;

    public PagingResponse() {
    }

    public PagingResponse(Pageable pageable, Integer totalPages, Long totalItems) {
        this.totalItems = totalItems;
        if (pageable.isPaged()) this.totalPages = totalPages;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(Long totalItems) {
        this.totalItems = totalItems;
    }
}