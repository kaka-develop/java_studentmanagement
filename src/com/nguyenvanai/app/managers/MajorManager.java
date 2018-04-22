package com.nguyenvanai.app.managers;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.gson.reflect.TypeToken;
import com.nguyenvanai.app.models.Major;

public class MajorManager extends AbstractManager {
	private static final MajorManager instance = new MajorManager();

	public static MajorManager getInstance() {
		return instance;
	}

	private MajorManager() {
	}

	@Override
	public String getFileName() {
		// TODO Auto-generated method stub
		return "majors.json";
	}

	@Override
	Type getListType() {
		Type listType = new TypeToken<Collection<Major>>() {
		}.getType();
		return listType;
	}

	@Override
	boolean validateID(String id) {
		String pattern = "m[0-9]{2}$";
		Pattern p = Pattern.compile(pattern,Pattern.CASE_INSENSITIVE);
		Matcher m = p.matcher(id);
		return m.find();
	}
}
