package com.motaharinia;


import com.motaharinia.server.user.stub.UserGrpc;
import com.motaharinia.server.user.stub.UserMicro;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication(scanBasePackages = {"com.motaharinia"})
public class GrpcClientApplication {

    public static void main(String[] args) throws IOException, InterruptedException {
        SpringApplication.run(GrpcClientApplication.class, args);
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
        UserGrpc.UserBlockingStub userStub = UserGrpc.newBlockingStub(managedChannel);

        UserMicro.LoginRequest loginRequest = UserMicro.LoginRequest.newBuilder().setUsername("user1").setPassword("pass1").build();
       UserMicro.APIResponse apiResponse=  userStub.login(loginRequest);
        System.out.println("apiResponse"+  apiResponse.toString());
    }

}
