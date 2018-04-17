package com.zjut.bean;

/**
 * 诗
 * 
 * @author admin
 *
 */
public class Poem {
	/**
	 * 类型：五言、七言
	 */
	private int type;
	/**
	 * 标题
	 */
	private String title;
	/**
	 * 诗句
	 */
	private String content;

	/**
	 * 获取是类型
	 * 
	 * @return
	 */
	public int getType() {
		return type;
	}

	/**
	 * 设置诗类型
	 * 
	 * @param type
	 */
	public void setType(int type) {
		this.type = type;
	}

	/**
	 * 获取诗标题
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 设置诗标题
	 * 
	 * @param type
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 获取诗句
	 * 
	 * @return
	 */
	public String getContent() {
		return content;
	}

	/**
	 * 设置诗标题
	 * 
	 * @param type
	 */
	public void setContent(String content) {
		this.content = content;
	}

}
