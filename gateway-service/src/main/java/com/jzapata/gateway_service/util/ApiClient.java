package com.jzapata.gateway_service.util;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

public class ApiClient {
    public static void main(String[] args) {
        String url = "http://localhost:8083/api/lavados";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth("eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJ3Z1NLRmFyN2xYaWlIVy00S0dGQ2xPTExyUlpqS0drOVBGZXFPMzAtRmJzIn0.eyJleHAiOjE3MjMxMjYwMjQsImlhdCI6MTcyMzEyNTcyNCwianRpIjoiM2ZlZjI1NDEtZWE5MS00MjgyLThiMDEtNjU5ZGY0ZTk0YmNhIiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgxL3JlYWxtcy9zcHJpbmctYm9vdC1yZWFsbS1wcm9kIiwiYXVkIjoiYWNjb3VudCIsInN1YiI6Ijg3MzNiYjViLTk3ZWUtNDk3ZS04MWMxLWYxMWNkMTI0NWE5MyIsInR5cCI6IkJlYXJlciIsImF6cCI6InNwcmluZy1jbGllbnQtYXBpLXJlc3QiLCJzaWQiOiI3NTBiNTk5Yy1jYzQ4LTRlODctYTc4OS0yNzE0NmQ2YTgyODciLCJhY3IiOiIxIiwiYWxsb3dlZC1vcmlnaW5zIjpbIioiXSwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtc3ByaW5nLWJvb3QtcmVhbG0tcHJvZCIsIm9mZmxpbmVfYWNjZXNzIiwiYWRtaW4iLCJ1bWFfYXV0aG9yaXphdGlvbiJdfSwicmVzb3VyY2VfYWNjZXNzIjp7InNwcmluZy1jbGllbnQtYXBpLXJlc3QiOnsicm9sZXMiOlsiYWRtaW5fY2xpZW50X3JvbGUiXX0sImFjY291bnQiOnsicm9sZXMiOlsibWFuYWdlLWFjY291bnQiLCJtYW5hZ2UtYWNjb3VudC1saW5rcyIsInZpZXctcHJvZmlsZSJdfX0sInNjb3BlIjoiZW1haWwgcHJvZmlsZSIsImVtYWlsX3ZlcmlmaWVkIjp0cnVlLCJuYW1lIjoicGFwYSB6YXBhdGEiLCJwcmVmZXJyZWRfdXNlcm5hbWUiOiJwYXBhIiwiZ2l2ZW5fbmFtZSI6InBhcGEiLCJmYW1pbHlfbmFtZSI6InphcGF0YSIsImVtYWlsIjoicGFwYWl0b0BlbWFpbC5jb20ifQ.wy9qd7gMscs4U4g1VdESyS0_KZgGYpkeTyH8QV-QNZQy9PBh7meQVdmuSvvHB5aB5b4HGt5Ca9THVFluUWyIjZsEO87VBwe3F_myYDzTxMRjCCqCJ_8OjjG_-f1PG7sPMI17EBv3p-L9gJ5cdBZh7xaMS2Ql0YpSv96R8nPM9yzhjBJziqgsaLq_MDDjsh1Ep2z56uTPDmzh37YdMedG2zKHmPxj96GCqdAXPws28TaqUljuQuTLPinePexDMJrwB29anQWv-RbQVmOhCyFu-lvRE_fsRpw2XT3RqAGVzL8G5kDngteZAtTSWC56jHHPnGqOT_SYWYVbe9ohdJ5Ukw"); // Reemplaza con tu token JWT

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response.getBody());
    }
}