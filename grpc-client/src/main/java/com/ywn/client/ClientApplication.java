package com.ywn.client;

import com.ywn.calculator.AddRequest;
import com.ywn.calculator.CalculatorServiceGrpc;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @Bean
    ApplicationRunner clientRunner(@GrpcClient("calculatorService")CalculatorServiceGrpc.CalculatorServiceBlockingStub calculatorServiceBlockingStub) {
        return args -> System.out.println(calculatorServiceBlockingStub.add(AddRequest.newBuilder().setNum1(10).setNum2(10).build()));
    }

}
