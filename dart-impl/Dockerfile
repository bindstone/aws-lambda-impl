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
# https://docs.aws.amazon.com/lambda/latest/dg/configuration-envvars.html

EXPOSE 8080
# ENV AWS_LAMBDA_FUNCTION_MEMORY_SIZE="256"
WORKDIR ${LAMBDA_TASK_ROOT}
COPY --from=build /app/bin/main.sh .
ENTRYPOINT [ "./main.sh" ]
# RUN [ "./main.sh" ]