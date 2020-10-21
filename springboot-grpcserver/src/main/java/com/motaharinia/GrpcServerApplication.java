package com.motaharinia;

import com.motaharinia.server.user.*;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.motaharinia"})
public class GrpcServerApplication {

    public static void main(String[] args) throws Exception  {
        SpringApplication.run(GrpcServerApplication.class, args);
        Server server = ServerBuilder.forPort(9090).addService(new UserService()).build();
        server.start();
        System.out.println("Server Started at " + server.getPort());
        server.awaitTermination();
    }

}
