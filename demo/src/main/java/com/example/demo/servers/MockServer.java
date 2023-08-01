package com.example.demo.servers;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.core.WireMockConfiguration;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MockServer {

    @PostConstruct
    public void startServer() {
        System.out.println( );
        WireMockConfiguration config = WireMockConfiguration.options().port(8000).bindAddress("0.0.0.0").usingFilesUnderClasspath("endPointMappings"); // Specify the directory containing mappings

        // Start the WireMock server
        WireMockServer wireMockServer = new WireMockServer(config);
        wireMockServer.start();

        // Optionally, you can perform some operations here, like loading initial data or setting up expectations.

        // Keep the server running until you want to stop it
        try {
            System.out.println("WireMock server is running on port 8000. Press any key to stop.");
            System.in.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Stop the WireMock server
        wireMockServer.stop();
    }



}
