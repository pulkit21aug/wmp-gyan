package com.puls.gyan.google;

import com.google.api.client.auth.oauth2.Credential;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeRequestUrl;
import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson.JacksonFactory;
import com.puls.gyan.config.ConfigService;
import com.puls.gyan.exception.ConfigServiceException;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

public class GoogleOauthHelper implements GoogleOauthHelperIfc {

	private ConfigService configService;
	
	/**
	 * CLIENT_ID constant before proceeding, set this up at
	 * https://code.google.com/apis/console/
	 */
	private static String CLIENT_ID = "10340892163-35l51a1fmq6b45dk2s3nuuk8qab4l4o8.apps.googleusercontent.com";
	/**
	 * CLIENT_SECRET constant before proceeding, set this up at
	 * https://code.google.com/apis/console/
	 */
	private static  String CLIENT_SECRET = "gsKzlujqZ2yWPgEHMcWe9yYO";

	/**
	 * Callback URI that google will redirect to after successful authentication
	 */
	public String  CALLBACK_URI = "http://localhost:8080/gyan/home";

	private static final Collection<String> SCOPE = Arrays
			.asList("https://www.googleapis.com/auth/userinfo.profile;https://www.googleapis.com/auth/userinfo.email"
					.split(";"));
	private static final String USER_INFO_URL = "https://www.googleapis.com/oauth2/v1/userinfo";
	private static final JsonFactory JSON_FACTORY = new JacksonFactory();
	private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();

	private final GoogleAuthorizationCodeFlow flow;

	/**
	 * Constructor initializes the Google Authorization Code Flow with CLIENT
	 * ID, SECRET, and SCOPE
	 */
	public GoogleOauthHelper() {
		flow = new GoogleAuthorizationCodeFlow.Builder(HTTP_TRANSPORT, JSON_FACTORY, CLIENT_ID, CLIENT_SECRET, SCOPE)
				.build();

	}

	/* (non-Javadoc)
	 * @see com.puls.gyan.google.GoogleOauthHelperIfc#buildLoginUrl(java.lang.String)
	 */
	@Override
	public String buildLoginUrl(String callBackUrl) {

		final GoogleAuthorizationCodeRequestUrl url = flow.newAuthorizationUrl();

		if(callBackUrl!=null) {
			CALLBACK_URI = callBackUrl;	
		}
		return url.setRedirectUri(CALLBACK_URI).build();
	}

	/* (non-Javadoc)
	 * @see com.puls.gyan.google.GoogleOauthHelperIfc#getUserInfoJson(java.lang.String)
	 */
	@Override
	public GoogleUserInfo getUserInfoJson(final String authCode) throws IOException {

		String callBackUrl;
		try {
			callBackUrl = configService.findByName("CALLBACK_URI");
			CALLBACK_URI = callBackUrl;
		} catch (ConfigServiceException e) {
			e.printStackTrace();
		}
		
		GoogleTokenResponse response = flow.newTokenRequest(authCode).setRedirectUri(CALLBACK_URI).execute();
		Credential credential = flow.createAndStoreCredential(response, null);
		HttpRequestFactory requestFactory = HTTP_TRANSPORT.createRequestFactory(credential);
		// Make an authenticated request
		GenericUrl url = new GenericUrl(USER_INFO_URL);
		HttpRequest request = requestFactory.buildGetRequest(url);
		request.getHeaders().setContentType("application/json");
		String jsonIdentity = request.execute().parseAsString();

		Gson gson = new GsonBuilder().create();
		
		GoogleUserInfo userInfo =   gson.fromJson(jsonIdentity,GoogleUserInfo.class);
		return userInfo;

	}

	public ConfigService getConfigService() {
		return configService;
	}

	public void setConfigService(ConfigService configService) {
		this.configService = configService;
	}

}
