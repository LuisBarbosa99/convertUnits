# convertUnits

## Instalando o Docker

### Linux

    $ sudo apt-get update

    $ sudo apt-get install \ apt-transport-https \ ca-certificates \ curl \ gnupg-agent \ software-properties-common

    $ curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo apt-key add -
    
    $ sudo apt-key fingerprint 0EBFCD88
    
    $ sudo add-apt-repository \ "deb [arch=amd64] https://download.docker.com/linux/ubuntu \ $(lsb_release -cs) \ stable"
    
    $ sudo apt-get update
    
    $ sudo apt-get install docker-ce docker-ce-cli containerd.io
    
    $ apt-cache madison docker-ce
    
    $ docker --version

## Instalando o Docker Compose

    $ sudo curl -L "https://github.com/docker/compose/releases/download/1.28.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose

## Criando um executável .JAR

    $ mvn package && java -jar target/gs-spring-boot-docker-0.1.0.jar

## Executando o Docker Compose

    $ sudo docker-compose up
