FROM dart:stable-sdk as build

WORKDIR /app

COPY ./pubspec.yaml ./pubspec.yaml
COPY ./pubspec.lock ./pubspec.lock
COPY ./bin ./bin

RUN dart pub get
RUN dart compile exe bin/main.dart -o bin/main.sh
RUN chmod +x bin/main.sh

FROM public.ecr.aws/lambda/provided:al2
# https://gallery.ecr.aws/lambda/provided
# https://docs.aws.amazon.com/lambda/latest/dg/runtimes-walkthrough.html

EXPOSE 8080

COPY --from=build /app/bin/main.sh ${LAMBDA_TASK_ROOT}

CMD [ "main.sh" ]