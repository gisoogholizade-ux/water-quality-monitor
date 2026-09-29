# Water Quality Monitor

سامانه سبک ثبت و تحلیل داده‌های کیفیت آب — پروژه تیم Nexora.

## وضعیت فعلی: 20%

مرحله اول شامل راه‌اندازی پروژه، مدل داده، ثبت اندازه‌گیری و داشبورد اولیه است.

### فناوری‌ها
- Java 21
- Spring Boot 3
- Spring MVC / Thymeleaf
- Spring Data JPA
- MySQL
- H2 (development)
- Bootstrap RTL
- Maven

### پارامترهای اندازه‌گیری
- Temperature
- pH
- Dissolved Oxygen (DO)
- Electrical Conductivity (EC)
- Sampling location
- Measurement date/time
- Notes

### اجرا
برای اجرای سریع با پروفایل توسعه:

```bash
mvn spring-boot:run -Dspring-boot.run.profiles=dev
```

سپس:
`http://localhost:8080`

برای MySQL پروفایل `mysql` را فعال کنید و تنظیمات اتصال را در `application-mysql.properties` قرار دهید.

## Roadmap
- [x] 20% — Core setup + measurement registration + initial dashboard
- [ ] 40% — History, search and filters
- [ ] 60% — Charts and analysis
- [ ] 80% — Thresholds, alerts and Excel export
- [ ] 100% — Testing, documentation and delivery

جزئیات مرحله اول در [PROGRESS_20.md](PROGRESS_20.md) آمده است.
