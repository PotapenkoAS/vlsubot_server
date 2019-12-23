package com.example.vlsubot_1_0.service;

import com.ibm.cloud.sdk.core.http.HttpConfigOptions;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.assistant.v2.Assistant;
import com.ibm.watson.assistant.v2.model.*;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.stereotype.Service;

import static com.example.vlsubot_1_0.Constants.*;

@Service
public class WatsonService {

    public String sendMessage(String message) {
        IamAuthenticator authenticator = new IamAuthenticator(WATSON_API_KEY);
        Assistant assistant = new Assistant("2019-02-28", authenticator);
        //  assistant.setServiceUrl(WATSON_URL);
        CreateSessionOptions sessionOptions = new CreateSessionOptions.Builder(WATSON_ID).build();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();
        assistant.setClient(client);

        HttpConfigOptions configOptions = new HttpConfigOptions.Builder()
                .disableSslVerification(true)
                .build();
        assistant.configureClient(configOptions);

        SessionResponse sessionResponse = assistant.createSession(sessionOptions).execute().getResult();
        MessageInput input = new MessageInput.Builder()
                .messageType("text")
                .text(message)
                .build();

        MessageOptions options = new MessageOptions.Builder(WATSON_ID, sessionResponse.getSessionId())
                .input(input)
                .build();

        MessageResponse response = assistant.message(options).execute().getResult();
        return response.getOutput().getGeneric().get(0).text();
    }
}
