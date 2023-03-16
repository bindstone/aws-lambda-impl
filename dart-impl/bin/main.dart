import 'dart:async';
import 'dart:convert';
import 'dart:io';

Future<void> main() async {

  final port = 8080;
  final server = await HttpServer.bind(InternetAddress.anyIPv4, port);
  print('Listening on port ${server.port}');

  await for (HttpRequest request in server) {
    // print(request.uri.path);
    // print(request.method);
    Future<String> content = utf8.decodeStream(request);
    content.then((value) {
      var data = jsonDecode(value);
      request.response
        ..headers.contentType = ContentType.text
        ..write(data['name'].toUpperCase())
        ..close();
    });
  }
}
