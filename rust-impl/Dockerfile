FROM rust:1.68-buster as builder

WORKDIR /build

ADD Cargo.toml Cargo.toml
ADD Cargo.lock Cargo.lock
ADD src src

RUN apt-get update && apt-get install -y musl-tools musl libssl-dev pkg-config
RUN rustup target add x86_64-unknown-linux-musl && cargo build --release --target x86_64-unknown-linux-musl

RUN ls /build/target/x86_64-unknown-linux-musl/release/
RUN chmod -R o+rX /build/target/x86_64-unknown-linux-musl/release/.

# copy artifacts to a clean image
FROM public.ecr.aws/lambda/provided:al2
EXPOSE 8080
COPY --from=builder /build/target/x86_64-unknown-linux-musl/release/rust-impl ${LAMBDA_RUNTIME_DIR}/bootstrap

CMD ["lambda-handler"]