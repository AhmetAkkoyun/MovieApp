FROM amazoncorretto:17
ARG JAR_FILE=targer/*.jar
COPY ${JAR_FILE} app.jar
CMD apt-get update -y
ENTRYPOINT ["java", "-jar", "app.jar"]


## dockerda image oluşturmak için aşağıdaki komutu konsolda çalıştır:
## docker build --build-arg JAR_FILE=build/libs/MovieApp-0.0.1-SNAPSHOT.jar -t ahmetakkoyun/movieapp:v001 .
    # docker build : image oluşturmak için konsol komutu
    # --build-arg JAR_FILE=build/libs/MovieApp-0.0.1-SNAPSHOT.jar : image argümanı
        # --build-arg : argüman oluşturma komutu
        # JAR_FILE=build/libs/MovieApp-0.0.1-SNAPSHOT.jar : image oluşturulacak build dosyasının yolu
    # ahmetakkoyun/movieapp:v001 : image dosyası
        # ahmetakkoyun : docker kullanıcı adı
        # movieapp : image dosyasına verdiğimiz isim
        # v001 : versiyon
        # . : bu noktayı en sona koyuyoruz. unutma.

## bir image dosyasını çalıştırmak için aşağıdaki komutu konsolda çalıştır:
## docker run --name javamovieapp -d -p 8091:8090 ahmetakkoyun/movieapp:v001
    # docker run : image çalıştırmak için konsol komutu
    # --name javamovieapp : çalışacak olan container'a vermek istediğimiz isim
    # -d : arkaplanda çalıştır
    # -p 8091:8090 : port
        # 8091 : dış port(solda) çakışmamasına dikkat etmemiz gereken bu.
        # 8090 : iç port(sağda)
    # ahmetakkoyun/movieapp:v001 : public image dosyası
        # ahmetakkoyun : docker hesabı kullanıcı adı
        # movieapp : image dosyasına verilmiş olan isim
        # v001 : image versiyonu

# dockerdan resmi postgres görüntüsünü çalıştırmak için:
# docker run --name docker-postgres -e POSTGRES_PASSWORD=root -d -p 5532:5432 postgres
    # docker run : konsol komutu
    # --name docker-postgres : çalışacak container için belirlediğimiz isim
    # -e POSTGRES_PASSWORD=root : veritabanı şifresi
    # -d : arkaplanda çalıştır
    # -p 5532:5432 : port
        # 5532 : dış port (5432 yaparsak bu konteyner çalışırken farklı bir yerden pg admine erişemeyiz)
        # 5432 : iç port (5432 pgadminin portu)
    # postgres : image ismi

# bunları docker üzerinden çalıştırabilmek için pgadminde de 5532 portunda çalışan bir server oluşturmak gerekiyor

