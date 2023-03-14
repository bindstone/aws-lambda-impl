import 'package:aws_lambda_dart_runtime/aws_lambda_dart_runtime.dart';

void main() async {

  upperCase(context, event) async {
    var requestBody = event.body;
    String name = requestBody["name"];

    final response = AwsApiGatewayResponse(
      body: name.toUpperCase(),
      statusCode: 200,
    );

    return response;
  }

  Runtime()
    ..registerHandler<AwsApiGatewayEvent>("uppercase", upperCase)
    ..invoke();
}
