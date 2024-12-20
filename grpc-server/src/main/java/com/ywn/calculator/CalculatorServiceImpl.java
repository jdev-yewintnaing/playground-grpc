package com.ywn.calculator;

import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class CalculatorServiceImpl extends CalculatorServiceGrpc.CalculatorServiceImplBase {

    @Override
    public void add(AddRequest request, io.grpc.stub.StreamObserver<AddResponse> responseObserver) {
        double num1 = request.getNum1();
        double num2 = request.getNum2();
        double result = num1 + num2;

       AddResponse response = AddResponse.newBuilder()
                .setResult(result)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
