package com.gsmserver.product;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {

    @Builder.Default
    public String
            id = "baseId",
            title = "baseTitle",
            category = "baseCategory",
            basePath = "basePath";

}
