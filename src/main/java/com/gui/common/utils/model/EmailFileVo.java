package com.gui.common.utils.model;

import lombok.Data;

import java.io.InputStream;

@Data
public class EmailFileVo {
    private String fileName;
    private InputStream inputStream;
}
