FROM public.ecr.aws/lambda/nodejs:18
# https://gallery.ecr.aws/lambda/nodejs

EXPOSE 8080
# ENV AWS_LAMBDA_FUNCTION_MEMORY_SIZE="256"

COPY app.js ${LAMBDA_TASK_ROOT}

CMD [ "app.handler" ]