# catalogue

[microservices-sample](https://github.com/n-ono/microservices-sample) のカタログサービス

## ドメインモデル

![カタログ](https://user-images.githubusercontent.com/58995947/99875706-009b5200-2c35-11eb-8021-13cb196e3346.png)

## 各種コマンド

下記コマンドは全てプロジェクトのルートディレクトリで実行する

### ビルド

```
$ docker-compose -f docs/docker/db/docker-compose.yml up
$ ./gradlew clean build
```

war を生成するだけであればコンテナの起動は不要

```
$ ./gradlew clean bootWar
```

### Docker イメージ生成

```
$ docker build -t <image-name>:<tag> -f docs/docker/Dockerfile . 
```

`<image-name>` と `<tag>` は任意の値を指定する
