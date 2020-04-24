package com.gsmserver.product;

import lombok.AllArgsConstructor;
import lombok.ToString;


@AllArgsConstructor
@ToString
public enum Products {

    MedusaBox(ProductDto.builder()
            .basePath("/medusa-pro-box")
            .category("Boxes")
            .id("860988")
            .title("Medusa PRO Box")
            .build()),
    OctoplusProBox(ProductDto.builder()
            .basePath("/octoplus-pro-box-with-7-in-1-cable-adapter-set-activated-for-samsung-plus-lg-plus-emmc-jtag/")
            .category("Boxes")
            .id("876464")
            .title("Octoplus Pro Box with 7 in 1 Cable/Adapter Set (Activated for Samsung + LG + eMMC/JTAG)")
            .build());

    public final ProductDto productDto;

    public ProductDto getDto() {
        return productDto;
    }

}
