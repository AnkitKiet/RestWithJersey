import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import funUseCase.GetRequest;
import funUseCase.PostRequest;

public class ApiDemo extends OkHttpUtility implements Commons {

	public static void main(String[] args) {
		ApiDemo objApiDemo = new ApiDemo();
		objApiDemo.init();
		objApiDemo.execGetReq.execGetRequest();
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject.put("user", "Ankit");
			jsonObject.put("email", "ankit@gmail.com");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		objApiDemo.execPostReq.execPostRequest(jsonObject.toString());
	}

	private void init() {
		setOkHttpClient();
	}

	GetRequest execGetReq = () -> {
		try {
			ResponseEntity responseEntity = handleResponseBody(execGetRequest(GET_API_URL));
			if (!responseEntity.isErrorStatus())
				System.out.println(responseEntity.getResponseBody());
		} catch (IOException getEx) {
			getEx.printStackTrace();
		}
	};

	PostRequest execPostReq = (String json) -> {
		try {
			ResponseEntity responseEntity = handleResponseBody(execPostRequest(json, POST_API_URL));
			if (!responseEntity.isErrorStatus())
				System.out.println(responseEntity.getResponseBody());
		} catch (IOException postEx) {
			postEx.printStackTrace();
		}
	};

}
