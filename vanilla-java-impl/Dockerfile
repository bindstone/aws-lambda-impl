#################
## BUILD
#################
FROM maven:3.9.0-amazoncorretto-17 as build

WORKDIR /app
COPY . /app
RUN mvn package

#################
## RUN
#################
FROM public.ecr.aws/lambda/java:17
# https://gallery.ecr.aws/lambda/java

EXPOSE 8080
# ENV AWS_LAMBDA_FUNCTION_MEMORY_SIZE="256"

COPY --from=build app/target/classes ${LAMBDA_TASK_ROOT}
COPY --from=build app/target/dependency/* ${LAMBDA_TASK_ROOT}/lib/

CMD [ "com.bindstone.Handler::handleRequest" ]