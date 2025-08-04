📘 RestAssuredCucumberHotelApiProject
Bu proje, Restful Booker API üzerinden otel rezervasyon sistemine dair otomasyon testlerini kapsamaktadır. Testler Rest Assured, Cucumber, ve JUnit teknolojileri kullanılarak yazılmıştır.

🚀 Teknolojiler
•Java 17
•Rest Assured
•Cucumber BDD
•JUnit 5
•Log4j2 – Loglama
•Maven – Proje yönetimi
•Gherkin – Test senaryoları

📂 Proje Yapısı
src/
 ├─ main/
 │   └─ java/
 │       └─ com.hotelReservations.models → POJO sınıflar
 │
 └─ test/
     ├─ java/
     │   ├─ com.hotelReservations.baseUrl → Temel yapılandırmalar
     │   ├─ com.hotelReservations.services → API istekleri
     │   ├─ com.hotelReservations.steps → Step Definitions
     │   └─ com.hotelReservations.runner → Test Runner
     │
     └─ resources/
         └─ features/ → Gherkin senaryoları (.feature dosyaları)

⚙️ Nasıl Çalıştırılır?
Projeyi klonlayın:
•git clone https://github.com/AyberkkOzturk/RestAssuredCucumberHotelApiProject.git
•cd RestAssuredCucumberHotelApiProject
•mvn clean install
•mvn test

📝 Loglama
•Tüm istek ve yanıt logları logs/logging.txt ve logs/app.log dosyalarına yazılmaktadır.

📌 Notlar
•Bu proje demo amaçlı hazırlanmıştır.
•Token üretimi, rezervasyon oluşturma ve silme işlemleri test edilmektedir.
