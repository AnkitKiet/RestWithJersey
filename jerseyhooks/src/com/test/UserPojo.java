package com.test;

import javax.xml.bind.annotation.XmlRootElement;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@XmlRootElement
public class UserPojo {

	private String user;
	private String email;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		JSONArray jsonArray = new JSONArray();
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("user", user);
			jsonObject.put("email", email);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		jsonArray.put(jsonObject);
		return jsonArray.toString();
	}

}
