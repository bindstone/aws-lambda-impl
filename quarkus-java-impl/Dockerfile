#################
## BUILD
#################
FROM maven:3.9.0-amazoncorretto-17 as build
## https://quarkus.io/guides/amazon-lambda
WORKDIR /app
COPY . /app
RUN mvn package

#################
## RUN
#################
FROM public.ecr.aws/lambda/java:17
# https://gallery.ecr.aws/lambda/java

EXPOSE 8080

COPY --from=build app/target/spring-java-impl-0.0.1-SNAPSHOT-aws.jar ${LAMBDA_TASK_ROOT}/lib/

CMD [ "org.springframework.cloud.function.adapter.aws.FunctionInvoker::handleRequest" ]
