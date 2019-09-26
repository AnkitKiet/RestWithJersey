import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpUtility {

	protected static OkHttpClient client;
	private final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

	protected void setOkHttpClient() {
		if (client == null)
			client = new OkHttpClient();
	}

	protected Response execGetRequest(String apiUrl) throws IOException {
		Request request = new Request.Builder().url(apiUrl).build();
		Response response = client.newCall(request).execute();
		return response;
	}

	protected ResponseEntity handleResponseBody(Response response) {
		ResponseEntity responseEntity = null;
		try {
			responseEntity = new ResponseEntity();
			if (response.isSuccessful())
				responseEntity.setResponseBody(response.body().string());
		} catch (Exception ex) {
			responseEntity.setErrorDesc(ex.toString());
			responseEntity.setErrorStatus(Boolean.TRUE);
		}
		return responseEntity;
	}

	protected Response execPostRequest(String json, String apiUrl) throws IOException {
		RequestBody body = RequestBody.create(JSON, json);
		Request request = new Request.Builder().url(apiUrl).post(body).build();
		Response response = client.newCall(request).execute();
		return response;
	}

}
