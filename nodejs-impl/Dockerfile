FROM public.ecr.aws/lambda/nodejs:18
# https://gallery.ecr.aws/lambda/nodejs

EXPOSE 8080

COPY app.js ${LAMBDA_TASK_ROOT}

CMD [ "app.handler" ]
