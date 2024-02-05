# openjdk image is deprecated, eclipse-temurin is ubuntu based
FROM eclipse-temurin:19-jdk
WORKDIR /app

ARG ANDROID_COMPILE_SDK="31"
ARG ANDROID_BUILD_TOOLS="30.0.3"
ARG ANDROID_SDK_TOOLS="9477386"
# ENV sticks around after build

RUN apt update -y && apt upgrade -y
RUN apt install wget unzip ruby ruby-dev build-essential -y

ENV ANDROID_HOME="/usr/lib/android-sdk"

RUN mkdir -p $ANDROID_HOME && \
    wget -q https://dl.google.com/android/repository/commandlinetools-linux-${ANDROID_SDK_TOOLS}_latest.zip && \
    unzip -q commandlinetools-linux-${ANDROID_SDK_TOOLS}_latest.zip && \
    mv cmdline-tools tools && \
    mkdir $ANDROID_HOME/cmdline-tools && \
    mv tools $ANDROID_HOME/cmdline-tools/tools && \
    rm commandlinetools-linux-${ANDROID_SDK_TOOLS}_latest.zip

RUN ln -s $ANDROID_HOME/cmdline-tools/tools/bin/sdkmanager /usr/local/bin

RUN echo y | sdkmanager --licenses >/dev/null
RUN echo y | sdkmanager "platforms;android-${ANDROID_COMPILE_SDK}" >/dev/null
RUN echo y | sdkmanager "platform-tools" >/dev/null
# Doesn't work on m1 macs aka arm64, build locally with --platform linux/amd64
RUN echo y | sdkmanager "build-tools;${ANDROID_BUILD_TOOLS}" >/dev/null

# Install Ruby Dependencies
RUN gem install bundler

COPY Gemfile ./
COPY Gemfile.lock ./

RUN bundle install
