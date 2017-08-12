package com.bing.resume.framework.editor;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class DatePropertyEditorSupport extends PropertyEditorSupport {
	public void setAsText(String text) throws IllegalArgumentException {
		if ((StringUtils.isBlank(text)) || (StringUtils.isEmpty(text))) {
			setValue(null);
		} else {
			text = text.trim();
			SimpleDateFormat sdf;
			if (text.matches("\\d{4}-\\d{1,2}-\\d{1,2}")) {
				sdf = new SimpleDateFormat("yyyy-MM-dd");
			} else {
				if (text.matches("\\d{4}-\\d{1,2}-\\d{1,2} \\d{2}:\\d{2}:\\d{2}")) {
					sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				} else {
					throw new IllegalArgumentException(
							"date or time format error ");
				}
			}
			Date date = null;
			try {
				date = sdf.parse(text.trim());
			} catch (ParseException e) {
				throw new IllegalArgumentException(
						"date or time format error  ");
			}
			setValue(date);
		}
	}
}
