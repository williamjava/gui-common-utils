package com.gui.common.utils.model;

import lombok.Data;

/**
 * Smtp:邮件配置对象
 *
 * @author wgui
 */
@Data
public class Smtp {
	public String host;
	public String port;
	public String username;
	public String password;
}
