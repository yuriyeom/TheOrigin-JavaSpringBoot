package dev.glassym.webclient.service;

import dev.glassym.webclient.model.NcpGeolocationDto;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.server.ResponseStatusException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Service
public class NcpApiService {
    private static final Logger logger = LoggerFactory.getLogger(NcpApiService.class);

    @Value("${ncp.api.access-key:stub-api-key}")
    private  String accessKey;

    @Value("${ncp.api.secret-key:stub-scret-key}")
    private  String secretKey;

    private static final String ncpHeaderNameTimestamp = "x-ncp-apigw-timestamp";
    private static final String ncpHeaderNameSignature = "x-ncp-apigw-signature-v2";

    private final WebClient ncpWebClient;


    public NcpApiService(WebClient ncpWebClient) {
        this.ncpWebClient = ncpWebClient;
    }

    public NcpGeolocationDto geoLocation(String ip){
        String epochString = String.valueOf(System.currentTimeMillis());
        // 요청을 보내기 위한 url의 앞부분
        String uriBase = "http://geolocation.apigw.ntruss.com";
        String uriPath = String.format("/geolocation/v2/geoLocation" +
                "?ip=%s&ext=t&responseFormatType=json", ip);

        String ncpSignature = this.makeSignature(
                "GET", uriPath, epochString
        );

        // 요청 보내기
        NcpGeolocationDto result = this.ncpWebClient
                .get()
                .uri(uriBase + uriPath)
//                .header(ncpHeaderNameTimestamp, epochString)
//                .header(ncpHeaderNameSignature, ncpSignature)
                // header를 2번 부르지않고 하는 방법
                .headers(httpHeaders -> {
                    httpHeaders.add(ncpHeaderNameTimestamp, epochString);
                    httpHeaders.add(ncpHeaderNameSignature, ncpSignature);
                })
                .exchangeToMono(clientResponse -> {
                    logger.trace(clientResponse.headers().toString());
                    return clientResponse.bodyToMono(NcpGeolocationDto.class);
                })
                .block();
        return result;

    }

    private String makeSignature(String method, String path, String epochString){
        String space = " ";					// one space
        String newLine = "\n";					// new line

        String message = method +
                space +
                path +
                newLine +
                epochString +
                newLine +
                accessKey;
        try{
            SecretKeySpec signingKey = new SecretKeySpec(secretKey.getBytes("UTF-8"), "HmacSHA256");
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(signingKey);

            byte[] rawHmac = mac.doFinal(message.getBytes(StandardCharsets.UTF_8));

            return Base64.encodeBase64String(rawHmac);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
