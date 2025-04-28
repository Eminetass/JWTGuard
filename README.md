# JWTGuard - Spring Boot JWT Authentication Project

## 📚 Proje Açıklaması
JWTGuard, Spring Boot ve Spring Security kullanılarak geliştirilmiş bir kimlik doğrulama (authentication) ve yetkilendirme (authorization) projesidir.  
Kullanıcılar sisteme giriş yaptıktan sonra, güvenli erişim sağlamak için bir **JWT (JSON Web Token)** alır ve bu token ile korumalı endpointlere erişebilir.

## 🚀 Kullanılan Teknolojiler
- Java 21
- Spring Boot 3
- Spring Security
- Spring Data JPA
- H2 Database (veya başka bir veritabanı)
- Maven
- JWT (JSON Web Token)

## 🗂️ Proje Yapısı
src/ └── main/ ├── java/com/example/jwtguard/ │
├── config/ # Güvenlik ayarları (SecurityConfig.java) │
├── controller/ # API endpointleri (AuthController, WebController) │
├── model/ # Entity (User.java) │ 
├── repository/ # Repository arayüzü (UserRepository.java) │
├── service/ # Servis katmanı (UserService.java) │
└── util/ # Yardımcı sınıflar (JWT ile ilgili) └── resources/
├── templates/ # HTML sayfaları (index.html)
└── application.properties # Konfigürasyon dosyası

## ⚙️ Kurulum ve Çalıştırma
1. Projeyi klonlayın:
    ```bash
    git clone https://github.com/kullanici-adin/jwtguard.git
    ```
2. Maven bağımlılıklarını yükleyin:
    ```bash
    mvn clean install
    ```
3. Uygulamayı başlatın:
    ```bash
    mvn spring-boot:run
    ```
4. Uygulama `http://localhost:8080` adresinde çalışır.

## 🔐 Authentication Süreci
- `/auth/register` → Kullanıcı kaydı
- `/auth/login` → Kullanıcı girişi ve JWT token alma
- Korunan endpointlere ulaşmak için JWT token Authorization header içinde gönderilir.

## 📬 API Örnekleri

### Kullanıcı Kaydı (Register)
```
POST /auth/register
Content-Type: application/json

{
  "username": "testuser",
  "password": "password123"
}

Giriş Yap (Login)
POST /auth/login
Content-Type: application/json

{
  "username": "testuser",
  "password": "password123"
}
Response:

json

{
  "token": "eyJhbGciOiJIUzI1NiIsInR..."
}
Korunan Endpointe Erişim

GET /api/protected
Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR...

🛡️ Güvenlik Yapısı
Şifreler PasswordEncoder ile hashlenir.
İsteklerde JWT Token doğrulaması yapılır.
Token süresi dolunca tekrar login yapılır.

✨ Katkıda Bulunma
Katkıda bulunmak isterseniz issue açabilir ve geliştirme önerilerinde bulunabilirsiniz.
