package com.gui.common.utils.model;

import lombok.Data;

import java.io.InputStream;

/**
 * 邮件附件对象信息
 *
 * @author wgui
 */
@Data
public class EmailFileVo {
    private String fileName;
    private InputStream inputStream;
}
