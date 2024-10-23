package com.js.msensorview.ui;

//import co.kr.ulike.tittlesensortest.BaseApplication;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

public class MarkerButton extends Button {
	boolean isBold;

	public MarkerButton(Context context) {

		super(context);
		setFont();
	}

	public MarkerButton(Context context, AttributeSet attrs) {

		super(context, attrs);
		setIsBold(attrs);
		setFont();
	}

	public MarkerButton(Context context, AttributeSet attrs, int defStyle) {

		super(context, attrs, defStyle);
		setIsBold(attrs);
		setFont();
	}

	private void setIsBold(AttributeSet attrs) {

		for (int i = 0; i < attrs.getAttributeCount(); i++) {
			if ("textStyle".equals(attrs.getAttributeName(i))) {
				String textStyle = attrs.getAttributeValue(i);
				if ("bold".equals(textStyle)) {
					isBold = true;
				} else {
					try {
						int value = attrs.getAttributeIntValue(i, Typeface.NORMAL);
						if (value == Typeface.NORMAL)
							isBold = false;
						else
							isBold = true;
					} catch (NumberFormatException e) {

					}
				}
			}
		}
	}

	public void setFont() {
//		if (isBold) {
//			Typeface typeface = BaseApplication.getFontBold();
//			if (typeface != null) {
//				setTypeface(typeface, Typeface.NORMAL);
//				setIncludeFontPadding(false);
//			}
//		} else {
//			Typeface typeface = BaseApplication.getFont();
//			if (typeface != null) {
//				setTypeface(typeface);
//				setIncludeFontPadding(false);
//			}
//		}

	}
}
